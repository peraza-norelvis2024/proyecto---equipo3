// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

public class MEstudiante extends MPersona{
    private MCarrera carrera_id;

    public MEstudiante(){
        super();
    }
    public MEstudiante(int codigo, String nombre, String apellido, String cedula, String direccion, String correo, String telefono, MCarrera carrera_id, boolean estatus) {
        super(codigo, nombre, apellido, cedula, direccion, correo, telefono, estatus);
        this.carrera_id = carrera_id;
    }

    public MCarrera getCarrera_id() {
        return carrera_id;
    }

    public void setCarrera_id(MCarrera carrera_id) {
        this.carrera_id = carrera_id;
    }
    
    
}
