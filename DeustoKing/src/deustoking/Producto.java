package deustoking;

import java.util.ArrayList;
import java.util.List;

public class Producto {
	private int idP;
	private String nombre;
    private String descripcion;
    private float precio;
    private int cantidad;
    private String modificacion;
    private TipoProducto tipoProducto;
    private String imagen;
    private List<Producto> listaProductos;
    
	public Producto(int idP, String nombre, String descripcion, float precio, int cantidad, String modificacion, TipoProducto producto, String imagen,List<Producto> productos) {
		super();
		this.idP = idP;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad=cantidad;
		this.modificacion=modificacion;
	}
	
	public Producto(int idP2, String nombre2, String ingredientes, float precio2, int cantidad2, String modificacion2,
			 String imagen2, ArrayList<Producto> productos2) {
		this.idP=idP2;
		this.nombre=nombre2;
		this.descripcion=ingredientes;
		this.precio=precio2;
		this.cantidad=cantidad2;
		this.modificacion=modificacion2;
		this.imagen=imagen2;
		this.listaProductos=productos2;
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
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
	public TipoProducto getProducto() {
		return tipoProducto;
	}
	public void setProducto(TipoProducto producto) {
		this.tipoProducto = producto;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public List<Producto> getProductos() {
		return listaProductos;
	}
	public void setProductos(List<Producto> productos) {
		this.listaProductos = productos;
	}
//	@Override
//	public String toString() {
//		return "Producto [idP=" + idP + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
//				+ ", cantidad=" + cantidad + ", modificacion=" + modificacion + "]";
//	}
	
	@Override
	public String toString() {
	//	String texto =  nombre + ": " + descripcion + "(" + cantidad +")" + modificacion;
		
		String texto = String.format("NOMBRE: %90s\nDESCRIPCIÓN: %90s\nCANTIDAD: %90d\nMODIFICACIÓN: %90s\nLISTA: %90s\n", nombre,descripcion,cantidad,modificacion, listaProductos);
		
		
		
		/*String textoConFormato = "";
		for(int i=0;i<texto.length();i++) {
			textoConFormato = textoConFormato + texto.charAt(i);
			if(i%30==0) {
				textoConFormato = textoConFormato + "\n";
			}
		}
		
		
		return textoConFormato;*/
		return texto;
	}
	


}
