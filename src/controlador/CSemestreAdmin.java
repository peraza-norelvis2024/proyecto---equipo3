// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.SemestreAdmin;
import vistas.DashboardAdministrador;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import conexion.CConexion;
import java.util.*;
import modelo.MSemestre;

public class CSemestreAdmin {
    private SemestreAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaSemestre;; 
    private MSemestre semestre;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CSemestreAdmin(SemestreAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.mapaSemestre = new HashMap<>();
        this.semestre = null;
        
        //Llenamos el combo de semestres registrados
        this.view.getComboNomBusSem().addItem("Seleccione opción");
        this.llenarCbxSemestres();
        this.view.getComboStaSem().addItem("Seleccione opción");
        this.view.getComboStaSem().addItem("Activo");
        this.view.getComboStaSem().addItem("Inactivo");
        
        //Accion de boton atras
        this.view.getBontonAtrasSem().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        //Accion de boton Buscar
        this.view.getBotonBuscarSem().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = view.getComboNomBusSem().getSelectedIndex();

                // Verificar si se seleccionó alguna opción
                if (selectedIndex != -1 && selectedIndex > 0) { 
                    buscarSemestre();
                }else{
                    JOptionPane.showMessageDialog(view,"Debe seleccionar un semestre", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                
            }
        });
        
        //Accion boton modificar
        this.view.getBotonModificarSem().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(semestre != null){
                    habilitarCampos();
                    view.getBotonModificarSem().setEnabled(false);
                    view.getComboStaSem().setEnabled(false);
                }
            }
        });
        
        //Accion boton cancelar
        this.view.getBontonCancelarSem().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?");
                if (JOptionPane.OK_OPTION==confirmado) {
                        limpiarCampos();
                        view.getComboNomBusSem().setEnabled(true);
                }
            }
        });
        
        this.view.getBotonGuardarSem().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()){
                    if(semestre != null){
                        semestre.setNombre(view.getCampoNomSem().getText());
                        editarSemestre(semestre);
                    }else{
                        registrarSemestre();
                    }
                }else{
                    JOptionPane.showMessageDialog(view,"Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Accion boton eliminar
        this.view.getBotonEliminarSem().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el semestre?");
                if (JOptionPane.OK_OPTION==confirmado) {
                
                    if(semestre != null){
                        eliminarSemestre(semestre);
                    }
                }
            }
        });
        
        //Accion boton agregar
        this.view.getBotonAgregarSem().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
                habilitarCampos();   
            }
        });
    }
    
        private void llenarCbxSemestres(){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT codigo, nombre FROM semestre WHERE estatus=true;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaSemestre.put(nombre, codigo);
            }
            for (String semestre : data) {
                view.getComboNomBusSem().addItem(semestre);
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
    
    public void buscarSemestre(){
        int codigoSemestreSeleccionado = this.obtenerSemestreSeleccionado();
        
        try{
            String sql = "SELECT s.codigo as codigo, s.nombre as nombre, s.estatus as estatus "
                    + "FROM semestre s "
                    + "WHERE s.codigo = ? LIMIT 1;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, codigoSemestreSeleccionado);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            if (resultSet.next()) {
                this.semestre = new MSemestre(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getBoolean("estatus")
                );

                this.view.getCampoNomSem().setText(this.semestre.getNombre());
                
                if(this.semestre.isEstatus()){
                    this.view.getComboStaSem().setSelectedIndex(1);
                }else{
                    this.view.getComboStaSem().setSelectedIndex(2);    
                }
                this.inhabilitarCampos();
                this.view.getBotonEliminarSem().setEnabled(true);
                this.view.getBotonModificarSem().setEnabled(true);
                this.view.getBontonCancelarSem().setEnabled(true);
    
                
            }else{
                JOptionPane.showMessageDialog(view,"No se encontro el semestre seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    private void editarSemestre(MSemestre semestre){
        try{
            String sql = "UPDATE semestre SET nombre = ? WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, semestre.getNombre());
            statement.setInt(2, semestre.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha actualizado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusSem().removeAllItems();
            this.mapaSemestre = new HashMap<>();
            this.view.getComboNomBusSem().addItem("Seleccione opción");
            this.view.getComboNomBusSem().setEnabled(true);
            this.llenarCbxSemestres();
        
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
    
    private void eliminarSemestre(MSemestre semestre){
        try{
            String sql = "UPDATE semestre SET estatus = false WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, semestre.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha eliminado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusSem().removeAllItems();
            this.mapaSemestre = new HashMap<>();
            this.view.getComboNomBusSem().addItem("Seleccione opción");
            this.view.getComboNomBusSem().setEnabled(true);
            this.llenarCbxSemestres();
        
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
    
    private void registrarSemestre(){
        try{
            String sql = "INSERT INTO semestre(nombre) VALUES(?);";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, view.getCampoNomSem().getText());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha registrado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusSem().removeAllItems();
            this.mapaSemestre = new HashMap<>();
            this.view.getComboNomBusSem().addItem("Seleccione opción");
            this.view.getComboNomBusSem().setEnabled(true);
            this.llenarCbxSemestres();
        
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
    
    private int obtenerSemestreSeleccionado() {
        int selectedIndex = view.getComboNomBusSem().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreSemestreSeleccionado = (String) view.getComboNomBusSem().getSelectedItem(); // Obtener nombre del semestre seleccionado
            return mapaSemestre.get(nombreSemestreSeleccionado); // Obtener código de semestre a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private void inhabilitarCampos(){
        this.view.getCampoNomSem().setEditable(false);
        this.view.getComboStaSem().setEnabled(false);
        this.view.getBotonAgregarSem().setEnabled(true);
        this.view.getBotonBuscarSem().setEnabled(true);
        this.view.getBotonEliminarSem().setEnabled(false);
        this.view.getBotonGuardarSem().setEnabled(false);
        this.view.getBotonModificarSem().setEnabled(false);
        this.view.getBontonCancelarSem().setEnabled(false);
    }
    
    private void habilitarCampos(){
        this.view.getComboNomBusSem().setEnabled(false);
        this.view.getCampoNomSem().setEditable(true);
        this.view.getComboStaSem().setEnabled(true);
        this.view.getBotonAgregarSem().setEnabled(false);
        this.view.getBotonEliminarSem().setEnabled(false);
        this.view.getBotonGuardarSem().setEnabled(true);
        this.view.getBotonModificarSem().setEnabled(false);
        this.view.getBontonCancelarSem().setEnabled(true);
        this.view.getBotonBuscarSem().setEnabled(false);
    }
    
    private void limpiarCampos(){
        inhabilitarCampos();
        this.view.getCampoNomSem().setText("");
        this.view.getComboStaSem().setSelectedIndex(0);
        this.view.getComboNomBusSem().setSelectedIndex(0);
        this.semestre = null;
    }
    
    private boolean validarCampos(){
        String nombre =  this.view.getCampoNomSem().getText();
        
        if(!nombre.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
