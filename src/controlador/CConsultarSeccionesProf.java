// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;

import java.sql.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import vistas.ConsultarSeccionesProf;
import modelo.Sesion;
import modelo.MPeriodoAcademico;
import conexion.CConexion;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import vistas.DashboardProfesor;

public class CConsultarSeccionesProf {
    private ConsultarSeccionesProf view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaPeriodos; 
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
   
    public CConsultarSeccionesProf(ConsultarSeccionesProf view, Sesion sesion) {
        this.view = view;
        this.sesion = sesion;
        this.mapaPeriodos = new HashMap<>();
        this.view.getListPeriodos().addItem("Seleccione opción");
        llenarCbxPeriodoAcademico();
        
        view.getListPeriodos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el código de la sección seleccionada
                int codigoPeriodoSeleccionado = obtenerCodigoPeriodoSeleccionado();
                llenarTablaSecciones(codigoPeriodoSeleccionado);
                // Realizar acciones con el código de la sección seleccionada
                System.out.println("Código de periodo seleccionado: " + codigoPeriodoSeleccionado);
                // Puedes realizar cualquier acción que necesites con este código
            }
        });
        
        view.getBontonAtras().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardProfesor frm = new DashboardProfesor();
                CDashboardProfesor controladorDashboardProfesor = new CDashboardProfesor(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        
    }
    
    private void llenarCbxPeriodoAcademico(){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT codigo, nombre FROM periodo_academico WHERE estatus=true;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaPeriodos.put(nombre, codigo);
            }
            for (String periodo : data) {
                view.getListPeriodos().addItem(periodo);
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
    
    private void llenarTablaSecciones(int periodo){
        
        System.out.println("Usuario logueado: " + sesion.getNombre_usuario());
        int codigo_profesor = sesion.getCodigo_usuario();
        TableModel model = view.getTablaSecciones().getModel();
        DefaultTableModel defaultModel = (DefaultTableModel) model;
        defaultModel.setRowCount(0);
        
        String sql = "SELECT s.numero as numero, a.nombre as asignatura, c.nombre as carrera, (SELECT COUNT(*) FROM inscripcion WHERE seccion_id = s.codigo AND estatus = true AND periodo_academico_id = ? ) as estudiantes FROM seccion s INNER JOIN asignatura a ON s.asignatura_id = a.codigo INNER JOIN carrera c ON a.carrera_id = c.codigo WHERE s.estatus=true and s.periodo_id = ? and s.profesor_id = ?;";
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, periodo);
            statement.setInt(2, periodo);
            statement.setInt(3, sesion.getCodigo_usuario());

            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getString("numero"),
                    resultSet.getString("asignatura"),
                    resultSet.getString("carrera"),
                    resultSet.getInt("estudiantes"),
                };
                ((DefaultTableModel) model).addRow(row);
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
    
    private int obtenerCodigoPeriodoSeleccionado() {
        int selectedIndex = view.getListPeriodos().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombrePeriodoSeleccionado = (String) view.getListPeriodos().getSelectedItem(); // Obtener nombre de sección seleccionada
            return mapaPeriodos.get(nombrePeriodoSeleccionado); // Obtener código de sección a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
}
