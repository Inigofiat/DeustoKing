package deustoking;

import java.util.ArrayList;
import java.util.List;

public class Factura {
	private Cliente cliente;
	private Personal personal;
    private List<Producto> productos;
    private double precio;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.personal = personal;
        this.productos = new ArrayList<>();
        this.precio = 0.0;
    }


	public void agregarProducto(Producto producto) {
        productos.add(producto);
        precio += producto.getPrecio();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Personal getPersonal() {
		return personal;
	}

    public List<Producto> getProductos() {
        return productos;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Atendido por: ");
        sb.append(personal.getNombreP()).append(" ").append(personal.getApellidosP()).append("\n");
        sb.append("Factura para: ");
        sb.append(cliente.getNombreC()).append("\n");
        sb.append("Dirección: ").append(cliente.getDireccionC()).append("\n");
        sb.append("Teléfono: ").append(cliente.getTelefonoC()).append("\n");
        sb.append("Productos:\n");
        for (Producto producto : productos) {
            sb.append(" - ").append(producto.getNombre()).append(":").append(producto.getPrecio()).append("\n");
        }
        sb.append("Precio Total:").append(precio);
        return sb.toString();
    }

}
