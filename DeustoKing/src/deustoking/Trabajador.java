package deustoking;

	public class Trabajador extends Persona{
		
		private double horasTrabajadas;
		private double sueldo;
		private int mesasAtendidas;
		private String nombreTrabajador;
		private String contraseniaTrabajador;
		private String dni;
		private PuestoTrabajo puesto;
		
		public Trabajador(String nombre, String apellidos, String telefono, String correo, String direccion, int id,
				double horasTrabajadas, double sueldo, int mesasAtendidas, String nombreTrabajador,
				String contraseniaTrabajador, String dni, PuestoTrabajo puesto) {
			super(nombre, apellidos, telefono, correo, direccion, id);
			this.horasTrabajadas = horasTrabajadas;
			this.sueldo = sueldo;
			this.mesasAtendidas = mesasAtendidas;
			this.nombreTrabajador = nombreTrabajador;
			this.contraseniaTrabajador = contraseniaTrabajador;
			this.dni = dni;
			this.puesto=puesto;
		}
		
		public Trabajador(String nombre, String apellidos, String telefono, PuestoTrabajo puesto, String dni) {
			this.nombre=nombre;
			this.apellidos=apellidos;
			this.telefono=telefono;
			this.puesto=puesto;
			this.dni=dni;
		}
		
		public Trabajador() {
			super();
			this.horasTrabajadas = 0;
			this.sueldo = 0;
			this.mesasAtendidas = 0;
			this.nombreTrabajador = null;
			this.contraseniaTrabajador = null;
			this.dni = null;
		}
	
		public double getHorasTrabajadas() {
			return horasTrabajadas;
		}
	
		public void setHorasTrabajadas(double horasTrabajadas) {
			this.horasTrabajadas = horasTrabajadas;
		}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public PuestoTrabajo getPuesto() {
		return puesto;
	}

	public void setPuesto(PuestoTrabajo puesto) {
		this.puesto = puesto;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Trabajador [horasTrabajadas=" + horasTrabajadas + ", sueldo=" + sueldo + ", mesasAtendidas="
				+ mesasAtendidas + ", nombreTrabajador=" + nombreTrabajador + ", contraseniaTrabajador="
				+ contraseniaTrabajador + ", dni=" + dni + ", puesto=" + puesto + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", id="
				+ id + "]";
	}

	
	
	
	


	
	
}
