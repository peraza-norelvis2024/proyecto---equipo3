// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.ReportesSeccionesAdmin;
import vistas.DashboardAdministrador;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;


import conexion.CConexion;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;
import modelo.MAsignatura;
import modelo.MEstudiante;
import modelo.MCarrera;
import modelo.MSemestre;
import modelo.MDecanato;
import modelo.MSeccion;
import modelo.MProfesor;

public class CReportesSeccionesAdmin {
    private ReportesSeccionesAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaAsignatura;
    private HashMap<String, Integer> mapaEstudiante;
    private MAsignatura asignatura;
    private MEstudiante estudiante;
    private HashMap<String, Integer> mapaCarrera;
    private HashMap<String, Integer> mapaSemestre;
    private MCarrera carrera;
    private MSemestre semestre;
    private HashMap<String, Integer> mapaDecanato;
    private HashMap<String, Integer> mapaSeccion;
    private MDecanato decanato;
    private MSeccion seccion;
    private HashMap<String, Integer> mapaProfesor;
    private MDecanato profesor;
    private List<MSeccion> arraySecciones;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CReportesSeccionesAdmin(ReportesSeccionesAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.view.getComboSeccionesRet().addItem("Seleccione opción");
        this.view.getComboSeccionesRet().addItem("Reporte general");
        this.view.getComboSeccionesRet().addItem("Reporte por sección");
        this.view.getComboSeccionRet().addItem("Seleccione opción");
        this.llenarCbxSecciones();
        
        //Accion de boton atras
        this.view.getBontonAtrasSeccionRet().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        this.view.getComboSeccionesRet().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = view.getComboSeccionesRet().getSelectedIndex();
                if(index == 0){
                    view.getComboSeccionRet().setEnabled(false);
                    // Limpiar la tabla
                    DefaultTableModel model = (DefaultTableModel) view.getTableSec().getModel();
                    model.setRowCount(0); // Elimina todas las filas del modelo
                    model.setColumnCount(0); // Elimina todas las columnas del modelo

                }
                
                else if(index == 1){
                    reporteGeneral();
                    view.getComboSeccionRet().setEnabled(false);
                }
                
                else if(index == 2){
                    view.getComboSeccionRet().setEnabled(true);
                    // Limpiar la tabla
                    DefaultTableModel model = (DefaultTableModel) view.getTableSec().getModel();
                    model.setRowCount(0); // Elimina todas las filas del modelo
                    model.setColumnCount(0); // Elimina todas las columnas del modelo
                    
                }
            }
        });
    }
    
    private void reporteGeneral(){
        String sql = ""
                + "WITH promedio_notas AS (SELECT seccion_id, AVG(nota) AS promedio FROM  nota GROUP BY seccion_id ) "
                + "SELECT s.numero AS nombre_seccion, pn.promedio AS promedio_notas, SUM(CASE WHEN n.nota > pn.promedio THEN 1 ELSE 0 END) AS estudiantes_con_nota_mayor, SUM(CASE WHEN n.nota < pn.promedio THEN 1 ELSE 0 END) AS estudiantes_con_nota_menor, c.nombre as nombre_carrera, d.nombre as nombre_decanato, a.nombre as nombre_asignatura, p.nombre as nombre_profesor, p.apellido as apellido_profesor "
                + "FROM seccion s "
                + "INNER JOIN nota n ON s.codigo = n.seccion_id "
                + "INNER JOIN asignatura a ON s.asignatura_id = a.codigo "
                + "INNER JOIN profesor p ON s.profesor_id = p.codigo "
                + "INNER JOIN carrera c ON a.carrera_id = c.codigo "
                + "INNER JOIN decanato d ON c.decanato_id = d.codigo "
                + "INNER JOIN periodo_academico pa ON s.periodo_id = pa.codigo "
                + "INNER JOIN promedio_notas pn ON s.codigo = pn.seccion_id "
                + "WHERE s.estatus = true AND pa.estatus = true AND pa.activo = true "
                + "GROUP BY s.codigo, s.numero, pn.promedio, c.nombre, d.nombre, p.nombre, p.apellido, a.nombre;";
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            DefaultTableModel newModel = new DefaultTableModel();
            newModel.addColumn("Sección");
            newModel.addColumn("Decanato");
            newModel.addColumn("Carrera");
            newModel.addColumn("Asignatura");
            newModel.addColumn("Profesor");
            newModel.addColumn("Promedio");
            newModel.addColumn("Mayor al promedio");
            newModel.addColumn("Menor al promedio");
            
            boolean encontro = false;
            while (resultSet.next()) {
                encontro = true;
                Object[] row = {
                    resultSet.getString("nombre_seccion"),
                    resultSet.getString("nombre_decanato"),
                    resultSet.getString("nombre_carrera"),
                    resultSet.getString("nombre_asignatura"),
                    resultSet.getString("nombre_profesor")+" "+resultSet.getString("apellido_profesor"),
                    resultSet.getFloat("promedio_notas"),
                    resultSet.getInt("estudiantes_con_nota_mayor"),
                    resultSet.getInt("estudiantes_con_nota_menor")
                };
                
                ((DefaultTableModel) newModel).addRow(row);
            }
            if(encontro){
                this.view.getTableSec().setModel(newModel);
            }else{
                JOptionPane.showMessageDialog(view,"No se encontraron registros", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión, el statement y el resultSet
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void llenarCbxSecciones() {
        try {
            // Crear una lista para almacenar los datos del combo
            this.arraySecciones = new ArrayList<>();
            mapaSeccion = new HashMap<>(); // Inicializamos el HashMap

            ArrayList<String> data = new ArrayList<>();
            view.getComboSeccionRet().removeAllItems();
            this.view.getComboSeccionRet().addItem("Seleccione opción");

            String sql = "SELECT s.codigo as codigo, s.numero as nombre, s.estatus as estatus  "
                    + "FROM seccion s "
                    + "WHERE s.estatus=true;"; // Quitamos las condiciones específicas de la consulta

            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            boolean encontro = false;
            while (resultSet.next()) {
                encontro = true;
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");

                MSeccion mseccion = new MSeccion();
                mseccion.setCodigo(codigo);
                mseccion.setNumero(nombre);
                mseccion.setEstatus(resultSet.getBoolean("estatus"));

                arraySecciones.add(mseccion);

                data.add(nombre);
                mapaSeccion.put(nombre, codigo); // Agregamos al HashMap
            }
            for (String seccion : data) {
                view.getComboSeccionRet().addItem(seccion);
            }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            // Cerrar la conexión, el statement y el resultSet
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  
}
