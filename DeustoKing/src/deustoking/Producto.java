package deustoking;

public class Producto {
	private int idP;
	private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private String modificacion;
    
	public Producto(int idP, String nombre, String descripcion, double precio, int cantidad, String modificacion) {
		super();
		this.idP = idP;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad=cantidad;
		this.modificacion=modificacion;
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
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getModificacion() {
		return modificacion;
	}
	public void setModificacion(String modificacion) {
		this.modificacion = modificacion;
	}
	@Override
	public String toString() {
		return "Producto [idP=" + idP + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", cantidad=" + cantidad + ", modificacion=" + modificacion + "]";
	}
	
	


}
