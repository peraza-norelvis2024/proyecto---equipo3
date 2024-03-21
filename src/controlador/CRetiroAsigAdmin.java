// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import vistas.RetiroAsigAdmin;
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
import modelo.MEstudiante;
import modelo.MInscripcion;
import modelo.MSeccion;

public class CRetiroAsigAdmin {
    private RetiroAsigAdmin view;
    private Sesion sesion;
    private CConexion cconexion = new CConexion();
    private HashMap<String, Integer> mapaAsignatura;
    private HashMap<String, Integer> mapaEstudiante;
    private MAsignatura asignatura;
    private MEstudiante estudiante;
    private MInscripcion inscripcion;
    private List<MInscripcion> inscripciones;
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    public CRetiroAsigAdmin(RetiroAsigAdmin view, Sesion sesion){
        this.view = view;
        this.sesion = sesion;
        this.mapaAsignatura = new HashMap<>();
        this.asignatura = null;
        this.mapaEstudiante = new HashMap<>();
        this.estudiante = null;
        this.inscripciones = new ArrayList<>();
        
        //Accion de boton atras
        this.view.getBontonAtrasRet().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdministrador frm = new DashboardAdministrador();
                CDashboardAdministrador controladorDashboardAdmin = new CDashboardAdministrador(frm, sesion);
                frm.setVisible(true);
                view.dispose();
            }
        });
        //Accion boton cancelar
        this.view.getBontonCancelarRet().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?");
                if (JOptionPane.OK_OPTION==confirmado) {
                        limpiarCampos();
                        view.getCampoCedRet().setEnabled(true);
                        view.getCampoCedRet().setEditable(true);
                }
            }
        });
        
        this.view.getBotonBuscarRet().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!view.getCampoCedRet().getText().isEmpty()){
                    buscarEstudiante();
                }
            }
        });
        
        this.view.getListAsigRet().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = view.getListAsigRet().getSelectedIndex();
                if(index > 0){
                    view.getBotonEliminarRet().setEnabled(true);
                }else{
                    view.getBotonEliminarRet().setEnabled(false);
                }
            }
        });
        
        this.view.getBotonEliminarRet().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmado = JOptionPane.showConfirmDialog(null, "¿Está seguro de retirar la asignatura?");
                if (JOptionPane.OK_OPTION==confirmado) {
                    retirarAsigantura();
                }
            }
        });
    }
    
    private void buscarEstudiante(){
        String sql = "SELECT i.codigo as codigo_inscripcion, e.codigo as codigo_estudiante, e.nombre as nombre_estudiante, e.apellido as apellido_estudiante, s.codigo as codigo_seccion, s.numero as nombre_seccion, a.codigo as codigo_asignatura, a.nombre as nombre_asignatura "
                + "FROM inscripcion i "
                + "INNER JOIN estudiante e ON i.estudiante_id = e.codigo "
                + "INNER JOIN seccion s ON i.seccion_id = s.codigo "
                + "INNER JOIN asignatura a ON s.asignatura_id = a.codigo "
                + "INNER JOIN periodo_academico p ON i.periodo_academico_id = p.codigo "
                + "WHERE e.cedula = ? AND i.estatus = true AND p.activo = true AND p.estatus = true AND s.estatus = true AND e.estatus = true "
                + "AND e.codigo NOT IN ("
                    + "SELECT ins.estudiante_id "
                    + "FROM inscripcion ins "
                    + "INNER JOIN periodo_academico pa ON ins.periodo_academico_id = pa.codigo "
                    + "WHERE ins.estatus = false AND pa.activo = true AND pa.estatus = true"
                + ");";
        
        try{
            this.mapaAsignatura = new HashMap<>();
            ArrayList<String> data = new ArrayList<>();
            
            this.inscripciones = new ArrayList<>();
            this.view.getListAsigRet().removeAllItems();
            this.view.getListAsigRet().addItem("Seleccione opción");
            
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, this.view.getCampoCedRet().getText());
            
            
            resultSet = statement.executeQuery();
            boolean encontro = false;
            
            while (resultSet.next()) {
                encontro = true;
                MEstudiante mestudiante = new MEstudiante();
                mestudiante.setCodigo(resultSet.getInt("codigo_estudiante"));
                mestudiante.setCedula(this.view.getCampoCedRet().getText());
                mestudiante.setNombre(resultSet.getString("nombre_estudiante"));
                mestudiante.setApellido(resultSet.getString("apellido_estudiante"));
                
                MAsignatura masignatura = new MAsignatura();
                masignatura.setCodigo(resultSet.getInt("codigo_asignatura"));
                masignatura.setNombre(resultSet.getString("nombre_asignatura"));
                
                
                MSeccion mseccion = new MSeccion();
                mseccion.setCodigo(resultSet.getInt("codigo_seccion"));
                mseccion.setNumero(resultSet.getString("nombre_seccion"));
                mseccion.setAsignatura_id(masignatura);
                
                MInscripcion minscripcion = new MInscripcion();
                minscripcion.setCodigo(resultSet.getInt("codigo_inscripcion"));
                minscripcion.setEstudiante_id(mestudiante);
                minscripcion.setSeccion_id(mseccion);
                
                inscripciones.add(minscripcion);
                
                data.add(masignatura.getNombre());
                mapaAsignatura.put(masignatura.getNombre(), masignatura.getCodigo());
            }
            for (String asignatura : data) {
                view.getListAsigRet().addItem(asignatura);
            }
            
            if(!encontro){
                limpiarCampos();
                this.view.getCampoCedRet().setEditable(true);
                JOptionPane.showMessageDialog(view,"El estudiante no puede retirar asignaturas", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                this.view.getCampoNomRet().setText(inscripciones.get(0).getEstudiante_id().getNombre());
                this.view.getCampoApeRet().setText(inscripciones.get(0).getEstudiante_id().getApellido());
                this.view.getListAsigRet().setEnabled(true);
                this.view.getBontonCancelarRet().setEnabled(true);
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
    
    private void retirarAsigantura(){
        int index = view.getListAsigRet().getSelectedIndex();
        MInscripcion inscrip = this.inscripciones.get(index - 1);
        String sql = "UPDATE inscripcion SET estatus = false WHERE codigo = ?;";
        try{
            connection = cconexion.establecerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, inscrip.getCodigo());
            
            statement.executeUpdate();
            this.limpiarCampos();
            this.view.getCampoCedRet().setEditable(true);
            this.view.getCampoCedRet().setEnabled(true);
            this.view.getBotonBuscarRet().setEnabled(true);
            JOptionPane.showMessageDialog(view,"Se ha retirado la asignatura exitosamente!");
            
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
        int selectedIndex = view.getListAsigRet().getSelectedIndex();

        // Verificar si se seleccionó alguna opción
        if (selectedIndex != -1 && selectedIndex > 0) { 
            String nombreAsignaturaSeleccionada = (String) view.getListAsigRet().getSelectedItem(); // Obtener nombre de asignatura seleccionada
            return mapaAsignatura.get(nombreAsignaturaSeleccionada); // Obtener código de asignatura a partir del nombre en el mapa
        }else{
            return 0;
        }
    }
    
    private void inhabilitarCampos(){
        this.view.getCampoCedRet().setEditable(false);
        this.view.getListAsigRet().setEnabled(false);
        this.view.getBotonEliminarRet().setEnabled(false);
        this.view.getBontonCancelarRet().setEnabled(false);
    }
    private void habilitarCampos(){
        this.view.getListAsigRet().setEnabled(false);
        this.view.getBotonEliminarRet().setEnabled(true);
        this.view.getBontonCancelarRet().setEnabled(true);
    }
    
    private void limpiarCampos(){
        inhabilitarCampos();
        this.view.getCampoNomRet().setText("");
        this.view.getCampoCedRet().setText("");
        this.view.getCampoApeRet().setText("");
        this.view.getListAsigRet().removeAllItems();
        this.mapaAsignatura = new HashMap<>();
        this.inscripciones = new ArrayList<>();
        this.inscripcion = null;
    }
}
