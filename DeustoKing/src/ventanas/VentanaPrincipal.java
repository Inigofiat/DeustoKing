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

import javax.swing.ImageIcon;
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
import javax.swing.Timer;
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
	private static final String nomfichClientes = "ficheros/Trabajadores.csv";
	private static Trabajador trabajador;
	private static  JComboBox<PuestoTrabajo> cargoComboBox;
	static Logger logger = Logger.getLogger(Main.class.getName());
	PanelGif gifPanel;
	
	
	
	
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
        
		
        panCiudades = new JPanel();
        panBotones = new JPanel();
        panInformación = new JPanel();
        panPrincipal = new JPanel();
        
        gifPanel = new PanelGif(new ImageIcon("imagenes/carga.gif").getImage());
        gifPanel.add(panBotones, BorderLayout.NORTH);
        gifPanel.add(panCiudades, BorderLayout.CENTER);
        gifPanel.add(panInformación, BorderLayout.SOUTH);
		
		btnReservas = new JButton("RESERVAS");
		btnReservas.setBackground(Color.BLACK);
		btnReservas.setForeground(Color.WHITE);
		btnReservas.setPreferredSize(new Dimension(150,40));
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
		
		btnInicSesion = new JButton("INICIO SESIÓN");
		btnInicSesion.setBackground(Color.BLACK);
		btnInicSesion.setForeground(Color.WHITE);
		btnInicSesion.setPreferredSize(new Dimension(150,40));
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
		
		
		
		lbV1 = new JLabel("");
		lbV1.setBackground(Color.WHITE);
		lbV1.setBounds(400, 209, 166, 182);
		lbV1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		panCiudades.add(lbV1);
		

		

		lbCup = new JLabel("     ¡REGISTRÁNDOTE CONSEGUIRÁS 75 PUNTOS!   ");
		lbCup.setBackground(Color.WHITE);
		lbCup.setBounds(400, 209, 166, 182);
		lbCup.setFont(new Font("Tw", Font.BOLD, 25));
		panInformación.add(lbCup);
		movimientoLabelPuntos(lbCup);
		
		int espacioEntrePaneles1 = 75; 
	    panCiudades.setBorder(new EmptyBorder(espacioEntrePaneles1, espacioEntrePaneles1, espacioEntrePaneles1, espacioEntrePaneles1));
	    int espacioEntrePaneles2 = 10; 
	    panBotones.setBorder(new EmptyBorder(espacioEntrePaneles2, espacioEntrePaneles2, espacioEntrePaneles2, espacioEntrePaneles2));
	    int espacioEntrePaneles3 = 75;
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
	    
	    panCiudades.setOpaque(false);
	    panBotones.setOpaque(false);
	    panInformación.setOpaque(false);
	    
	    setJMenuBar(menu);
	 
		
		setContentPane(gifPanel);
		
		Restaurante.miIcono(this, "imagenes/CORONA.png");
		
		setVisible(true);
		
	}
	
	private void movimientoLabelPuntos(JLabel label) {
	    Timer timer = new Timer(100, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            try {
	                String inicial = label.getText();
	                String movimiento = inicial.charAt(inicial.length() - 1) + inicial.substring(0, inicial.length() - 1);
	                label.setText(movimiento);
	            } catch (Exception ex) {
	                ex.printStackTrace(); 
	            }
	        }
	    });

	    timer.start();
	}
}