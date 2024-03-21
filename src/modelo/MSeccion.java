// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

public class MSeccion {
    private int codigo;
    private String numero;
    private int max_estudiantes;
    private MAsignatura asignatura_id;
    private MProfesor profesor_id;
    private MPeriodoAcademico periodo_id;
    private boolean estatus;

    public MSeccion(){}
    
    public MSeccion(int codigo, String numero, int max_estudiantes, MAsignatura asignatura_id, MProfesor profesor_id, MPeriodoAcademico periodo_id, boolean estatus) {
        this.codigo = codigo;
        this.numero = numero;
        this.max_estudiantes = max_estudiantes;
        this.asignatura_id = asignatura_id;
        this.profesor_id = profesor_id;
        this.periodo_id = periodo_id;
        this.estatus = estatus;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getMax_estudiantes() {
        return max_estudiantes;
    }

    public void setMax_estudiantes(int max_estudiantes) {
        this.max_estudiantes = max_estudiantes;
    }

    public MAsignatura getAsignatura_id() {
        return asignatura_id;
    }

    public void setAsignatura_id(MAsignatura asignatura_id) {
        this.asignatura_id = asignatura_id;
    }

    public MProfesor getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(MProfesor profesor_id) {
        this.profesor_id = profesor_id;
    }

    public MPeriodoAcademico getPeriodo_id() {
        return periodo_id;
    }

    public void setPeriodo_id(MPeriodoAcademico periodo_id) {
        this.periodo_id = periodo_id;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
     @Override
    public String toString() {
        return numero;
    }
}
