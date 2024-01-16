package Test;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deustoking.Cliente;
import deustoking.Cupon;
import deustoking.Producto;
import deustoking.PuestoTrabajo;
import deustoking.Reserva;
import deustoking.Restaurante;
import deustoking.TipoProducto;
import deustoking.Trabajador;
import deustoking.Utilidades;

public class RestauranteTest {
	
	@SuppressWarnings("unused")
	private static Map<String, List<Reserva>> mapaPorClientes = new TreeMap<>();
	@SuppressWarnings("unused")
	private static Set<Reserva> setReservas =  new TreeSet<>();
	private static List<Reserva> listaReservas = new ArrayList<>();
	private static List<Trabajador> listaTrabajadores = new ArrayList<>();
	private static Map<String, Cliente> mapaPersonaPorCorreo = new TreeMap<>();
	private static List<Cliente> clientes = new ArrayList<>();
	private static Cliente cliente;
	private static Map<Date, List<Reserva>> mapaHorasPorFecha = new TreeMap<>();
	private static Map<String, List<Reserva>> mapaReservas = new TreeMap<>();
	private static List<Producto>productos = new ArrayList<>();
	private static List<Producto> listaProductosFichero = new ArrayList<>();
	private static Set<String> fechasReservas = new HashSet<>();
	private static List<String> fechasOrdenadas = new ArrayList<>();
	private static Map<String, Cupon> mapaCupones = new TreeMap<>();
	@SuppressWarnings("unused")
	private static Restaurante r;
	private static JFrame ventana;
	private static Reserva reserva;
	private static Producto producto;

	@Before
	public void setUp() throws Exception {
		r = new Restaurante();
		ventana = new JFrame();
		cliente = new Cliente("Naroa", "Azcona", "606522009", "naroa.azcona@opendeusto.es", "Plaza Euskadi", 0, 0, "naroaazcona", "naroa040509");
		reserva = new Reserva(0, "Naroa", "606522009", "naroa.azcona@opendeusto.es", "09-05-2004", "20:30", 6);
		producto = new Producto(1, "Patatas", "Con queso", 10, 2, null, TipoProducto.ENTRANTE, null, null);
		
	}

	@After
	public void tearDown() throws Exception {
		r = null;
		ventana= null;
	}

	@Test
	public void testMiIcono() {
		String rutaIcono = "imagenes/CORONA.png";
		try {
			Restaurante.miIcono(ventana, rutaIcono);
			
			assertNotNull("El icono no puede ser nulo",rutaIcono);
			
			Image iconoEsperado = new ImageIcon(rutaIcono).getImage();
			Image iconoActual  = ventana.getIconImage();
			assertEquals("El icono debe de ser el esperado", iconoEsperado, iconoActual);
		}catch(Exception e) {
			fail(e.getMessage());
		}
		
		
	}

	@Test
	public void testCargarReservasEnLista() {
		String ruta = "ficheros/reservas.csv";
		Restaurante.cargarReservasEnLista(ruta);
		List<Reserva> reservas = Restaurante.getListaReservas();
		
		assertFalse(reservas.isEmpty());
		
		Map<String, List<Reserva>> mapaReservas = Restaurante.getMapaReservas();
		assertFalse(mapaReservas.isEmpty());
		
		for(Reserva reserva : reservas) {
			assertNotNull(reserva.getId());
			assertNotNull(reserva.getFecha());
			assertNotNull(reserva.getHora());
			assertNotNull(reserva.getnComensales());
			assertNotNull(reserva.getNombre());
			assertNotNull(reserva.getTelefono());
			assertNotNull(reserva.getCorreo());
			assertFalse(mapaReservas.containsKey(reserva.getTelefono()));
		}	
		
	}

	@Test
	public void testGetListaReservas() {
		Restaurante.getListaReservas().add(reserva);
		
		assertTrue(Restaurante.getListaReservas().contains(reserva));
	}

	@Test
	public void testGetMapaHorasPorFecha() {
		Map<Date, List<Reserva>> horasPorFecha = Restaurante.getMapaHorasPorFecha();
		
		assertEquals(mapaHorasPorFecha, horasPorFecha);
	}

	@Test
	public void testGetClientes() {
		List<Cliente> listaclientes = Restaurante.getClientes();
		
		assertNotNull(listaclientes);
		assertEquals(clientes, listaclientes);
		
	}
	
	@Test
	public void testGetReservasPorCliente() {
		Map<String, List<Reserva>> reservas = new HashMap<>();
		listaReservas.add(reserva);
		reservas.put("Naroa", listaReservas);
		Restaurante.setReservasPorCliente(reservas);
		Map<String, List<Reserva>> mapa = Restaurante.getReservasPorCliente();
		
		assertTrue(mapa.containsKey("Naroa"));
		
		List<Reserva> reservasClientes = mapa.get("Naroa");
		
		assertEquals(1, reservasClientes.size());
	}
	
	@Test
	public void testGetListaTrabajadores() {
		List<Trabajador> trabajadores = Restaurante.getListaTrabajadores();
		
		assertNotNull(trabajadores);
		assertEquals(listaTrabajadores, trabajadores);
	}
	
	@Test
	public void testGetMapaPersonaPorCorreo() {
		Map<String, Cliente> PersonaPorCorreo = Restaurante.getMapaPersonaPorCorreo();
		
		assertNotNull(PersonaPorCorreo);
		assertEquals(mapaPersonaPorCorreo, PersonaPorCorreo);
	}
	
	
	@Test
	public void testGetCliente() {
		Restaurante.setCliente(cliente);
		
		assertEquals(cliente, Restaurante.getCliente());
		
	}
	
	@Test
	public void testGetProductos() {
		List<Producto> listaProductos = Restaurante.getProductos();
		
		assertNotNull(listaProductos);
		assertEquals(productos, listaProductos);
	}
	
	@Test
	public void testGetFechasReservas() {
		Set<String> fechas = Restaurante.getFechasReservas();
		
		assertNotNull(fechas);
		assertEquals(fechasReservas, fechas);
	}
	
	@Test
	public void testGetFechasOrdenadas() {
		List<String> fechas = Restaurante.getFechasOrdenadas();
		
		assertNotNull(fechas);
		assertEquals(fechasOrdenadas, fechas);
	}
	
	
	@Test
	public void testObtenerReservasPorFecha() {
		Date fecha = Utilidades.stringToDate("17-08-2023");
		Reserva reservaConFecha = new Reserva(1, fecha, "15:30", 5);
		Restaurante.getListaReservas().add(reservaConFecha);
		
		List<Reserva> obtenerReservas = Restaurante.obtenerReservasPorFecha(fecha);
		assertTrue(obtenerReservas.contains(reservaConFecha));
		assertEquals(1, obtenerReservas.size());
		
	}

	@Test
	public void testGetPersonasHanCompradoElProducto() {
		String hora = "20:30";
		
		mapaPersonaPorCorreo.put("naroa.azcona@opendeusto.es", cliente);
	    listaReservas.add(reserva);
	    mapaReservas.put("naroa.azcona@opendeusto.es", listaReservas);

	    Restaurante.setMapaPersonaPorCorreo(mapaPersonaPorCorreo);
	    Restaurante.setReservasPorCliente(mapaReservas);

	    List<Cliente> personasProductos = Restaurante.getPersonasHanCompradoElProducto(hora);

	    assertEquals(1, personasProductos.size());
	    Cliente c = personasProductos.get(0);
	    assertEquals(cliente,c);

	}

	@Test
	public void testBuscarUsuario() {
		clientes.add(cliente);
		Restaurante.getClientes().add(cliente);
		Cliente clienteEncontrado = Restaurante.buscarUsuario("606522009");
		
		assertNotNull(clienteEncontrado);
		assertEquals("naroa.azcona@opendeusto.es", clienteEncontrado.getCorreo());
		assertEquals("naroaazcona", clienteEncontrado.getNombreUsuario());
		assertEquals("606522009", clienteEncontrado.getTelefono());

	}
	

	@Test
	public void testBuscarTrabajador() {
		Trabajador t = new Trabajador("Naroa", "Azcona", "606522009", PuestoTrabajo.JEFE_SALA, "79230672L");
		listaTrabajadores.add(t);
		Restaurante.getListaTrabajadores().add(t);
		Trabajador TrabajadorEncontrado = Restaurante.buscarTrabajador("79230672L");
		
		assertNotNull(TrabajadorEncontrado);
		assertEquals("79230672L", TrabajadorEncontrado.getDni());;
		assertEquals("606522009", TrabajadorEncontrado.getTelefono());

	}
	

	@Test
	public void testGuardarClientes() {
		Restaurante.getClientes().add(cliente);
		String ruta = "ficheros/Clientes.csv";
		Restaurante.guardarClientes(ruta);
		List<String> lineas = new ArrayList<>();
		
		try {
			Scanner sc = new Scanner(new FileReader(ruta));
			while(sc.hasNextLine()) {
				lineas.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			assertThrows("Fichero no encontrado", null, null);
		}
		
		assertEquals(Restaurante.getClientes().size(), lineas.size());
		for (int i = 0; i < Restaurante.getClientes().size(); lineas.size()) {
			Cliente c = Restaurante.getClientes().get(i);
			String l = lineas.get(i);
			String [] partes = l.split(";");
			assertEquals(c.getNombre(), partes[0]);
			assertEquals(c.getApellidos(), partes[1]);
			assertEquals(c.getTelefono(), partes[2]);
			assertEquals(c.getDireccion(), partes[3]);
			assertEquals(c.getCorreo(), partes[4]);
			assertEquals(c.getNombreUsuario(), partes[5]);
			assertEquals(c.getContrasenia(), partes[6]);
			assertEquals(c.getPuntosAcumulados(), Integer.parseInt(partes[7]));
			
		}
		
	}

	@Test
	public void testObtenerParametroBusquedaInicioSesion() {
		String email = Restaurante.obtenerParametroBusquedaInicioSesion("naroa.azcona@opendeusto.es", "", "");
		assertEquals("naroa.azcona@opendeusto.es", email);
		
		String nombre = Restaurante.obtenerParametroBusquedaInicioSesion("", "Naroaazcona", "");
		assertEquals("Naroaazcona", nombre);
		
		String tlf = Restaurante.obtenerParametroBusquedaInicioSesion("", "", "606522009");
		assertEquals("606522009", tlf);
	}

	@Test
	public void testVerificarCorreo() {
		assertTrue(Restaurante.verificarCorreo("naroa.azcona@opendeusto.es"));
		
		assertFalse(Restaurante.verificarCorreo("naroa.azcona@opendeusto"));
		
		assertFalse(Restaurante.verificarCorreo(""));
	}

	@Test
	public void testVerificarContrasenia() {
		assertTrue(Restaurante.verificarContrasenia("Azcona_04"));
		
		assertFalse(Restaurante.verificarContrasenia("az0"));
		
		assertFalse(Restaurante.verificarContrasenia("Azcona_"));
		
		assertFalse(Restaurante.verificarContrasenia("09052004"));
	}

	@Test
	public void testVerificarNombreUsuario() {
		assertTrue(Restaurante.verificarNombreUsuario("Naroaazcona"));
		
		assertFalse(Restaurante.verificarNombreUsuario("Na"));
		
		assertFalse(Restaurante.verificarNombreUsuario("09052004"));
	}

	@Test
	public void testVerificarTelefono() {
		assertTrue(Restaurante.verificarTelefono("606522009"));
		
		assertFalse(Restaurante.verificarTelefono("123"));
		
		assertFalse(Restaurante.verificarTelefono("124ac"));
	}

	@Test
	public void testAniadirCliente() {
		Restaurante.aniadirCliente(cliente);
		
		assertTrue(Restaurante.getClientes().contains(cliente));
	}


	@Test
	public void testGuardarReservasEnFichero() {
		String ruta = "ficheros/reservas.csv";
		Restaurante.guardarReservasEnFichero(reserva, ruta);

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine();
            assertNotNull(linea);

            String[] partes = linea.split(";");
            assertEquals(Reserva.getContador(), Integer.parseInt(partes[0].toString()));
            assertEquals(reserva.getHora(), partes[2].toString());

        } catch (IOException e) {
            
        }
	}


	@Test
	public void testObtenerProductos() {
		List<Producto> listaProductos = Restaurante.obtenerProductos();
		
		assertNotNull(listaProductos);
		assertEquals(productos, listaProductos);
	}


	@Test
	public void testGetMapaCupones() {
		Map<String, Cupon> mapaCupon = Restaurante.getMapaCupones();
		
		assertNotNull(mapaCupon);
		assertEquals(mapaCupones, mapaCupon);
	}


	@Test
	public void testBuscarProductoPorId() {
		//List<Producto> listaProductos = new ArrayList<>();
		productos.add(producto);
		Producto p1 = Restaurante.buscarProductoPorId(1, productos);
		assertNotNull(p1);
		assertEquals(producto, p1);
		
		List<Producto> listaProductos1 = new ArrayList<>();
		Producto p2 = Restaurante.buscarProductoPorId(5, listaProductos1);
		listaProductos1.add(p2);
		assertNotNull(p2);
		
		List<Producto> listaProductos2 = new ArrayList<>();
		Producto p3 = Restaurante.buscarProductoPorId(7, listaProductos2);
		listaProductos2.add(p3);
		assertNotNull(p3);
		
	}

	@Test
	public void testGetListaProductosFichero() {
		List<Producto> listaProductos = Restaurante.getListaProductosFichero();
		
		assertNotNull(listaProductos);
		assertEquals(listaProductosFichero, listaProductos);
	}

}
