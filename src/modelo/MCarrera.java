// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

public class MCarrera {
    private int codigo;
    private String nombre;
    private String descripcion;
    private MDecanato decanato_id;
    private boolean estatus;
    
    public MCarrera(){}
    
    public MCarrera(int codigo, String nombre, String descripcion, MDecanato decanato_id, boolean estatus) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.decanato_id = decanato_id;
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

    public MDecanato getDecanato_id() {
        return decanato_id;
    }

    public void setDecanato_id(MDecanato decanato_id) {
        this.decanato_id = decanato_id;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
}
