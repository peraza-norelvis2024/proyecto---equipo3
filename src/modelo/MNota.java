// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

public class MNota {
    private int codigo;
    private MEstudiante estudiante_id;
    private MSeccion seccion_id;
    private float nota;
    private boolean estatus;
    
    public MNota(){}
    
    public MNota(int codigo, MEstudiante estudiante_id, MSeccion seccion_id, float nota, boolean estatus) {
        this.codigo = codigo;
        this.estudiante_id = estudiante_id;
        this.seccion_id = seccion_id;
        this.nota = nota;
        this.estatus = estatus;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public MEstudiante getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(MEstudiante estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public MSeccion getSeccion_id() {
        return seccion_id;
    }

    public void setSeccion_id(MSeccion seccion_id) {
        this.seccion_id = seccion_id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
}
