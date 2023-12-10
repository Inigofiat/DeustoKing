package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import deustoking.Restaurante;

public class VentanaOtros extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnCostillas, btnBurrito, btnSandwich, btnBocata, btnVolver;
	private JLabel lblCostillas, lblBurrito, lblSandwich, lblBocata;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaOtros(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("OTROS");
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
        
        lblTitulo = new JLabel("OTROS PRODUCTOS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnBocata = new JButton();
		ImageIcon imNachos = new ImageIcon("src\\imagenes\\bocata.jpg");
		lblBocata = new JLabel("PORKING");
		btnBocata.setIcon(imNachos);
		btnBocata.setLayout(new BorderLayout());
		btnBocata.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnBocata.setPreferredSize(new Dimension(150,350));
		lblBocata.setHorizontalAlignment(SwingConstants.LEFT);
		lblBocata.setVerticalAlignment(SwingConstants.TOP);
		lblBocata.setForeground(Color.WHITE); 
		lblBocata.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnBocata.add(lblBocata, BorderLayout.CENTER);
		btnBocata.setMargin(margenBotones);
		pProductos.add(btnBocata);
		
		btnBurrito = new JButton();
		ImageIcon imAros = new ImageIcon("src\\imagenes\\burrito.jpg");
		lblBurrito = new JLabel("BURRIKING");
		btnBurrito.setIcon(imAros);
		btnBurrito.setLayout(new BorderLayout());
		btnBurrito.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnBurrito.setPreferredSize(new Dimension(150,350));
		lblBurrito.setHorizontalAlignment(SwingConstants.LEFT);
		lblBurrito.setVerticalAlignment(SwingConstants.TOP);
		lblBurrito.setForeground(Color.WHITE); 
		lblBurrito.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnBurrito.add(lblBurrito, BorderLayout.CENTER);
		btnBurrito.setMargin(margenBotones);
		pProductos.add(btnBurrito);
		
		btnCostillas = new JButton();
		ImageIcon imTequeños = new ImageIcon("src\\imagenes\\ribs.jpg");
		lblCostillas = new JLabel("DEUSTORIB");
		btnCostillas.setIcon(imTequeños);
		btnCostillas.setLayout(new BorderLayout());
		btnCostillas.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnCostillas.setPreferredSize(new Dimension(150,350));
		lblCostillas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCostillas.setVerticalAlignment(SwingConstants.TOP);
		lblCostillas.setForeground(Color.WHITE); 
		lblCostillas.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnCostillas.add(lblCostillas, BorderLayout.CENTER);
		btnCostillas.setMargin(margenBotones);
		pProductos.add(btnCostillas);
		
		btnSandwich = new JButton();
		ImageIcon imAlitas = new ImageIcon("src\\imagenes\\sandwich.jpg");
		lblSandwich = new JLabel("SANWING");
		btnSandwich.setIcon(imAlitas);
		btnSandwich.setLayout(new BorderLayout());
		btnSandwich.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnSandwich.setPreferredSize(new Dimension(150,350));
		lblSandwich.setHorizontalAlignment(SwingConstants.LEFT);
		lblSandwich.setVerticalAlignment(SwingConstants.TOP);
		lblSandwich.setForeground(Color.WHITE); 
		lblSandwich.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnSandwich.add(lblSandwich, BorderLayout.CENTER);
		btnSandwich.setMargin(margenBotones);
		pProductos.add(btnSandwich);
		
		pVolver = new JPanel();
		pVolver.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnVolver = new JButton("VOLVER A LA CARTA");	
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setPreferredSize(new Dimension(150,30));
		btnVolver.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnVolver.setMargin(new Insets(10, 10, 10, 10));
		btnVolver.setBorderPainted(true);
		pVolver.add(btnVolver);btnVolver.addActionListener((e)->{
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
