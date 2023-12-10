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

public class VentanaEnsaladas extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnCesar, btnMixta, btnPasta, btnCaprese, btnVolver;
	private JLabel lblCesar, lblMixta, lblPasta, lblCaprese;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaEnsaladas(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("Ensaladas");
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
        
        lblTitulo = new JLabel("ENSALADAS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnCesar = new JButton();
		ImageIcon imNachos = new ImageIcon("src\\imagenes\\cesar.jpg");
		lblCesar = new JLabel("CÉSAR");
		btnCesar.setIcon(imNachos);
		btnCesar.setLayout(new BorderLayout());
		btnCesar.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnCesar.setPreferredSize(new Dimension(150,350));
		lblCesar.setHorizontalAlignment(SwingConstants.LEFT);
		lblCesar.setVerticalAlignment(SwingConstants.TOP);
		lblCesar.setForeground(Color.WHITE); 
		lblCesar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnCesar.add(lblCesar, BorderLayout.CENTER);
		btnCesar.setMargin(margenBotones);
		pProductos.add(btnCesar);
		
		btnMixta = new JButton();
		ImageIcon imAros = new ImageIcon("src\\imagenes\\mixta.jpeg");
		lblMixta = new JLabel("MIXTA");
		btnMixta.setIcon(imAros);
		btnMixta.setLayout(new BorderLayout());
		btnMixta.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnMixta.setPreferredSize(new Dimension(150,350));
		lblMixta.setHorizontalAlignment(SwingConstants.LEFT);
		lblMixta.setVerticalAlignment(SwingConstants.TOP);
		lblMixta.setForeground(Color.WHITE); 
		lblMixta.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnMixta.add(lblMixta, BorderLayout.CENTER);
		btnMixta.setMargin(margenBotones);
		pProductos.add(btnMixta);
		
		btnPasta = new JButton();
		ImageIcon imTequeños = new ImageIcon("src\\imagenes\\depasta.jpg");
		lblPasta = new JLabel("DE PASTA");
		btnPasta.setIcon(imTequeños);
		btnPasta.setLayout(new BorderLayout());
		btnPasta.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnPasta.setPreferredSize(new Dimension(150,350));
		lblPasta.setHorizontalAlignment(SwingConstants.LEFT);
		lblPasta.setVerticalAlignment(SwingConstants.TOP);
		lblPasta.setForeground(Color.WHITE); 
		lblPasta.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnPasta.add(lblPasta, BorderLayout.CENTER);
		btnPasta.setMargin(margenBotones);
		pProductos.add(btnPasta);
		
		btnCaprese = new JButton();
		ImageIcon imAlitas = new ImageIcon("src\\imagenes\\caprese.jpg");
		lblCaprese = new JLabel("CAPRESE");
		btnCaprese.setIcon(imAlitas);
		btnCaprese.setLayout(new BorderLayout());
		btnCaprese.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnCaprese.setPreferredSize(new Dimension(150,350));
		lblCaprese.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaprese.setVerticalAlignment(SwingConstants.TOP);
		lblCaprese.setForeground(Color.WHITE); 
		lblCaprese.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnCaprese.add(lblCaprese, BorderLayout.CENTER);
		btnCaprese.setMargin(margenBotones);
		pProductos.add(btnCaprese);
		
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

