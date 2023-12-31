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

public class VentanaPostres extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnTartaQueso, btnTartaLotus, btnHelado, btnBatido, btnVolver;
	private JLabel lblTartaQueso, lblTataLotus, lblHelado, lblBatido;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());
	private JMenuBar menu;
	private JMenu menuDesplegable;
	private JMenuItem itCompra;
	
	public VentanaPostres(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("Postres");
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
        
        lblTitulo = new JLabel("POSTRES");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnTartaQueso = new JButton();
		ImageIcon imNachos = new ImageIcon("imagenes\\cheesecake.jpg");
		lblTartaQueso = new JLabel("CHEESECAKE");
		btnTartaQueso.setIcon(imNachos);
		btnTartaQueso.setLayout(new BorderLayout());
		btnTartaQueso.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnTartaQueso.setPreferredSize(new Dimension(150,350));
		lblTartaQueso.setHorizontalAlignment(SwingConstants.LEFT);
		lblTartaQueso.setVerticalAlignment(SwingConstants.TOP);
		lblTartaQueso.setForeground(Color.WHITE); 
		lblTartaQueso.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnTartaQueso.add(lblTartaQueso, BorderLayout.CENTER);
		btnTartaQueso.setMargin(margenBotones);
		pProductos.add(btnTartaQueso);
		btnTartaQueso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CHEESECAKE");
				Restaurante.informacionProductos("Tarta de Queso", "Tarta americana de queso, crumble de galleta con toques de canela, bañado con un coulis de fresa casero.", 5.80);
			}
		});
		
		btnTartaLotus = new JButton();
		ImageIcon imAros = new ImageIcon("imagenes\\lotuscake.jpg");
		lblTataLotus = new JLabel("LOTUSCAKE");
		btnTartaLotus.setIcon(imAros);
		btnTartaLotus.setLayout(new BorderLayout());
		btnTartaLotus.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnTartaLotus.setPreferredSize(new Dimension(150,350));
		lblTataLotus.setHorizontalAlignment(SwingConstants.LEFT);
		lblTataLotus.setVerticalAlignment(SwingConstants.TOP);
		lblTataLotus.setForeground(Color.WHITE); 
		lblTataLotus.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnTartaLotus.add(lblTataLotus, BorderLayout.CENTER);
		btnTartaLotus.setMargin(margenBotones);
		pProductos.add(btnTartaLotus);
		btnTartaLotus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON LOTUSCAKE");
				Restaurante.informacionProductos("Tarta de Lotus","Cuatro capas de esponjoso bizcocho de vainilla relleno con mousse de galleta Lotus, \ncon trozos crujientes de caramelo salado. "
						+ "Terminado con un baño de crema lotus y arena crujiente de galleta Lotus.", 6.20);
			}
		});
		
		btnHelado = new JButton();
		ImageIcon imTequeños = new ImageIcon("imagenes\\helado.jpg");
		lblHelado = new JLabel("FROZEN DEUSTOKING");
		btnHelado.setIcon(imTequeños);
		btnHelado.setLayout(new BorderLayout());
		btnHelado.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnHelado.setPreferredSize(new Dimension(150,350));
		lblHelado.setHorizontalAlignment(SwingConstants.LEFT);
		lblHelado.setVerticalAlignment(SwingConstants.TOP);
		lblHelado.setForeground(Color.WHITE); 
		lblHelado.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnHelado.add(lblHelado, BorderLayout.CENTER);
		btnHelado.setMargin(margenBotones);
		pProductos.add(btnHelado);
		btnHelado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON FROZEN DEUSTOKING");
				Restaurante.informacionProductos("Helado", "Heldao artesano de diferentes sabores:"
						+ " Chocolate, Fresa, Nata, Vainilla, Yogurt y Limón", 2.60);
			}
		});
		
		btnBatido = new JButton();
		ImageIcon imAlitas = new ImageIcon("imagenes\\batido.jpg");
		lblBatido = new JLabel("DEUSHAKE");
		btnBatido.setIcon(imAlitas);
		btnBatido.setLayout(new BorderLayout());
		btnBatido.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnBatido.setPreferredSize(new Dimension(150,350));
		lblBatido.setHorizontalAlignment(SwingConstants.LEFT);
		lblBatido.setVerticalAlignment(SwingConstants.TOP);
		lblBatido.setForeground(Color.WHITE); 
		lblBatido.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnBatido.add(lblBatido, BorderLayout.CENTER);
		btnBatido.setMargin(margenBotones);
		pProductos.add(btnBatido);
		btnBatido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON DEUSTOSHAKE");
				Restaurante.informacionProductos("Batido", "Batido sweet and fresh con galleta oreo y sirope de chocolate", 5.40);
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
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON VOLVER");
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
	    
	    Restaurante.miIcono(this, "/imagenes/CORONA.png");
	    
	    setVisible(true);
	}
}
