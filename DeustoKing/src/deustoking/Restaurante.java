package deustoking;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import org.jdatepicker.DatePicker;

//ordenar fecha
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
               
                Reserva reserva = new Reserva(id,fecha, hora, comensales);
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
						c.getNombreUsuario()+";"+c.getContrasenia());
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

	public static boolean verificarContrasenia(String contrasenia) {

		if(contrasenia.length() < 6 || !contrasenia.matches(".*[0-9].*") || !contrasenia.matches(".*[a-zA-Z].*") || !contrasenia.matches(".*[!@#$%^&*()-_=+{};:,<.>/?`~].*")) {
			JOptionPane.showMessageDialog(null, "La contraseña no contiene los caracteres necesarios", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	
	public static boolean verificarNombreUsuario(String nombreUsuario) {
		if(!nombreUsuario.matches(".*[a-zA-Z].*")&& nombreUsuario.length()<4) {
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
	

	public static boolean registroCliente(String nomfichCliente, String nombre, String apellido, String telefono, String direccion, String correo,
		int id, int puntos, String nombreUsuario, String contrasenia) {

		if(verificarContrasenia(contrasenia)&& verificarNombreUsuario(nombreUsuario)&&verificarTelefono(telefono)) {
			Cliente nuevoCliente = new Cliente(nombre, apellido, telefono,direccion, correo, 1, 0 , nombreUsuario, contrasenia);
			clientes.add(nuevoCliente);
			guardarClientes(nomfichCliente);
			return true;
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
				
				 String parametroBusqueda = obtenerParametroBusquedaInicioSesion(email, nombre, tlf);
				if(buscarUsuario(parametroBusqueda)==null) {
					Cliente cliente = new Cliente(nombre, apellidos, tlf, email, dir, Persona.getContador(), 0, nUsuario, contrasenia);
					clientes.add(cliente);
					
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}


	
	public static void cargarFechasEnComboBox(List<Reserva> reservas, JComboBox<String> cbFecha) {
	    Set<String> fechasAgregadas = new HashSet<>(); 

	    for (Reserva reserva : reservas) {
	    	String fecha = reserva.getFechaStr();

	        
	        if (!fechasAgregadas.contains(fecha)) {
	            cbFecha.addItem(fecha);
	            fechasAgregadas.add(fecha); 
	        }
	    }
	}
	
	public static void guardarReservasEnFichero(Reserva reserva, String nombrefich) {
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(nombrefich, true));
			String fecha = reserva.getFechaStr();
          
			pw.println(Reserva.getContador()+";"+ fecha+";"+reserva.getHora()+";"+reserva.getnComensales());
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
	

	
}
