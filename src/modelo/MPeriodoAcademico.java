// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package modelo;

import java.util.*;
        
public class MPeriodoAcademico {
    private int codigo;
    private String nombre;
    private String descripcion;
    private Date fecha_ingreso;
    private Date fecha_culminacion;
    private boolean estatus;
    private boolean activo;
    
    public MPeriodoAcademico(){}
    
    public MPeriodoAcademico(int codigo, String nombre, String descripcion, Date fecha_ingreso, Date fecha_culminacion, boolean estatus, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_culminacion = fecha_culminacion;
        this.estatus = estatus;
        this.activo = activo;
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

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_culminacion() {
        return fecha_culminacion;
    }

    public void setFecha_culminacion(Date fecha_culminacion) {
        this.fecha_culminacion = fecha_culminacion;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
