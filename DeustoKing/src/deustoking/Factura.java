package deustoking;

import java.util.ArrayList;
import java.util.List;

public class Factura {
	private Cliente cliente;
	private Trabajador personal;
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

    public Trabajador getPersonal() {
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
        sb.append(personal.getNombre()).append(" ").append(personal.getApellidos()).append("\n");
        sb.append("Factura para: ");
        sb.append(cliente.getNombre()).append("\n");
        sb.append("Dirección: ").append(cliente.getDireccion()).append("\n");
        sb.append("Teléfono: ").append(cliente.getTelefono()).append("\n");
        sb.append("Productos:\n");
        for (Producto producto : productos) {
            sb.append(" - ").append(producto.getNombre()).append(":").append(producto.getPrecio()).append("\n");
        }
        sb.append("Precio Total:").append(precio);
        return sb.toString();
    }

}
