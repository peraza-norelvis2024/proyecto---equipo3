// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import conexion.CConexion;
import modelo.Sesion;
import vistas.Login;
import vistas.DashboardAdministrador;
import vistas.DashboardProfesor;

import modelo.MUsuario;

public class CLogin {
    private Login view;
    private CConexion cconexion = new CConexion();
    private Sesion sesion;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
   
    public CLogin(Login view){
        this.view = view;
        this.view.getBotonAcceder().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String username = view.getCampoUsuario().getText();
                String password = view.getCampoPassword().getText();
                MUsuario mUsuario = new MUsuario(username, password);
                validarUsuario(mUsuario);
            }
        });
    }
    private void validarUsuario(MUsuario usuario){
        String sql = "SELECT u.codigo as usuario_codigo, u.rol_id as rol_id, r.nombre as rol_nombre FROM Usuario u JOIN Rol r ON u.rol_id = r.codigo WHERE u.usuario = ? AND u.contrasena = ? and u.estatus=true LIMIT 1;";
                
//                "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ? LIMIT 1";
        connection = cconexion.establecerConexion();
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getContrasena());
            
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if(resultSet.getString("rol_nombre").equalsIgnoreCase("Administrador")){
                    JOptionPane.showMessageDialog(this.view,"Bienvenido Administrador");
                    //Abrir la otra ventana si el usuario y contraseña son correctos
                    sesion = Sesion.getInstance();
                    DashboardAdministrador frm = new DashboardAdministrador();
                    CDashboardAdministrador controlador = new CDashboardAdministrador(frm, sesion);
                    frm.setVisible(true);
                    //Cerrar ventana anterior
                    this.view.dispose();

                }else{
                    
                    sql = "SELECT codigo, nombre, apellido, cedula FROM profesor WHERE usuario_id = ? and estatus=true LIMIT 1;";
        
                    statement = connection.prepareStatement(sql);
                    
                    statement.setInt(1, resultSet.getInt("usuario_codigo"));
                    resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre") +" "+resultSet.getString("apellido");
                        sesion = Sesion.getInstance();
                        sesion.iniciarSesion(resultSet.getInt("codigo"), nombre, resultSet.getString("cedula"));
                        
                        JOptionPane.showMessageDialog(this.view,"Bienvenido Profesor, "+nombre);
                        //Abrir la otra ventana si el usuario y contraseña son correctos
                        DashboardProfesor frm = new DashboardProfesor();
                        CDashboardProfesor controladorDashboardProfesor = new CDashboardProfesor(frm, sesion);
                        frm.setVisible(true);
                        this.view.dispose();
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this.view,"Credenciales incorrectas por favor verificar. \nUsuario: "+usuario.getUsuario()+" \nContraseña: "+ usuario.getContrasena(), "Error", JOptionPane.ERROR_MESSAGE);

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
}
