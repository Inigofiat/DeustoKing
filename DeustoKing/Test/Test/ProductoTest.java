package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Producto;
import deustoking.TipoProducto;

public class ProductoTest {
	private Producto producto;
	

	@Before
	public void setUp() throws Exception {
		producto = new Producto(1, "Carne", "Desc", 10, 2, "Mod", TipoProducto.ENTRANTE, "imagen", null);
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
		assertEquals("Carne", producto.getNombre());
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
		assertEquals(10, producto.getPrecio(), 0.001);
	}

	@Test
	public void testSetPrecio() {
		float precio = (float) 5.5;
		producto.setPrecio(precio);
		assertEquals(precio, producto.getPrecio(), 0.001);
	}
    @Test
    public void testGetModificacion() {
        assertEquals("Mod", producto.getModificacion());
    }
    
    
    @Test
    public void testSetModificacion() {
        producto.setModificacion("Nueva modificación");
        assertEquals("Nueva modificación", producto.getModificacion());
    }
    
    
    @Test
    public void testGetTipoProducto() {
        assertEquals(TipoProducto.ENTRANTE, producto.getTipoProducto());
    }
   
    
    @Test
    public void testSetTipoProducto() {
    	producto.setTipoProducto(TipoProducto.BEBIDA);
    	
    	assertEquals(TipoProducto.BEBIDA, producto.getTipoProducto());
       
    }
    
    @Test
    public void testGetImagen() {
       assertEquals("imagen", producto.getImagen());
    }
    
    @Test
    public void testSetImagen() {
    	producto.setImagen("Imagen nueva");
    	assertEquals("Imagen nueva", producto.getImagen());
       
    }
    
    @Test
    public void testGetListaProductos() {
    	assertNull(producto.getListaProductos());
    }
    
    @Test
    public void testSetListaProductos() {
    	List<Producto> productos = new ArrayList<>();
    	producto.setListaProductos(productos);
       
    	assertNotNull(productos.isEmpty());
    	
    	
    }
    

    @Test
    public void testGetCantidad() {
        assertEquals(2, producto.getCantidad());
    }
    
    @Test
    public void testSetCantidad() {
        producto.setCantidad(6);
        
        assertEquals(6, producto.getCantidad());
    }
  
    
    @Test
    public void testToString() {
        String expected = "NOMBRE: Carne\nDESCRIPCIÓN: Desc\nCANTIDAD: 10\nMODIFICACIÓN: Mod\nLISTA: null\nTIPO: ENTRANTE\n";

        String result = producto.toString();

        assertEquals(expected, result);
    }
    
    @Test
    public void testConstructor() {
    	
    	int id =1;
    	String nombre = "Nombre";
    	String desc = "Desc";
    	float precio = 1;
    	int cantidad =2;
    	String mod = "Mod";
    	String imagen ="Img";
    	ArrayList<Producto> l = new ArrayList<>();

       
    	Producto producto = new Producto(id, nombre, desc, precio, cantidad, mod, imagen, l);
     
        assertEquals(id, producto.getIdP());
        assertEquals(nombre, producto.getNombre());
        assertEquals(desc,producto.getDescripcion());
        assertEquals(precio, producto.getPrecio(), 0.00001f);
        assertEquals(cantidad, producto.getCantidad());
        assertEquals(mod, producto.getModificacion());
        assertEquals(imagen, producto.getImagen());
        assertEquals(l, producto.getListaProductos());

    }
		
    

}
