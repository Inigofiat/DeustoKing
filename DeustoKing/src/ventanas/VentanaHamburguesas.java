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

public class VentanaHamburguesas extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnH1, btnH2, btnH3, btnH4, btnVolver;
	private JLabel lblH1, lblH2, lblH3, lblH4;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());
	private JMenuBar menu;
	private JMenu menuDesplegable;
	private JMenuItem itCompra;
	
	public VentanaHamburguesas(JFrame va, String nombre, String imagen) {
		super();
		vActual=this;
		vAnterior = va;
		setTitle("Hamburguesas");
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
        
        lblTitulo = new JLabel("HAMBURGUESAS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnH1 = new JButton();
		ImageIcon imNachos = new ImageIcon("imagenes\\diablo.jpg");
		lblH1 = new JLabel("DIABLO");
		btnH1.setIcon(imNachos);
		btnH1.setLayout(new BorderLayout());
		btnH1.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnH1.setPreferredSize(new Dimension(150,350));
		lblH1.setHorizontalAlignment(SwingConstants.LEFT);
		lblH1.setVerticalAlignment(SwingConstants.TOP);
		lblH1.setForeground(Color.WHITE); 
		lblH1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnH1.add(lblH1, BorderLayout.CENTER);
		btnH1.setMargin(margenBotones);
		pProductos.add(btnH1);
		btnH1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON HAMBURGUESA DIABLO");
				Restaurante.informacionProductos("Diablo", "Picamos cada cacho de carne directamente en la plancha y la mezclamos con"
						+ "trozos de cebolla crunchy, bacon y queso americano, \nmontando una encima de otra hasta quedarnos tres hamburguesas entre queso chedar y bacon"
						+ "con nuestra salsa especial 'deustosalsa' ", 11.95);
				
			}
		});
		
		
		btnH2 = new JButton();
		ImageIcon imAros = new ImageIcon("imagenes\\pulledpork.jpg");
		lblH2 = new JLabel("PULLED PORK");
		btnH2.setIcon(imAros);
		btnH2.setLayout(new BorderLayout());
		btnH2.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnH2.setPreferredSize(new Dimension(150,350));
		lblH2.setHorizontalAlignment(SwingConstants.LEFT);
		lblH2.setVerticalAlignment(SwingConstants.TOP);
		lblH2.setForeground(Color.WHITE); 
		lblH2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnH2.add(lblH2, BorderLayout.CENTER);
		btnH2.setMargin(margenBotones);
		pProductos.add(btnH2);
		btnH2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON HAMBURGUESA PULLED PORK");
				Restaurante.informacionProductos("Pulled Pork", "Pan brioche artesano negro con tinta de calamar, nuestro característico pulled pork junto con cebolla morada triturada y cebolla pochada, \nqueso chedar,"
						+ "panceta y un toque de salsa barbacoa", 13.00);
				
			}
		});
		
		btnH3 = new JButton();
		ImageIcon imTequeños = new ImageIcon("imagenes\\baking.jpg");
		lblH3 = new JLabel("BAKING");
		btnH3.setIcon(imTequeños);
		btnH3.setLayout(new BorderLayout());
		btnH3.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnH3.setPreferredSize(new Dimension(150,350));
		lblH3.setHorizontalAlignment(SwingConstants.LEFT);
		lblH3.setVerticalAlignment(SwingConstants.TOP);
		lblH3.setForeground(Color.WHITE); 
		lblH3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnH3.add(lblH3, BorderLayout.CENTER);
		btnH3.setMargin(margenBotones);
		pProductos.add(btnH3);
		btnH3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON HAMBURGUESA BAKING");
				Restaurante.informacionProductos("Baking", "Pan de cristal hecho en casa, pechuga de pollo empanada con cebolla morada y caramelizada mezclada "
						+ "\ncon unos pepinillos de la tierra y salsa de chedar untada en el pan", 11.00);
				
			}
		});
		
		btnH4 = new JButton();
		ImageIcon imAlitas = new ImageIcon(imagen);
		lblH4 = new JLabel(nombre);
		btnH4.setIcon(imAlitas);
		btnH4.setLayout(new BorderLayout());
		btnH4.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnH4.setPreferredSize(new Dimension(150,350));
		lblH4.setHorizontalAlignment(SwingConstants.LEFT);
		lblH4.setVerticalAlignment(SwingConstants.TOP);
		lblH4.setForeground(Color.WHITE); 
		lblH4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnH4.add(lblH4, BorderLayout.CENTER);
		btnH4.setMargin(margenBotones);
		pProductos.add(btnH4);
		btnH4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nombre=="BILBO BURGER") {
					logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON HAMBURGUESA BILBO BURGER");
					Restaurante.informacionProductos(nombre, "Nuestro característico y llamativo pan brioche con un toque secreto, 150 gr de txuleton, una rodaja de queso de cabra \ncon"
							+ "nuestras salsa de queso, acompañada de una cebolla pochada y bacon con sirope de arce y un huevo", 12.55);
				}else if (nombre == "DONOSTI BURGER") {
					logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON HAMBURGUESA DONOSTI BURGER");
					Restaurante.informacionProductos(nombre, "Pan brioche, 150 gr de txuleta de vaca junto con ensalada variada que contiene lechuga y tomate, "
							+ "/npimientos de de el país vasco, queso mozzarella y cebolla crujiente ", 14.55);
				}else if(nombre=="GASTEIZ BURGER") {
					logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON HAMBURGUESA GASTEIZ BURGER");
					Restaurante.informacionProductos(nombre, "Pan brioche, 200 gr de txuleta de vaca, lechuga fresca, /nqueso gouda una combinación de bacon con panceta,"
							+ " un huevo a la plancha y nuestra salsa secreta ", 15.60);
				}
			}
		});
		
		
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
				logger.log(Level.INFO, "SE HA HECHO CLICK EN BOTON CESTA");
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
