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
		reserva = new Reserva(1,Utilidades.stringToDate("08-04-2004"),"12:30",5);
		reservaFechaStr = new Reserva(1, "08-04-2004", "12:30", 5);
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
	public void testCompareTo() {
		Reserva reserva1 = new Reserva(1,Utilidades.stringToDate("08-04-2004"), "14:30", 8);
        Reserva reserva2 = new Reserva(2,Utilidades.stringToDate("01-04-2004"), "15:30", 6);
        assertEquals(-1, reserva1.compareTo(reserva2)); 
        assertEquals(1, reserva2.compareTo(reserva1)); 
        assertEquals(0, reserva1.compareTo(reserva1));
	}
	
	 @Test
	 public void testToString() {
		 String expectedString = "Reserva [id=1, fecha=" + Utilidades.dateToString(reserva.getFecha()) + ", hora=12:30, nComensales=5]";
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
	
	 

}
