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

public class VentanaInfantil extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnCarne, btnPollo, btnVolver;
	private JLabel lblCarne, lblPollo;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());
	private JMenuBar menu;
	private JMenu menuDesplegable;
	private JMenuItem itCompra;
	
	public VentanaInfantil(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("Infantil");
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
        
        lblTitulo = new JLabel("INFANTIL");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnCarne = new JButton();
		ImageIcon imNachos = new ImageIcon("imagenes\\carne.jpg");
		lblCarne = new JLabel("KIDS CARNE");
		btnCarne.setIcon(imNachos);
		btnCarne.setLayout(new BorderLayout());
		btnCarne.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnCarne.setPreferredSize(new Dimension(200,200));
		lblCarne.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarne.setVerticalAlignment(SwingConstants.TOP);
		lblCarne.setForeground(Color.WHITE); 
		lblCarne.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnCarne.add(lblCarne, BorderLayout.CENTER);
		btnCarne.setMargin(margenBotones);
		pProductos.add(btnCarne);
		btnCarne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON HAMBURGUESA KIDS CARNE");
				Restaurante.informacionProductos("Kids Carne", "Pan brioche con 50 gr de carne y una loncha de queso cheddar", 1.50);
			}
		});
		
		btnPollo = new JButton();
		ImageIcon imAros = new ImageIcon("imagenes\\pollo.jpg");
		lblPollo = new JLabel("KIDS POLLO");
		btnPollo.setIcon(imAros);
		btnPollo.setLayout(new BorderLayout());
		btnPollo.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnPollo.setPreferredSize(new Dimension(200,200));
		lblPollo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPollo.setVerticalAlignment(SwingConstants.TOP);
		lblPollo.setForeground(Color.WHITE); 
		lblPollo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnPollo.add(lblPollo, BorderLayout.CENTER);
		btnPollo.setMargin(margenBotones);
		pProductos.add(btnPollo);
		btnPollo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON HAMBURGUESA POLLO KIDS");
				Restaurante.informacionProductos("Kids Pollo", "Pan brioche con pollo rebozado y una loncha de queso cheddar", 1.50);
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
			logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON VOLVER");
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		pVolver.add(btnVolver);
		
		GridLayout productosLayout = new GridLayout(0,2,0,30);
		productosLayout.setHgap(50); 
		pProductos.setLayout(productosLayout);
		
		FlowLayout tituloLayout = new FlowLayout(FlowLayout.CENTER);
	    pTitulo.setLayout(tituloLayout);
		
		FlowLayout botonVolverLayout = new FlowLayout(FlowLayout.CENTER);
	    botonVolverLayout.setHgap(3); 
	    pVolver.setLayout(botonVolverLayout);
	    
	    int espacioEntrePaneles1 = 240; 
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
	    barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    getContentPane().add(barra);
	    
	    setVisible(true);
	}
}
