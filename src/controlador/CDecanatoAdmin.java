// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.DecanatoAdmin;
import vistas.DashboardAdministrador;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import conexion.CConexion;
import java.util.*;
import modelo.MDecanato;
import modelo.MUniversidad;

public class CDecanatoAdmin {
    private DecanatoAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaDecanato;
    private HashMap<String, Integer> mapaUniversidad; 
    private MDecanato decanato;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public CDecanatoAdmin(DecanatoAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.mapaDecanato = new HashMap<>();
        this.mapaUniversidad = new HashMap<>();
        this.decanato = null;
        
        //Llenamos el combo de decanatos registrados
        this.view.getComboNombBusDec().addItem("Seleccione opción");
        this.llenarCbxDecanatos();
        this.view.getComboStaDec().addItem("Seleccione opción");
        this.view.getComboStaDec().addItem("Activo");
        this.view.getComboStaDec().addItem("Inactivo");
        
        //Accion de boton atras
        this.view.getBontonAtrasDec().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        //Accion de boton Buscar
        this.view.getBotonBuscarDec().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = view.getComboNombBusDec().getSelectedIndex();

                // Verificar si se seleccionó alguna opción
                if (selectedIndex != -1 && selectedIndex > 0) { 
                    buscarDecanato();
                }else{
                    JOptionPane.showMessageDialog(view,"Debe seleccionar un decanato", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                
            }
        });
        
        //Accion boton modificar
        this.view.getBotonModificarDec().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(decanato != null){
                    habilitarCampos();
                    view.getBotonModificarDec().setEnabled(false);
                    view.getComboStaDec().setEnabled(false);
                }
            }
        });
        
        //Accion boton cancelar
        this.view.getBontonCancelarDec().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?");
                if (JOptionPane.OK_OPTION==confirmado) {
                        limpiarCampos();
                        view.getComboNombBusDec().setEnabled(true);
                }
            }
        });
        
        this.view.getBotonGuardarDec().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()){
                    if(decanato != null){
                        decanato.setDescripcion(view.getCampoDesDec().getText());
                        decanato.setNombre(view.getCampoNomDec().getText());
                        editarDecanato(decanato);
                    }else{
                        registrarDecanato();
                    }
                }else{
                    JOptionPane.showMessageDialog(view,"Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Accion boton eliminar
        this.view.getBotonEliminarDec().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el decanato?");
                if (JOptionPane.OK_OPTION==confirmado) {
                
                    if(decanato != null){
                        eliminarDecanato(decanato);
                    }
                }
            }
        });
        
        //Accion boton agregar
        this.view.getBotonAgregarDec().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mapaUniversidad = new HashMap<>();
                limpiarCampos();
                habilitarCampos();
                view.getComboUniDec().removeAllItems();
                view.getComboUniDec().addItem("Seleccione opción");
                llenarCbxUniversidad();   
            }
        });
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
                view.getComboNombBusDec().addItem(decanato);
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
    
    private void llenarCbxUniversidad(){
        try{
            // Crear una lista para almacenar los datos del combo
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT codigo, nombre FROM universidad WHERE estatus=true;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaUniversidad.put(nombre, codigo);
            }
            for (String uni : data) {
                view.getComboUniDec().addItem(uni);
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
    
    public void buscarDecanato(){
        this.view.getComboUniDec().removeAllItems();
        int codigoDecanatoSeleccionado = this.obtenerDecanatoSeleccionado();
        
        try{
            String sql = "SELECT d.codigo as codigo, d.nombre as nombre, d.descripcion as descripcion, d.estatus as estatus, u.codigo as codigo_univ, u.nombre as nombre_univ, u.descripcion as descripcion_univ, u.estatus as estatus_univ "
                    + "FROM decanato d "
                    + "INNER JOIN universidad u ON d.universidad_id = u.codigo "
                    + "WHERE d.codigo = ? LIMIT 1;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, codigoDecanatoSeleccionado);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            if (resultSet.next()) {
                MUniversidad universidad = new MUniversidad(
                    resultSet.getInt("codigo_univ"),
                    resultSet.getString("nombre_univ"),
                    resultSet.getString("descripcion_univ"),
                    resultSet.getBoolean("estatus_univ")
                );
                
                this.decanato = new MDecanato(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getString("descripcion"),
                    universidad,
                    resultSet.getBoolean("estatus")
                );

                this.view.getCampoNomDec().setText(this.decanato.getNombre());
                this.view.getCampoDesDec().setText(this.decanato.getDescripcion());
                
                if(this.decanato.isEstatus()){
                    this.view.getComboStaDec().setSelectedIndex(1);
                }else{
                    this.view.getComboStaDec().setSelectedIndex(2);    
                }
                this.view.getComboUniDec().removeAllItems();
                this.view.getComboUniDec().addItem("Seleccione opción");
                this.view.getComboUniDec().addItem(this.decanato.getUniversidad_id().getNombre());
                this.view.getComboUniDec().setSelectedIndex(1);
                this.inhabilitarCampos();
                this.view.getBotonEliminarDec().setEnabled(true);
                this.view.getBotonModificarDec().setEnabled(true);
                this.view.getBontonCancelarDec().setEnabled(true);
    
                
            }else{
                JOptionPane.showMessageDialog(view,"No se encontro el decanato seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    private void editarDecanato(MDecanato decanato){
        try{
            String sql = "UPDATE decanato SET nombre = ?, descripcion = ? WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, decanato.getNombre());
            statement.setString(2, decanato.getDescripcion());
            statement.setInt(3, decanato.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha actualizado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNombBusDec().removeAllItems();
            this.mapaDecanato = new HashMap<>();
            this.view.getComboNombBusDec().addItem("Seleccione opción");
            this.view.getComboNombBusDec().setEnabled(true);
            this.llenarCbxDecanatos();
        
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
    
    private void eliminarDecanato(MDecanato decanato){
        try{
            String sql = "UPDATE decanato SET estatus = false WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, decanato.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha eliminado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNombBusDec().removeAllItems();
            this.mapaDecanato = new HashMap<>();
            this.view.getComboNombBusDec().addItem("Seleccione opción");
            this.view.getComboNombBusDec().setEnabled(true);
            this.llenarCbxDecanatos();
        
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
    
    private void registrarDecanato(){
        try{
            String sql = "INSERT INTO decanato(nombre, descripcion, universidad_id) VALUES(?,?,?);";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, view.getCampoNomDec().getText());
            statement.setString(2, view.getCampoDesDec().getText());
            statement.setInt(3, this.obtenerUniversidadSeleccionado());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha registrado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNombBusDec().removeAllItems();
            this.mapaDecanato = new HashMap<>();
            this.view.getComboNombBusDec().addItem("Seleccione opción");
            this.view.getComboNombBusDec().setEnabled(true);
            this.llenarCbxDecanatos();
        
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
    
    private int obtenerDecanatoSeleccionado() {
        int selectedIndex = view.getComboNombBusDec().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreDecanatoSeleccionado = (String) view.getComboNombBusDec().getSelectedItem(); // Obtener nombre de decanato seleccionado
            return mapaDecanato.get(nombreDecanatoSeleccionado); // Obtener código de decanato a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerUniversidadSeleccionado() {
        int selectedIndex = view.getComboUniDec().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreUniversidadSeleccionado = (String) view.getComboUniDec().getSelectedItem(); // Obtener nombre de decanato seleccionado
            return mapaUniversidad.get(nombreUniversidadSeleccionado); // Obtener código de decanato a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private void inhabilitarCampos(){
        this.view.getCampoNomDec().setEditable(false);
        this.view.getCampoDesDec().setEditable(false);
        this.view.getComboStaDec().setEnabled(false);
        this.view.getComboUniDec().setEditable(false);
        this.view.getBotonAgregarDec().setEnabled(true);
        this.view.getBotonBuscarDec().setEnabled(true);
        this.view.getBotonEliminarDec().setEnabled(false);
        this.view.getBotonGuardarDec().setEnabled(false);
        this.view.getBotonModificarDec().setEnabled(false);
        this.view.getBontonCancelarDec().setEnabled(false);
    }
    
    private void habilitarCampos(){
        this.view.getComboNombBusDec().setEnabled(false);
        this.view.getCampoNomDec().setEditable(true);
        this.view.getCampoDesDec().setEditable(true);
        this.view.getComboStaDec().setEnabled(true);
        this.view.getComboUniDec().setEditable(true);
        this.view.getBotonAgregarDec().setEnabled(false);
        this.view.getBotonEliminarDec().setEnabled(false);
        this.view.getBotonGuardarDec().setEnabled(true);
        this.view.getBotonModificarDec().setEnabled(false);
        this.view.getBontonCancelarDec().setEnabled(true);
        this.view.getBotonBuscarDec().setEnabled(false);
    }
    
    private void limpiarCampos(){
        inhabilitarCampos();
        this.view.getCampoNomDec().setText("");
        this.view.getCampoDesDec().setText("");
        this.view.getComboStaDec().setSelectedIndex(0);
        this.view.getComboUniDec().removeAllItems();
        this.view.getComboNombBusDec().setSelectedIndex(0);
        this.decanato = null;
    }
    
    private boolean validarCampos(){
        String nombre =  this.view.getCampoNomDec().getText();
        String descripcion =  this.view.getCampoDesDec().getText();
        int universidad =  this.view.getComboUniDec().getSelectedIndex();
        
        if(!nombre.isEmpty() && !descripcion.isEmpty() && universidad > 0){
            return true;
        }else{
            return false;
        }
    }
}
