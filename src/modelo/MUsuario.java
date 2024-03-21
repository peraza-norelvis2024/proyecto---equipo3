// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez
 
package modelo;

public class MUsuario {
    int codigo;
    String usuario;
    String contrasena;
    MRol rol_id;
    boolean estatus;
    
    public MUsuario(){}
    
    public MUsuario(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public MRol getRol_id() {
        return rol_id;
    }

    public void setRol_id(MRol rol_id) {
        this.rol_id = rol_id;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
}
