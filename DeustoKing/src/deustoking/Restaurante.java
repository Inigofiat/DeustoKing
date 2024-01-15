package deustoking;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import org.jdatepicker.DatePicker;

import basesDeDatos.BD;
import ventanas.Main;
import ventanas.VentanaCarta;
import ventanas.VentanaCliente;

public class Restaurante {
	

	private  static Map<String, List<Reserva>> reservasPorCliente;
	private  static Set<Reserva> setReservas;
	private  static  List<Reserva> listaReservas;
	private static  List<Trabajador> listaTrabajadores;
	private  static Map<String, Cliente> mapaPersonaPorCorreo;
	private static List<Cliente> clientes;
	private static Cliente cliente;
	private static Map<Date, List<Reserva>> mapaHorasPorFecha;
	private static Map<String, List<Reserva>> mapaReservas;
	private static List<Producto>productos;
	private static List<Producto> listaProductosFichero;
	private static Set<String> fechasReservas;
	private static  List<String> fechasOrdenadas;
	private static Map<String, Cupon> mapaCupones;
	static Logger logger = Logger.getLogger(Main.class.getName());


	
	static {
		reservasPorCliente = new TreeMap<>();
		setReservas = new TreeSet<>();
		cliente = new Cliente();
		mapaPersonaPorCorreo = new TreeMap<>();
		listaReservas = new ArrayList<>();
		clientes = new ArrayList<>();
		mapaHorasPorFecha = new TreeMap<>();
		mapaReservas= new TreeMap<>();
		listaTrabajadores=new ArrayList<>();
		productos= new ArrayList<>();
		fechasReservas= new HashSet<>();
		fechasOrdenadas = new ArrayList<>();
		mapaCupones = new TreeMap<>();
		listaProductosFichero = new ArrayList<>();

	}
	
	/***
	 * Este método sustituye el icono por defecto por la ruta que se recibe por parametro
	 * 	 
	 * @param ventana donde se va a implementar el metodo
	 * @param rutaIcono la ruta de la imagen
	 * 
	 */
	
	
	public static void miIcono(JFrame ventana, String rutaIcono) {
		try {
			Image icon = new ImageIcon(rutaIcono).getImage();
			ventana.setIconImage(icon);
		}catch(Exception e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DE LA IMAGEN");
		}
	}
	

	/***
	 * Este método lee las reservas que están en el fichero que recibe por parámetro y las carga en la lista de resevas
	 * 
	 * @param nombfich fichero reservas.csv
	 */

	public static  void cargarReservasEnLista (String nombfich) {
       
        
        try {
			Scanner sc = new Scanner(new File(nombfich));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				int id = Integer.parseInt(partes[0]);
                String fecha = partes[1];
                String hora = partes[2];
                int comensales = Integer.parseInt(partes[3]);
                String nombre = partes[4];
                String telefono = partes[5];
                String email = partes[6];
               
                Reserva reserva = new Reserva(id,nombre, telefono, email, fecha, hora, comensales);
                listaReservas.add(reserva);
                if(!mapaReservas.containsKey(telefono)) {
                	mapaReservas.put(telefono, new ArrayList<>());
                }
                mapaReservas.get(telefono).add(reserva);
        
                
			}
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO");
		}       
        			
	}
	
	/***
	 * Este método lee los trabajadores que están en el fichero que recibe por parámetro y los carga en la lista de trabajadores
	 * 
	 * @param nombfich fichero Trabajadores.csv
	 */
	
	
	public static void cargarTrabajadoresEnLista(String nombfich) {
		try {
			Scanner sc = new Scanner(new File(nombfich));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[]partes = linea.split(";");
				String nombre = partes[0];
				String apellidos = partes[1];
				String telefono = partes[2];
				PuestoTrabajo puesto = PuestoTrabajo.valueOf(partes[3]);
				String dni = partes[4];
				Trabajador t = new Trabajador(nombre, apellidos, telefono, puesto, dni);
				listaTrabajadores.add(t);
			}
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO ");		
			}
	}
	
	/***
	 * Este método devuelve la lista de reservas
	 * 
	 * @return devuelve la lista de reservas
	 */
	
	public static List<Reserva> getListaReservas(){
		return listaReservas;
		
	}
	
	/***
	 * Este método devuelve el mapa de las fechas
	 * 
	 * @return devuelve el mapa que tiene como clave la fecha en la que se ha hecho la reserva y como valor la lista de las reservas
	 */
	
	public static Map<Date, List<Reserva>> getMapaHorasPorFecha() {
		return mapaHorasPorFecha;
	}
	
	/***
	 * Este método obtiene todas las reservas que se hacen en una fehca y se guardan en una lista
	 * 
	 * @param fecha las reservas que se han hecho en esa fehca
	 * @return devuelve las reservas que se han hecho en una fecha
	 */
	
	public static List<Reserva> obtenerReservasPorFecha(Date fecha) {
	    List<Reserva> reservasPorFecha = new ArrayList<>();
	        for (Reserva reserva : listaReservas) {
	        
	            if (reserva.getFecha().equals(fecha)) {
	                reservasPorFecha.add(reserva);
	                
	            }
	            
	        }
	    return reservasPorFecha;
	  
	}
	
	/***
	 * Este método obtiene las personas que han comprado un producto en una hora que es la que se le pasa por parametro 
	 * y se cargan en la lista de clientes
	 * 
	 * @param hora a la hora que han comprado el producto
	 * @return devuelve la lista de clientes que han comprado 
	 */
	
	
	public static List<Cliente> getPersonasHanCompradoElProducto(String hora){
		List<Cliente> lp = new ArrayList<>();
		
		for(String correo: reservasPorCliente.keySet()) {
			List<Reserva> reservas = reservasPorCliente.get(correo);
			//Buscamos el producto en la lista
			boolean enc = false;
			int pos = 0;
			while(!enc && pos<reservas.size()) {
				if(reservas.get(pos).getHora().equals(hora)) {
					enc = true;
				}else {
					pos++;
				}
			}
			if(enc) {
				lp.add(mapaPersonaPorCorreo.get(correo));
			}
		}
		return lp;
	}
	
	/***
	 * Este método busca los parametros que se han metido por inicio y busca el usuario que coincide con esos parametros 
	 * 
	 * @param inicio los parametros que mete el usuario la iniciar sesion
	 * @return devuelve null en caso de no encontrarse el usuario
	 */


	public static Cliente buscarUsuario(String inicio) {
	    boolean enc = false;
	    int pos = 0;
	    Cliente c = null;

	    while (!enc && pos < clientes.size()) {
	        c = clientes.get(pos);
	        if (( c.getCorreo().equals(inicio)) ||
	            ( c.getNombreUsuario().equals(inicio)) ||
	            ( c.getTelefono().equals(inicio))) {
	            enc = true;
	        } else {
	            pos++;
	        }
	    }

	    if (enc) {
	        return c;
	    } else {
	        return null;
	    }
	}
	
	/***
	 * Este método busca los trabajadores que hay 
	 * 
	 * @param inicio el parametro que introduce el trabajador al inciar sesion 
	 * @return devuelve un null en caso de no encontrar el trabajador
	 */
	
	public static Trabajador buscarTrabajador (String inicio) {
		boolean enc = false;
		int pos = 0;
		Trabajador t = null;
		while(!enc && pos<listaTrabajadores.size()) {
			t=listaTrabajadores.get(pos);
			if((t.getDni().equals(inicio))) {
				enc = true;
			}else {
				pos++;
			}
		}
		
		if(enc) {
			return t;
		}else {
			return null;
		}
	}
	
	/***
	 * Este método guarda los clientes en el fichero clientes.csv
	 * 
	 * @param nomfichClientes fichero de clientes.csv donde se guardan los clientes registrados
	 */

	public static void guardarClientes(String nomfichClientes) {
		try {
			PrintWriter pw = new PrintWriter(nomfichClientes);
			for(Cliente c: clientes) {
				pw.println(c.getNombre()+";"+c.getApellidos()+";"+c.getTelefono()+";"+c.getDireccion()+";"+c.getCorreo()+";"+
						c.getNombreUsuario()+";"+c.getContrasenia()+";"+c.getPuntosAcumulados());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO ");	
		}
	}
	
	/***
	 * Este método solo acepta al iniciar sesión los unicos tres parametros que le pasamos, el email, el nombre y el teléfono
	 * 
	 * @param email parametro con el que el usuario puede iniciar sesion
	 * @param nombre parametro con el que el usuario puede iniciar sesion
	 * @param tlf parametro con el que el usuario puede iniciar sesion
	 * @return telefono
	 */


	public static String obtenerParametroBusquedaInicioSesion(String email, String nombre, String tlf) {
	    
	    if (!email.isEmpty()) {
	        return email;
	    } else if (!nombre.isEmpty()) {
	        return nombre;
	    } else {
	        return tlf;
	    }
	}
	
	/***
	 * Este método verifica el correo que se mete por parametro al registrarse, saltando un error en caso de que no se cumplan las condiciones necesarias
	 * 
	 * @param correo que mete el usuario al registrarse 
	 * @return true en caso que el usuario haya metido correctamente los carácteres necesarios
	 */
	
	public static boolean verificarCorreo(String correo) {

		if(correo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.(com|org|es))$")) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "El correo no es válido", "ERROR", JOptionPane.ERROR_MESSAGE);
		return false;
		
	}
	
	/***
	 * Este método verifica la contraseña que se mete por parametro al registrarse, salta un error en caso de que no se cumplan las condiciones necesarias
	 * 
	 * @param contrasenia contraseña que mete el usuario al registrarse 
	 * @return  true en caso que el usuario haya metido correctamente los carácteres de la contraseña
	 */


	public static boolean verificarContrasenia(String contrasenia) {

		if(contrasenia.length() < 6 || !contrasenia.matches(".*[0-9].*") || !contrasenia.matches(".*[a-zA-Z].*") || !contrasenia.matches(".*[!@#$%^&*()-_=+{};:,<.>/?`~].*")) {
			JOptionPane.showMessageDialog(null, "La contraseña no contiene los caracteres necesarios", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	/***
	 * Este método verifica el nombre del usuario que el usuario elige al registrarse, en caso de no contener los carácteres minimos saltara un error
	 * 
	 * @param nombreUsuario nombre que mete el usuario al registrarse 
	 * @return true en caso de que haya metido un nombre de usuario que contenga las condiciones necesarias
	 */	
	
	public static boolean verificarNombreUsuario(String nombreUsuario) {
		if(!nombreUsuario.matches(".*[a-zA-Z].*") || nombreUsuario.length()<4) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	/***
	 * Este método verifica el telefono que el usuario mete al registrarse, en caso de no contener 9 números o contener alguna letras o caracter
	 * saltara un error.
	 * 
	 * @param telefono telefono que mete el usuario al registrarse
	 * @return devuelve true cuando el telefono introducido contiene todas las condiciones puestas
	 */

	public static boolean verificarTelefono(String telefono) {
		if(telefono.length()!=9 || !telefono.matches(".*[0-9].*") || telefono.matches(".*[a-zA-Z].*")) {
			JOptionPane.showMessageDialog(null, "El numero de teléfono es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/***
	 * Este método lo que hace es añadir el cliente a la lista
	 * 
	 * @param c los clientes registrados
	 */
	
	
	public static void aniadirCliente(Cliente c) {
		clientes.add(c);
	}
	
	/***
	 * Este método tras haber verificado y comprobado que los datos metidos por el usuario son correctos se registraran (guardan en el fichero)
	 * 
	 * @param nomfichCliente fichero clientes.csv
	 * @param nombre nombre metido en el programa por el usuario
	 * @param apellido apellido metido en el programa por el usuario
	 * @param telefono telefono metido en el programa por el usuario
	 * @param direccion direccion metido en el programa por el usuario
	 * @param correo correo metido en el programa por el usuario
	 * @param id id del usuario
	 * @param puntos puntos que tiene el usuario
	 * @param nombreUsuario nombre inventado por el
	 * @param contrasenia contraseña metido en el programa por el usuario
	 * @return en caso de que se verifique la contraseña, el nombre del usuario este correctamente y el telefono este bien devolvera true
	 * en caso contrario devolvera false
	 */

	public static boolean registroCliente(String nomfichCliente, String nombre, String apellido, String telefono, String direccion, String correo,
    int id, int puntos, String nombreUsuario, String contrasenia, JFrame frame) {

	if (verificarContrasenia(contrasenia) && verificarNombreUsuario(nombreUsuario) && verificarTelefono(telefono) &&
        buscarUsuario(telefono) == null && buscarUsuario(correo) == null && buscarUsuario(nombre) == null) {

		Cliente nuevoCliente = new Cliente(nombre, apellido, telefono, direccion, correo, 1, puntos, nombreUsuario, contrasenia);
            clientes.add(nuevoCliente);
            System.out.println(nuevoCliente.getPuntosAcumulados());
            guardarClientes(nomfichCliente);
            
            Connection con = BD.initBD("deustoking.db");
            Restaurante.volcarCSVPersonasABD(con, nomfichCliente);
            BD.cerrarBD(con); 
            

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    

	return false;
	}	
	
	/***
	 * Este método carga en la lista clientes los usuarios que esten en el fichero clientes.csv
	 * 
	 * @param nombfich fichero clientes.csv
	 */
	
	public static void cargarClientesEnLista(String nombfich) {
		try {
			Scanner sc = new Scanner(new File(nombfich));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[]partes = linea.split(";");
				String nombre = partes[0];
				String apellidos = partes[1];
				String tlf = partes[2];
				String email = partes[3];
				String dir = partes[4];
				String nUsuario = partes[5];
				String contrasenia = partes[6];
				int puntos = Integer.parseInt(partes[7]);
				
				 String parametroBusqueda = obtenerParametroBusquedaInicioSesion(email, nombre, tlf);
				if(buscarUsuario(parametroBusqueda)==null) {
					Cliente cliente = new Cliente(nombre, apellidos, tlf, email, dir, Persona.getContador(), puntos, nUsuario, contrasenia);
					clientes.add(cliente);
					
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO ");			
		}
	}

	/***
	 * Este método va cargando en el combo las fechas en las que se hacen las reservas
	 * 
	 * @param reservas una lista con todas las reservas realizadas
	 * @param cbFecha combo con todas las fechas
	 */
	
	public static void cargarFechasEnComboBox(List<Reserva> reservas, JComboBox<String> cbFecha) {
		for (Reserva reserva : reservas) {
            String fecha = reserva.getFechaStr();

            if (!fechasReservas.contains(fecha)) {
                fechasOrdenadas.add(fecha);
                fechasReservas.add(fecha);
            }
        }

        Collections.sort(fechasOrdenadas, new Comparator<String>() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 

            @Override
            public int compare(String fecha1, String fecha2) {
                try {
                    return sdf.parse(fecha1).compareTo(sdf.parse(fecha2));
                } catch (ParseException e) {
                	logger.log(Level.WARNING, "NO SE HA PODIDO MODIFICAR EL FORMATO DE LA FECHA");	
                    return 0;
                }
            }
        });

        cbFecha.removeAllItems();

        for (String fecha : fechasOrdenadas) {
            cbFecha.addItem(fecha);
        }
	}
	
	/***
	 * Este método guarda las reservas que se van haciendo en el fichero reservas.csv
	 * 
	 * @param reserva las reservas que se van haciendo
	 * @param nombrefich fichero reservas.csv
	 */
	
	public static void guardarReservasEnFichero(Reserva reserva, String nombrefich) {
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(nombrefich, true));
			String fecha = reserva.getFechaStr();
          
			pw.println(Reserva.getContador()+";"+ fecha+";"+reserva.getHora()+";"+reserva.getnComensales()+";"+reserva.getNombre()+";"+reserva.getTelefono()+";"+reserva.getCorreo());
			pw.close();
		} catch (IOException e) {
			logger.log(Level.WARNING, "SE HA INTERRUMPIDO LA OPERACIÓN ESCRITURA EN EL FICHERO");	
		}
	
	}
	
	/***
	 * Este método recibe una hora y una fecha con numero de comensales y guarda la reserva con dichos parametros en el fichero reservas.csv
	 * 
	 * @param datePicker calendario para escoger el dia
	 * @param horas comboBox con las horas para hacer la reserva
	 * @param nComensales comboBox con el numero de perosnas que iran a dicha reserva
	 * @param nomfichReservas fichero reservas.csv
	 * @param vActual ventana Reserva
	 * @param vAnterior 
	 */
	
	public static void reservar(DatePicker datePicker, JComboBox<String> horas, JComboBox<Integer> nComensales, String nomfichReservas, JFrame vActual, JFrame vAnterior,
			String nombre, String telefono, String correo) {
		GregorianCalendar calendar = (GregorianCalendar) datePicker.getModel().getValue();
	    ZonedDateTime fechaLocal = calendar.toZonedDateTime();
	    Date fechaDate = Date.from(fechaLocal.toInstant());
	    String hora = (String) horas.getSelectedItem();
	    int comensales = (int) nComensales.getSelectedItem();
		Reserva reserva = new Reserva(Reserva.getContador(), nombre, telefono, correo, Utilidades.dateToString(fechaDate), hora, comensales);
	    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar la reserva?", "Confirmar reserva", JOptionPane.YES_NO_OPTION);
	    if (opcion == JOptionPane.YES_OPTION) {
	        Restaurante.guardarReservasEnFichero(reserva, nomfichReservas);
	        JOptionPane.showMessageDialog(null, "Reserva guardada exitosamente");
	    } else {
	        int opcion2 = JOptionPane.showConfirmDialog(null, "¿Desea continuar en la ventana de reserva?", "Continua reserva",JOptionPane.YES_NO_OPTION);
	        if(opcion2==JOptionPane.YES_OPTION) {
	        	vActual.setVisible(true);
	        }else {
	        	vActual.dispose();
				vAnterior.setVisible(true);
	        }
	    }
    }
	
	/***
	 * Este método vuelca todo el contenido del fichero  a la base de datos
	 * 
	 * @param con conexión para la base de datos
	 * @param nomfich fichero clientes.csv
	 */
	
	public static void volcarCSVPersonasABD(Connection con, String nomfich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomfich));
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String []partes = linea.split(";");
				String nombre = partes[0];
				String apellidos = partes[1];
				String telefono = partes[2];
				String correo = partes[3];
				String direccion = partes[4];
				String nombreUsuario = partes[5];
				String contrasenia = partes[6];
				int puntosAcumulado = Integer.parseInt(partes[7]);
				Cliente c = new Cliente(nombre, apellidos, telefono, correo, direccion, Persona.getContador(),puntosAcumulado , nombreUsuario, contrasenia);
				BD.insertarCliente(con, c);
			
			}
			sc.close();
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO ");		}
	}
	
	/***
	 * Este método vuelca todas las reservas del fichero a la base de datos
	 * 
	 * @param con conexión para la base de datos
	 * @param nomfich fichero reservas.csv
	 */
	
	public static void volcarCSVReservasABD(Connection con, String nomfich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomfich));
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String []partes = linea.split(";");
				int id = Integer.parseInt(partes[0]);
				String fecha = partes[1];
				String hora = partes[2];
				int nComensales = Integer.parseInt(partes[3]);
				Reserva r = new Reserva(id, fecha, hora, nComensales);
				
				BD.insertarReserva(con, r);
			
			}
			sc.close();
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO ");		}
	}
	
	/***
	 * Este método vuelca todos los cupones del fichero a la base de datos
	 * 
	 * @param con conexión para la base de datos
	 * @param nomfich fichero Cupones.csv
	 */
	
	public static void volcarCSVCuponesABD(Connection con, String nomfich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomfich));
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String[]partes = linea.split(";");
				int minPuntos = Integer.parseInt(partes[0]);
				double descuento = Double.parseDouble(partes[1]);
				String foto = partes[2];
				String nombre = partes[3];
				
				Cupon c = new Cupon(minPuntos, descuento, foto, nombre);
				BD.insertarCupon(con, c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO");
		}
		
	}
	
	/***
	 * Este método hace que al seleccionar un producto te salgan sus ingredientes y si lo quieres añadir o no
	 * 
	 * @param nombre  del producto
	 * @param ingredientes que ingredientes tiene el producto seleccionado
	 * @param precio el precio de dicho producto
	 */
	
	public static void informacionProductos(String nombre, String ingredientes, float precio) {

	    SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 20, 1);
	    JSpinner spinner = new JSpinner(spinnerModel);
	    JPanel spinnerPanel = new JPanel();
	    spinnerPanel.add(spinner);
	    Dimension panelSize = new Dimension(200, spinnerPanel.getPreferredSize().height);
	    spinnerPanel.setPreferredSize(panelSize);
	    Object[] mensaje = {
	            "Ingredientes:", ingredientes,
	            "\n",
	            "Precio:", precio + " €",
	            "\n",
	            "Cantidad a añadir:",
	            spinnerPanel
	    };

	    Object[] opciones = {"Añadir", "Cancelar"};
	    int resultado = JOptionPane.showOptionDialog(
	            null, mensaje, nombre, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
	            null, opciones, opciones[0]
	    );

	    if (resultado == JOptionPane.OK_OPTION) {
	        int cantidad = (int) spinner.getValue();
	        JOptionPane.showMessageDialog(null, "Añadido con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
	        Producto p = new Producto(1, nombre, ingredientes,precio, cantidad, "","",new ArrayList<>());
	        productos.add(p);

	        for (Producto pr : productos) {
	            System.out.println(pr);
	        }
	    }
	}
	
	/***
	 * Este método obtiene una lista de productod 
	 * 
	 * @return devuelve los productos
	 */
	
	public static List<Producto> obtenerProductos() {
        return productos;
    }
	
	/***
	 * Este método carga los cupones del fichero Cupones.csv
	 */
	
	public static void cargarCupones() {
		try {
			Scanner sc = new Scanner(new FileReader("ficheros/Cupones.csv"));
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String [] partes = linea.split(";");
				Cupon c = new Cupon(Integer.parseInt(partes[0]), Float.parseFloat(partes[1]), "imagenes/"+partes[2], partes[3]);
				mapaCupones.put(c.getFoto(), c);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO ");		}
		
	}
	
	/***
	 * Este método obtiene en mapa de los cupones
	 * 
	 * @return devuelve el mapa de los cupones
	 */
	
	public static Map<String, Cupon> getMapaCupones(){
		return mapaCupones;
	}
	
	/***
	 * Este método vuelca la lista de clientes al fichero clientes.csv
	 */
	
	public static void volcarListaClientesAlFichero() {
		try {
			PrintWriter pw = new PrintWriter("ficheros/Clientes.csv");
			for(Cliente c: clientes) {
				pw.println(c.getNombre()+";"+c.getApellidos()+";"+c.getTelefono()+";"+c.getDireccion()+";"+c.getCorreo()+";"+
						c.getNombreUsuario()+";"+c.getContrasenia()+";"+c.getPuntosAcumulados());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO ");		}
	}
	
	/***
	 * Este método hace que al seleccionar un cupon te salga su descuento
	 * 
	 * @param cupon que cupon se ha seleccionado
	 * @param descripcion la descripcion del cupon
	 */
	
	public static void informacionCupones(String cupon, String descripcion) {
	    JPanel spinnerPanel = new JPanel();
	    Object[] mensaje = {
	            cupon,
	            "\n",
	            "Descripción:", descripcion,
	            spinnerPanel
	    };
	    
	    Object[] opciones = {"VOLVER"};
	    int resultado = JOptionPane.showOptionDialog(
	            null, mensaje, cupon, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
	            null, opciones, opciones[0]
	    );
		
	}
	
	public static List<Reserva>  obtenerReservasCliente(String telefono) {
		List<Reserva> reservas = mapaReservas.get(telefono);
		if(reservas!=null) {
			Collections.sort(reservas, (reserva1,reserva2) -> reserva1.getFecha().compareTo(reserva2.getFecha()));
		}
		
		return reservas;
	}
	
	public static void cargarProductosEnLista(String nomfich) {
		listaProductosFichero.clear();
		try {
			Scanner sc = new Scanner(new File(nomfich));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes=linea.split(";");
				
				int idP = Integer.parseInt(partes[0]);
				String nombre = partes[1];
				String descripcion = partes[2];
				float precio=0;
				if(!partes[3].isEmpty()) {
					precio = Float.parseFloat(partes[3]);
				}
				
				int cantidad =0;
				if(!partes[4].isEmpty()) {
					cantidad = Integer.parseInt(partes[4]);
				}
				
				String modificacion = partes[5];
				TipoProducto tipoProducto = TipoProducto.valueOf(partes[6]);
				String imagen = partes[7];
				ArrayList<Producto> lP = new ArrayList<>();
				if(partes.length==9) {
					String[]productos = partes[8].split(":");
					for (String idProducto : productos) {
						int id = Integer.parseInt(idProducto);
						Producto productoEncontrado = buscarProductoPorId(id, listaProductosFichero);
						if(productoEncontrado!=null) {
							lP.add(productoEncontrado);
						}
					}
				}
				
				if(partes.length==9) {
					MenuDeusto menu = new MenuDeusto(idP, nombre, descripcion, precio, cantidad, modificacion, tipoProducto, imagen, lP);
					listaProductosFichero.add(menu);
				}else {
					Producto producto = new Producto(idP, nombre, descripcion, precio, cantidad, modificacion, tipoProducto, imagen, null);
					listaProductosFichero.add(producto);
				}
			}
			sc.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Producto buscarProductoPorId(int id, List<Producto> listaProductos) {
		for (Producto producto : listaProductos) {
			if(producto.getIdP()==id) {
				return producto;
			}
		}
		
		return null;
	}


	public static List<Producto> getListaProductosFichero() {
		return listaProductosFichero;
	}
	
	public static void volcarListaReservasAlFichero() {
		try {
			PrintWriter pw = new PrintWriter("ficheros/reservas.csv");
			for(Reserva r: listaReservas) {
				pw.println(r.getNombre()+";"+r.getTelefono()+";"+r.getCorreo()+";"+r.getFecha()+";"+r.getHora()+";"+
						r.getnComensales());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO ");		}
	}
	
	
	
}
