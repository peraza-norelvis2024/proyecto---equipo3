// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

public class MDecanato {
    private int codigo;
    private String nombre;
    private String descripcion;
    private MUniversidad universidad_id;
    private boolean estatus;

    public MDecanato(int codigo, String nombre, String descripcion, MUniversidad universidad_id, boolean estatus) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.universidad_id = universidad_id;
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

    public MUniversidad getUniversidad_id() {
        return universidad_id;
    }

    public void setUniversidad_id(MUniversidad universidad_id) {
        this.universidad_id = universidad_id;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
}
