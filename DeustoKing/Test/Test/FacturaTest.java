package Test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Cliente;
import deustoking.Factura;
import deustoking.Producto;
import deustoking.Restaurante;
import deustoking.TipoProducto;
import deustoking.Utilidades;

public class FacturaTest {
	private Factura factura;
    private Cliente cliente;
    private JList<Producto> productosList;
    private float precioTotal;
    private LocalDate fechaDate;
    private String hora;
	

    @Before
    public void setUp() {
        cliente = new Cliente("Naroa", "Azcona", "606522009","naroa.azcona@opendeusto.es","Plaza Euskadi", 1, 3, "AzconaNaroa", "Azcona_04");
       
        precioTotal = 100.0f;
        
        DefaultListModel<Producto> modeloProductos = new DefaultListModel<>();
        
        modeloProductos.addElement(new Producto(1, "Carne", "Desc", 10, 2, "Mod", TipoProducto.ENTRANTE, "imagen", null));
        modeloProductos.addElement(new Producto(3, "Hamburguesa", "Desc", 13, 4, "Mod", TipoProducto.HAMBURGUESA, "imagen1", null));
        modeloProductos.addElement(new Producto(6, "Taco", "Desc", 8, 3, "Mod", TipoProducto.OTRO, "imagen2", null));

        productosList = new JList<>(modeloProductos);
        
        fechaDate = LocalDate.now();
        hora = "12:30";
        factura = new Factura(cliente, fechaDate, hora, productosList, precioTotal);
    }

	@After
	public void tearDown() throws Exception {
		factura = null;
	}

	@Test
	public void testFactura() {
		
		assertEquals(cliente, factura.getCliente());
        assertEquals(fechaDate, factura.getFecha());
        assertEquals(hora, factura.getHora());
        assertEquals(productosList, factura.getProductos());
        assertEquals(100, factura.getPrecioTotal(),2.0f);
	}


	@Test
	public void testGetCliente() {
		assertEquals(cliente, factura.getCliente());
	}
	

	@Test
	public void testSetCliente() {
		factura.setCliente(cliente);
		
		assertEquals(cliente, factura.getCliente());
	}
	

	@Test
	public void testGetFecha() {
		assertEquals(fechaDate, factura.getFecha());
	}

	@Test
	public void testGetHora() {
		assertEquals(hora, factura.getHora());
	}

	@Test
	public void testSetHora() {
		
		String horaN = "13:00";
		
		factura.setHora(horaN);
		
		assertEquals(horaN, factura.getHora());

	}

	@Test
	public void testSetFecha() {
		factura.setFecha(fechaDate);	
		assertEquals(fechaDate, factura.getFecha());
	}

    @Test
    public void testSetFechaStr() {

        String fechaStr = "15-01-2024";

        factura.setFechaStr(fechaStr);

        LocalDate fechaDespues = factura.getFecha();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaDespues.format(formatter);

        assertEquals(fechaStr, fechaFormateada);
    }

	@Test
	public void testGetProductos() {
	    assertEquals(productosList.getModel().getSize(), factura.getProductos().getModel().getSize());
	}

	@Test
	public void testSetProductos() {
		
		factura.setProductos(productosList);
		assertEquals(productosList, factura.getProductos());
	}

	@Test
	public void testGetPrecioTotal() {
		assertEquals(precioTotal, factura.getPrecioTotal(), 2.0f);
	}

	@Test
	public void testSetPrecioTotal() {
		float precio = 10;
		factura.setPrecioTotal(precio);
		assertEquals(precio, factura.getPrecioTotal(),2.0f);
	}

	@Test
    public void testToString() {
		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setFecha(fechaDate);
		factura.setHora(hora);
		factura.setPrecioTotal(precioTotal);
		factura.setProductos(productosList);
		
		
        String expectedString = "Factura [cliente[nombre=Naroa, apellidos=Azcona, telefono=606522009, correo=naroa.azcona@opendeusto.es, direccion=Plaza Euskadi, id=1, "
        		+ "puntosAcumulados=3, nombreUsuario=AzconaNaroa, contrasenia=Azcona_04], fecha="+fechaDate + ", hora=12:30,"
        				+ " productos=[Producto [idP=1, nombre=Producto 1, descripcion=d1, precio=10.0f, cantidad=2, modificacion=mod1], "
        				+ "Producto [idP=1, nombre=Producto 2, descripcion=d2, precio=11.0f, cantidad=3, modificacion=mod2],"
        				+ "Producto [idP=1, nombre=Producto 3, descripcion=d3, precio=12.0f, cantidad=4, modificacion=mod3]], "
        				+ "precioTotal=100.0f]";
        
  
        assertEquals(expectedString, factura.toString());
    }

}
 