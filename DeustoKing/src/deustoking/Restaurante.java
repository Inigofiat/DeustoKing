package deustoking;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

//ordenar fecha
public class Restaurante {
	

	private  static Map<String, List<Reserva>> reservasPorCliente;
	private  static Set<Reserva> setReservas;
	private  static  List<Reserva> listaReservas;
	private  static Map<String, Cliente> mapaPersonaPorCorreo;
	private static List<Cliente> clientes;
	private static Cliente cliente;
	private static Map<LocalDate, List<Reserva>> mapaHorasPorFecha;

	
	static {
		reservasPorCliente = new TreeMap<>();
		setReservas = new TreeSet<>();
		cliente = new Cliente();
		mapaPersonaPorCorreo = new TreeMap<>();
		listaReservas = new ArrayList<>();
		clientes = new ArrayList<>();
		mapaHorasPorFecha = new TreeMap<>();
	}
	
	public static void miIcono(JFrame ventana, String rutaIcono) {
		try {
			Image icon = new ImageIcon(Restaurante.class.getResource(rutaIcono)).getImage();
			ventana.setIconImage(icon);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	public  void cargarReservasEnLista (String nombfich) {
       
        
        try {
			Scanner sc = new Scanner(new File(nombfich));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				int id = Integer.parseInt(partes[0]);
                LocalDate fecha = LocalDate.parse(partes[0], formatter);
                String hora = partes[1];
                int comensales = Integer.parseInt(partes[2]);
                Reserva reserva = new Reserva(id,fecha, hora, comensales);
                System.out.println(reserva);
                listaReservas.add(reserva);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}       
        			
	}
	public static List<Reserva> getListaReservas(){
		return listaReservas;
		
	}
	
	public static List<Reserva> obtenerReservasPorFecha(LocalDate fecha) {
	    List<Reserva> reservasPorFecha = new ArrayList<>();
	        for (Reserva reserva : listaReservas) {
	        	System.out.println(reserva.getFecha());
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
	        LocalDate fecha = reserva.getFecha();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String fechaFormateada = fecha.format(formatter);

	        
	        if (!fechasAgregadas.contains(fechaFormateada)) {
	            cbFecha.addItem(fechaFormateada);
	            fechasAgregadas.add(fechaFormateada); 
	        }
	    }
	}
	
	public static void guardarReservasEnFichero(Reserva reserva, String nombrefich) {
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(nombrefich, true));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String fechaFormateada = reserva.getFecha().format(formatter);
          
			pw.println(Reserva.getContador()+";"+ fechaFormateada+";"+reserva.getHora()+";"+reserva.getnComensales());
			pw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	

	
}
