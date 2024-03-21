// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;

import java.sql.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import conexion.CConexion;
import modelo.MAsignatura;
import modelo.MCarrera;
import modelo.MEstudiante;
import modelo.MInscripcion;

import modelo.Sesion;
import modelo.MPeriodoAcademico;
import modelo.MSeccion;
import modelo.MSemestre;

import vistas.DashboardAdministrador;
import vistas.InscripcionAdmin;

public class CInscripcionAdmin {
    private InscripcionAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaPeriodos; 
    private HashMap<String, Integer> mapaAsignatura;
    private HashMap<String, Integer> mapaSecciones;
    
    private MEstudiante estudiante;
    private MCarrera carrera;
    private MPeriodoAcademico periodoAcademico;
    private MAsignatura asignatura_model;
    private MSeccion seccion_model;
    
    private List<MInscripcion> inscripciones;
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
   
    public CInscripcionAdmin(InscripcionAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.mapaPeriodos = new HashMap<>();
        this.inscripciones = new ArrayList<>();
        
        TableModel model = view.getjTablaInscripcion().getModel();
        DefaultTableModel defaultModel = (DefaultTableModel) model;
        defaultModel.setRowCount(0);
        
        llenarCbxPeriodoAcademico();
        
        this.view.getBotonBuscar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = view.getCampoCedula().getText();
                int index = view.getCampoPeriodoAcademico().getSelectedIndex();
                
                if(cedula != "" && cedula != null && index > 0){
                    int periodo = obtenerCodigoPeriodoSeleccionado();
                    
                    periodoAcademico = new MPeriodoAcademico();
                    periodoAcademico.setCodigo(periodo);
                    periodoAcademico.setNombre((String) view.getCampoPeriodoAcademico().getSelectedItem());
                    
                    buscarEstudiante(cedula, periodo);
                    
                }else{
                    JOptionPane.showMessageDialog(view,"Debe ingresar una cédula y seleccionar un periodo académico", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        
        this.view.getCampoAsignatura().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int periodo = obtenerCodigoPeriodoSeleccionado();
                int asignatura = obtenerCodigoAsignaturaSeleccionada();
                if(asignatura > 0){
                    asignatura_model = new MAsignatura();
                    asignatura_model.setCodigo(asignatura);
                    asignatura_model.setNombre((String) view.getCampoAsignatura().getSelectedItem());
                    
                    llenarCbxSecciones(periodo, asignatura);
                }
            }
        });
        
        this.view.getCampoSecciones().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int seccion = obtenerCodigoSeccionSeleccionado();
                if(seccion > 0){
                    seccion_model = new MSeccion();
                    seccion_model.setCodigo(seccion);
                    seccion_model.setNumero((String) view.getCampoSecciones().getSelectedItem());
                    seccion_model.setAsignatura_id(asignatura_model);
                    
                    view.getBotonAgregar().setEnabled(true);
                }
            }

        });
        
        this.view.getBotonAgregar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int seccion = obtenerCodigoSeccionSeleccionado();
                if(seccion > 0){
                    llenarTablaInscripcion();
                }
            }
            
        });
        
        this.view.getBotonInscripcion().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarInscripcion();
                JOptionPane.showMessageDialog(view,"Se ha inscrito exitosamente!");
                limpiarCampos();
            }
            
        });
        
        this.view.getBontonAtras1().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
    }
    
    private void llenarCbxPeriodoAcademico(){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            this.view.getCampoPeriodoAcademico().addItem("Seleccione opción");
        
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
                view.getCampoPeriodoAcademico().addItem(periodo);
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
    
    private void llenarCbxAsignatura(int carrera_id, int periodo_id){
        try{
            // Crear una lista para almacenar los datos del combo
            this.mapaAsignatura = new HashMap<>();
            ArrayList<String> data = new ArrayList<>();
            this.view.getCampoAsignatura().removeAllItems();
            this.view.getCampoAsignatura().addItem("Seleccione opción");
        
            //String sql = "SELECT codigo, nombre FROM asigantura WHERE estatus=true AND carrera_id = ?;";
            String sql = "SELECT codigo, nombre "
                    + "FROM asignatura "
                    + "WHERE codigo NOT IN ("
                        + "SELECT DISTINCT s.asignatura_id "
                        + "FROM inscripcion i "
                        + "INNER JOIN seccion s ON i.seccion_id = s.codigo "
                        + "WHERE i.estudiante_id = ? AND i.periodo_academico_id = ? AND i.estatus = true"
                    + ")"
                    + "AND carrera_id = ? AND estatus = true;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, estudiante.getCodigo());
            statement.setInt(2, periodo_id);
            statement.setInt(3, carrera_id);
            
            resultSet = statement.executeQuery();
            
            boolean encontro = false;
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                encontro = true;
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaAsignatura.put(nombre, codigo);
            }
            
            for (String asignatura : data) {
                view.getCampoAsignatura().addItem(asignatura);
            }
            
            view.getCampoAsignatura().setEnabled(encontro);
            if(!encontro){
               JOptionPane.showMessageDialog(view,"El estudiante no tiene asignaturas para inscribir", "Error", JOptionPane.ERROR_MESSAGE);
               limpiarCampos();
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
    
    private void llenarCbxSecciones(int periodo, int asignatura){
        try{
            // Crear una lista para almacenar los datos del combo
            this.mapaSecciones = new HashMap<>();
            ArrayList<String> data = new ArrayList<>();
            this.view.getCampoSecciones().removeAllItems();
            this.view.getCampoSecciones().addItem("Seleccione opción");
            int estudiante_id = estudiante.getCodigo();
            
            String sql = "SELECT codigo, numero "
                    + "FROM seccion "
                    + "WHERE codigo NOT IN ("
                        + "SELECT DISTINCT s.asignatura_id "
                        + "FROM inscripcion i "
                        + "INNER JOIN seccion s ON i.seccion_id = s.codigo "
                        + "WHERE i.estudiante_id = ? AND i.periodo_academico_id = ? AND i.estatus = true"
                    + ")"
                    + "AND asignatura_id = ? AND estatus = true;";
            
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, estudiante_id);
            statement.setInt(2, periodo);
            statement.setInt(3, asignatura);
            
            resultSet = statement.executeQuery();
            boolean encontro = false;
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                encontro = true;
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("numero");
                
                data.add(nombre);
                mapaSecciones.put(nombre, codigo);
            }
            for (String seccion : data) {
                view.getCampoSecciones().addItem(seccion);
            }
            
            view.getCampoSecciones().setEnabled(encontro);
            

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
    
    private void buscarEstudiante(String cedula, int periodo){
        // Crear una lista para almacenar los datos del combo
        ArrayList<String> data = new ArrayList<>();
        String sql = "SELECT e.codigo as estudiante_id, e.nombre as nombre, e.apellido as apellido, c.nombre as carrera, c.codigo as carrera_id "
                + "FROM estudiante e "
                + "INNER JOIN carrera c ON e.carrera_id = c.codigo "
                + "WHERE e.cedula = ? AND e.estatus = true LIMIT 1;";
        try {
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, cedula);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            if (resultSet.next()) {
                int codigo = resultSet.getInt("estudiante_id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String carrera_nombre = resultSet.getString("carrera");
                int carrera_id = resultSet.getInt("carrera_id");
                
                
                estudiante = new MEstudiante();
                estudiante.setCodigo(codigo);
                estudiante.setCedula(cedula);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
                
                carrera = new MCarrera();
                carrera.setCodigo(carrera_id);
                carrera.setNombre(carrera_nombre);
                
                estudiante.setCarrera_id(carrera);
                
                view.getCampoNombres().setText(estudiante.getNombre());
                view.getCampoApellidos().setText(estudiante.getApellido());
                view.getCampoCarrera1().setText(estudiante.getCarrera_id().getNombre());
                llenarCbxAsignatura(carrera_id, periodo);
                
                
            }else{
                JOptionPane.showMessageDialog(view,"No se encontro al estudiante", "Error", JOptionPane.ERROR_MESSAGE);
                
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
    
    private void llenarTablaInscripcion(){
        int seccion = obtenerCodigoSeccionSeleccionado();
        MSemestre semestre;
        
        TableModel model = view.getjTablaInscripcion().getModel();
        
        ArrayList<String> data = new ArrayList<>();
        String sql = "SELECT sm.codigo as codigo, sm.nombre as nombre "
                + "FROM seccion s "
                + "INNER JOIN asignatura a ON s.asignatura_id =  a.codigo "
                + "INNER JOIN semestre sm ON a.semestre_id = sm.codigo "
                + "WHERE s.codigo = ? AND s.estatus = true LIMIT 1;";
        try {
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, seccion);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            if (resultSet.next()) {
                semestre = new MSemestre(resultSet.getInt("codigo"), resultSet.getString("nombre"), true);
                
                MInscripcion inscripcion = new MInscripcion();
                inscripcion.setEstudiante_id(estudiante);
                inscripcion.setPeriodo_academico_id(periodoAcademico);
                inscripcion.setSeccion_id(seccion_model);
                inscripcion.setSemestre_id(semestre);
                
                inscripciones.add(inscripcion);
                
                Object[] row = {
                    inscripcion.getSeccion_id().getAsignatura_id().getCodigo(),
                    inscripcion.getSeccion_id().getAsignatura_id().getNombre(),
                    inscripcion.getSemestre_id().getNombre(),
                    inscripcion.getSeccion_id().getNumero(),
                };
                ((DefaultTableModel) model).addRow(row);
                view.getBotonInscripcion().setEnabled(true);
                
            }else{
                JOptionPane.showMessageDialog(view,"No se encontro el semestre", "Error", JOptionPane.ERROR_MESSAGE);
                
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
        //MInscripcion inscripcion = new MInscripcion();
                
    }
    
    private void registrarInscripcion(){
        String sql = "INSERT INTO inscripcion (estudiante_id, seccion_id, periodo_academico_id, semestre_id) VALUES (?,?,?,?);";
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);

            for (MInscripcion inscripcion : inscripciones) {
                statement.setInt(1, inscripcion.getEstudiante_id().getCodigo());
                statement.setInt(2, inscripcion.getSeccion_id().getCodigo());
                statement.setInt(3, inscripcion.getPeriodo_academico_id().getCodigo());
                statement.setInt(4, inscripcion.getSemestre_id().getCodigo());
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cerrar la conexión, el statement y el resultSet
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private int obtenerCodigoPeriodoSeleccionado() {
        int selectedIndex = view.getCampoPeriodoAcademico().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombrePeriodoSeleccionado = (String) view.getCampoPeriodoAcademico().getSelectedItem(); // Obtener nombre de periodo seleccionada
            return mapaPeriodos.get(nombrePeriodoSeleccionado); // Obtener código de periodo a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerCodigoAsignaturaSeleccionada() {
        int selectedIndex = view.getCampoAsignatura().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreAsignaturaSeleccionado = (String) view.getCampoAsignatura().getSelectedItem(); // Obtener nombre de asignatura seleccionada
            return mapaAsignatura.get(nombreAsignaturaSeleccionado); // Obtener código de asignatura a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerCodigoSeccionSeleccionado() {
        int selectedIndex = view.getCampoSecciones().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreSeccionSeleccionado = (String) view.getCampoSecciones().getSelectedItem(); // Obtener nombre de seccion seleccionada
            return mapaSecciones.get(nombreSeccionSeleccionado); // Obtener código de seccion a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private void limpiarCampos(){
        view.getCampoCedula().setText("");
        view.getCampoNombres().setText("");
        view.getCampoApellidos().setText("");
        view.getCampoCarrera1().setText("");
        
        TableModel model = view.getjTablaInscripcion().getModel();
        DefaultTableModel defaultModel = (DefaultTableModel) model;
        defaultModel.setRowCount(0);
        
        view.getCampoPeriodoAcademico().removeAllItems();
        llenarCbxPeriodoAcademico();
        
        view.getCampoAsignatura().removeAllItems();
        view.getCampoAsignatura().setEnabled(false);
        
        view.getCampoSecciones().removeAllItems();
        view.getCampoSecciones().setEnabled(false);
        
        view.getBotonAgregar().setEnabled(false);
        view.getBotonInscripcion().setEnabled(false);
    }
}
