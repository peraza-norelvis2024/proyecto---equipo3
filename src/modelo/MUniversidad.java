// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

public class MUniversidad {
    
    private int codigo;
    private String nombre;
    private String descripcion;
    private boolean estatus;
    
    public MUniversidad(){}
    
    public MUniversidad(int codigo, String nombre, String descripcion, boolean estatus){
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estatus
     */
    public boolean isEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
}
