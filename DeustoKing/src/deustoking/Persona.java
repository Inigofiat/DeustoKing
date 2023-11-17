package deustoking;

public class Persona {
	static int contador = 1;	
	protected String nombre;
	protected String apellidos;
	protected String telefono;
	protected String correo;
	protected String direccion;
	protected int id;
	
	public Persona(String nombre, String apellidos, String telefono, String correo, String direccion, int id) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.id = contador;
		contador++;
	}
	
	public Persona() {
		super();
		this.nombre = null;
		this.apellidos = null;
		this.telefono = null;
		this.correo = null;
		this.direccion = null;
		this.id = contador;
		contador++;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Persona.contador = contador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", correo="
				+ correo + ", direccion=" + direccion + ", id=" + id + "]";
	}
	
	
	
	
	

}
