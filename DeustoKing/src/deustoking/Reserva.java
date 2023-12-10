package deustoking;


import java.util.Date;

public class Reserva implements Comparable<Reserva>{
	static int contador = 1;
	private int id;
	private Date fecha;
	private String hora;
	private int nComensales;
	
	
	public Reserva(int id, Date fecha, String hora, int nComensales) {
		super();
		this.id = contador;
		contador++;
		this.fecha = fecha;
		this.hora = hora;
		this.nComensales = nComensales;
		
	}
	
	public Reserva(int id, String fecha, String hora, int nComensales) {
		super();
		this.id = contador;
		contador++;
		
		this.fecha = Utilidades.stringToDate(fecha);
		this.hora = hora;
		this.nComensales = nComensales;
		
	}
	
	public Reserva() {
		super();
		this.id = contador;
		contador++;
		this.fecha = null;
		this.hora = null;
		this.nComensales = 0;
		
	}
	
	public static void reiniciarContador() {
	    contador = 1;
	}
	
	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Reserva.contador = contador;
	}
	
	public String getFechaStr() {
	       return Utilidades.dateToString(fecha);
	    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}
	

	public void setFecha(Date fecha) {
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
	public int compareTo(Reserva o) {
		
		return this.getHora().compareTo(o.getHora());
	}




	
	
	
	

}
