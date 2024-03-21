// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.AsignaturaAdmin;
import vistas.DashboardAdministrador;

import modelo.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import conexion.CConexion;
import java.util.*;
import modelo.MAsignatura;
import modelo.MSemestre;
import modelo.MCarrera;

public class CAsignaturaAdmin {
    private AsignaturaAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaAsignatura;
    private HashMap<String, Integer> mapaSemestre;
    private HashMap<String, Integer> mapaCarrera;
    private MAsignatura asignatura;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CAsignaturaAdmin(AsignaturaAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.mapaAsignatura = new HashMap<>();
        this.mapaSemestre = new HashMap<>();
        this.mapaCarrera = new HashMap<>();
        this.asignatura = null;
        
        //Llenamos el combo de asignaturas registradas
        this.view.getComboNomBusAsig().addItem("Seleccione opción");
        
        this.llenarCbxAsignaturas();
        
        this.view.getComboCarAsig().addItem("Seleccione opción");
        this.llenarCbxCarreras();
        
        this.view.getComboSemAsig().addItem("Seleccione opción");
        this.llenarCbxSemestres();
        
        this.view.getComboStaAsig().addItem("Seleccione opción");
        this.view.getComboStaAsig().addItem("Activo");
        this.view.getComboStaAsig().addItem("Inactivo");
        
        //Accion de boton atras
        this.view.getBontonAtrasAsig().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        //Accion de boton Buscar
        this.view.getBotonBuscarAsig().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = view.getComboNomBusAsig().getSelectedIndex();

                // Verificar si se seleccionó alguna opción
                if (selectedIndex != -1 && selectedIndex > 0) { 
                    buscarAsignatura();
                }else{
                    JOptionPane.showMessageDialog(view,"Debe seleccionar una asignatura", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                
            }
        });
        
        //Accion boton modificar
        this.view.getBotonModificarAsig().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(asignatura != null){
                    habilitarCampos();
                    view.getBotonModificarAsig().setEnabled(false);
                    view.getComboStaAsig().setEnabled(false);
                }
            }
        });
        
        //Accion boton cancelar
        this.view.getBontonCancelarAsig().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?");
                if (JOptionPane.OK_OPTION==confirmado) {
                        limpiarCampos();
                        view.getComboNomBusAsig().setEnabled(true);
                }
            }
        });
        
        this.view.getBotonGuardarAsig().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()){
                    if(asignatura != null){
                        asignatura.setDescripcion(view.getCampoDesAsig().getText());
                        asignatura.setNombre(view.getCampoNomAsig().getText());
                        editarAsignatura(asignatura);
                    }else{
                        registrarAsignatura();
                    }
                }else{
                    JOptionPane.showMessageDialog(view,"Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Accion boton eliminar
        this.view.getBotonEliminarAsig().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la asignatura?");
                if (JOptionPane.OK_OPTION==confirmado) {
                    if(asignatura != null){
                        eliminarAsignatura(asignatura);
                    }
                }
            }
        });
        
        //Accion boton agregar
        this.view.getBotonAgregarAsig().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mapaSemestre = new HashMap<>();
                limpiarCampos();
                habilitarCampos();
                view.getComboSemAsig().removeAllItems();
                view.getComboSemAsig().addItem("Seleccione opción");
                llenarCbxSemestres();
                
                view.getComboCarAsig().removeAllItems();
                view.getComboCarAsig().addItem("Seleccione opción");
                llenarCbxCarreras();
            }
        });
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
                view.getComboNomBusAsig().addItem(asignatura);
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
            for (String sem : data) {
                view.getComboSemAsig().addItem(sem);
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
                view.getComboCarAsig().addItem(sem);
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
    
    public void buscarAsignatura(){
        int codigoAsignaturaSeleccionada = this.obtenerAsignaturaSeleccionada();
        
        try{
            String sql = "SELECT a.codigo as codigo, a.nombre as nombre, a.descripcion as descripcion, a.estatus as estatus, s.codigo as codigo_sem, s.nombre as nombre_sem, s.estatus as estatus_sem, c.codigo as codigo_car, c.nombre as nombre_car, c.descripcion as descripcion_car, c.estatus as estatus_car "
                    + "FROM asignatura a "
                    + "INNER JOIN semestre s ON a.semestre_id = s.codigo "
                    + "INNER JOIN carrera c ON a.carrera_id = c.codigo "
                    + "WHERE a.codigo = ? LIMIT 1;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, codigoAsignaturaSeleccionada);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            if (resultSet.next()) {
                MSemestre semestre = new MSemestre(
                    resultSet.getInt("codigo_sem"),
                    resultSet.getString("nombre_sem"),
                    resultSet.getBoolean("estatus_sem")
                );
                        
                MCarrera carrera = new MCarrera();
                carrera.setCodigo(resultSet.getInt("codigo_car"));
                carrera.setDescripcion(resultSet.getString("descripcion_car"));
                carrera.setNombre(resultSet.getString("nombre_car"));
                carrera.setEstatus(resultSet.getBoolean("estatus_car"));
                
                this.asignatura = new MAsignatura(
                    resultSet.getInt("codigo"),
                    resultSet.getString("nombre"),
                    resultSet.getString("descripcion"),
                    carrera,
                    semestre,
                    resultSet.getBoolean("estatus")
                );

                this.view.getCampoNomAsig().setText(this.asignatura.getNombre());
                this.view.getCampoDesAsig().setText(this.asignatura.getDescripcion());
                
                if(this.asignatura.isEstatus()){
                    this.view.getComboStaAsig().setSelectedIndex(1);
                }else{
                    this.view.getComboStaAsig().setSelectedIndex(2);    
                }
                
                this.view.getComboSemAsig().setSelectedItem(asignatura.getSemestre_id().getNombre());
                this.view.getComboCarAsig().setSelectedItem(asignatura.getCarreraId().getNombre());
                
                this.inhabilitarCampos();
                
                this.view.getBotonEliminarAsig().setEnabled(true);
                this.view.getBotonModificarAsig().setEnabled(true);
                this.view.getBontonCancelarAsig().setEnabled(true);
    
                
            }else{
                JOptionPane.showMessageDialog(view,"No se encontro la asignatura seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    private void editarAsignatura(MAsignatura asignatura){
        try{
            String sql = "UPDATE asignatura SET nombre = ?, descripcion = ?, carrera_id = ?, semestre_id = ? WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, view.getCampoNomAsig().getText());
            statement.setString(2, view.getCampoDesAsig().getText());
            statement.setInt(3, this.obtenerCarreraSeleccionada());
            statement.setInt(4, this.obtenerSemestreSeleccionado());
            statement.setInt(5, asignatura.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha actualizado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusAsig().removeAllItems();
            this.mapaAsignatura = new HashMap<>();
            this.view.getComboNomBusAsig().addItem("Seleccione opción");
            this.view.getComboNomBusAsig().setEnabled(true);
            this.llenarCbxAsignaturas();
        
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
    
    private void eliminarAsignatura(MAsignatura asignatura){
        try{
            String sql = "UPDATE asignatura SET estatus = false WHERE codigo = ?;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, asignatura.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha eliminado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusAsig().removeAllItems();
            this.mapaAsignatura = new HashMap<>();
            this.view.getComboNomBusAsig().addItem("Seleccione opción");
            this.view.getComboNomBusAsig().setEnabled(true);
            this.llenarCbxAsignaturas();
        
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
    
    private void registrarAsignatura(){
        try{
            String sql = "INSERT INTO asignatura(nombre, descripcion, carrera_id, semestre_id) VALUES(?,?,?,?);";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, view.getCampoNomAsig().getText());
            statement.setString(2, view.getCampoDesAsig().getText());
            statement.setInt(3, this.obtenerCarreraSeleccionada());
            statement.setInt(4, this.obtenerSemestreSeleccionado());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(view,"Se ha registrado exitosamente!");
            this.limpiarCampos();
            this.view.getComboNomBusAsig().removeAllItems();
            this.mapaAsignatura = new HashMap<>();
            this.view.getComboNomBusAsig().addItem("Seleccione opción");
            this.view.getComboNomBusAsig().setEnabled(true);
            this.llenarCbxAsignaturas();
        
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
    
    private int obtenerAsignaturaSeleccionada() {
        int selectedIndex = view.getComboNomBusAsig().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreAsignaturaSeleccionada = (String) view.getComboNomBusAsig().getSelectedItem(); // Obtener nombre de asignatura seleccionada
            return mapaAsignatura.get(nombreAsignaturaSeleccionada); // Obtener código de asignatura a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerSemestreSeleccionado() {
        int selectedIndex = view.getComboSemAsig().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreSemestreSeleccionado = (String) view.getComboSemAsig().getSelectedItem(); // Obtener nombre de semestre seleccionado
            return mapaSemestre.get(nombreSemestreSeleccionado); // Obtener código de semestre a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private int obtenerCarreraSeleccionada() {
        int selectedIndex = view.getComboCarAsig().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreCarreraSeleccionada = (String) view.getComboCarAsig().getSelectedItem(); // Obtener nombre de carrera seleccionada
            return mapaCarrera.get(nombreCarreraSeleccionada); // Obtener código de carrera a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private void inhabilitarCampos(){
        this.view.getCampoNomAsig().setEditable(false);
        this.view.getCampoDesAsig().setEditable(false);
        this.view.getComboSemAsig().setEnabled(false);
        this.view.getComboCarAsig().setEnabled(false);
        this.view.getComboStaAsig().setEnabled(false);
        this.view.getBotonAgregarAsig().setEnabled(true);
        this.view.getBotonBuscarAsig().setEnabled(true);
        this.view.getBotonEliminarAsig().setEnabled(false);
        this.view.getBotonGuardarAsig().setEnabled(false);
        this.view.getBotonModificarAsig().setEnabled(false);
        this.view.getBontonCancelarAsig().setEnabled(false);
    }
    
    private void habilitarCampos(){
        this.view.getComboNomBusAsig().setEnabled(false);
        this.view.getCampoNomAsig().setEditable(true);
        this.view.getCampoDesAsig().setEditable(true);
        this.view.getComboSemAsig().setEnabled(true);
        this.view.getComboCarAsig().setEnabled(true);
        this.view.getComboStaAsig().setEnabled(true);
        this.view.getBotonAgregarAsig().setEnabled(false);
        this.view.getBotonEliminarAsig().setEnabled(false);
        this.view.getBotonGuardarAsig().setEnabled(true);
        this.view.getBotonModificarAsig().setEnabled(false);
        this.view.getBontonCancelarAsig().setEnabled(true);
        this.view.getBotonBuscarAsig().setEnabled(false);
    }
    
    private void limpiarCampos(){
        inhabilitarCampos();
        this.view.getCampoNomAsig().setText("");
        this.view.getCampoDesAsig().setText("");
        this.view.getComboSemAsig().setSelectedIndex(0);
        this.view.getComboCarAsig().setSelectedIndex(0);
        this.view.getComboStaAsig().setSelectedIndex(0);
        this.view.getComboNomBusAsig().setSelectedIndex(0);
        this.asignatura = null;
    }
    
    private boolean validarCampos(){
        String nombre =  this.view.getCampoNomAsig().getText();
        String descripcion =  this.view.getCampoDesAsig().getText();
        int semestre =  this.view.getComboSemAsig().getSelectedIndex();
        int carrera =  this.view.getComboCarAsig().getSelectedIndex();
        
        if(!nombre.isEmpty() && !descripcion.isEmpty() && semestre > 0 && carrera > 0){
            return true;
        }else{
            return false;
        }
    }
}
