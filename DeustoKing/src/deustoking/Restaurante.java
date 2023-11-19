package deustoking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Restaurante {
	
	private static Map<String, List<Reserva>> reservasPorCliente;
	private static Set<Reserva> setReservas;
	private List<Reserva> listaReservas;
	private Map<String, Cliente> mapaPersonaPorCorreo;
	Cliente cliente;
	
	public Restaurante() {
		reservasPorCliente = new TreeMap<>();
		setReservas = new TreeSet<>();
		cliente = new Cliente();
		mapaPersonaPorCorreo = new TreeMap<>();
		listaReservas = new ArrayList<>();
	}
	
	public void guardarReservasEnFichero(Reserva reserva, String nombrefich) {
		
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(nombrefich, true));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            String fechaFormateada = reserva.getFecha().format(formatter);
	          
				pw.println(fechaFormateada+";"+reserva.getHora()+";"+reserva.getnComensales());
				pw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}
	
	public void cargarReservasEnLista (String nombfich) {
       
        
        try {
			Scanner sc = new Scanner(new File(nombfich));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fecha = LocalDate.parse(partes[0], formatter);
                String hora = partes[1];
                int comensales = Integer.parseInt(partes[2]);
               
                Reserva reserva = new Reserva(fecha, hora, comensales);
                System.out.println(reserva);
                listaReservas.add(reserva);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}       
        			
	}
	public List<Reserva> getListaReservas(){
		return listaReservas;
		
	}
	
	public List<Reserva> obtenerReservasPorFecha(LocalDate fecha) {
	    List<Reserva> reservasPorFecha = new ArrayList<>();
	        for (Reserva reserva : listaReservas) {
	        	System.out.println(reserva.getFecha());
	            if (reserva.getFecha().equals(fecha)) {
	                reservasPorFecha.add(reserva);
	                
	            }
	            
	        }
	    return reservasPorFecha;
	    
	}
	
	
	public List<Cliente> getPersonasHanCompradoElProducto(String hora){
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
	
}
