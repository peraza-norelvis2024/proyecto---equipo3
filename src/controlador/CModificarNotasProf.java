// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import java.sql.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import vistas.ModificarNotaProf;
import modelo.Sesion;
import conexion.CConexion;
import modelo.MCarrera;
import modelo.MEstudiante;
import modelo.MNota;
import modelo.MSeccion;
import vistas.CargarNotasProf;


public class CModificarNotasProf {
    private ModificarNotaProf view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private MEstudiante estudiante;
    private HashMap<String, Integer> mapaAsignaturas;
    private List<MNota> arrayNotas;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    private MNota nota;
    
    public CModificarNotasProf(ModificarNotaProf view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.estudiante = null;
        this.mapaAsignaturas = new HashMap<>();
        this.nota = null;
        this.view.getBontonGuardar().setEnabled(false);
        
        this.view.getBotonBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = view.getCampoCedula().getText();
                if(!cedula.isEmpty()){
                    buscarCedula(cedula);
                }else{
                    JOptionPane.showMessageDialog(view,"Debe ingresar una cedula", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        this.view.getListAsignatura().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = view.getListAsignatura().getSelectedIndex();
                // Verificar si se seleccionó alguna opción
                if (selectedIndex != -1 && selectedIndex > 0) { 
                    if(estudiante != null){
                        cargarNota(estudiante);
                    }else{
                        JOptionPane.showMessageDialog(view,"No se encuentra estudiante seleccionado", "Error", JOptionPane.ERROR_MESSAGE);    
                    }
                }
            }
        });
        
        this.view.getBontonCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "Está seguro de cancelar la modificación");
                if (JOptionPane.OK_OPTION==confirmado) {
                    limpiarCampos();
                }
            }
        });
        
        this.view.getBontonGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(estudiante != null && view.getCampoNota().getValue() != null){
                   guardarNota(nota);
                }else{
                   JOptionPane.showMessageDialog(view,"Debe llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);    
                }
            }
        });
        
        //Accion de boton atras
        this.view.getBontonAtras().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CargarNotasProf frm = new CargarNotasProf();
                CCargarNotaProf controlador_cargar = new CCargarNotaProf(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        
        
    }
    
    private void buscarCedula(String cedula){
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
                MCarrera carrera = new MCarrera();
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

                cargarAsignaturas(estudiante);
                
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
    
    private void cargarAsignaturas(MEstudiante estudiante){
        try{
            view.getListAsignatura().removeAllItems();
            ArrayList<String> data = new ArrayList<>();
            String sql = "SELECT a.codigo as codigo, a.nombre as nombre "
                    + "FROM nota n "
                    + "INNER JOIN estudiante e ON n.estudiante_id = e.codigo "
                    + "INNER JOIN seccion s ON n.seccion_id = s.codigo "
                    + "INNER JOIN asignatura a ON s.asignatura_id = a.codigo "
                    + "INNER JOIN periodo_academico p ON s.periodo_id = p.codigo "
                    + "WHERE n.estudiante_id = ? AND p.estatus = true AND p.activo = true AND n.estatus = true;";
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, estudiante.getCodigo());
            
            resultSet = statement.executeQuery();
            
            boolean encontro = false;
            
            this.view.getListAsignatura().removeAllItems();
            this.view.getListAsignatura().addItem("Seleccione una opción");
            
            while (resultSet.next()) {
                encontro = true;
                    int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                
                data.add(nombre);
                mapaAsignaturas.put(nombre, codigo);
            }
            for (String asignatura : data) {
                view.getListAsignatura().addItem(asignatura);
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
    
    private void cargarNota(MEstudiante estudiante){
        try{
            int codigo_asignatura = obtenerCodigoAsignaturaSeleccionada();
            
            String sql = "SELECT s.codigo as codigo_seccion, s.numero as nombre_seccion, n.nota as nota, n.codigo as nota_id "
                    + "FROM nota n "
                    + "INNER JOIN estudiante e ON n.estudiante_id = e.codigo "
                    + "INNER JOIN seccion s ON n.seccion_id = s.codigo "
                    + "INNER JOIN asignatura a ON s.asignatura_id = a.codigo "
                    + "INNER JOIN periodo_academico p ON s.periodo_id = p.codigo "
                    + "WHERE n.estudiante_id = ? AND a.codigo = ? AND p.estatus = true AND p.activo = true AND n.estatus = true LIMIT 1;";
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, estudiante.getCodigo());;
            statement.setInt(2, codigo_asignatura);
            
            resultSet = statement.executeQuery();
            // Iterar sobre los resultados y agregarlos a la lista
            
            if(resultSet.next()) {
                
                MSeccion seccion = new MSeccion();
                seccion.setCodigo(resultSet.getInt("codigo_seccion"));
                seccion.setNumero(resultSet.getString("nombre_seccion"));
                
                this.nota = new MNota();
                this.nota.setCodigo(resultSet.getInt("nota_id"));
                this.nota.setEstudiante_id(estudiante);
                this.nota.setSeccion_id(seccion);
                this.nota.setNota(resultSet.getFloat("nota"));
                
                this.view.getCampoNombre().setText(this.nota.getEstudiante_id().getNombre());
                this.view.getCampoApellido().setText(this.nota.getEstudiante_id().getApellido());
                this.view.getCampoCarrera().setText(this.nota.getEstudiante_id().getCarrera_id().getNombre());
                this.view.getCampoSeccion().setText(this.nota.getSeccion_id().getNumero());
                this.view.getCampoNota().setValue(this.nota.getNota());
                
                this.view.getBontonGuardar().setEnabled(true);
        
            }else{
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
    
    private void guardarNota(MNota nota){
        String sql = "UPDATE nota SET nota = ? WHERE codigo = ?;";
        try{
        
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setFloat(1, Float.parseFloat(this.view.getCampoNota().getValue().toString()));
            statement.setInt(2, nota.getCodigo());

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
    
    public void limpiarCampos(){
        this.view.getCampoNombre().setText("");
        this.view.getCampoApellido().setText("");
        this.view.getCampoCarrera().setText("");
        this.view.getCampoSeccion().setText("");
        this.view.getCampoNota().setValue(null);
        this.view.getCampoCedula().setText("");
        this.view.getBontonGuardar().setEnabled(false);
        
        this.mapaAsignaturas = new HashMap<>();
        
        this.estudiante = null;
        this.nota = null;
        this.view.getListAsignatura().removeAllItems();
    }
}
