package deustoking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva implements Comparable<Reserva>{
	
	private LocalDate fecha;
	private String hora;
	private int nComensales;
	
	
	public Reserva(LocalDate fecha, String hora, int nComensales) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.nComensales = nComensales;
		
	}
	
	public Reserva() {
		super();
		this.fecha = null;
		this.hora = null;
		this.nComensales = 0;
		
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getFormattedFecha() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fecha.format(formatter);
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
	
	



	@Override
	public String toString() {
		return "Reserva [fecha=" + getFormattedFecha() + ", hora=" + hora + ", nComensales=" + nComensales 
				+ "]";
	}

	@Override
	public int compareTo(Reserva o) {
		
		return this.getHora().compareTo(o.getHora());
	}

	
	
	
	

}
