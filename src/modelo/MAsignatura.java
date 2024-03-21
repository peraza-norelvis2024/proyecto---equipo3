// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

public class MAsignatura {
    private int codigo;
    private String nombre;
    private String descripcion;
    private MCarrera carrera_id;
    private MSemestre semestre_id;
    private boolean estatus;
    
    public MAsignatura(){}
    
    public MAsignatura(int codigo, String nombre, String descripcion, MCarrera carrera_id, MSemestre semestre, boolean estatus) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.carrera_id = carrera_id;
        this.semestre_id = semestre;
        this.estatus = estatus;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MCarrera getCarreraId() {
        return carrera_id;
    }

    public void setCarrera(MCarrera carrera_id) {
        this.carrera_id = carrera_id;
    }

    public MSemestre getSemestre_id() {
        return semestre_id;
    }

    public void setSemestreId(MSemestre semestre_id) {
        this.semestre_id = semestre_id;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
}
