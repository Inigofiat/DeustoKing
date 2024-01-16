package Test;
	
import static org.junit.Assert.*;
	
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
	
import deustoking.Cupon;
	
public class CuponTest {
	private Cupon cupon;
	
	@Before
	public void setUp() throws Exception {
		cupon = new Cupon(0, 0, "imagen", "desc");
	}
	
	@After
	public void tearDown() throws Exception {
		cupon = null;
	}
	
	@Test
	public void testCuponIntFloatStringString() {
		
		int min = 0;
		double descuento = 0;
		String foto = "imagen";
		String desc = "desc";
		assertEquals(min, cupon.getMinPuntos());
		assertEquals(descuento, cupon.getDescuento(), 0.00001f);
		assertEquals(foto, cupon.getFoto());
		assertEquals(desc, cupon.getDescripcion());
		
	}
	
	@Test
	public void testGetMinPuntos() {
		assertEquals(0, cupon.getMinPuntos());
	}
	
	@Test
	public void testSetMinPuntos() {
		cupon.setMinPuntos(3);
		assertEquals(3, cupon.getMinPuntos());
	}
	
	@Test
	public void testGetDescuento() {
		assertEquals(0, cupon.getDescuento(), 0.00001f);
	}
	
	@Test
	public void testSetDescuento() {
		cupon.setDescuento(0.20f);
		assertEquals(0.20f, cupon.getDescuento(), 0.00001f);
	}
	
	@Test
	public void testGetFoto() {
		assertEquals("imagen", cupon.getFoto());
	}
	
	@Test
	public void testSetFoto() {
		cupon.setFoto("nueva imagen");
		assertEquals("nueva imagen", cupon.getFoto());
	}
	
	@Test
	public void testGetDescripcion() {
		assertEquals("desc", cupon.getDescripcion());
	}
	
	@Test
	public void testSetDescripcion() {
		cupon.setDescripcion("descripcion");
		assertEquals("descripcion", cupon.getDescripcion());
	}
	
	@Test
	public void testToString() {
		cupon.setMinPuntos(0);
		cupon.setDescuento(0);
		cupon.setFoto("imagen");
		cupon.setDescripcion("desc");
		
		String expectedToString = "Cupon [minPuntos= 0, descuento= 0, foto= imagen, descripción= desc]";
		
		assertEquals(expectedToString, cupon.toString());
	}
	
	}