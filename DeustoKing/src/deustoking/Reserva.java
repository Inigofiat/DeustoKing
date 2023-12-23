package deustoking;


import java.util.Date;

public class Reserva implements Comparable<Reserva>{
	static int contador = 1;
	private String nombre;
	private String telefono;
	private String correo;
	private int id;
	private Date fecha;
	private String hora;
	private int nComensales;
	
	
	public Reserva(String nombre, String telefono, String correo, Date fecha, String hora, int nComensales) {
		super();
		this.id = contador;
		contador++;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
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
	
	public Reserva(int id, Date fecha, String hora, int nComensales) {
		super();
		this.id = contador;
		contador++;
		
		this.fecha = fecha;
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
		
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public int compareTo(Reserva o) {
		
		return this.getHora().compareTo(o.getHora());
	}

	@Override
	public String toString() {
		return "Reserva [nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", id=" + id + ", fecha="
				+ Utilidades.dateToString(fecha) + ", hora=" + hora + ", nComensales=" + nComensales + "]";
	}

	
	
	




	
	
	
	

}
