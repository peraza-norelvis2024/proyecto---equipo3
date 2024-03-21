// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.SeccionAdmin;
import vistas.DashboardAdministrador;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import conexion.CConexion;
import java.util.*;
import modelo.MSeccion;
import modelo.MPeriodoAcademico;
import modelo.MAsignatura;
import modelo.MProfesor;

public class CSeccionesAdmin {
    private SeccionAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    
    private HashMap<String, Integer> mapaSeccion;
    private HashMap<String, Integer> mapaPeriodoAcademico;
    private HashMap<String, Integer> mapaAsignatura;
    private HashMap<String, Integer> mapaProfesor;
    private List<MSeccion> arraySecciones;
    
    private MSeccion seccion;
    private MPeriodoAcademico periodoAcademico;
    private MAsignatura asignatura;
    private MProfesor profesor;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CSeccionesAdmin(SeccionAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.mapaSeccion = new HashMap<>();
        this.seccion = null;
        this.mapaPeriodoAcademico = new HashMap<>();
        this.periodoAcademico = null;
        this.mapaAsignatura = new HashMap<>();
        this.asignatura = null;
        this.mapaProfesor = new HashMap<>();
        this.profesor = null;
        this.arraySecciones = new ArrayList<>();
    
        //Llenamos el combo de secciones registradas
        this.view.getComboPerAcaBusSec().addItem("Seleccione opción");
        this.view.getComboPerAcaSec().addItem("Seleccione opción");
        this.llenarCbxPeriodos();
        
        this.view.getComboAsigBusSec().addItem("Seleccione opción");
        this.view.getComboAsigSec().addItem("Seleccione opción");
        this.llenarCbxAsignaturas();
        
        this.view.getComboProfSec().addItem("Seleccione opción");
        this.llenarCbxProfesores();
        
        this.view.getComboStaSec().addItem("Seleccione opción");
        this.view.getComboStaSec().addItem("Activo");
        this.view.getComboStaSec().addItem("Inactivo");
        
        this.inhabilitarCampos();
        
        this.view.getComboAsigBusSec().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = view.getComboAsigBusSec().getSelectedIndex();
                int selectedIndex2 = view.getComboPerAcaBusSec().getSelectedIndex();

                // Verificar si se seleccionó alguna opción
                if (selectedIndex != -1 && selectedIndex > 0 && selectedIndex2 != -1 && selectedIndex2 > 0) { 
                    llenarCbxSecciones();
                }
            
            }
        
        });
        //Accion de boton atras
        this.view.getBontonAtrasSeccion().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        //Accion de boton Buscar
        this.view.getBotonBuscarSeccion().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex1 = view.getComboPerAcaBusSec().getSelectedIndex();
                int selectedIndex2 = view.getComboAsigBusSec().getSelectedIndex();
                int selectedIndex3 = view.getComboSecciones().getSelectedIndex();

                // Verificar si se seleccionó alguna opción
                if (selectedIndex1 != -1 && selectedIndex1 > 0 && selectedIndex2 != -1 && selectedIndex2 > 0&& selectedIndex3 != -1 && selectedIndex3 > 0) { 
                    buscarSeccion();
                }else{
                    JOptionPane.showMessageDialog(view,"Debe seleccionar las opciones", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                
            }
        });
        
        //Accion boton modificar
        this.view.getBotonModificarSeccion().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(seccion != null){
                    habilitarCampos();
                    view.getBotonModificarSeccion().setEnabled(false);
                    view.getBotonGuardarSeccion().setEnabled(true);
                    view.getComboStaSec().setEnabled(false);
                   
                }
            }
        });
        
        //Accion boton cancelar
        this.view.getBontonCancelarSeccion().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?");
                if (JOptionPane.OK_OPTION==confirmado) {
                        limpiarCampos();
                        view.getComboPerAcaBusSec().setEnabled(true);
                        view.getComboAsigBusSec().setEnabled(true);
                }
            }
        });
        
        this.view.getBotonGuardarSeccion().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()){
                    if(seccion != null){
                        editarSeccion();
                    }else{
                        registrarSeccion();
                    }
                }else{
                    JOptionPane.showMessageDialog(view,"Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Accion boton eliminar
        this.view.getBotonEliminarSeccion().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la sección?");
                if (JOptionPane.OK_OPTION==confirmado) {
                
                    if(seccion != null){
                        eliminarSeccion(seccion);
                    }
                }
            }
        });
        
        //Accion boton agregar
        this.view.getBotonAgregarSeccion().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
                habilitarCampos();   
                view.getBotonGuardarSeccion().setEnabled(true);
            }
        });
        
        
    }
    private void llenarCbxPeriodos(){
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
                mapaPeriodoAcademico.put(nombre, codigo);
            }
            for (String periodoAcademico : data) {
                view.getComboPerAcaBusSec().addItem(periodoAcademico);
                view.getComboPerAcaSec().addItem(periodoAcademico);
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
    
    private void llenarCbxAsignaturas(){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT codigo, nombre FROM asignatura WHERE estatus=true;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaAsignatura.put(nombre, codigo);
            }
            for (String asignatura : data) {
                view.getComboAsigSec().addItem(asignatura);
                view.getComboAsigBusSec().addItem(asignatura);
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
    
    private void llenarCbxSecciones(){
        try{
            // Crear una lista para almacenar los datos del combo
            this.arraySecciones = new ArrayList<>();
    
            ArrayList<String> data = new ArrayList<>();
            view.getComboSecciones().removeAllItems();
            this.view.getComboSecciones().addItem("Seleccione opción");
        
            String sql = "SELECT s.codigo as codigo, s.numero as nombre, s.max_estudiantes as max_estudiantes, s.estatus as estatus, p.codigo as id_periodo, p.nombre as nombre_periodo, a.codigo as id_asignatura, a.nombre as nombre_asignatura, pr.codigo as id_profesor, pr.nombre as nombre_profesor, pr.apellido as apellido_profesor  "
                    + "FROM seccion s "
                    + "INNER JOIN asignatura a ON s.asignatura_id = a.codigo "
                    + "INNER JOIN periodo_academico p ON s.periodo_id = p.codigo "
                    + "INNER JOIN profesor pr ON s.profesor_id = pr.codigo "
                    + "WHERE a.codigo = ? AND s.periodo_id = ? AND s.estatus=true;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, this.obtenerAsignaturaSeleccionada());
            statement.setInt(2, this.obtenerPeriodoSeleccionado());
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            boolean encontro = false;
            while (resultSet.next()) {
                encontro = true;
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                MPeriodoAcademico mperiodo = new MPeriodoAcademico();
                mperiodo.setCodigo(resultSet.getInt("id_periodo"));
                mperiodo.setNombre(resultSet.getString("nombre_periodo"));
                
                MAsignatura masignatura = new MAsignatura();
                masignatura.setCodigo(resultSet.getInt("id_asignatura"));
                masignatura.setNombre(resultSet.getString("nombre_asignatura"));
                
                MProfesor mprof = new MProfesor();
                mprof.setCodigo(resultSet.getInt("id_profesor"));
                mprof.setNombre(resultSet.getString("nombre_profesor"));
                mprof.setApellido(resultSet.getString("apellido_profesor"));
                
                
                MSeccion mseccion = new MSeccion();
                mseccion.setCodigo(codigo);
                mseccion.setNumero(nombre);
                mseccion.setMax_estudiantes(resultSet.getInt("max_estudiantes"));
                mseccion.setEstatus(resultSet.getBoolean("estatus"));
                mseccion.setAsignatura_id(masignatura);
                mseccion.setPeriodo_id(mperiodo);
                mseccion.setProfesor_id(mprof);
                
                arraySecciones.add(mseccion);
                
                data.add(nombre);
                mapaSeccion.put(nombre, codigo);
            }
            for (String secc : data) {
                view.getComboSecciones().addItem(secc);
            }
            
            view.getComboSecciones().setEnabled(encontro);
            if(!encontro){
               JOptionPane.showMessageDialog(view,"No se encontraron secciones para la asignatura seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    private void llenarCbxProfesores(){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT codigo, nombre, apellido FROM profesor WHERE estatus=true;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                
                data.add(nombre+" "+apellido);
                mapaProfesor.put(nombre+" "+apellido, codigo);
            }
            for (String profesor : data) {
                view.getComboProfSec().addItem(profesor);
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
    
    private void buscarSeccion(){
        int index = this.view.getComboSecciones().getSelectedIndex();
        
        this.seccion = arraySecciones.get(index-1);
        this.view.getCampoNumSec().setText(this.seccion.getNumero());
        this.view.getCampoMaxEstSec().setText(String.valueOf(this.seccion.getMax_estudiantes()));
        this.view.getComboAsigSec().setSelectedItem(this.seccion.getAsignatura_id().getNombre());
        this.view.getComboPerAcaSec().setSelectedItem(this.seccion.getPeriodo_id().getNombre());
        this.view.getComboProfSec().setSelectedItem(this.seccion.getProfesor_id().getNombre()+" "+this.seccion.getProfesor_id().getApellido());
        if(this.seccion.isEstatus()){
            this.view.getComboStaSec().setSelectedIndex(1);
        }else{
            this.view.getComboStaSec().setSelectedIndex(2);
        }
        this.inhabilitarCampos();
        this.view.getBotonModificarSeccion().setEnabled(true);
        this.view.getBontonCancelarSeccion().setEnabled(true);
        this.view.getBotonEliminarSeccion().setEnabled(true);
    }
    
    private void editarSeccion(){
        String sql = "UPDATE seccion SET numero = ?, max_estudiantes = ?, asignatura_id = ?, profesor_id = ?, periodo_id = ? WHERE codigo = ?;";
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, this.view.getCampoNumSec().getText());
            statement.setInt(2, Integer.valueOf(this.view.getCampoMaxEstSec().getText()));
            statement.setInt(3, this.obtenerAsignaturaSeleccionadaForm());
            statement.setInt(4, this.obtenerProfesorSeleccionadaForm());
            statement.setInt(5, this.obtenerPeriodoSeleccionadoForm());
            statement.setInt(6, this.seccion.getCodigo());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(view,"Se ha actualizado exitosamente!");
            this.limpiarCampos();
            
            
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
    
    private void registrarSeccion(){
        String sql = "INSERT INTO seccion (numero, max_estudiantes, asignatura_id, profesor_id, periodo_id) VALUES(?,?,?,?,?);";
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, this.view.getCampoNumSec().getText());
            statement.setInt(2, Integer.valueOf(this.view.getCampoMaxEstSec().getText()));
            statement.setInt(3, this.obtenerAsignaturaSeleccionadaForm());
            statement.setInt(4, this.obtenerProfesorSeleccionadaForm());
            statement.setInt(5, this.obtenerPeriodoSeleccionadoForm());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(view,"Se ha registrado exitosamente!");
            this.limpiarCampos();
            
            
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
    
    private void eliminarSeccion(MSeccion seccion){
        try{
            String sql = "UPDATE seccion SET estatus = false WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, seccion.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha eliminado exitosamente!");
            this.limpiarCampos();
            
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
    
    
    private int obtenerPeriodoSeleccionado() {
        int selectedIndex = view.getComboPerAcaBusSec().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombrePeriodoSeleccionado = (String) view.getComboPerAcaBusSec().getSelectedItem(); // Obtener nombre de periodo academico seleccionado
            return mapaPeriodoAcademico.get(nombrePeriodoSeleccionado); // Obtener código de periodo academico a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerAsignaturaSeleccionada() {
        int selectedIndex = view.getComboAsigBusSec().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreAsignaturaSeleccionada = (String) view.getComboAsigBusSec().getSelectedItem(); // Obtener nombre de asignatura seleccionada
            return mapaAsignatura.get(nombreAsignaturaSeleccionada); // Obtener código de asignatura a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerPeriodoSeleccionadoForm() {
        int selectedIndex = view.getComboPerAcaSec().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombrePeriodoSeleccionado = (String) view.getComboPerAcaSec().getSelectedItem(); // Obtener nombre de periodo academico seleccionado
            return mapaPeriodoAcademico.get(nombrePeriodoSeleccionado); // Obtener código de periodo academico a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerAsignaturaSeleccionadaForm() {
        int selectedIndex = view.getComboAsigSec().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreAsignaturaSeleccionada = (String) view.getComboAsigSec().getSelectedItem(); // Obtener nombre de asignatura seleccionada
            return mapaAsignatura.get(nombreAsignaturaSeleccionada); // Obtener código de asignatura a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerProfesorSeleccionadaForm() {
        int selectedIndex = view.getComboProfSec().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreProfesorSeleccionada = (String) view.getComboProfSec().getSelectedItem(); // Obtener nombre de prof seleccionada
            return mapaProfesor.get(nombreProfesorSeleccionada); // Obtener código de prof a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private void inhabilitarCampos(){
        this.view.getCampoNumSec().setEditable(false);
        this.view.getCampoMaxEstSec().setEditable(false);
        
        this.view.getComboSecciones().setEnabled(false);
        this.view.getComboAsigSec().setEnabled(false);
        this.view.getComboPerAcaSec().setEnabled(false);
        this.view.getComboProfSec().setEnabled(false);
        this.view.getComboStaSec().setEnabled(false);
        
        this.view.getBotonAgregarSeccion().setEnabled(true);
        this.view.getBotonBuscarSeccion().setEnabled(true);
        this.view.getBotonEliminarSeccion().setEnabled(false);
        this.view.getBotonGuardarSeccion().setEnabled(false);
        this.view.getBotonModificarSeccion().setEnabled(false);
        this.view.getBontonCancelarSeccion().setEnabled(false);
    }
    
    private void habilitarCampos(){
        this.view.getCampoNumSec().setEditable(true);
        this.view.getCampoMaxEstSec().setEditable(true);
        
        this.view.getComboAsigSec().setEnabled(true);
        this.view.getComboPerAcaSec().setEnabled(true);
        this.view.getComboProfSec().setEnabled(true);
        this.view.getComboStaSec().setEnabled(true);
        
        this.view.getBotonAgregarSeccion().setEnabled(false);
        this.view.getBotonEliminarSeccion().setEnabled(false);
        this.view.getBotonGuardarSeccion().setEnabled(true);
        this.view.getBotonModificarSeccion().setEnabled(false);
        this.view.getBontonCancelarSeccion().setEnabled(true);
        this.view.getBotonBuscarSeccion().setEnabled(false);
    }
    
    private void limpiarCampos(){
        inhabilitarCampos();
        this.view.getCampoNumSec().setText("");
        this.view.getCampoMaxEstSec().setText("");
        
        this.view.getComboAsigBusSec().setSelectedIndex(0);
        this.view.getComboPerAcaBusSec().setSelectedIndex(0);
        this.view.getComboSecciones().removeAllItems();
        this.view.getComboAsigSec().setSelectedIndex(0);
        this.view.getComboPerAcaSec().setSelectedIndex(0);
        this.view.getComboProfSec().setSelectedIndex(0);
        this.view.getComboStaSec().setSelectedIndex(0);
        
        this.asignatura = null;
        this.periodoAcademico = null;
        this.profesor = null;
        this.seccion = null;
    }
    
    private boolean validarCampos(){
        int indexAsig = this.view.getComboAsigSec().getSelectedIndex();
        int indexPer = this.view.getComboPerAcaSec().getSelectedIndex();
        int indexProf = this.view.getComboProfSec().getSelectedIndex();
        String numero = this.view.getCampoNumSec().getText();
        String max = this.view.getCampoMaxEstSec().getText();
        
        if(!numero.isEmpty() && !max.isEmpty() && indexAsig > 0 && indexPer > 0 && indexProf > 0){
            return true;
        }else{
            return false;
        }
    }
    
    
}
