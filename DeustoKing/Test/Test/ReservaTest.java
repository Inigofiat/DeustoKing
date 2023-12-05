package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Persona;
import deustoking.Reserva;

public class ReservaTest {
	private Reserva reserva;
	@Before
	public void setUp() throws Exception {
		
		reserva = new Reserva(1,LocalDate.of(2023, 12, 25),"12:30",5);
		Reserva.reiniciarContador();
	}

	@After
	public void tearDown() throws Exception {
		reserva = null;
	}
	
	@Test
	public void testReserva() {
		 reserva = new Reserva();
		 assertEquals(null, reserva.getFecha());
	     assertEquals(null, reserva.getHora());
	     assertEquals(0, reserva.getnComensales());
	}

	@Test
	public void testGetFecha() {
		assertEquals(LocalDate.of(2023, 12, 25), reserva.getFecha());
	}

	@Test
	public void testGetFormattedFecha() {
        Reserva reserva = new Reserva(1,LocalDate.of(2022, 12, 12), "12:30", 2);
        assertEquals("12-12-2022", reserva.getFormattedFecha());
	}

	@Test
	public void testSetFecha() {
		LocalDate fecha = LocalDate.of(2023, 12, 31);
		reserva.setFecha(fecha);
		assertEquals(fecha, reserva.getFecha());
	}

	@Test
	public void testGetHora() {
		assertEquals("12:30", reserva.getHora());
	}

	@Test
	public void testSetHora() {
		String hora = "13:30";
		reserva.setHora(hora);
		assertEquals(hora, reserva.getHora());
	}

	@Test
	public void testGetnComensales() {
		assertEquals(5, reserva.getnComensales());
	}

	@Test
	public void testSetnComensales() {
		int comensales = 9;
		reserva.setnComensales(comensales);
		assertEquals(comensales, reserva.getnComensales());
	}

	@Test
	public void testToString() {
		 
         reserva.setFecha(LocalDate.of(2023, 12, 10));
         reserva.setHora("14:30");
         reserva.setnComensales(8);
         String expectedToString = "Reserva [fecha=10-12-2023, hora=14:30, nComensales=8]";
         assertEquals(expectedToString, reserva.toString());
	}

	@Test
	public void testCompareTo() {
		Reserva reserva1 = new Reserva(1,LocalDate.of(2023, 12, 10), "14:30", 8);
        Reserva reserva2 = new Reserva(2,LocalDate.of(2023, 12, 10), "15:30", 6);
        assertEquals(-1, reserva1.compareTo(reserva2)); 
        assertEquals(1, reserva2.compareTo(reserva1)); 
        assertEquals(0, reserva1.compareTo(reserva1)); 
    }
	
	@Test
    public void testGetContador() {
		
        assertEquals(1, Reserva.getContador()); 
    }
	
    @Test
    public void testSetContador() {
        // Prueba el método setContador
        Reserva.setContador(5);
        int resultado = Reserva.getContador();
        assertEquals(5, resultado); // Asegúrate de que el contador se establece correctamente
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

}
