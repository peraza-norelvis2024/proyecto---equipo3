// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.PeriodoAcademicoAdmin;
import vistas.DashboardAdministrador;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.Date;

import conexion.CConexion;
import java.util.*;
import modelo.MPeriodoAcademico;

public class CPeriodoAcademicoAdmin {
    private PeriodoAcademicoAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaPeriodoAcademico; 
    private MPeriodoAcademico periodoAcademico;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CPeriodoAcademicoAdmin(PeriodoAcademicoAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.mapaPeriodoAcademico = new HashMap<>();
        this.periodoAcademico = null;
        
        //Llenamos el combo de periodos registrados
        this.view.getComboNomBusPerAcad().addItem("Seleccione opción");
        this.llenarCbxPeriodos();
        this.view.getComboStaPerAcad().addItem("Seleccione opción");
        this.view.getComboStaPerAcad().addItem("Activo");
        this.view.getComboStaPerAcad().addItem("Inactivo");
        this.view.getComboActPerAcad().addItem("Seleccione opción");
        this.view.getComboActPerAcad().addItem("Activo");
        this.view.getComboActPerAcad().addItem("Inactivo");
        
        //Accion de boton atras
        this.view.getBontonAtrasPerAcad().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        //Accion de boton Buscar
        this.view.getBotonBuscarPerAcad().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = view.getComboNomBusPerAcad().getSelectedIndex();

                // Verificar si se seleccionó alguna opción
                if (selectedIndex != -1 && selectedIndex > 0) { 
                    buscarPeriodo();
                }else{
                    JOptionPane.showMessageDialog(view,"Debe seleccionar un periodo académico", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                
            }
        });
        
        //Accion boton modificar
        this.view.getBotonModificarPerAcad().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(periodoAcademico != null){
                    habilitarCampos();
                    view.getBotonModificarPerAcad().setEnabled(false);
                    view.getComboStaPerAcad().setEnabled(false);
                }
            }
        });
        
        //Accion boton cancelar
        this.view.getBontonCancelarPerAca().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?");
                if (JOptionPane.OK_OPTION==confirmado) {
                        limpiarCampos();
                        view.getComboNomBusPerAcad().setEnabled(true);
                }
            }
        });
        
        this.view.getBotonGuardarPerAcad().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()){
                    if(periodoAcademico != null){
                        periodoAcademico.setDescripcion(view.getCampoDesPerAcad().getText());
                        periodoAcademico.setNombre(view.getCampoNomPerAcad().getText());
                        periodoAcademico.setFecha_ingreso((java.util.Date) view.getCampoFecIngPerAcad().getValue());
                        periodoAcademico.setFecha_culminacion((java.util.Date) view.getCampoFecCulPerAcad().getValue());
                        editarPeriodo(periodoAcademico);
                    }else{
                        registrarPeriodo();
                    }
                }else{
                    JOptionPane.showMessageDialog(view,"Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Accion boton eliminar
        this.view.getBotonEliminarPerAcad().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar periodo académico?");
                if (JOptionPane.OK_OPTION==confirmado) {
                
                    if(periodoAcademico != null){
                        eliminarPeriodo(periodoAcademico);
                    }
                }
            }
        });
        
        //Accion boton agregar
        this.view.getBotonAgregarPerAcad().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
                habilitarCampos();  
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
                view.getComboNomBusPerAcad().addItem(periodoAcademico);
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
    
    public void buscarPeriodo(){
        int codigoPeriodoSeleccionado = this.obtenerPeriodoSeleccionado();
        
        try{
            String sql = "SELECT p.codigo as codigo, p.nombre as nombre, p.descripcion as descripcion, p.fecha_ingreso as fecha_ingreso, p.fecha_culminacion as fecha_culminacion, p.activo as activo, p.estatus as estatus "
                    + "FROM periodo_academico p "
                    + "WHERE p.codigo = ? LIMIT 1;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, codigoPeriodoSeleccionado);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            if (resultSet.next()) {
                
                this.periodoAcademico = new MPeriodoAcademico(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getString("descripcion"),
                    new java.util.Date(resultSet.getDate("fecha_ingreso").getTime()),
                    new java.util.Date(resultSet.getDate("fecha_culminacion").getTime()),
                    resultSet.getBoolean("activo"),
                    resultSet.getBoolean("estatus")
                );

                this.view.getCampoNomPerAcad().setText(this.periodoAcademico.getNombre());
                this.view.getCampoDesPerAcad().setText(this.periodoAcademico.getDescripcion());
                this.view.getCampoFecIngPerAcad().setValue(this.periodoAcademico.getFecha_ingreso());
                this.view.getCampoFecCulPerAcad().setValue(this.periodoAcademico.getFecha_culminacion());
                
                if(this.periodoAcademico.isEstatus()){
                    this.view.getComboStaPerAcad().setSelectedIndex(1);
                }else{
                    this.view.getComboStaPerAcad().setSelectedIndex(2);    
                }
                
                if(this.periodoAcademico.isActivo()){
                    this.view.getComboActPerAcad().setSelectedIndex(1);
                }else{
                    this.view.getComboActPerAcad().setSelectedIndex(2);    
                }

                this.inhabilitarCampos();
                this.view.getBotonEliminarPerAcad().setEnabled(true);
                this.view.getBotonModificarPerAcad().setEnabled(true);
                this.view.getBontonCancelarPerAca().setEnabled(true);
    
                
            }else{
                JOptionPane.showMessageDialog(view,"No se encontro el periodo académico seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    private void editarPeriodo(MPeriodoAcademico periodoAcademico){
        try{
            String sql = "UPDATE periodo_academico SET nombre = ?, descripcion = ?, fecha_ingreso = ?, fecha_culminacion = ? WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, periodoAcademico.getNombre());
            statement.setString(2, periodoAcademico.getDescripcion());
            statement.setDate(3, new Date(periodoAcademico.getFecha_ingreso().getTime()));
            statement.setDate(4, new Date(periodoAcademico.getFecha_culminacion().getTime()));
            statement.setInt(5, periodoAcademico.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha actualizado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusPerAcad().removeAllItems();
            this.mapaPeriodoAcademico = new HashMap<>();
            this.view.getComboNomBusPerAcad().addItem("Seleccione opción");
            this.view.getComboNomBusPerAcad().setEnabled(true);
            this.llenarCbxPeriodos();
        
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
    
    private void eliminarPeriodo(MPeriodoAcademico periodoAcademico){
        try{
            String sql = "UPDATE periodo_academico SET estatus = false WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, periodoAcademico.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha eliminado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusPerAcad().removeAllItems();
            this.mapaPeriodoAcademico = new HashMap<>();
            this.view.getComboNomBusPerAcad().addItem("Seleccione opción");
            this.view.getComboNomBusPerAcad().setEnabled(true);
            this.llenarCbxPeriodos();
        
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
    
    private void registrarPeriodo(){
        try{
            String sql = "INSERT INTO periodo_academico(nombre, descripcion, fecha_ingreso, fecha_culminacion) VALUES(?,?,?,?);";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, view.getCampoNomPerAcad().getText());
            statement.setString(2, view.getCampoDesPerAcad().getText());
            statement.setDate(3, new Date(((java.util.Date) view.getCampoFecIngPerAcad().getValue()).getTime()));
            statement.setDate(4, new Date(((java.util.Date) view.getCampoFecCulPerAcad().getValue()).getTime()));
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha registrado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusPerAcad().removeAllItems();
            this.mapaPeriodoAcademico = new HashMap<>();
            this.view.getComboNomBusPerAcad().addItem("Seleccione opción");
            this.view.getComboNomBusPerAcad().setEnabled(true);
            this.llenarCbxPeriodos();
        
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
        int selectedIndex = view.getComboNomBusPerAcad().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombrePeriodoSeleccionado = (String) view.getComboNomBusPerAcad().getSelectedItem(); // Obtener nombre de periodo academico seleccionado
            return mapaPeriodoAcademico.get(nombrePeriodoSeleccionado); // Obtener código de periodo academico a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private void inhabilitarCampos(){
        this.view.getCampoNomPerAcad().setEditable(false);
        this.view.getCampoDesPerAcad().setEditable(false);
        this.view.getCampoFecIngPerAcad().setEditable(false);
        this.view.getCampoFecCulPerAcad().setEditable(false);
        this.view.getComboStaPerAcad().setEnabled(false);
        this.view.getComboActPerAcad().setEditable(false);
        this.view.getBotonAgregarPerAcad().setEnabled(true);
        this.view.getBotonBuscarPerAcad().setEnabled(true);
        this.view.getBotonEliminarPerAcad().setEnabled(false);
        this.view.getBotonGuardarPerAcad().setEnabled(false);
        this.view.getBotonModificarPerAcad().setEnabled(false);
        this.view.getBontonCancelarPerAca().setEnabled(false);
    }
    
    private void habilitarCampos(){
        this.view.getComboNomBusPerAcad().setEnabled(false);
        this.view.getCampoNomPerAcad().setEditable(true);
        this.view.getCampoDesPerAcad().setEditable(true);
        this.view.getCampoFecIngPerAcad().setEditable(true);
        this.view.getCampoFecCulPerAcad().setEditable(true);
        this.view.getComboStaPerAcad().setEnabled(true);
        this.view.getComboActPerAcad().setEditable(true);
        this.view.getBotonAgregarPerAcad().setEnabled(false);
        this.view.getBotonEliminarPerAcad().setEnabled(false);
        this.view.getBotonGuardarPerAcad().setEnabled(true);
        this.view.getBotonModificarPerAcad().setEnabled(false);
        this.view.getBontonCancelarPerAca().setEnabled(true);
        this.view.getBotonBuscarPerAcad().setEnabled(false);
    }
    
    private void limpiarCampos(){
        inhabilitarCampos();
        this.view.getCampoNomPerAcad().setText("");
        this.view.getCampoDesPerAcad().setText("");
        this.view.getCampoFecIngPerAcad().setValue(null);
        this.view.getCampoFecCulPerAcad().setValue(null);
        this.view.getComboStaPerAcad().setSelectedIndex(0);
        this.view.getComboActPerAcad().setSelectedIndex(0);
        this.view.getComboNomBusPerAcad().setSelectedIndex(0);
        this.periodoAcademico = null;
    }
    
    private boolean validarCampos(){
        String nombre =  this.view.getCampoNomPerAcad().getText();
        String descripcion =  this.view.getCampoDesPerAcad().getText();
        java.util.Date fecha_ingreso =  (java.util.Date) this.view.getCampoFecIngPerAcad().getValue();
        java.util.Date fecha_culminacion =  (java.util.Date) this.view.getCampoFecCulPerAcad().getValue();
        
        if(!nombre.isEmpty() && !descripcion.isEmpty() && fecha_ingreso != null && fecha_culminacion != null && fecha_ingreso.compareTo(fecha_culminacion) < 0){
            return true;
        }else{
            return false;
        }
    }
}
