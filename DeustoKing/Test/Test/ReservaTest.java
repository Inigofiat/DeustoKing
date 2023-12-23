package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Reserva;
import deustoking.Utilidades;

public class ReservaTest {
	private  Reserva reserva;
	private Reserva reservaFechaStr;

	@Before
	public void setUp() throws Exception {
		reserva = new Reserva("nombre","tlf","correo",Utilidades.stringToDate("08-04-2004"),"12:30",5);
		reservaFechaStr = new Reserva(1, "nomb", "telfo", "mail", "01-04-1998", "21:30", 2);
		Reserva.reiniciarContador();
	}

	@After
	public void tearDown() throws Exception {
		reserva=null;
	}


	@Test
	public void testReiniciarContador() {
		 assertEquals(1, Reserva.getContador());
	}

	@Test
	public void testGetContador() {
		 assertEquals(1, Reserva.getContador()); 
	}

	@Test
	public void testSetContador() {
		Reserva.setContador(5);
        int resultado = Reserva.getContador();
        assertEquals(5, resultado);
	}

	@Test
	public void testGetFechaStr() {
		 assertEquals(Utilidades.dateToString(reserva.getFecha()), reserva.getFechaStr());
	}

	@Test
	public void testGetId() {
		assertNotNull(reserva.getId()); 
	}

	@Test
	public void testSetId() {
		 reserva.setId(10);
	     assertEquals(10, reserva.getId()); 
	}

	@Test
	public void testGetFecha() {
		assertEquals(Utilidades.stringToDate(reservaFechaStr.getFechaStr()), reservaFechaStr.getFecha());
	}

	@Test
	public void testSetFecha() {
		Date fecha = Utilidades.stringToDate("07-04-2004");
		reserva.setFecha(fecha);
		assertEquals(reserva.getFecha(), fecha);
	}

	@Test
	public void testGetHora() {
		assertEquals("12:30", reserva.getHora());
	}

	@Test
	public void testSetHora() {
		String hora = "13:30";
		reserva.setHora(hora);
		assertEquals(reserva.getHora(), hora);
	}

	@Test
	public void testGetnComensales() {
		assertEquals(5, reserva.getnComensales());
	}

	@Test
	public void testSetnComensales() {
		int comensales = 8;
		reserva.setnComensales(comensales);
		assertEquals(reserva.getnComensales(), comensales);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("nombre", reserva.getNombre());
	}

	@Test
	public void testSetNombre() {
		String nombre = "yo";
		reserva.setNombre(nombre);
		assertEquals(reserva.getNombre(), nombre);
	}
	
	@Test
	public void testGetTelefono() {
		assertEquals("tlf", reserva.getTelefono());
	}

	@Test
	public void testSetTelefono() {
		String telefono = "123456789";
		reserva.setTelefono(telefono);
		assertEquals(reserva.getTelefono(), telefono);
	}
	
	@Test
	public void testGetCorreo() {
		assertEquals("correo", reserva.getCorreo());
	}

	@Test
	public void testSetCorreo() {
		String correo = "i@gmail.com";
		reserva.setCorreo(correo);
		assertEquals(reserva.getCorreo(), correo);
	}

	@Test
	public void testCompareTo() {
		Reserva reserva1 = new Reserva(1,Utilidades.stringToDate("08-04-2004"), "14:30", 8);
        Reserva reserva2 = new Reserva(2,Utilidades.stringToDate("01-04-2004"), "15:30", 6);
        assertEquals(-1, reserva1.compareTo(reserva2)); 
        assertEquals(1, reserva2.compareTo(reserva1)); 
        assertEquals(0, reserva1.compareTo(reserva1));
	}
	
	 @Test
	 public void testToString() {
		 reserva.setNombre("nombre");
		 reserva.setTelefono("tlf");
		 reserva.setCorreo("correo");
		 reserva.setFecha(Utilidades.stringToDate("08-04-2004"));
		 reserva.setHora("12:30");
		 reserva.setnComensales(5);
		 Date fechaEsperada = Utilidades.stringToDate("08-04-2004");
		 String expectedString = "Reserva [nombre=nombre, telefono=tlf, correo=correo, id=1, fecha=08-04-2004, hora=12:30, nComensales=5]";
	     assertEquals(expectedString, reserva.toString());
	 	
		

			

	 }
	 
	 @Test
	 public void testReserva() {
		 Reserva nueva = new Reserva();
		 assertEquals(1, nueva.getId());
		 assertNull(nueva.getFecha());
		 assertNull(nueva.getHora());
		 assertEquals(0, nueva.getnComensales());
	 }
	 
	    @Test
	    public void testReservaConstructorConIdyDateObject() {
	     
	        int id = 1;
	        Date fecha = Utilidades.stringToDate("12-05-2024");
	        String hora = "19:30";
	        int nComensales = 2;

	        Reserva reserva = new Reserva(id, fecha, hora, nComensales);

	        assertEquals(id, reserva.getId());
	        assertEquals(fecha, reserva.getFecha());
	        assertEquals(hora, reserva.getHora());
	        assertEquals(nComensales, reserva.getnComensales());
	    }
	    @Test
	    public void testReservaConstructorConStringDate() {
	        int id = 1;
	        String fechaStr = "23-12-2020";
	        String hora = "19:00";
	        int nComensales = 3;

	        Reserva reserva = new Reserva(id, fechaStr, hora, nComensales);

	        assertEquals(id, reserva.getId());
	        assertEquals(Utilidades.stringToDate(fechaStr), reserva.getFecha());
	        assertEquals(hora, reserva.getHora());
	        assertEquals(nComensales, reserva.getnComensales());
	    }

	
	 

}
