package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Persona;

public class PersonaTest {
	private Persona persona;
	@Before
	public void setUp() throws Exception {
		persona = new Persona("Nombre", "Apellidos", "123456789", "Correo", "Direccion", 1);
	}

	@After
	public void tearDown() throws Exception {
		persona = null;
	}

	@Test
	public void testGetContador() {
		 Persona.setContador(10);
		 int resultado = Persona.getContador();
		 assertEquals(10, resultado);
	}

	@Test	
	public void testSetContador() {
		 Persona.setContador(5);
	     Persona.setContador(15);
	     assertEquals(15, Persona.getContador());
	}

	@Test
	public void testGetNombre() {
		assertEquals("Nombre", persona.getNombre());
	}

	@Test
	public void testSetNombre() {
		String nombre = "Iñigo";
		persona.setNombre(nombre);
		assertEquals(nombre, persona.getNombre());
	}

	@Test
	public void testGetApellidos() {
		assertEquals("Apellidos", persona.getApellidos());
	}

	@Test
	public void testSetApellidos() {
		String apellidos ="Fiat Sarasola";
		persona.setApellidos(apellidos);
		assertEquals(apellidos, persona.getApellidos());
	}

	@Test
	public void testGetTelefono() {
		assertEquals("123456789", persona.getTelefono());
	}

	@Test
	public void testSetTelefono() {
		String tlf = "987654321";
		persona.setTelefono(tlf);
		assertEquals(tlf, persona.getTelefono());
	}

	@Test
	public void testGetCorreo() {
		assertEquals("Correo", persona.getCorreo());
	}

	@Test
	public void testSetCorreo() {
		String correo = "Email";
		persona.setCorreo(correo);
		assertEquals(correo, persona.getCorreo());
	}

	@Test
	public void testGetDireccion() {
		assertEquals("Direccion", persona.getDireccion());
	}

	@Test
	public void testSetDireccion() {
		String dir = "Dir";
		persona.setDireccion(dir);
		assertEquals(dir, persona.getDireccion());
	}

	@Test
	public void testGetId() {
		assertEquals(1, persona.getId());
	}

	@Test
	public void testSetId() {
		 persona.setId(2);
	     assertEquals(2, persona.getId());
	}

    @Test
    public void testToString() {
    	
         persona.setNombre("John");
         persona.setApellidos("Doe");
         persona.setTelefono("123456789");
         persona.setCorreo("john.doe@example.com");
         persona.setDireccion("123 Main Street");
         persona.setId(1);
         String expectedToString = "Persona [nombre=John, apellidos=Doe, telefono=123456789, correo=john.doe@example.com, direccion=123 Main Street, id=1]";
         assertEquals(expectedToString, persona.toString());
    }
}