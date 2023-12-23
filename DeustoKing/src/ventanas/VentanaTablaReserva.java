package ventanas;

import java.awt.BorderLayout;import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;


import deustoking.Cliente;
import deustoking.Persona;
import deustoking.Reserva;
import deustoking.Restaurante;

public class VentanaTablaReserva extends JFrame{
	private ModeloReserva modeloTablaReservas;
	private JTable tablaReserva;
	private JScrollPane scrollTablaReserva;
	private JPanel pContenedor, pPrincipal, pNorte, pCentro;
	private JComboBox<String> cbFecha;
	private ModeloCliente modeloTablaReservasClientes;
	private JScrollPane scrollTablaCliente;
	private JTable tablaCliente;
	private SpinnerModel modeloSpinner;
	private JSpinner spComensales;
	
	
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
        pNorte = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 15);
        pNorte.setLayout(flowLayout);
        
        
        cbFecha = new JComboBox<>();    
        cbFecha.setPreferredSize(new Dimension(300, cbFecha.getPreferredSize().height));
        pNorte.add(cbFecha);
        
        modeloSpinner = new SpinnerNumberModel(2, 2, 10, 1);
        spComensales = new JSpinner(modeloSpinner);
        spComensales.setPreferredSize(new Dimension(150, 35));
        pNorte.add(spComensales);
    
        
       
	  
	    Restaurante.cargarFechasEnComboBox(Restaurante.getListaReservas(), cbFecha);
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

		    	List<Reserva> listaReservas = obtenerReservasFecha();
		        tablaReserva.setModel(new ModeloReserva(listaReservas));
		    }
		});
		
	    tablaReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int fila = tablaReserva.rowAtPoint(p);
				Reserva r = ((ModeloReserva)tablaReserva.getModel()).getReserva(fila);
				Cliente c = new Cliente(r.getNombre(), "",r.getTelefono(), r.getCorreo(),"", 0,0, "", "");
				List<Cliente> lp = new ArrayList<>();
				lp.add(c);
				tablaCliente.setModel(new ModeloCliente(lp));
			}
		});
	    
	    spComensales.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int valor = Integer.parseInt(spComensales.getValue().toString());
				List<Reserva> listaReservas = obtenerReservasFecha();
				List<Reserva> nueva = new ArrayList<>();
				for(Reserva r: listaReservas) {
					if(r.getnComensales() == valor) {
						nueva.add(r);
					}
				}
				tablaReserva.setModel(new ModeloReserva(nueva));
			}
		});
	    
	    
	    pContenedor.add(pNorte, BorderLayout.NORTH);
	    pContenedor.add(pCentro, BorderLayout.CENTER);
	    pPrincipal.add(pContenedor,BorderLayout.CENTER);
	    
	    getContentPane().add(pPrincipal);

		setVisible(true);
	}
	
	private List<Reserva> obtenerReservasFecha(){
  	  	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	    String fechaString = (String) cbFecha.getSelectedItem();
	    Date fecha;
	    List<Reserva> listaReservas = new ArrayList<>();
	    try {
			fecha = dateFormatter.parse(fechaString);
			listaReservas = Restaurante.obtenerReservasPorFecha(fecha);
	    } catch (ParseException e) {
			e.printStackTrace();
		}
         
	    return listaReservas;
  }
	
	public static void main(String[] args) {
		VentanaTablaReserva v = new VentanaTablaReserva();
	}
}
