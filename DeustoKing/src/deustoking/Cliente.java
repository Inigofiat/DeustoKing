package deustoking;

public class Cliente extends Persona {

	private int puntosAcumulados;
	private String nombreUsuario;
	private String contrasenia;
	
	public Cliente(String nombre, String apellidos, String telefono, String correo, String direccion, int id,
			int puntosAcumulados, String nombreUsuario, String contrasenia) {
		super(nombre, apellidos, telefono, correo, direccion, id);
		this.puntosAcumulados = puntosAcumulados;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}
	
	public Cliente() {
		super();
		this.puntosAcumulados = 0;
		this.nombreUsuario = null;
		this.contrasenia = null;
	}

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Cliente [puntosAcumulados=" + puntosAcumulados + ", nombreUsuario=" + nombreUsuario + ", contrasenia="
				+ contrasenia + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", correo=" + correo + ", direccion=" + direccion + ", id=" + id + "]";
	}

	
	
	
	
}
