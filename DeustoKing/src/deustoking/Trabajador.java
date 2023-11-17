package deustoking;

public class Trabajador extends Persona{
	
	private float horasTrabajadas;
	private float sueldo;
	private int mesasAtendidas;
	private String nombreTrabajador;
	private String contraseniaTrabajador;
	
	public Trabajador(String nombre, String apellidos, String telefono, String correo, String direccion, int id,
			float horasTrabajadas, float sueldo, int mesasAtendidas, String nombreTrabajador,
			String contraseniaTrabajador) {
		super(nombre, apellidos, telefono, correo, direccion, id);
		this.horasTrabajadas = horasTrabajadas;
		this.sueldo = sueldo;
		this.mesasAtendidas = mesasAtendidas;
		this.nombreTrabajador = nombreTrabajador;
		this.contraseniaTrabajador = contraseniaTrabajador;
	}
	
	public Trabajador() {
		super();
		this.horasTrabajadas = 0;
		this.sueldo = 0;
		this.mesasAtendidas = 0;
		this.nombreTrabajador = null;
		this.contraseniaTrabajador = null;
	}

	public float getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(float horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getMesasAtendidas() {
		return mesasAtendidas;
	}

	public void setMesasAtendidas(int mesasAtendidas) {
		this.mesasAtendidas = mesasAtendidas;
	}

	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	public String getContraseniaTrabajador() {
		return contraseniaTrabajador;
	}

	public void setContraseniaTrabajador(String contraseniaTrabajador) {
		this.contraseniaTrabajador = contraseniaTrabajador;
	}

	@Override
	public String toString() {
		return "Personal [horasTrabajadas=" + horasTrabajadas + ", sueldo=" + sueldo + ", mesasAtendidas="
				+ mesasAtendidas + ", nombreTrabajador=" + nombreTrabajador + ", contraseniaTrabajador="
				+ contraseniaTrabajador + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", correo=" + correo + ", direccion=" + direccion + ", id=" + id + "]";
	}
	
	
}
