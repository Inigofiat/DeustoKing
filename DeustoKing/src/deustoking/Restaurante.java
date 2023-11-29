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
