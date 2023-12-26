package deustoking;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import org.jdatepicker.DatePicker;

import basesDeDatos.BD;
import ventanas.VentanaCarta;

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
	private static Set<String> fechasReservas;
	private static  List<String> fechasOrdenadas;
	private static Map<String, Cupon> mapaCupones;

	
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

	}
	
	public static void miIcono(JFrame ventana, String rutaIcono) {
		try {
			Image icon = new ImageIcon(Restaurante.class.getResource(rutaIcono)).getImage();
			ventana.setIconImage(icon);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}       
        			
	}
	
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
			e.printStackTrace();
		}
	}
	public static List<Reserva> getListaReservas(){
		return listaReservas;
		
	}
	
	public static Map<Date, List<Reserva>> getMapaHorasPorFecha() {
		return mapaHorasPorFecha;
	}
	
	public static List<Reserva> obtenerReservasPorFecha(Date fecha) {
	    List<Reserva> reservasPorFecha = new ArrayList<>();
	        for (Reserva reserva : listaReservas) {
	        
	            if (reserva.getFecha().equals(fecha)) {
	                reservasPorFecha.add(reserva);
	                
	            }
	            
	        }
	    return reservasPorFecha;
	  
	}
	
	
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
			e.printStackTrace();
		}
	}

	public static String obtenerParametroBusquedaInicioSesion(String email, String nombre, String tlf) {
	    
	    if (!email.isEmpty()) {
	        return email;
	    } else if (!nombre.isEmpty()) {
	        return nombre;
	    } else {
	        return tlf;
	    }
	}
	
	public static boolean verificarCorreo(String correo) {

		if(correo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.(com|org|es))$")) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "El correo no es válido", "ERROR", JOptionPane.ERROR_MESSAGE);
		return false;
		
	}

	public static boolean verificarContrasenia(String contrasenia) {

		if(contrasenia.length() < 6 || !contrasenia.matches(".*[0-9].*") || !contrasenia.matches(".*[a-zA-Z].*") || !contrasenia.matches(".*[!@#$%^&*()-_=+{};:,<.>/?`~].*")) {
			JOptionPane.showMessageDialog(null, "La contraseña no contiene los caracteres necesarios", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	
	public static boolean verificarNombreUsuario(String nombreUsuario) {
		if(!nombreUsuario.matches(".*[a-zA-Z].*") || nombreUsuario.length()<4) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	

	public static boolean verificarTelefono(String telefono) {
		if(telefono.length()!=9 || !telefono.matches(".*[0-9].*") || telefono.matches(".*[a-zA-Z].*")) {
			JOptionPane.showMessageDialog(null, "El numero de teléfono es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	
	public static void aniadirCliente(Cliente c) {
		clientes.add(c);
	}
	

//	public static boolean registroCliente(String nomfichCliente, String nombre, String apellido, String telefono, String direccion, String correo,
//		int id, int puntos, String nombreUsuario, String contrasenia) {
//
//		if(verificarCorreo(correo) && verificarContrasenia(contrasenia)&& verificarNombreUsuario(nombreUsuario)&&verificarTelefono(telefono)&& buscarUsuario(telefono)==null && buscarUsuario(correo)==null && buscarUsuario(nombre)==null) {
//			Cliente nuevoCliente = new Cliente(nombre, apellido, telefono,direccion, correo, 1, 7 , nombreUsuario, contrasenia);
//			clientes.add(nuevoCliente);
//			guardarClientes(nomfichCliente);
//			Connection con = BD.initBD("deustoking.db");
//			Restaurante.volcarCSVPersonasABD(con, nomfichCliente);
//			BD.cerrarBD(con);
//			return true;
//		} 
//		return false;
//	}
	
	public static boolean registroCliente(String nomfichCliente, String nombre, String apellido, String telefono, String direccion, String correo,
    int id, int puntos, String nombreUsuario, String contrasenia, JFrame frame) {

if (verificarContrasenia(contrasenia) && verificarNombreUsuario(nombreUsuario) && verificarTelefono(telefono) &&
        buscarUsuario(telefono) == null && buscarUsuario(correo) == null && buscarUsuario(nombre) == null) {

    Cliente nuevoCliente = new Cliente(nombre, apellido, telefono, direccion, correo, 1, puntos, nombreUsuario, contrasenia);

    
    JComboBox<Ciudad> ciudadComboBox = new JComboBox<>(Ciudad.values());
    ciudadComboBox.setSelectedItem(null); 

    Object[] message = {
            "Nombre y Apellidos:", nuevoCliente.getNombre() + " " + nuevoCliente.getApellidos(),
            "Teléfono:", nuevoCliente.getTelefono(),
            "Email:", nuevoCliente.getCorreo(),
            "Ciudad:", ciudadComboBox
    };

    int option = JOptionPane.showOptionDialog(null, message, "Datos del Nuevo Cliente",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

    if (option == JOptionPane.OK_OPTION) {
        Ciudad ciudadSeleccionada = (Ciudad) ciudadComboBox.getSelectedItem();
            clientes.add(nuevoCliente);
            System.out.println(nuevoCliente.getPuntosAcumulados());
            guardarClientes(nomfichCliente);

            Connection con = BD.initBD("deustoking.db");
            Restaurante.volcarCSVPersonasABD(con, nomfichCliente);
            BD.cerrarBD(con);
            
            if (ciudadSeleccionada != null) {
                switch (ciudadSeleccionada) {
                    case BILBO:
                        new VentanaCarta(frame, "BILBO");
                        break;
                    case DONOSTI:
                    	new VentanaCarta(frame, "DONOSTI");
                        break;
                    case GASTEIZ:
                    	new VentanaCarta(frame, "GASTEIZ");
                    	break;
                   
                }
            } 

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una ciudad válida", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

return false;
}
	
	
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
			
			e.printStackTrace();
		}
	}


	
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
                    e.printStackTrace();
                    return 0;
                }
            }
        });

        cbFecha.removeAllItems();

        for (String fecha : fechasOrdenadas) {
            cbFecha.addItem(fecha);
        }
	}
	
	public static void guardarReservasEnFichero(Reserva reserva, String nombrefich) {
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(nombrefich, true));
			String fecha = reserva.getFechaStr();
          
			pw.println(Reserva.getContador()+";"+ fecha+";"+reserva.getHora()+";"+reserva.getnComensales()+";"+reserva.getNombre()+";"+reserva.getTelefono()+";"+reserva.getCorreo());
			pw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	public static void reservar(DatePicker datePicker, JComboBox<String> horas, JComboBox<Integer> nComensales, String nomfichReservas, JFrame vActual, JFrame vAnterior) {
		GregorianCalendar calendar = (GregorianCalendar) datePicker.getModel().getValue();
	    ZonedDateTime fechaLocal = calendar.toZonedDateTime();
	    Date fechaDate = Date.from(fechaLocal.toInstant());
	    String hora = (String) horas.getSelectedItem();
	    int comensales = (int) nComensales.getSelectedItem();
	    Reserva reserva = new Reserva(Reserva.getContador(), fechaDate, hora, comensales);
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
				Cliente c = new Cliente(nombre, apellidos, telefono, correo, direccion, Persona.getContador(), 0, nombreUsuario, contrasenia);
				BD.insertarCliente(con, c);
			
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
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
			e.printStackTrace();
		}
	}
	
	public static void informacionProductos(String nombre, String ingredientes, double precio) {

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
	        Producto p = new Producto(1, nombre, ingredientes, precio, cantidad, "");
	        productos.add(p);

	        for (Producto pr : productos) {
	            System.out.println(pr);
	        }
	    }
	}
	
	public static List<Producto> obtenerProductos() {
        return productos;
    }
	
	public static void cargarCupones() {
		try {
			Scanner sc = new Scanner(new FileReader("ficheros/cupones.csv"));
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String [] partes = linea.split(";");
				Cupon c = new Cupon(Integer.parseInt(partes[0]), Float.parseFloat(partes[1]), partes[2], partes[3]);
				mapaCupones.put(c.getFoto(), c);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Map<String, Cupon> getMapaCupones(){
		return mapaCupones;
	}
	
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
			e.printStackTrace();
		}
	}
	
}
