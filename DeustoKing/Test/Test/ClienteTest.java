package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Cliente;

public class ClienteTest {
	private Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("Nombre", "Apellidos", "123456789", "Correo", "Dir", 0, 0, "nUsuario","Contrasenia");
	}

	@After
	public void tearDown() throws Exception {
		cliente = null;
	}
	
	@Test
	public void testToString() {
	    cliente.setNombre("Nombre");
	    cliente.setApellidos("Apellidos");
	    cliente.setTelefono("123456789");
	    cliente.setCorreo("Correo");
	    cliente.setDireccion("Dir");
	    cliente.setId(1);

	    cliente.setPuntosAcumulados(0);
	    cliente.setNombreUsuario("nUsuario");
	    cliente.setContrasenia("Contrasenia");

	    String expectedToString = "Cliente [puntosAcumulados=0, nombreUsuario=nUsuario, contrasenia=Contrasenia, "
	            + "nombre=Nombre, apellidos=Apellidos, telefono=123456789, correo=Correo, direccion=Dir, id=1]";
	    assertEquals(expectedToString, cliente.toString());
	}

	@Test
	public void testGetPuntosAcumulados() {
		assertEquals(0, cliente.getPuntosAcumulados());
		
	}

	@Test
	public void testSetPuntosAcumulados() {
		int pAcum = 30;
		cliente.setPuntosAcumulados(pAcum);
		assertEquals(pAcum, cliente.getPuntosAcumulados());
	}

	@Test
	public void testGetNombreUsuario() {
		assertEquals("nUsuario", cliente.getNombreUsuario());
	}

	@Test
	public void testSetNombreUsuario() {
		String nUsu = "Iñigo";
		cliente.setNombreUsuario(nUsu);
		assertEquals(nUsu, cliente.getNombreUsuario());
	}

	@Test
	public void testGetContrasenia() {
		assertEquals("Contrasenia", cliente.getContrasenia());
	}

	@Test
	public void testSetContrasenia() {
		String cont = "cont";
		cliente.setContrasenia(cont);
		assertEquals(cont, cliente.getContrasenia());
	}
	
    @Test
    public void testConstructorPorDefecto() {
        Cliente defaultCliente = new Cliente();
        assertEquals(0, defaultCliente.getPuntosAcumulados());
        assertNull(defaultCliente.getNombreUsuario());
        assertNull(defaultCliente.getContrasenia());
    }

}
