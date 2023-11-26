package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Cliente;
import deustoking.Persona;

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
		Cliente cliente = new Cliente();
		cliente.setNombre("Aitor");
		cliente.setApellidos("de la Osa");
		cliente.setTelefono("987654321");
		cliente.setCorreo("aitordela.osa@opendeusto.es");
		cliente.setDireccion("321 Kalea");
		cliente.setId(2);
		cliente.setPuntosAcumulados(100);
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

}
