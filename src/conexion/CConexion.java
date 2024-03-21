// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class CConexion {
    Connection conexion = null;
    String usuario = "postgres";
    String contrasena = "garden86";
    String bd = "proyecto";
    String ip = "localhost";
    String puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(cadena, usuario, contrasena);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos. error: "+e.toString());
        }
        
        return conexion;
    }
}
