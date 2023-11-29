package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Producto;

public class ProductoTest {
	private Producto producto;

	@Before
	public void setUp() throws Exception {
		producto = new Producto("Producto", 1, 2.5);
	}

	@After
	public void tearDown() throws Exception {
		producto=null;
	}

	@Test
	public void testGetNombre() {
		assertEquals("Producto", producto.getNombre());
	}

	@Test
	public void testSetNombre() {
		String nombre = "Camiseta";
		producto.setNombre(nombre);
		assertEquals(nombre, producto.getNombre());
	}

	@Test
	public void testGetCantidad() {
		assertEquals(1, producto.getCantidad());
	}

	@Test
	public void testSetCantidad() {
		int cantidad = 3;
		producto.setCantidad(cantidad);
		assertEquals(cantidad, producto.getCantidad());
	}

	@Test
	public void testGetPrecio() {
		assertEquals(2.5, producto.getPrecio(), 0.001);
	}

	@Test
	public void testSetPrecio() {
		double precio = 5.5;
		producto.setPrecio(precio);
		assertEquals(precio, producto.getPrecio(), 0.001);
	}
	
    @Test
    public void testToString() {
        
        String expectedToString = "Nombre: Producto, Cantidad: 1, Precio: $2.5";
        String actualToString = producto.toString();
        assertEquals(expectedToString, actualToString);
    }

}
