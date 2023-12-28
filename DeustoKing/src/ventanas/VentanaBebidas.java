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

public class VentanaBebidas extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnCocacola, btnAgua, btnVino, btnFanta, btnVolver;
	private JLabel lblCocacola, lblAgua, lblVino, lblFanta;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());
	private JMenuBar menu;
	private JMenu menuDesplegable;
	private JMenuItem itCompra;
	
	public VentanaBebidas(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("BEBIDAS");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        
        pTitulo = new JPanel();
        pTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        lblTitulo = new JLabel("BEBIDAS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnCocacola = new JButton();
		ImageIcon imNachos = new ImageIcon("imagenes\\cocacola.jpg");
		lblCocacola = new JLabel("COCA-COLA");
		btnCocacola.setIcon(imNachos);
		btnCocacola.setLayout(new BorderLayout());
		btnCocacola.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnCocacola.setPreferredSize(new Dimension(150,350));
		lblCocacola.setHorizontalAlignment(SwingConstants.LEFT);
		lblCocacola.setVerticalAlignment(SwingConstants.TOP);
		lblCocacola.setForeground(Color.WHITE); 
		lblCocacola.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnCocacola.add(lblCocacola, BorderLayout.CENTER);
		btnCocacola.setMargin(margenBotones);
		pProductos.add(btnCocacola);
		btnCocacola.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Restaurante.informacionProductos("Coca-Cola", "Una Coca-Cola bien fría nos hace disfrutar de cada instante de nuestras vidas de una forma especial."
						+ "\nPor su sabor único y su carácter refrescante y auténtico, Coca-Cola añade magia a cada momento", 3.50 );
				
			}
		});
		
		btnAgua = new JButton();
		ImageIcon imAros = new ImageIcon("imagenes\\agua.jpeg");
		lblAgua = new JLabel("AGUA");
		btnAgua.setIcon(imAros);
		btnAgua.setLayout(new BorderLayout());
		btnAgua.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnAgua.setPreferredSize(new Dimension(150,350));
		lblAgua.setHorizontalAlignment(SwingConstants.LEFT);
		lblAgua.setVerticalAlignment(SwingConstants.TOP);
		lblAgua.setForeground(Color.WHITE); 
		lblAgua.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnAgua.add(lblAgua, BorderLayout.CENTER);
		btnAgua.setMargin(margenBotones);
		pProductos.add(btnAgua);
		btnAgua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Restaurante.informacionProductos("Agua", "DeustoWater es un agua de débil mineralización y sabor suave y refrescante.\r\n"
						+ "\nDeustoWater proviene de Elgoibar, concretamente de Alzola.", 2.20);
			}
		});
		
		btnVino = new JButton();
		ImageIcon imTequeños = new ImageIcon("imagenes\\vino.png");
		lblVino = new JLabel("VINO");
		btnVino.setIcon(imTequeños);
		btnVino.setLayout(new BorderLayout());
		btnVino.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnVino.setPreferredSize(new Dimension(150,350));
		lblVino.setHorizontalAlignment(SwingConstants.LEFT);
		lblVino.setVerticalAlignment(SwingConstants.TOP);
		lblVino.setForeground(Color.WHITE); 
		lblVino.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnVino.add(lblVino, BorderLayout.CENTER);
		btnVino.setMargin(margenBotones);
		pProductos.add(btnVino);
		btnVino.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Restaurante.informacionProductos("Vino", "Nuestro vino se elaboró con uvas seleccionadas de viñas viejas ubicadas por encima de los 900 m de altitud "
						+ "\nen suelos arcillosos que ofrecen vinos elegantes y con estructura debido a los ciclos de maduración más largos ", 3.40);
			}
		});
		
		btnFanta = new JButton();
		ImageIcon imAlitas = new ImageIcon("imagenes\\fanta.jpg");
		lblFanta = new JLabel("FANTA");
		btnFanta.setIcon(imAlitas);
		btnFanta.setLayout(new BorderLayout());
		btnFanta.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnFanta.setPreferredSize(new Dimension(150,350));
		lblFanta.setHorizontalAlignment(SwingConstants.LEFT);
		lblFanta.setVerticalAlignment(SwingConstants.TOP);
		lblFanta.setForeground(Color.WHITE); 
		lblFanta.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnFanta.add(lblFanta, BorderLayout.CENTER);
		btnFanta.setMargin(margenBotones);
		pProductos.add(btnFanta);
		btnFanta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Restaurante.informacionProductos("Fanta", "Si te aburres..... A tomar fanta y diviértete con nosotros"
						+ "\nSu sabor afrutado y refrescante hacen que sea completamente imposible aburrirse con una Fanta en la mano.", 2.50);
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
		pVolver.add(btnVolver);
		btnVolver.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON VOLVER");
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
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
