package deustoking;

public class Producto {
	private int idP;
	private String nombre;
    private String descripcion;
    private double precio;
    
	public Producto(int idP, String nombre, String descripcion, double precio) {
		super();
		this.idP = idP;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [idP=" + idP + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ "]";
	}


}
