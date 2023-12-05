package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Persona;
import deustoking.Trabajador;

public class TrabajadorTest {
	private Trabajador trabajador;
	@Before
	public void setUp() throws Exception {
		trabajador = new Trabajador("Naroa", "Azcona Acero", "606522009", "naroa.azcona@opendeusto.es", "Bilbo", Persona.getContador(), 0.0, 1000, 0, "NaroaAzcona", 
				"Azcona_2004", "79230672L");
	}

	@After
	public void tearDown() throws Exception {
		trabajador=null;
	}

	@Test
	public void testToString() {
		Trabajador trabajador = new Trabajador();
		trabajador.setNombre("Naroa");
		trabajador.setApellidos("Azcona");
		trabajador.setTelefono("123456789");
		trabajador.setCorreo("naroa.azcona@opendeusto.es");
		trabajador.setDireccion("Bilbo");
		trabajador.setId(0);
		trabajador.setHorasTrabajadas(24);
		trabajador.setSueldo(1000);
		trabajador.setMesasAtendidas(1);
		trabajador.setNombreTrabajador("AzconaNaroa");
		trabajador.setContraseniaTrabajador("Naroa_09");
		String expectedString = "Trabajador [horasTrabajadas=24.0, sueldo=1000.0, mesasAtendidas=1, nombreTrabajador=AzconaNaroa, contraseniaTrabajador=Naroa_09, dni=null, nombre=Naroa, apellidos=Azcona, telefono=123456789, correo=naroa.azcona@opendeusto.es, direccion=Bilbo, id=0]";
        String actualString = trabajador.toString();
        assertEquals(expectedString, actualString);
	}


	@Test
	public void testGetHorasTrabajadas() {
		assertEquals(0.0, trabajador.getHorasTrabajadas(),0.001);
		
	}

	@Test
	public void testSetHorasTrabajadas() {
		double horas = 24.0;
		trabajador.setHorasTrabajadas(horas);
		assertEquals(horas, trabajador.getHorasTrabajadas(),0.001);
	}

	@Test
	public void testGetSueldo() {
		assertEquals(1000, trabajador.getSueldo(),0.001);
	}

	@Test
	public void testSetSueldo() {
		double sueldo = 2500;
		trabajador.setSueldo(sueldo);
		assertEquals(sueldo, trabajador.getSueldo(),0.001);
	}

	@Test
	public void testGetMesasAtendidas() {
		assertEquals(0, trabajador.getMesasAtendidas());
	}

	@Test
	public void testSetMesasAtendidas() {
		int mesaT = 1;
		trabajador.setMesasAtendidas(mesaT);
		assertEquals(mesaT, trabajador.getMesasAtendidas());
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
	public void testGetContraseniaTrabajador() {
		assertEquals("Azcona_2004", trabajador.getContraseniaTrabajador());
	}

	@Test
	public void testSetContraseniaTrabajador() {
		String contTrabT = "Cont";
		trabajador.setContraseniaTrabajador(contTrabT);;
		assertEquals(contTrabT, trabajador.getContraseniaTrabajador());
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

}
