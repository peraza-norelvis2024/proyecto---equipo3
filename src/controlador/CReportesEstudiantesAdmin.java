//Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.ReportesEstudiantesAdmin;
import vistas.DashboardAdministrador;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import conexion.CConexion;
import java.util.*;
import modelo.MAsignatura;
import modelo.MEstudiante;
import modelo.MCarrera;
import modelo.MSemestre;
import modelo.MDecanato;
import modelo.MSeccion;

public class CReportesEstudiantesAdmin {
    private ReportesEstudiantesAdmin view;
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

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CReportesEstudiantesAdmin(ReportesEstudiantesAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.view.getComboEstudianteRet().setEnabled(true);
        this.view.getComboEstudianteRet().addItem("Seleccione una opción");
        this.view.getComboEstudianteRet().addItem("Estudiantes que retiraron una materia");
        this.view.getComboEstudianteRet().addItem("Estudiantes por decanato");
        this.view.getComboEstudianteRet().addItem("Estudiantes por carrera");
        this.view.getComboEstudianteRet().addItem("Estudiante por semestre");
        this.view.getComboEstudianteRet().addItem("20 mejores promedios de estudiantes por carrera");
        this.view.getComboEstudianteRet().addItem("20 mejores promedios de estudiantes por decanato");
        this.view.getComboEstudianteRet().addItem("Estudiantes con promedios por encima de 16 puntos por sección y carrera");
        
        this.view.getComboEstudianteRet().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int index = view.getComboEstudianteRet().getSelectedIndex();
                if(index == 1){
                    estudiantesRetirados();
                }
                
                else if(index == 2){
                    estudiantesPorDecanatos();
                }
                
                else if(index == 3){
                    estudiantesPorCarrera();
                }
                
                else if(index == 4){
                    estudiantesPorSemestre();
                }
                
                else if(index == 5){
                    
                }
                
                else if(index == 6){
                    
                }
            }
        });
        
        
        //Accion de boton atras
        this.view.getBontonAtrasEstudianteRet().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });   
    }
    
    private void estudiantesRetirados(){
        String sql = ""
                + "SELECT e.nombre as nombre, e.apellido as apellido, e.cedula as cedula, a.nombre as nombre_asignatura "
                + "FROM inscripcion i "
                + "INNER JOIN estudiante e ON i.estudiante_id = e.codigo "
                + "INNER JOIN seccion s ON i.seccion_id = s.codigo "
                + "INNER JOIN periodo_academico p ON i.periodo_academico_id = p.codigo "
                + "INNER JOIN asignatura a ON s.asignatura_id = a.codigo "
                + "WHERE i.estatus = false AND p.estatus = true AND p.activo = true AND e.estatus = true AND s.estatus = true; ";
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            DefaultTableModel newModel = new DefaultTableModel();
            newModel.addColumn("Nombre");
            newModel.addColumn("Apellido");
            newModel.addColumn("Cédula");
            newModel.addColumn("Asignatura");
            
            boolean encontro = false;
            while (resultSet.next()) {
                encontro = true;
                Object[] row = {
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("cedula"),
                    resultSet.getString("nombre_asignatura"),
                };
                
                ((DefaultTableModel) newModel).addRow(row);
            }
            if(encontro){
                this.view.getTableEst().setModel(newModel);
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
    
    private void estudiantesPorDecanatos(){
         String sql = ""
                + "SELECT e.nombre as nombre, e.apellido as apellido, e.cedula as cedula, d.nombre as nombre_decanato "
                + "FROM estudiante e "
                + "INNER JOIN carrera c ON e.carrera_id = c.codigo "
                + "INNER JOIN decanato d ON c.decanato_id = d.codigo "
                + "WHERE e.estatus = true AND d.estatus = true AND c.estatus = true; ";
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) view.getTableEst().getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            // Iterar sobre los resultados y agregarlos a la lista
            DefaultTableModel newModel = new DefaultTableModel();
            newModel.addColumn("Nombre");
            newModel.addColumn("Apellido");
            newModel.addColumn("Cédula");
            newModel.addColumn("Decanato");
            
            boolean encontro = false;
            while (resultSet.next()) {
                encontro = true;
                Object[] row = {
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("cedula"),
                    resultSet.getString("nombre_decanato"),
                };
                
                ((DefaultTableModel) newModel).addRow(row);
            }
            if(encontro){
                this.view.getTableEst().setModel(newModel);
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
    
    private void estudiantesPorCarrera(){
         String sql = ""
                + "SELECT e.nombre as nombre, e.apellido as apellido, e.cedula as cedula, c.nombre as nombre_carrera "
                + "FROM estudiante e "
                + "INNER JOIN carrera c ON e.carrera_id = c.codigo "
                + "WHERE e.estatus = true AND c.estatus = true; ";
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) view.getTableEst().getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            // Iterar sobre los resultados y agregarlos a la lista
            DefaultTableModel newModel = new DefaultTableModel();
            newModel.addColumn("Nombre");
            newModel.addColumn("Apellido");
            newModel.addColumn("Cédula");
            newModel.addColumn("Carrera");
            
            boolean encontro = false;
            while (resultSet.next()) {
                encontro = true;
                Object[] row = {
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("cedula"),
                    resultSet.getString("nombre_carrera"),
                };
                
                ((DefaultTableModel) newModel).addRow(row);
            }
            if(encontro){
                this.view.getTableEst().setModel(newModel);
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
    
    private void estudiantesPorSemestre() {
        String sql = ""
                + "SELECT e.nombre AS nombre, e.apellido AS apellido, e.cedula AS cedula, MIN(s.nombre) AS nombre_semestre "
                + "FROM estudiante e "
                + "INNER JOIN inscripcion i ON e.codigo = i.estudiante_id "
                + "INNER JOIN seccion sec ON i.seccion_id = sec.codigo "
                + "INNER JOIN asignatura a ON sec.asignatura_id = a.codigo "
                + "INNER JOIN semestre s ON a.semestre_id = s.codigo "
                + "WHERE e.estatus = true AND s.estatus = true "
                + "GROUP BY e.nombre, e.apellido, e.cedula";
        try {
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) view.getTableEst().getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            // Iterar sobre los resultados y agregarlos a la lista
            DefaultTableModel newModel = new DefaultTableModel();
            newModel.addColumn("Nombre");
            newModel.addColumn("Apellido");
            newModel.addColumn("Cédula");
            newModel.addColumn("Semestre");

            boolean encontro = false;
            while (resultSet.next()) {
                encontro = true;
                Object[] row = {
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("cedula"),
                    resultSet.getString("nombre_semestre"),
                };

                ((DefaultTableModel) newModel).addRow(row);
            }
            if (encontro) {
                this.view.getTableEst().setModel(newModel);
            } else {
                JOptionPane.showMessageDialog(view, "No se encontraron registros", "Error", JOptionPane.ERROR_MESSAGE);
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
