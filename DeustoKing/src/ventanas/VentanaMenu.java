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
import javax.swing.JCheckBox;
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

public class VentanaMenu extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnM1, btnM2, btnM3, btnM4, btnVolver;
	private JLabel lblM1, lblM2, lblM3, lblM4;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());
	private JMenuBar menu;
	private JMenu menuDesplegable;
	private JMenuItem itCompra;

	
	public VentanaMenu(JFrame va, String lbNombre, String imagen, String nombre) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("MENÚ");
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
        
        lblTitulo = new JLabel(lbNombre);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		
		btnM1 = new JButton();
		ImageIcon imNachos = new ImageIcon(imagen);
		lblM1 = new JLabel(nombre);
		btnM1.setIcon(imNachos);
		btnM1.setLayout(new BorderLayout());
		btnM1.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnM1.setPreferredSize(new Dimension(150,350));
		lblM1.setHorizontalAlignment(SwingConstants.LEFT);
		lblM1.setVerticalAlignment(SwingConstants.TOP);
		lblM1.setForeground(Color.WHITE); 
		lblM1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnM1.add(lblM1, BorderLayout.CENTER);
		btnM1.setMargin(margenBotones);
		
		pProductos.add(btnM1);
		
		btnM2 = new JButton();
		ImageIcon imAros = new ImageIcon("imagenes\\patatas.jpg");
		lblM2 = new JLabel("PATATAS");
		btnM2.setIcon(imAros);
		btnM2.setLayout(new BorderLayout());
		btnM2.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnM2.setPreferredSize(new Dimension(150,350));
		lblM2.setHorizontalAlignment(SwingConstants.LEFT);
		lblM2.setVerticalAlignment(SwingConstants.TOP);
		lblM2.setForeground(Color.WHITE); 
		lblM2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnM2.add(lblM2, BorderLayout.CENTER);
		btnM2.setMargin(margenBotones);
		pProductos.add(btnM2);
		
		btnM3 = new JButton();
		ImageIcon imTequeños = new ImageIcon("imagenes\\agua.jpeg");
		lblM3 = new JLabel("BEBIDA A ELEGIR");
		btnM3.setIcon(imTequeños);
		btnM3.setLayout(new BorderLayout());
		btnM3.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnM3.setPreferredSize(new Dimension(150,350));
		lblM3.setHorizontalAlignment(SwingConstants.LEFT);
		lblM3.setVerticalAlignment(SwingConstants.TOP);
		lblM3.setForeground(Color.WHITE); 
		lblM3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnM3.add(lblM3, BorderLayout.CENTER);
		btnM3.setMargin(margenBotones);
		btnM3.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON BEBIDAS");
			new VentanaBebidas(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});
		pProductos.add(btnM3);
		
		btnM4 = new JButton();
		ImageIcon imAlitas = new ImageIcon("imagenes\\helado.jpg");
		lblM4 = new JLabel("POSTRE A ELEGIR");
		btnM4.setIcon(imAlitas);
		btnM4.setLayout(new BorderLayout());
		btnM4.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnM4.setPreferredSize(new Dimension(150,350));
		lblM4.setHorizontalAlignment(SwingConstants.LEFT);
		lblM4.setVerticalAlignment(SwingConstants.TOP);
		lblM4.setForeground(Color.WHITE); 
		lblM4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnM4.add(lblM4, BorderLayout.CENTER);
		btnM4.setMargin(margenBotones);
		pProductos.add(btnM4);
		
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
				logger.log(Level.INFO, "SE HA HECHO CLICK EN LA CESTA");
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
