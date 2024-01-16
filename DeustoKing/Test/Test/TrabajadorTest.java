package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Persona;
import deustoking.PuestoTrabajo;
import deustoking.Trabajador;

public class TrabajadorTest {
	private Trabajador trabajador;
	@Before
	public void setUp() throws Exception {
		trabajador = new Trabajador("Naroa", "Azcona Acero", "606522009", "naroa.azcona@opendeusto.es", "Bilbo", Persona.getContador(), 0, "NaroaAzcona", 
				 "79230672L", PuestoTrabajo.JEFE);
	}

	@After
	public void tearDown() throws Exception {
		trabajador=null;
	}

	@Test
	public void testToString() {
		Trabajador trabajador = new Trabajador();
		trabajador.setNombre("Naroa");
		trabajador.setApellidos("Azcona Acero");
		trabajador.setTelefono("606522009");
		trabajador.setCorreo("naroa.azcona@opendeusto.es");
		trabajador.setDireccion("Bilbo");
		trabajador.setId(0);
		trabajador.setSueldo(1000);
		trabajador.setNombreTrabajador("NaroaAzcona");
		trabajador.setDni("79230672L");
		trabajador.setPuesto(PuestoTrabajo.JEFE);
        String expectedString = "Trabajador [sueldo=1000.0, nombreTrabajador=NaroaAzcona, dni=79230672L, puesto=JEFE, nombre=Naroa, apellidos=Azcona Acero, telefono=606522009, correo=naroa.azcona@opendeusto.es, direccion=Bilbo, id=0]";
      
        assertEquals(expectedString, trabajador.toString());
	}

	@Test
	public void testGetSueldo() {
		assertEquals(0.0, trabajador.getSueldo(),0.001);
	}

	@Test
	public void testSetSueldo() {
		float sueldo = 2500;
		trabajador.setSueldo(sueldo);
		assertEquals(sueldo, trabajador.getSueldo(),0.001);
	}

	@Test
	public void testGetNombreTrabajador() {
		assertEquals("NaroaAzcona", trabajador.getNombreTrabajador());
	}

	@Test
	public void testSetNombreTrabajador() {
		String nombTrabT = "Yo";
		trabajador.setNombreTrabajador(nombTrabT);
		assertEquals(nombTrabT, trabajador.getNombreTrabajador());
	}

	@Test
	public void testGetDni() {
		assertEquals("79230672L", trabajador.getDni());
	}

	@Test
	public void testSetDni() {
		String dni = "12345678P";
		trabajador.setDni(dni);
		assertEquals(dni, trabajador.getDni());
	}
	
	@Test
	public void testGetPuesto() {
		assertEquals(PuestoTrabajo.JEFE, trabajador.getPuesto());
	}

	@Test
	public void testSetPuesto() {
		PuestoTrabajo puesto = PuestoTrabajo.JEFE;
		trabajador.setPuesto(puesto);
		assertEquals(puesto, trabajador.getPuesto());
	}
	
    @Test
    public void testConstructor() {
       
        String nombre = "Iñigo";
        String apellidos = "Fiat";
        String telefono = "717772600";
        PuestoTrabajo puesto = PuestoTrabajo.CAMARERO;
        String dni = "16101227P";

       
        Trabajador trabajador = new Trabajador(nombre, apellidos, telefono, puesto, dni);

     
        assertEquals(nombre, trabajador.getNombre());
        assertEquals(apellidos, trabajador.getApellidos());
        assertEquals(telefono, trabajador.getTelefono());
        assertEquals(puesto, trabajador.getPuesto());
        assertEquals(dni, trabajador.getDni());
    }

}
