// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.EstudianteAdmin;
import vistas.DashboardAdministrador;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import conexion.CConexion;
import java.util.*;
import modelo.MEstudiante;
import modelo.MCarrera;

public class CEstudianteAdmin {
    private EstudianteAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaEstudiante;
    private HashMap<String, Integer> mapaCarrera; 
    private MEstudiante estudiante;
    private MCarrera carrera;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CEstudianteAdmin(EstudianteAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        
        this.estudiante = null;
        this.mapaCarrera = new HashMap<>();
    
        this.view.getComboStaEst().addItem("Seleccione opción");
        this.view.getComboStaEst().addItem("Activo");
        this.view.getComboStaEst().addItem("Inactivo");
        
        this.view.getComboCarEst().addItem("Seleccione opción");
        this.llenarCbxCarreras();
        this.view.getCampoCedBusEst().setEditable(true);
        
        //Accion de boton atras
        this.view.getBontonAtrasEst().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        //Accion boton cancelar
        this.view.getBontonCancelarEst().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?");
                if (JOptionPane.OK_OPTION==confirmado) {
                        limpiarCampos();
                        view.getCampoCedBusEst().setEnabled(true);
                }
            }
        });
        
        //Accion de boton Buscar
        this.view.getBotonBuscarEst().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = view.getCampoCedBusEst().getText();

                // Verificar si se seleccionó alguna opción
                if (!cedula.isEmpty()) { 
                    buscarEstudiante();
                }else{
                    JOptionPane.showMessageDialog(view,"Debe ingresar una cédula", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                
            }
        });
        
        //Accion boton modificar
        this.view.getBotonModificarEst().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(estudiante != null){
                    habilitarCampos();
                    view.getCampoCedEst().setEditable(false);
                    view.getBotonModificarEst().setEnabled(false);
                    view.getComboStaEst().setEnabled(false);
                }
            }
        });
        
        this.view.getBotonGuardarEst().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()){
                    if(estudiante != null){
                        estudiante.setNombre(view.getCampoNomEst().getText());
                        estudiante.setApellido(view.getCampoApeEst().getText());
                        estudiante.setCorreo(view.getCampoCorEst().getText());
                        estudiante.setDireccion(view.getCampoDirEst().getText());
                        estudiante.setTelefono(view.getCampoTelEst().getText());
                        
                        MCarrera carrera = new MCarrera();
                        carrera.setCodigo(obtenerCarreraSeleccionada());
                        carrera.setNombre(view.getComboCarEst().getSelectedItem().toString());
                        estudiante.setCarrera_id(carrera);
                        
                        editarEstudiante(estudiante);
                    }else{
                        registrarEstudiante();
                    }
                }else{
                    JOptionPane.showMessageDialog(view,"Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Accion boton eliminar
        this.view.getBotonEliminarEst().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el estudiante?");
                if (JOptionPane.OK_OPTION==confirmado) {
                
                    if(estudiante != null){
                        eliminarEstudiante(estudiante);
                    }
                }
            }
        });
        
        //Accion boton agregar
        this.view.getBotonAgregarEst().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
                habilitarCampos();
            }
        });
        
        
        
    }
    
    public void buscarEstudiante(){
        String cedula = this.view.getCampoCedBusEst().getText();
        
        try{
            String sql = "SELECT e.codigo as codigo, e.nombre as nombre, e.apellido as apellido, e.direccion as direccion, e.telefono as telefono, e.correo as correo, e.estatus as estatus, c.codigo as codigo_carrera, c.nombre as nombre_carrera "
                    + "FROM estudiante e "
                    + "INNER JOIN carrera c ON e.carrera_id = c.codigo "
                    + "WHERE e.cedula = ? AND e.estatus = true LIMIT 1;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, cedula);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            if (resultSet.next()) {
                carrera = new MCarrera();
                carrera.setCodigo(resultSet.getInt("codigo_carrera"));
                carrera.setNombre(resultSet.getString("nombre_carrera"));
                
                this.estudiante = new MEstudiante(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    cedula,
                    resultSet.getString("direccion"),
                    resultSet.getString("correo"),
                    resultSet.getString("telefono"),
                    carrera,
                    resultSet.getBoolean("estatus")
                );

                this.view.getCampoCedEst().setText(this.estudiante.getCedula());
                this.view.getCampoNomEst().setText(this.estudiante.getNombre());
                this.view.getCampoApeEst().setText(this.estudiante.getApellido());
                this.view.getCampoDirEst().setText(this.estudiante.getDireccion());
                this.view.getCampoCorEst().setText(this.estudiante.getCorreo());
                this.view.getCampoTelEst().setText(this.estudiante.getTelefono());
                
                if(this.estudiante.isEstatus()){
                    this.view.getComboStaEst().setSelectedIndex(1);
                }else{
                    this.view.getComboStaEst().setSelectedIndex(2);    
                }
                
                this.view.getComboCarEst().setSelectedItem(this.estudiante.getCarrera_id().getNombre());
                
                this.inhabilitarCampos();
                this.view.getBotonEliminarEst().setEnabled(true);
                this.view.getBotonModificarEst().setEnabled(true);
                this.view.getBontonCancelarEst().setEnabled(true);
    
                
            }else{
                JOptionPane.showMessageDialog(view,"No se encontro la cédula ingresada", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    private void editarEstudiante(MEstudiante estudiante){
        try{
            String sql = "UPDATE estudiante SET nombre = ?, apellido = ?, correo = ?, direccion = ?, telefono = ?, carrera_id = ? WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, estudiante.getNombre());
            statement.setString(2, estudiante.getApellido());
            statement.setString(3, estudiante.getCorreo());
            statement.setString(4, estudiante.getDireccion());
            statement.setString(5, estudiante.getTelefono());
            statement.setInt(6, estudiante.getCarrera_id().getCodigo());
            statement.setInt(7, estudiante.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha actualizado exitosamente!");
            this.limpiarCampos();
            this.view.getCampoCedBusEst().setEnabled(true);
            
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
    
    private void registrarEstudiante(){
        try{
            String sql = "INSERT INTO estudiante(cedula, nombre, apellido, correo, direccion, telefono, carrera_id) VALUES(?,?,?,?,?,?,?);";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, view.getCampoCedEst().getText());
            statement.setString(2, view.getCampoNomEst().getText());
            statement.setString(3, view.getCampoApeEst().getText());
            statement.setString(4, view.getCampoCorEst().getText());
            statement.setString(5, view.getCampoDirEst().getText());
            statement.setString(6, view.getCampoTelEst().getText());
            statement.setInt(7, this.obtenerCarreraSeleccionada());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha registrado exitosamente!");
            this.limpiarCampos();
            this.view.getCampoCedBusEst().setEnabled(true);
            
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
    
    private void eliminarEstudiante(MEstudiante estudiante){
        try{
            String sql = "UPDATE estudiante SET estatus = false WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, estudiante.getCodigo());
            
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
    
    private void llenarCbxCarreras(){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT codigo, nombre FROM carrera WHERE estatus=true;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaCarrera.put(nombre, codigo);
            }
            for (String sem : data) {
                view.getComboCarEst().addItem(sem);
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
    
    private void inhabilitarCampos(){
        this.view.getCampoNomEst().setEditable(false);
        this.view.getCampoApeEst().setEditable(false);
        this.view.getCampoCedEst().setEditable(false);
        this.view.getCampoCorEst().setEditable(false);
        this.view.getCampoDirEst().setEditable(false);
        this.view.getCampoTelEst().setEditable(false);
        this.view.getComboStaEst().setEnabled(false);
        this.view.getComboCarEst().setEnabled(false);
        
        this.view.getBotonAgregarEst().setEnabled(true);
        this.view.getBotonBuscarEst().setEnabled(true);
        this.view.getBotonEliminarEst().setEnabled(false);
        this.view.getBotonGuardarEst().setEnabled(false);
        this.view.getBotonModificarEst().setEnabled(false);
        this.view.getBontonCancelarEst().setEnabled(false);
    }
    
    private void habilitarCampos(){
        this.view.getCampoCedBusEst().setEnabled(false);
        this.view.getCampoNomEst().setEditable(true);
        this.view.getCampoApeEst().setEditable(true);
        this.view.getCampoCedEst().setEditable(true);
        this.view.getCampoCorEst().setEditable(true);
        this.view.getCampoDirEst().setEditable(true);
        this.view.getCampoTelEst().setEditable(true);
        this.view.getComboStaEst().setEnabled(true);
        this.view.getComboCarEst().setEnabled(true);
        
        this.view.getBotonAgregarEst().setEnabled(false);
        this.view.getBotonEliminarEst().setEnabled(false);
        this.view.getBotonGuardarEst().setEnabled(true);
        this.view.getBotonModificarEst().setEnabled(false);
        this.view.getBontonCancelarEst().setEnabled(true);
        this.view.getBotonBuscarEst().setEnabled(false);
    }
    
    private void limpiarCampos(){
        inhabilitarCampos();
        this.view.getCampoNomEst().setText("");
        this.view.getCampoApeEst().setText("");
        this.view.getCampoCedEst().setText("");
        this.view.getCampoCorEst().setText("");
        this.view.getCampoDirEst().setText("");
        this.view.getCampoTelEst().setText("");
        this.view.getComboStaEst().setSelectedIndex(0);
        this.view.getComboCarEst().setSelectedIndex(0);
        this.view.getCampoCedBusEst().setText("");
        this.estudiante = null;
    }
    
    private boolean validarCampos(){
        String nombre =  this.view.getCampoNomEst().getText();
        String apellido =  this.view.getCampoApeEst().getText();
        String correo =  this.view.getCampoCorEst().getText();
        String direccion =  this.view.getCampoDirEst().getText();
        String telefono =  this.view.getCampoTelEst().getText();
        String cedula =  this.view.getCampoCedEst().getText();
        int carrera_id  = this.view.getComboCarEst().getSelectedIndex();
        
        if(!nombre.isEmpty() && !apellido.isEmpty() && !correo.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !cedula.isEmpty() && carrera_id > 0){
            return true;
        }else{
            return false;
        }
    }
    
    private int obtenerCarreraSeleccionada() {
        int selectedIndex = view.getComboCarEst().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreCarreraSeleccionada = (String) view.getComboCarEst().getSelectedItem(); // Obtener nombre de carrera seleccionada
            return mapaCarrera.get(nombreCarreraSeleccionada); // Obtener código de carrera a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
}

