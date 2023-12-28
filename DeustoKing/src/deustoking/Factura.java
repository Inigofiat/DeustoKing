package deustoking;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JList;

public class Factura {
	private Cliente cliente;
	private LocalDate fecha;
	private String hora;
	private JList<Producto> productos;
	private float precioTotal;
	
	public Factura() {
		super();
	}

	public Factura(Cliente cliente, LocalDate fecha, String hora, JList<Producto> productos, float precioTotal) {
		super();
		this.cliente = cliente;
		this.fecha = fecha;
		this.hora = hora;
		this.productos = productos;
		this.precioTotal = precioTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public void setFechaStr(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.fecha = LocalDate.parse(fecha, formatter);
    }

	public JList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(JList<Producto> productos) {
		this.productos = productos;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public String toString() {
		return "Factura [cliente=" + cliente + ", fecha=" + fecha + ", hora=" + hora + ", productos=" + productos
				+ ", precioTotal=" + precioTotal + "]";
	}
	

}