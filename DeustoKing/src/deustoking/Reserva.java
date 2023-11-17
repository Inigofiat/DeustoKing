package deustoking;

import java.time.LocalDate;

public class Reserva {
	
	private LocalDate fecha;
	private String hora;
	private int nComensales;
	private String cliente;
	
	public Reserva(LocalDate fecha, String hora, int nComensales, String cliente) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.nComensales = nComensales;
		this.cliente=cliente;
	}
	
	public Reserva() {
		super();
		this.fecha = null;
		this.hora = null;
		this.nComensales = 0;
		this.cliente=null;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getnComensales() {
		return nComensales;
	}

	public void setnComensales(int nComensales) {
		this.nComensales = nComensales;
	}
	
	

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Reserva [fecha=" + fecha + ", hora=" + hora + ", nComensales=" + nComensales + ", cliente=" + cliente
				+ "]";
	}

	
	
	
	

}
