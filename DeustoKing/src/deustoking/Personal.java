package deustoking;

public class Personal {
	static int contador = 1;	
	private String nombreP;
	private String apellidosP;
	private String telefonoP;
	private String correoP;
	private String direccionP;
	private int idPersonal;
	private float horasTrabajadas;
	private float sueldo;
	private int mesasAtendidas;
	
	public Personal(String nombreP, String apellidosP, String telefonoP, String correoP, String direccionP,
			int idPersonal, float horasTrabajadas, float sueldo, int mesasAtendidas) {
		super();
		this.nombreP = nombreP;
		this.apellidosP = apellidosP;
		this.telefonoP = telefonoP;
		this.correoP = correoP;
		this.direccionP = direccionP;
		this.idPersonal = contador;
		contador++;
		this.horasTrabajadas = horasTrabajadas;
		this.sueldo = sueldo;
		this.mesasAtendidas = mesasAtendidas;
	}
	
	public Personal() {
		super();
		this.nombreP = "";
		this.apellidosP = "";
		this.telefonoP = "";
		this.correoP = "";
		this.direccionP = "";
		this.idPersonal = contador;
		contador++;
		this.horasTrabajadas = 0;
		this.sueldo = 0;
		this.mesasAtendidas = 0;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Personal.contador = contador;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public String getApellidosP() {
		return apellidosP;
	}

	public void setApellidosP(String apellidosP) {
		this.apellidosP = apellidosP;
	}

	public String getTelefonoP() {
		return telefonoP;
	}

	public void setTelefonoP(String telefonoP) {
		this.telefonoP = telefonoP;
	}

	public String getCorreoP() {
		return correoP;
	}

	public void setCorreoP(String correoP) {
		this.correoP = correoP;
	}

	public String getDireccionP() {
		return direccionP;
	}

	public void setDireccionP(String direccionP) {
		this.direccionP = direccionP;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
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

	@Override
	public String toString() {
		return "Personal [nombreP=" + nombreP + ", apellidosP=" + apellidosP + ", telefonoP=" + telefonoP + ", correoP="
				+ correoP + ", direccionP=" + direccionP + ", idPersonal=" + idPersonal + ", horasTrabajadas="
				+ horasTrabajadas + ", sueldo=" + sueldo + ", mesasAtendidas=" + mesasAtendidas + "]";
	}
}
