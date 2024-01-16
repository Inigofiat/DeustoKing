package deustoking;

	public class Trabajador extends Persona{
		
		private double sueldo;
		private String nombreTrabajador;
		private String dni;
		private PuestoTrabajo puesto;
		
		public Trabajador(String nombre, String apellidos, String telefono, String correo, String direccion, int id,
				double sueldo, String nombreTrabajador, String dni, PuestoTrabajo puesto) {
			super(nombre, apellidos, telefono, correo, direccion, id);
			this.sueldo = sueldo;
			this.nombreTrabajador = nombreTrabajador;
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
			this.sueldo = 0;
			this.nombreTrabajador = null;
			this.dni = null;
			this.puesto = null;
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

	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Trabajador [sueldo=" + sueldo + ", nombreTrabajador=" + nombreTrabajador + ", dni=" + dni + ", puesto="
				+ puesto + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", correo="
				+ correo + ", direccion=" + direccion + ", id=" + id + "]";
	}



	
	
	
	


	
	
}
