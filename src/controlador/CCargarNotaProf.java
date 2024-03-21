// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;

import java.sql.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import vistas.CargarNotasProf;
import vistas.DashboardProfesor;
import modelo.Sesion;
import conexion.CConexion;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.MEstudiante;
import modelo.MNota;
import modelo.MSeccion;
import vistas.ModificarNotaProf;

public class CCargarNotaProf {
    private CargarNotasProf view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaPeriodos;
    private HashMap<String, Integer> mapaCarreras;
    private HashMap<String, Integer> mapaAsignaturas;
    private HashMap<String, Integer> mapaSecciones;
    private List<MNota> arrayNotas;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
   
    public CCargarNotaProf(CargarNotasProf view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.view.getListPeriodos().addItem("Seleccione opción");
        this.mapaPeriodos = new HashMap<>();
        this.mapaCarreras = new HashMap<>();
        this.mapaAsignaturas = new HashMap<>();
        this.mapaSecciones = new HashMap<>();
        this.arrayNotas = new ArrayList<MNota>();
        
        DefaultTableModel tabla = (DefaultTableModel) view.getTablaNotas().getModel();
        tabla.setRowCount(0);
        
        llenarCbxPeriodoAcademico();
        
        view.getListPeriodos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el código de la sección seleccionada
                int codigoPeriodoSeleccionado = obtenerCodigoPeriodoSeleccionado();
                view.getListCarreras().removeAllItems();
                
                if(codigoPeriodoSeleccionado != 0){
                    
                    view.getListCarreras().addItem("Seleccione opción");
                    llenarCbxCarrera(codigoPeriodoSeleccionado);
                }
            }
        });
        
        view.getListCarreras().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el código de la sección seleccionada
                int codigoPeriodoSeleccionado = obtenerCodigoPeriodoSeleccionado();
                int codigoCarreraSeleccionado = obtenerCodigoCarreraSeleccionada();
                view.getListAsignatura().removeAllItems();
                
                if(codigoCarreraSeleccionado!=0){
                    view.getListAsignatura().addItem("Seleccione opción");

                    llenarCbxAsignaturas(codigoPeriodoSeleccionado, codigoCarreraSeleccionado);
                
                }
            }
        });
        
        view.getListAsignatura().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el código de la asignatura seleccionada
                int codigoPeriodoSeleccionado = obtenerCodigoPeriodoSeleccionado();
                int codigoAsignaturaSeleccionado = obtenerCodigoAsignaturaSeleccionada();
                view.getListSeccion().removeAllItems();
                
                if(codigoAsignaturaSeleccionado!=0){
                    view.getListSeccion().addItem("Seleccione opción");

                    llenarCbxSecciones(codigoPeriodoSeleccionado, codigoAsignaturaSeleccionado);
                }
            }
        });
        
        view.getListSeccion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el código de la sección seleccionada
                int codigoPeriodoSeleccionado = obtenerCodigoPeriodoSeleccionado();
                int codigoSeccionSeleccionado = obtenerCodigoSeccionSeleccionado();
                
                if(codigoSeccionSeleccionado!=0){
                    view.getListSeccion().addItem("Seleccione opción");

                    llenarTablaNotas(codigoPeriodoSeleccionado, codigoSeccionSeleccionado);
                }
            }
        });
        
        view.getBontonAtras1().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardProfesor frm = new DashboardProfesor();
                CDashboardProfesor controladorDashboardProfesor = new CDashboardProfesor(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        view.getBontonGuardar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tabla = (DefaultTableModel) view.getTablaNotas().getModel();
                if(tabla.getRowCount() > 0) {
                    guardarNotas();
                }else{
                    JOptionPane.showMessageDialog(view,"No se encontraron notas para guardar", "Error", JOptionPane.ERROR_MESSAGE);    
                }
            }
        });
        
        view.getModificarNota().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificarNotaProf frm = new ModificarNotaProf();
                CModificarNotasProf controladorModificarNota = new CModificarNotasProf(frm, sesion);
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
    
    private void llenarCbxCarrera(int periodo){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT DISTINCT c.codigo, c.nombre FROM seccion s INNER JOIN asignatura a ON s.asignatura_id = a.codigo INNER JOIN carrera c ON a.carrera_id = c.codigo WHERE s.estatus=true AND s.profesor_id = ? AND s.periodo_id = ?;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sesion.getCodigo_usuario());
            statement.setInt(2, periodo);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaCarreras.put(nombre, codigo);
            }
            for (String carrera : data) {
                view.getListCarreras().addItem(carrera);
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
    
    private void llenarCbxAsignaturas(int periodo, int carrera){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT DISTINCT a.codigo, a.nombre FROM seccion s INNER JOIN asignatura a ON s.asignatura_id = a.codigo INNER JOIN carrera c ON a.carrera_id = c.codigo WHERE s.estatus=true AND s.profesor_id = ? AND s.periodo_id = ? AND a.carrera_id = ?;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sesion.getCodigo_usuario());
            statement.setInt(2, periodo);
            statement.setInt(3, carrera);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaAsignaturas.put(nombre, codigo);
            }
            for (String asignatura : data) {
                view.getListAsignatura().addItem(asignatura);
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
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT DISTINCT s.codigo, s.numero FROM seccion s INNER JOIN asignatura a ON s.asignatura_id = a.codigo INNER JOIN carrera c ON a.carrera_id = c.codigo WHERE s.estatus=true AND s.profesor_id = ? AND s.periodo_id = ? AND s.asignatura_id = ?;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sesion.getCodigo_usuario());
            statement.setInt(2, periodo);
            statement.setInt(3, asignatura);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("numero");
                
                data.add(nombre);
                mapaSecciones.put(nombre, codigo);
            }
            for (String seccion : data) {
                view.getListSeccion().addItem(seccion);
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
    
    
    private void llenarTablaNotas(int periodo, int seccion){
        this.arrayNotas = new ArrayList<MNota>();
        
        int codigo_profesor = sesion.getCodigo_usuario();
        TableModel model = view.getTablaNotas().getModel();
        DefaultTableModel defaultModel = (DefaultTableModel) model;
        defaultModel.setRowCount(0);
        
        String sql = "SELECT e.codigo as codigo_est, e.cedula as cedula, e.nombre as nombre, e.apellido as apellido, COALESCE(n.nota, NULL) AS nota, COALESCE(n.codigo, 0) AS nota_id "
                + "FROM inscripcion i "
                + "INNER JOIN estudiante e ON i.estudiante_id = e.codigo "
                + "LEFT JOIN "
                + "(SELECT estudiante_id, nota, codigo FROM nota WHERE seccion_id = ?) n ON e.codigo = n.estudiante_id "
                + "WHERE i.seccion_id = ? AND i.periodo_academico_id = ? AND i.estatus = true;";
        
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, seccion);
            statement.setInt(2, seccion);
            statement.setInt(3, periodo);
            
            resultSet = statement.executeQuery();
            boolean encontro = false;
            while (resultSet.next()) {
                encontro = true;
                Float nota = null;
                
                if (resultSet.getObject("nota") != null) {
                    nota = resultSet.getFloat("nota");
                }
                
                Object[] row = {
                    resultSet.getString("cedula"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    nota,
                };
                
                MEstudiante estudiante = new MEstudiante();
                estudiante.setCodigo(resultSet.getInt("codigo_est"));
                estudiante.setCedula(resultSet.getString("cedula"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setApellido(resultSet.getString("apellido"));
                
                MSeccion mseccion = new MSeccion();
                mseccion.setCodigo(seccion);
                
                MNota mnota = new MNota();
                mnota.setCodigo(resultSet.getInt("nota_id"));
                mnota.setEstudiante_id(estudiante);
                mnota.setSeccion_id(mseccion);
                
                if(nota == null || nota < 0){
                    mnota.setNota(-1);
                }else{
                    mnota.setNota(nota);
                }
                
                arrayNotas.add(mnota);
                
                ((DefaultTableModel) model).addRow(row);
            }
            if(!encontro){
                JOptionPane.showMessageDialog(view,"No se encontraron notas", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    private void guardarNotas(){
        DefaultTableModel tabla = (DefaultTableModel) this.view.getTablaNotas().getModel();
        boolean error = false;
        for (int row = 0; row < tabla.getRowCount(); row++) {
            Object[] rowData = new Object[tabla.getColumnCount()];
            rowData[0] = tabla.getValueAt(row, 0);
            rowData[1] = tabla.getValueAt(row, 1);
            rowData[2] = tabla.getValueAt(row, 2);
            rowData[3] = tabla.getValueAt(row, 3);
            
            if(rowData[3] != null && rowData[3]!=""){
                rowData[3] = Float.parseFloat(rowData[3].toString());
            }else{
                rowData[3] = Float.parseFloat("-1.0");
            }
            
            MNota nota = arrayNotas.get(row);
            
            String sql = "";
            
            if(nota.getCodigo() == 0 && (rowData[3] != null && (float) rowData[3] > -1)){
                sql = "INSERT INTO nota(nota, seccion_id, estudiante_id) "
                        + "VALUES ( "+(float) rowData[3]+","+nota.getSeccion_id().getCodigo()+","+nota.getEstudiante_id().getCodigo()+");";
            }
            
            if(nota.getCodigo() > 0 && (rowData[3] != null && (float) rowData[3] > -1)){
                sql = "UPDATE nota SET nota = "+(float) rowData[3]+" WHERE codigo = "+nota.getCodigo()+";";
            }
            
            
            try{
                if(!sql.equals("")){
                    connection = cconexion.establecerConexion();
                    statement = connection.prepareStatement(sql);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                error = true;
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
        
        if(error){
            JOptionPane.showMessageDialog(view,"Error al guardar notas, por favor verificar", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(view,"Se ha guardado exitosamente!");
        }
        
        this.limpiarCampos();
    
    }
    
    private int obtenerCodigoPeriodoSeleccionado() {
        int selectedIndex = view.getListPeriodos().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombrePeriodoSeleccionado = (String) view.getListPeriodos().getSelectedItem(); // Obtener nombre de periodo seleccionada
            return mapaPeriodos.get(nombrePeriodoSeleccionado); // Obtener código de periodo a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    private int obtenerCodigoCarreraSeleccionada() {
        int selectedIndex = view.getListCarreras().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreCarreraSeleccionado = (String) view.getListCarreras().getSelectedItem(); // Obtener nombre de carrera seleccionada
            return mapaCarreras.get(nombreCarreraSeleccionado); // Obtener código de carrera a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerCodigoAsignaturaSeleccionada() {
        int selectedIndex = view.getListAsignatura().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreAsignaturaSeleccionado = (String) view.getListAsignatura().getSelectedItem(); // Obtener nombre de asignatura seleccionada
            return mapaAsignaturas.get(nombreAsignaturaSeleccionado); // Obtener código de asignatura a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerCodigoSeccionSeleccionado() {
        int selectedIndex = view.getListSeccion().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreSeccionSeleccionado = (String) view.getListSeccion().getSelectedItem(); // Obtener nombre de seccion seleccionada
            return mapaSecciones.get(nombreSeccionSeleccionado); // Obtener código de seccion a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    public void limpiarCampos(){
        this.view.getListPeriodos().setSelectedIndex(0);
        this.view.getListAsignatura().removeAllItems();
        this.view.getListCarreras().removeAllItems();
        this.view.getListSeccion().removeAllItems();
        
        TableModel model = view.getTablaNotas().getModel();
        DefaultTableModel defaultModel = (DefaultTableModel) model;
        defaultModel.setRowCount(0);
        
        this.mapaCarreras = new HashMap<>();
        this.mapaAsignaturas = new HashMap<>();
        this.mapaSecciones = new HashMap<>();
        this.arrayNotas = new ArrayList<MNota>();
        
    }
}
