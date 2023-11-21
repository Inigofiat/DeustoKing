package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


import deustoking.Cliente;
import deustoking.Persona;
import deustoking.Reserva;
import deustoking.Restaurante;

public class VentanaTablaReserva extends JFrame{
	private ModeloReserva modeloTablaReservas;
	private JTable tablaReserva;
	private JScrollPane scrollTablaReserva;
	private JPanel pContenedor, pPrincipal, pOeste, pCentro;
	private JComboBox<String> cbFecha;
	private ModeloCliente modeloTablaReservasClientes;
	private JScrollPane scrollTablaCliente;
	private JTable tablaCliente;
	
	
	
	public VentanaTablaReserva() {
		super();
		
		Restaurante.cargarReservasEnLista("reservas.csv");
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        
        
     
        pContenedor = new JPanel();
        pContenedor.setLayout(new BorderLayout()); 
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());   
        pCentro = new JPanel();
        pCentro.setLayout(new BorderLayout());
        pOeste = new JPanel();
        cbFecha = new JComboBox<>();
        pOeste.add(cbFecha);
    
        
       
	    cargarFechasEnComboBox(Restaurante.getListaReservas());
        modeloTablaReservas = new ModeloReserva(null);
        tablaReserva = new JTable(modeloTablaReservas);
	    scrollTablaReserva = new JScrollPane(tablaReserva);
	    tablaReserva.setDefaultRenderer(Object.class, new RendererReserva());
	    pCentro.add(scrollTablaReserva, BorderLayout.NORTH);
	    
	    modeloTablaReservasClientes = new ModeloCliente(null);
		tablaCliente = new JTable(modeloTablaReservasClientes);
		scrollTablaCliente = new JScrollPane(tablaCliente);
		pCentro.add(scrollTablaCliente, BorderLayout.SOUTH);   
	    
	    cbFecha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String fechaString = (String) cbFecha.getSelectedItem();       
		        LocalDate fecha = LocalDate.parse(fechaString, formatter);
		        List<Reserva> listaReservas = Restaurante.obtenerReservasPorFecha(fecha);
		        tablaReserva.setModel(new ModeloReserva(listaReservas));		        
			}
		});
	    
	    tablaReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int fila = tablaReserva.rowAtPoint(p);
				String fecha = tablaReserva.getModel().getValueAt(fila, 1).toString();
				List<Cliente> lp = Restaurante.getPersonasHanCompradoElProducto(fecha);
				tablaCliente.setModel(new ModeloCliente(lp));
				
			}
		});
	    
	    pContenedor.add(pOeste, BorderLayout.WEST);
	    pContenedor.add(pCentro, BorderLayout.CENTER);
	    pPrincipal.add(pContenedor,BorderLayout.CENTER);
	    
	    getContentPane().add(pPrincipal);
	    
	    Restaurante.miIcono(this, "/imagenes/CORONA.png");
	    
		setVisible(true);
	}
	
	private void cargarFechasEnComboBox(List<Reserva> reservas) {
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
	


	
	
	public static void main(String[] args) {
		VentanaTablaReserva v = new VentanaTablaReserva();
	}

}
