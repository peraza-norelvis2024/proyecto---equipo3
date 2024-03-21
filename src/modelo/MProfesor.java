// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

public class MProfesor extends MPersona{
    private String especialidad;
    private MUsuario usuario_id;
    
    public MProfesor(){}
    
    public MProfesor(int codigo, String nombre, String apellido, String cedula, String direccion, String correo, String telefono, String especialidad, MUsuario usuario_id, boolean estatus) {
        super(codigo, nombre, apellido, cedula, direccion, correo, telefono, estatus);
        this.especialidad = especialidad;
        this.usuario_id = usuario_id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public MUsuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(MUsuario usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    
}
