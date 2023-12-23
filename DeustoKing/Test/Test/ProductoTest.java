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
		producto = new Producto(1,"Producto", "Desc", 2.5,1,"Mod");
	}

	@After
	public void tearDown() throws Exception {
		producto=null;
	}

	@Test
	public void testGetIdP() {
		assertEquals(1, producto.getIdP());
	}

	@Test
	public void testSetIdP() {
		int id = 2;
		producto.setIdP(id);
		assertEquals(id, producto.getIdP());
	}

	@Test
	public void testGetNombre() {
		assertEquals("Producto", producto.getNombre());
	}

	@Test
	public void testSetNombre() {
		String nombre = "Carne";
		producto.setNombre(nombre);
		assertEquals(nombre, producto.getNombre());
	}

	@Test
	public void testGetDescripcion() {
		assertEquals("Desc", producto.getDescripcion());
	}

	@Test
	public void testSetDescripcion() {
		String descr = "Dos de carne";
		producto.setDescripcion(descr);
		assertEquals(descr, producto.getDescripcion());
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
    public void testGetModificacion() {
        assertEquals("Mod", producto.getModificacion());
    }
    
    @Test
    public void testGetCantidad() {
        assertEquals(1, producto.getCantidad());
    }
    
    @Test
    public void testSetModificacion() {
        producto.setModificacion("Nueva modificación");
        assertEquals("Nueva modificación", producto.getModificacion());
    }
    
    @Test
    public void testToString() {
    	producto.setIdP(1);
        producto.setNombre("Producto");
        producto.setDescripcion("Desc");
        producto.setPrecio(2.5);
        producto.setCantidad(1);
        producto.setModificacion("Mod");
        String expectedString = "Producto [idP=1, nombre=Producto, descripcion=Desc, precio=2.5, cantidad=1, modificacion=Mod]";
        assertEquals(expectedString, producto.toString());
		
	
    }

}
