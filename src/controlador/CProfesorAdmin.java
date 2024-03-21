// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.DashboardAdministrador;
import vistas.ProfesorAdmin;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import conexion.CConexion;
import java.util.*;

import modelo.MProfesor;
import modelo.MUsuario;

public class CProfesorAdmin {
    private ProfesorAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private MProfesor profesor;
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CProfesorAdmin(ProfesorAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        
        this.profesor = null;
        
        this.view.getComboStaProf().addItem("Seleccione opción");
        this.view.getComboStaProf().addItem("Activo");
        this.view.getComboStaProf().addItem("Inactivo");
        
        //Accion de boton atras
        this.view.getBontonAtrasProf().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        //Accion boton cancelar
        this.view.getBontonCancelarProf().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?");
                if (JOptionPane.OK_OPTION==confirmado) {
                        limpiarCampos();
                        view.getCampoCedBusProf().setEnabled(true);
                }
            }
        });
        
        //Accion de boton Buscar
        this.view.getBotonBuscarProf().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = view.getCampoCedBusProf().getText();

                // Verificar si se seleccionó alguna opción
                if (!cedula.isEmpty()) { 
                    buscarProfesor();
                }else{
                    JOptionPane.showMessageDialog(view,"Debe ingresar una cédula", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                
            }
        });
        
        //Accion boton modificar
        this.view.getBotonModificarProf().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(profesor != null){
                    habilitarCampos();
                    view.getCampoCedProf().setEditable(false);
                    view.getBotonModificarProf().setEnabled(false);
                    view.getComboStaProf().setEnabled(false);
                }
            }
        });
        
        this.view.getBotonGuardarProf().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()){
                    if(profesor != null){
                        profesor.setNombre(view.getCampoNomProf().getText());
                        profesor.setApellido(view.getCampoApeProf().getText());
                        profesor.setCorreo(view.getCampoCorProf().getText());
                        profesor.setDireccion(view.getCampoDirProf().getText());
                        profesor.setTelefono(view.getCampoTelProf().getText());
                        profesor.setEspecialidad(view.getCampoEspProf().getText());
                        editarProfesor(profesor);
                    }else{
                        registrarProfesor();
                    }
                }else{
                    JOptionPane.showMessageDialog(view,"Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Accion boton eliminar
        this.view.getBotonEliminarProf().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el profesor?");
                if (JOptionPane.OK_OPTION==confirmado) {
                
                    if(profesor != null){
                        eliminarProfesor(profesor);
                    }
                }
            }
        });
        
        //Accion boton agregar
        this.view.getBotonAgregarProf().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
                habilitarCampos();
            }
        });
        
    }
    
    public void buscarProfesor(){
        String cedula = this.view.getCampoCedBusProf().getText();
        
        try{
            String sql = "SELECT codigo, nombre, apellido, direccion, telefono, correo, especialidad, estatus "
                    + "FROM profesor "
                    + "WHERE cedula = ? AND estatus = true LIMIT 1;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, cedula);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            if (resultSet.next()) {
                
                this.profesor = new MProfesor(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    cedula,
                    resultSet.getString("direccion"),
                    resultSet.getString("correo"),
                    resultSet.getString("telefono"),
                    resultSet.getString("especialidad"),
                    new MUsuario(),
                    resultSet.getBoolean("estatus")
                );

                this.view.getCampoCedProf().setText(this.profesor.getCedula());
                this.view.getCampoNomProf().setText(this.profesor.getNombre());
                this.view.getCampoApeProf().setText(this.profesor.getApellido());
                this.view.getCampoDirProf().setText(this.profesor.getDireccion());
                this.view.getCampoCorProf().setText(this.profesor.getCorreo());
                this.view.getCampoTelProf().setText(this.profesor.getTelefono());
                this.view.getCampoEspProf().setText(this.profesor.getEspecialidad());
                
                if(this.profesor.isEstatus()){
                    this.view.getComboStaProf().setSelectedIndex(1);
                }else{
                    this.view.getComboStaProf().setSelectedIndex(2);    
                }
                
                this.inhabilitarCampos();
                this.view.getBotonEliminarProf().setEnabled(true);
                this.view.getBotonModificarProf().setEnabled(true);
                this.view.getBontonCancelarProf().setEnabled(true);
    
                
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
    
    private void editarProfesor(MProfesor profesor){
        try{
            String sql = "UPDATE profesor SET nombre = ?, apellido = ?, correo = ?, direccion = ?, telefono = ?, especialidad = ? WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, profesor.getNombre());
            statement.setString(2, profesor.getApellido());
            statement.setString(3, profesor.getCorreo());
            statement.setString(4, profesor.getDireccion());
            statement.setString(5, profesor.getTelefono());
            statement.setString(6, profesor.getEspecialidad());
            statement.setInt(7, profesor.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha actualizado exitosamente!");
            this.limpiarCampos();
            this.view.getCampoCedBusProf().setEnabled(true);
            
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
    
    private void registrarProfesor(){
        try{
            String sql = "INSERT INTO profesor(cedula, nombre, apellido, correo, direccion, telefono, especialidad) VALUES(?,?,?,?,?,?,?);";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, view.getCampoCedProf().getText());
            statement.setString(2, view.getCampoNomProf().getText());
            statement.setString(3, view.getCampoApeProf().getText());
            statement.setString(4, view.getCampoCorProf().getText());
            statement.setString(5, view.getCampoDirProf().getText());
            statement.setString(6, view.getCampoTelProf().getText());
            statement.setString(7, view.getCampoEspProf().getText());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha registrado exitosamente!");
            this.limpiarCampos();
            this.view.getCampoCedBusProf().setEnabled(true);
            
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
    
    private void eliminarProfesor(MProfesor profesor){
        try{
            String sql = "UPDATE profesor SET estatus = false WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, profesor.getCodigo());
            
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
    
    private void inhabilitarCampos(){
        this.view.getCampoNomProf().setEditable(false);
        this.view.getCampoApeProf().setEditable(false);
        this.view.getCampoCedProf().setEditable(false);
        this.view.getCampoCorProf().setEditable(false);
        this.view.getCampoDirProf().setEditable(false);
        this.view.getCampoEspProf().setEditable(false);
        this.view.getCampoTelProf().setEditable(false);
        this.view.getComboStaProf().setEnabled(false);
        this.view.getBotonAgregarProf().setEnabled(true);
        this.view.getBotonBuscarProf().setEnabled(true);
        this.view.getBotonEliminarProf().setEnabled(false);
        this.view.getBotonGuardarProf().setEnabled(false);
        this.view.getBotonModificarProf().setEnabled(false);
        this.view.getBontonCancelarProf().setEnabled(false);
    }
    
    private void habilitarCampos(){
        this.view.getCampoCedBusProf().setEnabled(false);
        this.view.getCampoNomProf().setEditable(true);
        this.view.getCampoApeProf().setEditable(true);
        this.view.getCampoCedProf().setEditable(true);
        this.view.getCampoCorProf().setEditable(true);
        this.view.getCampoDirProf().setEditable(true);
        this.view.getCampoEspProf().setEditable(true);
        this.view.getCampoTelProf().setEditable(true);
        this.view.getComboStaProf().setEnabled(true);
        
        this.view.getBotonAgregarProf().setEnabled(false);
        this.view.getBotonEliminarProf().setEnabled(false);
        this.view.getBotonGuardarProf().setEnabled(true);
        this.view.getBotonModificarProf().setEnabled(false);
        this.view.getBontonCancelarProf().setEnabled(true);
        this.view.getBotonBuscarProf().setEnabled(false);
    }
    
    private void limpiarCampos(){
        inhabilitarCampos();
        this.view.getCampoNomProf().setText("");
        this.view.getCampoApeProf().setText("");
        this.view.getCampoCedProf().setText("");
        this.view.getCampoCorProf().setText("");
        this.view.getCampoDirProf().setText("");
        this.view.getCampoEspProf().setText("");
        this.view.getCampoTelProf().setText("");
        this.view.getComboStaProf().setSelectedIndex(0);
        this.view.getCampoCedBusProf().setText("");
        this.profesor = null;
    }
    
    private boolean validarCampos(){
        String nombre =  this.view.getCampoNomProf().getText();
        String apellido =  this.view.getCampoApeProf().getText();
        String correo =  this.view.getCampoCorProf().getText();
        String direccion =  this.view.getCampoDirProf().getText();
        String telefono =  this.view.getCampoTelProf().getText();
        String especialidad =  this.view.getCampoEspProf().getText();
        String cedula =  this.view.getCampoCedProf().getText();
        
        
        if(!nombre.isEmpty() && !apellido.isEmpty() && !correo.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !especialidad.isEmpty() && !cedula.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
