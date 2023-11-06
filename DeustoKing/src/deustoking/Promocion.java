package deustoking;

import java.sql.Date;

public class Promocion {
	private String nombre;
    private Date fechaCaducidad;
    private String descripcion;

    public Promocion(String nombre, Date fechaCaducidad, String descripcion) {
        this.nombre = nombre;
        this.fechaCaducidad = fechaCaducidad;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
