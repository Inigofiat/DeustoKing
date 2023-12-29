package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JButton btnC1, btnC2, btnC3, btnC4, btnC5, btnC6, btnC7, btnC8, btnVolver;
	private JLabel lblC1, lblC2, lblC3, lblC4, lblC5, lblC6, lblC7, lblC8;
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
		ImageIcon cupon1 = new ImageIcon("imagenes\\10.gif");
		lblC1 = new JLabel("CUPÓN DEL 10%");
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
		btnC1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CUPÓN DEL 10%");
				Restaurante.informacionCupones("Cupón del 10%", "Este cupón aplica un 10% al precio total. "
						+ "\nSe requiere un mínimo de 90 puntos para canjearlo");
			}
		});
		
		btnC2 = new JButton();
		ImageIcon cupon2 = new ImageIcon("imagenes\\15.gif");
		lblC2 = new JLabel("CUPÓN DEL 15%");
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
		btnC2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CUPÓN DEL 15%");
				Restaurante.informacionCupones("Cupón del 15%","Este cupón aplica un 15% al precio total. "
						+ "\nSe requiere un mínimo de 150 puntos para canjearlo" );
			}
		});
		
		btnC3 = new JButton();
		ImageIcon cupon3 = new ImageIcon("imagenes\\20.gif");
		lblC3 = new JLabel("CUPÓN DEL 20%");
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
		btnC3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CUPÓN DEL 20%");
				Restaurante.informacionCupones("Cupón del 20%","Este cupón aplica un 20% al precio total. "
						+ "\nSe requiere un mínimo de 190 puntos para canjearlo" );
			}
		});
		
		btnC4 = new JButton();
		ImageIcon cupon4 = new ImageIcon("imagenes\\30.gif");
		lblC4 = new JLabel("CUPÓN DEL 30%");
		btnC4.setIcon(cupon4);
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
		btnC4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CUPÓN DEL 30%");
				Restaurante.informacionCupones("Cupón del 30%","Este cupón aplica un 30% al precio total. "
						+ "\nSe requiere un mínimo de 350 puntos para canjearlo" );
			}
		});
		
		btnC5 = new JButton();
		ImageIcon cupon5 = new ImageIcon("imagenes\\35.gif");
		lblC5 = new JLabel("CUPÓN DEL 35%");
		btnC5.setIcon(cupon5);
		btnC5.setLayout(new BorderLayout());
		btnC5.setPreferredSize(new Dimension(cupon1.getIconWidth(), cupon1.getIconHeight()));	
		btnC5.setPreferredSize(new Dimension(150,350));
		lblC5.setHorizontalAlignment(SwingConstants.LEFT);
		lblC5.setVerticalAlignment(SwingConstants.TOP);
		btnC5.setBackground(buttonBackgroundColor);
		btnC5.setBorderPainted(false);
		lblC5.setForeground(Color.WHITE); 
		lblC5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnC5.add(lblC5, BorderLayout.CENTER);
		btnC5.setMargin(margenBotones);
		pProductos.add(btnC5);
		btnC5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CUPÓN DEL 35%");
				Restaurante.informacionCupones("Cupón del 35%","Este cupón aplica un 35% al precio total. "
						+ "\nSe requiere un mínimo de 550 puntos para canjearlo" );
			}
		});
		
		btnC6 = new JButton();
		ImageIcon cupon6 = new ImageIcon("imagenes\\40.gif");
		lblC6 = new JLabel("CUPÓN DEL 40%");
		btnC6.setIcon(cupon6);
		btnC6.setLayout(new BorderLayout());
		btnC6.setPreferredSize(new Dimension(cupon1.getIconWidth(), cupon1.getIconHeight()));	
		btnC6.setPreferredSize(new Dimension(150,350));
		lblC6.setHorizontalAlignment(SwingConstants.LEFT);
		lblC6.setVerticalAlignment(SwingConstants.TOP);
		btnC6.setBackground(buttonBackgroundColor);
		btnC6.setBorderPainted(false);
		lblC6.setForeground(Color.WHITE); 
		lblC6.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnC6.add(lblC6, BorderLayout.CENTER);
		btnC6.setMargin(margenBotones);
		pProductos.add(btnC6);
		btnC6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CUPÓN DEL 40%");
				Restaurante.informacionCupones("Cupón del 40%","Este cupón aplica un 40% al precio total. "
						+ "\nSe requiere un mínimo de 690 puntos para canjearlo" );
			}
		});
		
		btnC7 = new JButton();
		ImageIcon cupon7 = new ImageIcon("imagenes\\50.gif");
		lblC7 = new JLabel("CUPÓN DEL 50%");
		btnC7.setIcon(cupon7);
		btnC7.setLayout(new BorderLayout());
		btnC7.setPreferredSize(new Dimension(cupon1.getIconWidth(), cupon1.getIconHeight()));	
		btnC7.setPreferredSize(new Dimension(150,350));
		lblC7.setHorizontalAlignment(SwingConstants.LEFT);
		lblC7.setVerticalAlignment(SwingConstants.TOP);
		btnC7.setBackground(buttonBackgroundColor);
		btnC7.setBorderPainted(false);
		lblC7.setForeground(Color.WHITE); 
		lblC7.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnC7.add(lblC7, BorderLayout.CENTER);
		btnC7.setMargin(margenBotones);
		pProductos.add(btnC7);
		btnC7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CUPÓN DEL 50%");
				Restaurante.informacionCupones("Cupón del 50%","Este cupón aplica un 50% al precio total. "
						+ "\nSe requiere un mínimo de 800 puntos para canjearlo" );
			}
		});
		
		btnC8 = new JButton();
		ImageIcon cupon8 = new ImageIcon("imagenes\\70.gif");
		lblC8 = new JLabel("CUPÓN DEL 70%");
		btnC8.setIcon(cupon8);
		btnC8.setLayout(new BorderLayout());
		btnC8.setPreferredSize(new Dimension(cupon1.getIconWidth(), cupon1.getIconHeight()));	
		btnC8.setPreferredSize(new Dimension(150,350));
		lblC8.setHorizontalAlignment(SwingConstants.LEFT);
		lblC8.setVerticalAlignment(SwingConstants.TOP);
		btnC8.setBackground(buttonBackgroundColor);
		btnC8.setBorderPainted(false);
		lblC8.setForeground(Color.WHITE); 
		lblC8.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnC8.add(lblC8, BorderLayout.CENTER);
		btnC8.setMargin(margenBotones);
		pProductos.add(btnC8);
		btnC8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON CUPÓN DEL 70%");
				Restaurante.informacionCupones("Cupón del 70%","Este cupón aplica un 70% al precio total. "
						+ "\nSe requiere un mínimo de 1000 puntos para canjearlo" );
			}
		});
		
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
