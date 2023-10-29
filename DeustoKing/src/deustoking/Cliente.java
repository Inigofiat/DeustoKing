package deustoking;

public class Cliente {
	public int contador = 1;
	private String nombreC;
	private String apellidosC;
	private String telefonoC;
	private String correoC;
	private String direccionC;
	private int idCliente;
	private int puntosAcumulados;
	private String nombreUsuario;
	private String contrasenia;
	
	public Cliente(String nombreC, String apellidosC, String teléfonoC, int idCliente, String correoC, String direcciónC,
			int puntosAcumulados, String nombreUsuario, String contrasenia) {
		super();
		this.nombreC = nombreC;
		this.apellidosC = apellidosC;
		this.telefonoC = teléfonoC;
		this.correoC = correoC;
		this.direccionC = direcciónC;
		this.idCliente = contador;
		contador ++;
		this.puntosAcumulados = puntosAcumulados;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}
	
	public Cliente() {
		super();
		this.nombreC = null;
		this.apellidosC = null;
		this.telefonoC = null;
		this.correoC = null;
		this.direccionC = null;
		this.idCliente = contador;
		contador ++;
		this.puntosAcumulados = 0;
		this.nombreUsuario = null;
		this.contrasenia = null;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	public String getApellidosC() {
		return apellidosC;
	}

	public void setApellidosC(String apellidosC) {
		this.apellidosC = apellidosC;
	}

	public String getTelefonoC() {
		return telefonoC;
	}

	public void setTelefonoC(String teléfonoC) {
		this.telefonoC = teléfonoC;
	}

	public String getCorreoC() {
		return correoC;
	}

	public void setCorreoC(String correoC) {
		this.correoC = correoC;
	}

	public String getDireccionC() {
		return direccionC;
	}

	public void setDireccionC(String direccionC) {
		this.direccionC = direccionC;
	}

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
		return "Cliente [contador=" + contador + ", nombreC=" + nombreC + ", apellidosC=" + apellidosC
				+ ", nombreUsuario=" + nombreUsuario + ", telefonoC=" + telefonoC + ", correoC=" + correoC
				+ ", direccionC=" + direccionC + ", contrasenia=" + contrasenia + ", idCliente=" + idCliente
				+ ", puntosAcumulados=" + puntosAcumulados + "]";
	}

	
	
	
}
