package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import deustoking.PuestoTrabajo;
import deustoking.Restaurante;
import deustoking.Trabajador;



public class VentanaPrincipal extends JFrame {

	
	private JButton btnBilbao, btnDonostia, btnGasteiz, btnInicSesion, btnCupon, btnReservas;
	private JLabel lbV1, lbCup;
	private JPanel panCiudades, panBotones, panPrincipal, panInformación;
	private JMenuBar menu;
	private JMenu menuDesplegable;
	private JMenuItem itTrabajador;
	private JFrame vActual, vAnterior;
	private GradientPaint gr1, gr2, gr3;
	private static final String nomfichClientes = "ficheros/Trabajadores.csv";
	private static Trabajador trabajador;
	private static  JComboBox<PuestoTrabajo> cargoComboBox;
	static Logger logger = Logger.getLogger(Main.class.getName());
	
	
	public VentanaPrincipal(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		
		setTitle("DeustoKing");
        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Restaurante.cargarTrabajadoresEnLista(nomfichClientes);
		cargoComboBox=new JComboBox<>(PuestoTrabajo.values());
		JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new BorderLayout());
        
		
		
		panPrincipal = new JPanel();
		panPrincipal.setLayout(new BorderLayout());
		
		panBotones = new JPanel();
		panBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnReservas = new JButton("RESERVAS");
		btnReservas.setBackground(new Color(189,206,243));
		btnReservas.setPreferredSize(new Dimension(200,50));
		btnReservas.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnReservas.setMargin(new Insets(10, 10, 10, 10));
		panBotones.add(btnReservas);
		btnReservas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE ESTA ABRIENDO LA VENTANA DE RESERVAS");
				new VentanaReserva(vActual);
				vActual.setVisible(false);
				vActual.dispose();
				
			}
		});
		
		btnCupon = new JButton("CUPONES");
		btnCupon.setBackground(new Color(189,206,243));
		btnCupon.setPreferredSize(new Dimension(200,50));
		btnCupon.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnCupon.setMargin(new Insets(10, 10, 10, 10));
		panBotones.add(btnCupon);
		btnCupon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA ABIERTO LA VENTANA DE CUPONES");
				new VentanaCupones(vActual);
				vActual.setVisible(false);
				vActual.dispose();
				
			}
		});
		
		btnInicSesion = new JButton("INICIO SESIÓN");
		btnInicSesion.setBackground(new Color(189,206,243));
		btnInicSesion.setPreferredSize(new Dimension(200,50));
		btnInicSesion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnInicSesion.setMargin(new Insets(10, 10, 10, 10));
		panBotones.add(btnInicSesion);
		btnInicSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA ABIERTO LA VENTANA DE INICIO DE SESION");
				new VentanaInicioSesion(vActual);
				vActual.setVisible(false);
				vActual.dispose();
				
			}
		});
		
		panCiudades = new JPanel();
		panCiudades.setLayout(new FlowLayout());
		
		lbV1 = new JLabel("");
		lbV1.setBackground(Color.WHITE);
		lbV1.setBounds(400, 209, 166, 182);
		lbV1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		panCiudades.add(lbV1);
		
		btnBilbao = new JButton("BILBO");
		
		btnBilbao.setBounds(400, 209, 166, 182);
		btnBilbao.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		btnBilbao.setPreferredSize(new Dimension(250,300));
		btnBilbao.setBackground(new Color(249,96,96));
		
		  
		
		
		gr1 = new GradientPaint(0, 0, Color.RED, 0, btnBilbao.getHeight(), Color.WHITE);

	        // Se crea una clase para personalizar el aspecto del botón
	        btnBilbao.setUI(new BasicButtonUI() {
	            @Override
	            public void paint(Graphics g, JComponent c) {
	                Graphics2D g2d = (Graphics2D) g;
	                g2d.setPaint(gr1);               
	                g2d.fillRect(0, 0, c.getWidth(), c.getHeight());
	                super.paint(g, c);
	            }
	        });
	        
		
		btnBilbao.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON CARTA");
			new VentanaCarta(vActual, "BILBO");
		});
		panCiudades.add(btnBilbao);
		
		
		JPanel panelCentro = new JPanel();
		
		panelCentro.add(panCiudades);
		
	
		btnDonostia = new JButton("DONOSTIA");
		btnDonostia.setBackground(new Color(171,249,236));
		btnDonostia.setBounds(400, 209, 166, 182);
		btnDonostia.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		btnDonostia.setPreferredSize(new Dimension(250,300));
		btnDonostia.setBackground(new Color(82,164,79));
		
		gr2 = new GradientPaint(0, 0, Color.BLUE, 0, btnDonostia.getHeight(), Color.WHITE);

	      
	        btnDonostia.setUI(new BasicButtonUI() {
	            @Override
	            public void paint(Graphics g, JComponent c) {
	                Graphics2D g2d = (Graphics2D) g;
	                g2d.setPaint(gr2);
	                g2d.fillRect(0, 0, c.getWidth(), c.getHeight());
	                super.paint(g, c);
	            }
	        });
		
		panCiudades.add(btnDonostia);
		btnDonostia.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA ABIERTO LA VENTANA CARTA DE DONSOTIA");
			new VentanaCarta(vActual, "DONOSTI");
		});
		
		btnGasteiz = new JButton("GASTEIZ");
		btnGasteiz.setBackground(Color.LIGHT_GRAY);
		btnGasteiz.setBounds(400, 209, 166, 182);
		btnGasteiz.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		btnGasteiz.setPreferredSize(new Dimension(250,300));
		
		 gr3= new GradientPaint(0, 0, Color.GREEN, 0, btnGasteiz.getHeight(), Color.WHITE);

	        // SE crea una clase para personalizar el aspecto del botón
	        btnGasteiz.setUI(new BasicButtonUI() {
	            @Override
	            public void paint(Graphics g, JComponent c) {
	                Graphics2D g2d = (Graphics2D) g;
	                g2d.setPaint(gr3);
	                g2d.fillRect(0, 0, c.getWidth(), c.getHeight());
	                super.paint(g, c);
	            }
	        });
		panCiudades.add(btnGasteiz);
		btnGasteiz.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA ABIERTO LA VENTANA CARTA DE GASTEIZ");
			new VentanaCarta(vActual, "GASTEIZ");
		});
		
		lbV1 = new JLabel("");
		lbV1.setBackground(Color.WHITE);
		lbV1.setBounds(400, 209, 166, 182);
		lbV1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		panCiudades.add(lbV1);
		
		panInformación = new JPanel();
		panInformación.setLayout(new FlowLayout(FlowLayout.CENTER));
		

		lbCup = new JLabel("¡CON LA PRIMERA COMPRA REGISTRÁNDOTE CONSEGUIRÁS 75 PUNTOS!");
		lbCup.setBackground(Color.WHITE);
		lbCup.setBounds(400, 209, 166, 182);
		lbCup.setFont(new Font("Tw", Font.PLAIN, 25));
		panInformación.add(lbCup);
		
		int espacioEntrePaneles1 = 200; 
	    panCiudades.setBorder(new EmptyBorder(espacioEntrePaneles1, espacioEntrePaneles1, espacioEntrePaneles1, espacioEntrePaneles1));
	    int espacioEntrePaneles2 = 10; 
	    panBotones.setBorder(new EmptyBorder(espacioEntrePaneles2, espacioEntrePaneles2, espacioEntrePaneles2, espacioEntrePaneles2));
	    int espacioEntrePaneles3 = 100;
	    panInformación.setBorder(new EmptyBorder(espacioEntrePaneles3, espacioEntrePaneles3, espacioEntrePaneles3, espacioEntrePaneles3 ));
	     
	    FlowLayout ciudadesLayout = new FlowLayout();
	    ciudadesLayout.setHgap(50); 
	    panCiudades.setLayout(ciudadesLayout);
	    
	    FlowLayout botonesLayout = new FlowLayout(FlowLayout.RIGHT);
	    botonesLayout.setHgap(25); 
	    panBotones.setLayout(botonesLayout);
	    
	    menu = new JMenuBar();
	    menuDesplegable = new JMenu("¿Eres trabajador?");
	    menuDesplegable.setFont(new Font("Tw", Font.BOLD, 12));
	    menuDesplegable.setForeground(new Color(0,0,0));
	    itTrabajador= new JMenuItem("Trabajador");
	    itTrabajador.setFont(new Font("Tw", Font.PLAIN, 12));
	    itTrabajador.addActionListener(new ActionListener() {
			
	    	 @Override
			    public void actionPerformed(ActionEvent e) {

			        String dni = "";
			        Trabajador t = null;

			        while (t == null) {
			            dni = JOptionPane.showInputDialog("Ingrese su DNI:");

			            if (dni == null) {
			                break;
			            }

			            if (dni.isEmpty()) {
			                JOptionPane.showMessageDialog(null, "Inserte el DNI", "ERROR", JOptionPane.ERROR_MESSAGE);
			            } else {
			                t = Restaurante.buscarTrabajador(dni);

			                if (t == null) {
			                    JOptionPane.showMessageDialog(null, "Trabajador no encontrado", "ERROR", JOptionPane.WARNING_MESSAGE);
			                }
			            }
			        }
			       
			        if (t != null) {
			            PuestoTrabajo selectedCargo = null;
			            while (selectedCargo == null) {
			                cargoComboBox.setSelectedItem(t.getPuesto());
			                Object[] mensaje = {
			                        "Nombre y Apellidos:", t.getNombre() + " " + t.getApellidos(),
			                        "Teléfono:", t.getTelefono(),
			                        "DNI:", dni,
			                        "Seleccione el cargo:", cargoComboBox
			                };

			                int result = JOptionPane.showConfirmDialog(null, mensaje, "Ingrese su información",
			                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			                if (result == JOptionPane.OK_OPTION) {
			                    selectedCargo = (PuestoTrabajo) cargoComboBox.getSelectedItem();

			                    if (!dni.equals(t.getDni()) || !selectedCargo.equals(t.getPuesto())) {
			                        JOptionPane.showMessageDialog(null, "Cargo incorrecto", "ERROR", JOptionPane.WARNING_MESSAGE);

			                        selectedCargo = null;
			                    } else {
			                        JOptionPane.showMessageDialog(null, "¡Bienvenido!", "SESIÓN INICIADA", JOptionPane.INFORMATION_MESSAGE);
			                        trabajador = t;
			                        new VentanaReserva(vActual);
			                        vActual.setVisible(false);
			                    }
			                } else {
			                   
			                    break;
			                }
			            }
			        }
			    }
		});
	    
	    
	    menuDesplegable.add(itTrabajador);
	    
	    menu.add(menuDesplegable);
	    
	    
	    setJMenuBar(menu);
	 
	     
	    panelContenedor.add(panCiudades, BorderLayout.CENTER);
	    panelContenedor.add(panBotones, BorderLayout.NORTH);
	    panelContenedor.add(panInformación, BorderLayout.SOUTH);
	 
		
		panPrincipal.add(panelContenedor, BorderLayout.CENTER);
		getContentPane().add(panPrincipal);
		
		Restaurante.miIcono(this, "/imagenes/CORONA.png");
		
		setVisible(true);
		
	}
}