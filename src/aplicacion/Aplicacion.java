// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package aplicacion;
import vistas.Login;
import controlador.CLogin;

public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login view = new Login();
        CLogin controlador = new CLogin(view);
        view.setVisible(true);
    }
}
