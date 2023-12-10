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

public class VentanaCupones extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnC1, btnC2, btnC3, btnC4, btnVolver;
	private JLabel lblC1, lblC2, lblC3, lblC4;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaCupones(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("Cupones");
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
        Color panelBackgroundColor = pPrincipal.getBackground();
        Color buttonBackgroundColor = new Color(panelBackgroundColor.getRGB());
        
        pTitulo = new JPanel();
        pTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        lblTitulo = new JLabel("CUPONES");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnC1 = new JButton();
		ImageIcon cupon1 = new ImageIcon("src\\imagenes\\CUPON.png");
		lblC1 = new JLabel("CUPÓN 1: 2 x 1 en menú DeustoKing");
		btnC1.setIcon(cupon1);
		btnC1.setLayout(new BorderLayout());
		btnC1.setPreferredSize(new Dimension(cupon1.getIconWidth(), cupon1.getIconHeight()));	
		btnC1.setPreferredSize(new Dimension(150,350));
		lblC1.setHorizontalAlignment(SwingConstants.LEFT);
		lblC1.setVerticalAlignment(SwingConstants.TOP);
		btnC1.setBackground(buttonBackgroundColor);
		btnC1.setBorderPainted(false);
		lblC1.setForeground(Color.WHITE); 
		lblC1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnC1.add(lblC1, BorderLayout.CENTER);
		btnC1.setMargin(margenBotones);
		pProductos.add(btnC1);
		
		btnC2 = new JButton();
		ImageIcon cupon2 = new ImageIcon("src\\imagenes\\CUPON.png");
		lblC2 = new JLabel("CUPÓN 2: - 50% en Bilbo.");
		btnC2.setIcon(cupon2);
		btnC2.setLayout(new BorderLayout());
		btnC2.setPreferredSize(new Dimension(cupon2.getIconWidth(), cupon2.getIconHeight()));	
		btnC2.setPreferredSize(new Dimension(150,350));
		lblC2.setHorizontalAlignment(SwingConstants.LEFT);
		lblC2.setVerticalAlignment(SwingConstants.TOP);
		btnC2.setBackground(buttonBackgroundColor);
		btnC2.setBorderPainted(false);
		lblC2.setForeground(Color.WHITE); 
		lblC2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnC2.add(lblC2, BorderLayout.CENTER);
		btnC2.setMargin(margenBotones);
		pProductos.add(btnC2);
		
		btnC3 = new JButton();
		ImageIcon cupon3 = new ImageIcon("src\\imagenes\\CUPON.png");
		lblC3 = new JLabel("CUPÓN 3: 1,99€ Deushake");
		btnC3.setIcon(cupon3);
		btnC3.setLayout(new BorderLayout());
		btnC3.setPreferredSize(new Dimension(cupon3.getIconWidth(), cupon3.getIconHeight()));	
		btnC3.setPreferredSize(new Dimension(150,350));
		lblC3.setHorizontalAlignment(SwingConstants.LEFT);
		lblC3.setVerticalAlignment(SwingConstants.TOP);
		btnC3.setBackground(buttonBackgroundColor);
		btnC3.setBorderPainted(false);
		lblC3.setForeground(Color.WHITE); 
		lblC3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnC3.add(lblC3, BorderLayout.CENTER);
		btnC3.setMargin(margenBotones);
		pProductos.add(btnC3);
		
		btnC4 = new JButton();
		ImageIcon cupon4 = new ImageIcon("src\\imagenes\\CUPON.png");
		lblC4 = new JLabel("CUPÓN 4: 15,99€ Sanwing + Porking");
		btnC4.setIcon(cupon1);
		btnC4.setLayout(new BorderLayout());
		btnC4.setPreferredSize(new Dimension(cupon4.getIconWidth(), cupon4.getIconHeight()));	
		btnC4.setPreferredSize(new Dimension(150,350));
		lblC4.setHorizontalAlignment(SwingConstants.LEFT);
		lblC4.setVerticalAlignment(SwingConstants.TOP);
		btnC4.setBackground(buttonBackgroundColor);
		btnC4.setBorderPainted(false);
		lblC4.setForeground(Color.WHITE); 
		lblC4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnC4.add(lblC4, BorderLayout.CENTER);
		btnC4.setMargin(margenBotones);
		pProductos.add(btnC4);
		
		pVolver = new JPanel();
		pVolver.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnVolver = new JButton("VOLVER AL INICIO");	
		btnVolver.setBackground(Color.lightGray);
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
