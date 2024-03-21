// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

public class MInscripcion {
    private int codigo;
    private MEstudiante estudiante_id;
    private MSeccion seccion_id;
    private MPeriodoAcademico periodo_academico_id;
    private MSemestre semestre_id;
    private boolean estatus;
    
    public MInscripcion(){}
    
    public MInscripcion(int codigo, MEstudiante estudiante_id, MSeccion seccion_id, MPeriodoAcademico periodo_academico_id, MSemestre semestre_id, boolean estatus) {
        this.codigo = codigo;
        this.estudiante_id = estudiante_id;
        this.seccion_id = seccion_id;
        this.periodo_academico_id = periodo_academico_id;
        this.semestre_id = semestre_id;
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

    public MPeriodoAcademico getPeriodo_academico_id() {
        return periodo_academico_id;
    }

    public void setPeriodo_academico_id(MPeriodoAcademico periodo_academico_id) {
        this.periodo_academico_id = periodo_academico_id;
    }

    public MSemestre getSemestre_id() {
        return semestre_id;
    }

    public void setSemestre_id(MSemestre semestre_id) {
        this.semestre_id = semestre_id;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
}
