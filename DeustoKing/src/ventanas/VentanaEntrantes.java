package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import deustoking.Restaurante;

public class VentanaEntrantes extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnNachos, btnArosCebolla, btnTequeños, btnAlitas, btnVolver;
	private JLabel lblNachos, lblArosCebolla, lblTequeños, lblAlitas;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	private JMenuBar menu;
	private JMenu menuDesplegable;
	private JMenuItem itCompra;
	static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaEntrantes(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("Entrantes");
        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pContenedor = new JPanel();
		pContenedor.setLayout(new BorderLayout());
        
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        
        pTitulo = new JPanel();
        pTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        lblTitulo = new JLabel("ENTRANTES");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnNachos = new JButton();
		ImageIcon imNachos = new ImageIcon("imagenes\\nachos.jpeg");
		lblNachos = new JLabel("NACHOS");
		btnNachos.setIcon(imNachos);
		btnNachos.setLayout(new BorderLayout());
		btnNachos.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnNachos.setPreferredSize(new Dimension(150,350));
		lblNachos.setHorizontalAlignment(SwingConstants.LEFT);
		lblNachos.setVerticalAlignment(SwingConstants.TOP);
		lblNachos.setForeground(Color.WHITE); 
		lblNachos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnNachos.add(lblNachos, BorderLayout.CENTER);
		btnNachos.setMargin(margenBotones);
		btnNachos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON NACHOMANIA");
				Restaurante.informacionProductos("NachoMania", "Guacamole casero, pulled pork macerado con cuatro quesos y salsa bbq,"
						+ "\npico de gallo, salsa cheddar, crema agria y jalapeños, acompañado de nachos caseros de maíz.", 9.90);
				
			}
		});
		pProductos.add(btnNachos);
		
		btnArosCebolla = new JButton();
		ImageIcon imAros = new ImageIcon("imagenes\\aros.jpg");
		lblArosCebolla = new JLabel("AROS DE CEBOLLA");
		btnArosCebolla.setIcon(imAros);
		btnArosCebolla.setLayout(new BorderLayout());
		btnArosCebolla.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnArosCebolla.setPreferredSize(new Dimension(150,350));
		lblArosCebolla.setHorizontalAlignment(SwingConstants.LEFT);
		lblArosCebolla.setVerticalAlignment(SwingConstants.TOP);
		lblArosCebolla.setForeground(Color.WHITE); 
		lblArosCebolla.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnArosCebolla.add(lblArosCebolla, BorderLayout.CENTER);
		btnArosCebolla.setMargin(margenBotones);
		btnArosCebolla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTONS AROS DE CEBOLLA");
				Restaurante.informacionProductos("CrispyRings", "Crujientes aros de cebolla acompañados de nuestra salsa barbacos.", 8.40);
				
			}
		});
		pProductos.add(btnArosCebolla);
		
		btnTequeños = new JButton();
		ImageIcon imTequeños = new ImageIcon("imagenes\\tequeños.jpg");
		lblTequeños = new JLabel("TEQUEÑOS");
		btnTequeños.setIcon(imTequeños);
		btnTequeños.setLayout(new BorderLayout());
		btnTequeños.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnTequeños.setPreferredSize(new Dimension(150,350));
		lblTequeños.setHorizontalAlignment(SwingConstants.LEFT);
		lblTequeños.setVerticalAlignment(SwingConstants.TOP);
		lblTequeños.setForeground(Color.WHITE); 
		lblTequeños.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnTequeños.add(lblTequeños, BorderLayout.CENTER);
		btnTequeños.setMargin(margenBotones);
		btnTequeños.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON TEQUEÑOS");
				Restaurante.informacionProductos("TequeÑitos", "Palitos crujientes rellenos de queso fundido, servidos con nuestra exclusiva salsa casera (8uds).", 8.50);
				
			}
		});
		pProductos.add(btnTequeños);
		
		btnAlitas = new JButton();
		ImageIcon imAlitas = new ImageIcon("imagenes\\alitas.jpg");
		lblAlitas = new JLabel("ALITAS");
		btnAlitas.setIcon(imAlitas);
		btnAlitas.setLayout(new BorderLayout());
		btnAlitas.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnAlitas.setPreferredSize(new Dimension(150,350));
		lblAlitas.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlitas.setVerticalAlignment(SwingConstants.TOP);
		lblAlitas.setForeground(Color.WHITE); 
		lblAlitas.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnAlitas.add(lblAlitas, BorderLayout.CENTER);
		btnAlitas.setMargin(margenBotones);
		btnAlitas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN BOTON ALITAS");
				Restaurante.informacionProductos("Alitas", "Alitas de pollo en salsa sweet chili con sésamo y cebollino (6uds)", 6.50);
				
			}
		});
		pProductos.add(btnAlitas);
		
		pVolver = new JPanel();
		pVolver.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnVolver = new JButton("VOLVER A LA CARTA");	
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setPreferredSize(new Dimension(150,30));
		btnVolver.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnVolver.setMargin(new Insets(10, 10, 10, 10));
		btnVolver.setBorderPainted(true);
		btnVolver.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON VOLVER");
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		pVolver.add(btnVolver);
		pVolver.add(btnVolver);
		
		GridLayout productosLayout = new GridLayout(0,2,0,30);
		productosLayout.setHgap(30); 
		pProductos.setLayout(productosLayout);
		
		FlowLayout tituloLayout = new FlowLayout(FlowLayout.CENTER);
	    pTitulo.setLayout(tituloLayout);
		
		FlowLayout botonVolverLayout = new FlowLayout(FlowLayout.CENTER);
	    botonVolverLayout.setHgap(3); 
	    pVolver.setLayout(botonVolverLayout);
	    
	    int espacioEntrePaneles1 = 130; 
	    pProductos.setBorder(new EmptyBorder(espacioEntrePaneles1, espacioEntrePaneles1, espacioEntrePaneles1, espacioEntrePaneles1 ));
	    
	    menu = new JMenuBar();
	    menuDesplegable = new JMenu("");
	    ImageIcon icono = new ImageIcon("imagenes/carro.png");
	    Image imagenEscalada = icono.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	    icono = new ImageIcon(imagenEscalada);
	    menuDesplegable.setIcon(icono);
	    menuDesplegable.setFont(new Font("Tw", Font.BOLD, 12));
	    menuDesplegable.setForeground(new Color(0,0,0));
	    itCompra = new JMenuItem("Cesta");
	    itCompra.setFont(new Font("Tw", Font.PLAIN, 12));
	    itCompra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CESTA");
				new VentanaTablaProductos(vActual);
				vActual.dispose();
				
			}
		});

	    menuDesplegable.add(itCompra);

	    menu.add(menuDesplegable);

	    setJMenuBar(menu);
        
        pContenedor.add(lblTitulo, BorderLayout.NORTH);
	    pContenedor.add(pProductos, BorderLayout.CENTER);
	    pContenedor.add(pVolver, BorderLayout.SOUTH);
	    pPrincipal.add(pContenedor,BorderLayout.CENTER);
	    
	    getContentPane().add(pPrincipal);
	    
	    barra = new JScrollPane(pPrincipal);
	    barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    getContentPane().add(barra);
	    
	    Restaurante.miIcono(this, "imagenes/CORONA.png");
	    
	    setVisible(true);
	}
	
}
