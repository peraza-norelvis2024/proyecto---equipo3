// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.CarreraAdmin;
import vistas.DashboardAdministrador;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import conexion.CConexion;
import java.util.*;
import modelo.MCarrera;
import modelo.MDecanato;
import modelo.MUniversidad;

public class CCarreraAdmin {
    private CarreraAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaCarrera;
    private HashMap<String, Integer> mapaDecanato; 
    private MCarrera carrera;
    private MDecanato decanato;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CCarreraAdmin(CarreraAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.mapaCarrera = new HashMap<>();
        this.mapaDecanato = new HashMap<>();
        this.carrera = null;
        this.decanato = null;
        
        //Llenamos el combo de carreras registradas
        this.view.getComboNomBusCar().addItem("Seleccione opción");
        this.llenarCbxCarreras();
        this.view.getComboDecCar().addItem("Seleccione opción");
        this.llenarCbxDecanatos();
        this.view.getComboStaCar().addItem("Seleccione opción");
        this.view.getComboStaCar().addItem("Activo");
        this.view.getComboStaCar().addItem("Inactivo");
        
        //Accion de boton atras
        this.view.getBontonAtrasCar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        //Accion de boton Buscar
        this.view.getBotonBuscarCar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = view.getComboNomBusCar().getSelectedIndex();

                // Verificar si se seleccionó alguna opción
                if (selectedIndex != -1 && selectedIndex > 0) { 
                    buscarCarrera();
                }else{
                    JOptionPane.showMessageDialog(view,"Debe seleccionar una carrera", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                
            }
        });
        
        //Accion boton modificar
        this.view.getBotonModificarCar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(carrera != null){
                    habilitarCampos();
                    view.getBotonModificarCar().setEnabled(false);
                    view.getComboStaCar().setEnabled(false);
                }
            }
        });
        
        //Accion boton cancelar
        this.view.getBontonCancelarCar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?");
                if (JOptionPane.OK_OPTION==confirmado) {
                        limpiarCampos();
                        view.getComboNomBusCar().setEnabled(true);
                }
            }
        });
        
        this.view.getBotonGuardarCar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()){
                    if(carrera != null){
                        carrera.setNombre(view.getCampoNomCar().getText());
                        carrera.setDescripcion(view.getCampoDesCar().getText());
                        carrera.getDecanato_id().setCodigo(obtenerDecanatoSeleccionado());
                        carrera.getDecanato_id().setNombre(view.getComboDecCar().getSelectedItem().toString());
                        editarCarrera(carrera);
                    }else{
                        registrarCarrera();
                    }
                }else{
                    JOptionPane.showMessageDialog(view,"Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Accion boton eliminar
        this.view.getBotonEliminarCar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la carrera?");
                if (JOptionPane.OK_OPTION==confirmado) {
                
                    if(carrera != null){
                        eliminarCarrera(carrera);
                    }
                }
            }
        });
        
        //Accion boton agregar
        this.view.getBotonAgregarCar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
                habilitarCampos();   
            }
        });
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
            for (String carrera : data) {
                view.getComboNomBusCar().addItem(carrera);
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
    
    private void llenarCbxDecanatos(){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT codigo, nombre FROM decanato WHERE estatus=true;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaDecanato.put(nombre, codigo);
            }
            for (String decanato : data) {
                view.getComboDecCar().addItem(decanato);
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
    
    public void buscarCarrera(){
        int codigoCarreraSeleccionada = this.obtenerCarreraSeleccionada();
        
        try{
            String sql = "SELECT c.codigo as codigo, c.nombre as nombre, c.descripcion as descripcion, c.decanato_id as decanato_id, c.estatus as estatus, d.codigo as codigo_deca, d.nombre as nombre_deca, d.descripcion as descripcion_deca, d.estatus as estatus_deca "
                    + "FROM carrera c "
                    + "INNER JOIN decanato d ON c.decanato_id = d.codigo "
                    + "WHERE c.codigo = ? LIMIT 1;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, codigoCarreraSeleccionada);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            if (resultSet.next()) {
                
                this.decanato = new MDecanato(
                    resultSet.getInt("codigo_deca"),
                    resultSet.getString("nombre_deca"),
                    resultSet.getString("descripcion_deca"),
                    new MUniversidad(),
                    resultSet.getBoolean("estatus_deca")
                );
                
                this.carrera = new MCarrera(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getString("descripcion"),
                    decanato,
                    resultSet.getBoolean("estatus")
                );
                
                this.view.getCampoNomCar().setText(this.carrera.getNombre());
                this.view.getCampoDesCar().setText(this.carrera.getDescripcion());
                
                if(this.decanato.isEstatus()){
                    this.view.getComboStaCar().setSelectedIndex(1);
                }else{
                    this.view.getComboStaCar().setSelectedIndex(2);    
                }
                
                this.view.getComboDecCar().setSelectedItem(this.decanato.getNombre());
                
                this.inhabilitarCampos();
                this.view.getComboDecCar().setEnabled(false);
                this.view.getBotonEliminarCar().setEnabled(true);
                this.view.getBotonModificarCar().setEnabled(true);
                this.view.getBontonCancelarCar().setEnabled(true);
    
                
            }else{
                JOptionPane.showMessageDialog(view,"No se encontro la carrera seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    private void editarCarrera(MCarrera carrera){
        try{
            String sql = "UPDATE carrera SET nombre = ?, descripcion = ?, decanato_id = ? WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, carrera.getNombre());
            statement.setString(2, carrera.getDescripcion());
            statement.setInt(3, carrera.getDecanato_id().getCodigo());
            statement.setInt(4, carrera.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha actualizado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusCar().removeAllItems();
            this.mapaCarrera = new HashMap<>();
            this.view.getComboNomBusCar().addItem("Seleccione opción");
            this.view.getComboNomBusCar().setEnabled(true);
            this.llenarCbxCarreras();
            this.view.getComboDecCar().setSelectedIndex(0);
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
    
    private void eliminarCarrera(MCarrera carrera){
        try{
            String sql = "UPDATE carrera SET estatus = false WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, carrera.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha eliminado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusCar().removeAllItems();
            this.mapaCarrera = new HashMap<>();
            this.view.getComboNomBusCar().addItem("Seleccione opción");
            this.view.getComboNomBusCar().setEnabled(true);
            this.llenarCbxCarreras();
        
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
    
    private void registrarCarrera(){
        try{
            String sql = "INSERT INTO carrera(nombre, descripcion, decanato_id) VALUES(?,?,?);";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, view.getCampoNomCar().getText());
            statement.setString(2, view.getCampoDesCar().getText());
            statement.setInt(3, this.obtenerDecanatoSeleccionado());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha registrado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusCar().removeAllItems();
            this.mapaCarrera = new HashMap<>();
            this.view.getComboNomBusCar().addItem("Seleccione opción");
            this.view.getComboNomBusCar().setEnabled(true);
            this.llenarCbxCarreras();
        
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
    
    private int obtenerCarreraSeleccionada() {
        int selectedIndex = view.getComboNomBusCar().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreCarreraSeleccionada = (String) view.getComboNomBusCar().getSelectedItem(); // Obtener nombre la carrera seleccionada
            return mapaCarrera.get(nombreCarreraSeleccionada); // Obtener código de la carrera a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerDecanatoSeleccionado() {
        int selectedIndex = view.getComboDecCar().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreDecanatoSeleccionado = (String) view.getComboDecCar().getSelectedItem(); // Obtener nombre de decanato seleccionado
            return mapaDecanato.get(nombreDecanatoSeleccionado); // Obtener código de decanato a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private void inhabilitarCampos(){
        this.view.getCampoNomCar().setEditable(false);
        this.view.getCampoDesCar().setEditable(false);
        this.view.getComboStaCar().setEnabled(false);
        this.view.getComboDecCar().setEnabled(false);
        this.view.getBotonAgregarCar().setEnabled(true);
        this.view.getBotonBuscarCar().setEnabled(true);
        this.view.getBotonEliminarCar().setEnabled(false);
        this.view.getBotonGuardarCar().setEnabled(false);
        this.view.getBotonModificarCar().setEnabled(false);
        this.view.getBontonCancelarCar().setEnabled(false);
    }
    
    private void habilitarCampos(){
        this.view.getComboNomBusCar().setEnabled(false);
        this.view.getCampoNomCar().setEditable(true);
        this.view.getCampoDesCar().setEditable(true);
        this.view.getComboStaCar().setEnabled(true);
        this.view.getComboDecCar().setEnabled(true);
        this.view.getBotonAgregarCar().setEnabled(false);
        this.view.getBotonEliminarCar().setEnabled(false);
        this.view.getBotonGuardarCar().setEnabled(true);
        this.view.getBotonModificarCar().setEnabled(false);
        this.view.getBontonCancelarCar().setEnabled(true);
        this.view.getBotonBuscarCar().setEnabled(false);
    }
    
    private void limpiarCampos(){
        inhabilitarCampos();
        this.view.getCampoNomCar().setText("");
        this.view.getCampoDesCar().setText("");
        this.view.getComboStaCar().setSelectedIndex(0);
        this.view.getComboNomBusCar().setSelectedIndex(0);
        this.view.getComboDecCar().setSelectedIndex(0);
        this.decanato = null;
        this.carrera = null;
    }
    
    private boolean validarCampos(){
        String nombre =  this.view.getCampoNomCar().getText();
        String descripcion =  this.view.getCampoDesCar().getText();
        int decanato =  this.view.getComboDecCar().getSelectedIndex();
        
        if(!nombre.isEmpty() && !descripcion.isEmpty() && decanato > 0){
            return true;
        }else{
            return false;
        }
    }
}
