package deustoking;

import java.util.List;

public class MenuDeusto extends Producto{
	
	private List<Producto> productos;

	public MenuDeusto(int idP, String nombre, String descripcion, float precio, int cantidad, String modificacion,
			TipoProducto producto, String imagen, List<Producto> productos) {
		super(idP, nombre, descripcion, precio, cantidad, modificacion, producto, imagen, productos);
		this.productos=productos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "MenuDeusto [nombre=" + nombre + ", productos=" + productos + "]";
	}


	
	

}
