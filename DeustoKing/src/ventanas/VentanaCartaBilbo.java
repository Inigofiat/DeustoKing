package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Paint;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaCartaBilbo extends JFrame {
	
	private JPanel pBotones, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnEntrantesNorte, btnEnsaladaNorte, 
	btnHamburguesasNorte, btnPostresNorte, btnBebidasNorte, btnInfantilNorte, btnOtrosNorte, btnSmashNorte, btnMenuNorte, btnAlergenosNorte,
	btnEntrantesCentro, btnEnsaladaCentro, btnHamburguesasCentro, btnPostresCentro, btnBebidasCentro, btnInfantilCentro, btnOtrosCentro, 
	btnSmashCentro, btnMenuCentro, btnAlergenosCentro, btnVolver;
	private JLabel lblEntrantesCentro, lblEnsaladaCentro, lblHamburguesasCentro, lblPostresCentro, lblBebidasCentro, lblInfantilCentro, 
	lblOtrosCentro, lblSmashCentro, lblMenuCentro, lblAlergenosCentro;
	private JScrollPane barra;
	private JFrame vActual, vAnterior;
	
	public VentanaCartaBilbo(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("Carta");
		setBounds(-10, 0, 1800, 900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pContenedor = new JPanel();
		pContenedor.setLayout(new BorderLayout());
        
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        
        pBotones = new JPanel();
        pBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        btnEntrantesNorte = new JButton("ENTRANTES");
        btnEntrantesNorte.setBackground(Color.LIGHT_GRAY);
        btnEntrantesNorte.setPreferredSize(new Dimension(120,30));
        btnEntrantesNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
        btnEntrantesNorte.setMargin(new Insets(10, 10, 10, 10));
        btnEntrantesNorte.setBorderPainted(false);
		pBotones.add(btnEntrantesNorte);
		btnEntrantesNorte.addActionListener((e)->{
			VentanaEntrantes v = new VentanaEntrantes();
			v.setVisible(true);
		});
		
		btnEnsaladaNorte = new JButton("ENSALADAS");
		btnEnsaladaNorte.setBackground(Color.LIGHT_GRAY);
		btnEnsaladaNorte.setPreferredSize(new Dimension(120,30));
		btnEnsaladaNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnEnsaladaNorte.setMargin(new Insets(10, 10, 10, 10));
		btnEnsaladaNorte.setBorderPainted(false);
		pBotones.add(btnEnsaladaNorte);
		btnEnsaladaNorte.addActionListener((e)->{
			VentanaEnsaladas v = new VentanaEnsaladas();
			v.setVisible(true);
		});
		
		btnHamburguesasNorte = new JButton("HAMBURGUESAS");
		btnHamburguesasNorte.setBackground(Color.LIGHT_GRAY);
		btnHamburguesasNorte.setPreferredSize(new Dimension(140,30));
		btnHamburguesasNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnHamburguesasNorte.setMargin(new Insets(10, 10, 10, 10));
		btnHamburguesasNorte.setBorderPainted(false);
		pBotones.add(btnHamburguesasNorte);
		btnHamburguesasNorte.addActionListener((e)->{
			VentanaHamburguesasBilbo v = new VentanaHamburguesasBilbo();
			v.setVisible(true);
		});
		
		btnPostresNorte = new JButton("POSTRES");
		btnPostresNorte.setBackground(Color.LIGHT_GRAY);
		btnPostresNorte.setPreferredSize(new Dimension(120,30));
		btnPostresNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnPostresNorte.setMargin(new Insets(10, 10, 10, 10));
		btnPostresNorte.setBorderPainted(false);
		pBotones.add(btnPostresNorte);
		btnPostresNorte.addActionListener((e)->{
			VentanaPostres v = new VentanaPostres();
			v.setVisible(true);
		});
		
		btnBebidasNorte = new JButton("BEBIDAS");
		btnBebidasNorte.setBackground(Color.LIGHT_GRAY);
		btnBebidasNorte.setPreferredSize(new Dimension(120,30));
		btnBebidasNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnBebidasNorte.setMargin(new Insets(10, 10, 10, 10));
		btnBebidasNorte.setBorderPainted(false);
		pBotones.add(btnBebidasNorte);
		btnBebidasNorte.addActionListener((e)->{
			VentanaBebidas v = new VentanaBebidas();
			v.setVisible(true);
		});
		
		btnInfantilNorte = new JButton("INFANTIL");
		btnInfantilNorte.setBackground(Color.LIGHT_GRAY);
		btnInfantilNorte.setPreferredSize(new Dimension(120,30));
		btnInfantilNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnInfantilNorte.setMargin(new Insets(10, 10, 10, 10));
		btnInfantilNorte.setBorderPainted(false);
		pBotones.add(btnInfantilNorte);
		btnInfantilNorte.addActionListener((e)->{
			VentanaInfantil v = new VentanaInfantil();
			v.setVisible(true);
		});
		
		
		btnOtrosNorte = new JButton("OTROS");
		btnOtrosNorte.setBackground(Color.LIGHT_GRAY);
		btnOtrosNorte.setPreferredSize(new Dimension(120,30));
		btnOtrosNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnOtrosNorte.setMargin(new Insets(10, 10, 10, 10));
		btnOtrosNorte.setBorderPainted(false);
		pBotones.add(btnOtrosNorte);
		btnOtrosNorte.addActionListener((e)->{
			VentanaOtros v = new VentanaOtros();
			v.setVisible(true);
		});
		
		
		btnSmashNorte = new JButton("SMASH");
		btnSmashNorte.setBackground(Color.LIGHT_GRAY);
		btnSmashNorte.setPreferredSize(new Dimension(120,30));
		btnSmashNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnSmashNorte.setMargin(new Insets(10, 10, 10, 10));
		btnSmashNorte.setBorderPainted(false);
		pBotones.add(btnSmashNorte);
		btnSmashNorte.addActionListener((e)->{
			VentanaSmash v = new VentanaSmash();
			v.setVisible(true);
		});
		
		btnMenuNorte = new JButton("MENÚ DEUSTOKING");
		btnMenuNorte.setBackground(Color.LIGHT_GRAY);
		btnMenuNorte.setPreferredSize(new Dimension(150,30));
		btnMenuNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnMenuNorte.setMargin(new Insets(10, 10, 10, 10));
		btnMenuNorte.setBorderPainted(false);
		pBotones.add(btnMenuNorte);
		btnMenuNorte.addActionListener((e)->{
			VentanaMenuBilbo v = new VentanaMenuBilbo();
			v.setVisible(true);
		});
		
		btnAlergenosNorte = new JButton("ALÉRGENOS");
		btnAlergenosNorte.setBackground(Color.LIGHT_GRAY);
		btnAlergenosNorte.setPreferredSize(new Dimension(120,30));
		btnAlergenosNorte.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnAlergenosNorte.setMargin(new Insets(10, 10, 10, 10));
		btnAlergenosNorte.setBorderPainted(false);
		pBotones.add(btnAlergenosNorte);
		
		pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		

		
		btnEntrantesCentro = new JButton();
		ImageIcon imEntrante = new ImageIcon("src\\imagenes\\aroscebolla.jpg");
		lblEntrantesCentro = new JLabel("ENTRANTES");
		btnEntrantesCentro.setIcon(imEntrante);
		btnEntrantesCentro.setLayout(new BorderLayout());
		btnEntrantesCentro.setPreferredSize(new Dimension(imEntrante.getIconWidth(), imEntrante.getIconHeight()));	
		btnEntrantesCentro.setPreferredSize(new Dimension(150,400));
		lblEntrantesCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblEntrantesCentro.setVerticalAlignment(SwingConstants.TOP);
		lblEntrantesCentro.setForeground(Color.WHITE); 
		lblEntrantesCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnEntrantesCentro.add(lblEntrantesCentro, BorderLayout.CENTER);
		btnEntrantesCentro.setMargin(margenBotones);
		pProductos.add(btnEntrantesCentro);
		btnEntrantesCentro.addActionListener((e)->{
			VentanaEntrantes v = new VentanaEntrantes();
			v.setVisible(true);
		});
		
		
		
		btnEnsaladaCentro = new JButton();
		ImageIcon imEnsaldas = new ImageIcon("src\\imagenes\\ensalada.jpg");
		lblEnsaladaCentro= new JLabel("ENSALADAS");
		btnEnsaladaCentro.setIcon(imEnsaldas);
		btnEnsaladaCentro.setLayout(new BorderLayout());
		btnEnsaladaCentro.setPreferredSize(new Dimension(imEnsaldas.getIconWidth(), imEnsaldas.getIconHeight()));	
		btnEnsaladaCentro.setPreferredSize(new Dimension(150,400));
		lblEnsaladaCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnsaladaCentro.setVerticalAlignment(SwingConstants.TOP);
		lblEnsaladaCentro.setForeground(Color.WHITE); 
		lblEnsaladaCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnEnsaladaCentro.add(lblEnsaladaCentro, BorderLayout.CENTER);
		btnEnsaladaCentro.setMargin(margenBotones);
		pProductos.add(btnEnsaladaCentro);
		btnEnsaladaCentro.addActionListener((e)->{
			VentanaEnsaladas v = new VentanaEnsaladas();
			v.setVisible(true);
		});
		
		
		btnHamburguesasCentro = new JButton();
		ImageIcon imHamburguesas = new ImageIcon("src\\imagenes\\hambur.png");
		lblHamburguesasCentro = new JLabel("HAMBURGUESAS");
		btnHamburguesasCentro.setIcon(imHamburguesas);
		btnHamburguesasCentro.setLayout(new BorderLayout());
		btnHamburguesasCentro.setPreferredSize(new Dimension(imHamburguesas.getIconWidth(), imHamburguesas.getIconHeight()));	
		btnHamburguesasCentro.setPreferredSize(new Dimension(150,400));
		lblHamburguesasCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblHamburguesasCentro.setVerticalAlignment(SwingConstants.TOP);
		lblHamburguesasCentro.setForeground(Color.WHITE); 
		lblHamburguesasCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnHamburguesasCentro.add(lblHamburguesasCentro, BorderLayout.CENTER);
		btnHamburguesasCentro.setMargin(margenBotones);
		pProductos.add(btnHamburguesasCentro);
		btnHamburguesasCentro.addActionListener((e)->{
			VentanaHamburguesasBilbo v = new VentanaHamburguesasBilbo();
			v.setVisible(true);
		});
		
		
		btnPostresCentro = new JButton();
		ImageIcon imPostres = new ImageIcon("src\\imagenes\\postre.jpg");
		lblPostresCentro= new JLabel("POSTRES");
		btnPostresCentro.setIcon(imPostres);
		btnPostresCentro.setLayout(new BorderLayout());
		btnPostresCentro.setPreferredSize(new Dimension(imPostres.getIconWidth(), imPostres.getIconHeight()));	
		btnPostresCentro.setPreferredSize(new Dimension(150,400));
		lblPostresCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblPostresCentro.setVerticalAlignment(SwingConstants.TOP);
		lblPostresCentro.setForeground(Color.WHITE); 
		lblPostresCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		btnPostresCentro.add(lblPostresCentro, BorderLayout.CENTER);
		btnPostresCentro.setMargin(margenBotones);
		pProductos.add(btnPostresCentro);
		btnPostresCentro.addActionListener((e)->{
			VentanaPostres v = new VentanaPostres();
			v.setVisible(true);
		});
		
		btnBebidasCentro = new JButton();
		ImageIcon imBebidas = new ImageIcon("src\\imagenes\\bebida.jpg");
		lblBebidasCentro= new JLabel("BEBIDAS");
		btnBebidasCentro.setIcon(imBebidas);
		btnBebidasCentro.setLayout(new BorderLayout());
		btnBebidasCentro.setPreferredSize(new Dimension(imBebidas.getIconWidth(), imBebidas.getIconHeight()));	
		btnBebidasCentro.setPreferredSize(new Dimension(150,400));
		lblBebidasCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBebidasCentro.setVerticalAlignment(SwingConstants.TOP);
		lblBebidasCentro.setForeground(Color.WHITE);
		lblBebidasCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		btnBebidasCentro.add(lblBebidasCentro, BorderLayout.CENTER);
		btnBebidasCentro.setMargin(margenBotones);
		pProductos.add(btnBebidasCentro);
		btnBebidasCentro.addActionListener((e)->{
			VentanaBebidas v = new VentanaBebidas();
			v.setVisible(true);
		});
		
		btnInfantilCentro = new JButton();
		ImageIcon imInfantil = new ImageIcon("src\\imagenes\\infantil.jpg");
		lblInfantilCentro= new JLabel("INFANTIL");
		btnInfantilCentro.setIcon(imInfantil);
		btnInfantilCentro.setLayout(new BorderLayout());
		btnInfantilCentro.setPreferredSize(new Dimension(imInfantil.getIconWidth(), imInfantil.getIconHeight()));	
		btnInfantilCentro.setPreferredSize(new Dimension(150,400));
		lblInfantilCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfantilCentro.setVerticalAlignment(SwingConstants.TOP);
		lblInfantilCentro.setForeground(Color.WHITE); // Color del texto
		lblInfantilCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		btnInfantilCentro.add(lblInfantilCentro, BorderLayout.CENTER);
		btnInfantilCentro.setMargin(margenBotones);
		pProductos.add(btnInfantilCentro);
		btnInfantilCentro.addActionListener((e)->{
			VentanaInfantil v = new VentanaInfantil();
			v.setVisible(true);
		});
		
		btnOtrosCentro = new JButton();
		ImageIcon imOtros = new ImageIcon("src\\imagenes\\otros.jpg");
		lblOtrosCentro= new JLabel("OTROS");
		btnOtrosCentro.setIcon(imOtros);
		btnOtrosCentro.setLayout(new BorderLayout());
		btnOtrosCentro.setPreferredSize(new Dimension(imOtros.getIconWidth(), imOtros.getIconHeight()));	
		btnOtrosCentro.setPreferredSize(new Dimension(150,400));
		lblOtrosCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblOtrosCentro.setVerticalAlignment(SwingConstants.TOP);
		lblOtrosCentro.setForeground(Color.WHITE); 
		lblOtrosCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		btnOtrosCentro.add(lblOtrosCentro, BorderLayout.CENTER);
		btnEntrantesCentro.setMargin(margenBotones);
		pProductos.add(btnOtrosCentro);
		btnOtrosCentro.addActionListener((e)->{
			VentanaOtros v = new VentanaOtros();
			v.setVisible(true);
		});
		
		btnSmashCentro = new JButton();
		ImageIcon imSmash = new ImageIcon("src\\imagenes\\smash.jpg");
		lblSmashCentro= new JLabel("SMASH");
		btnSmashCentro.setIcon(imSmash);
		btnSmashCentro.setLayout(new BorderLayout());
		btnSmashCentro.setPreferredSize(new Dimension(imSmash.getIconWidth(), imSmash.getIconHeight()));	
		btnSmashCentro.setPreferredSize(new Dimension(150,400));
		lblSmashCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblSmashCentro.setVerticalAlignment(SwingConstants.TOP);
		lblSmashCentro.setForeground(Color.WHITE); 
		lblSmashCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		btnSmashCentro.add(lblSmashCentro, BorderLayout.CENTER);
		btnSmashCentro.setMargin(margenBotones);
		pProductos.add(btnSmashCentro);
		btnSmashCentro.addActionListener((e)->{
			VentanaSmash v = new VentanaSmash();
			v.setVisible(true);
		});
		
		btnMenuCentro = new JButton();
		ImageIcon imMenu = new ImageIcon("src\\imagenes\\menu.png");
		lblMenuCentro= new JLabel("MENÚ DEUSTOKING");
		btnMenuCentro.setIcon(imMenu);
		btnMenuCentro.setLayout(new BorderLayout());
		btnMenuCentro.setPreferredSize(new Dimension(imMenu.getIconWidth(), imMenu.getIconHeight()));	
		btnMenuCentro.setPreferredSize(new Dimension(150,400));
		lblMenuCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenuCentro.setVerticalAlignment(SwingConstants.TOP);
		lblMenuCentro.setForeground(Color.WHITE); 
		lblMenuCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		btnMenuCentro.add(lblMenuCentro, BorderLayout.CENTER);
		btnMenuCentro.setMargin(margenBotones);
		pProductos.add(btnMenuCentro);
		btnMenuCentro.addActionListener((e)->{
			VentanaMenuBilbo v = new VentanaMenuBilbo();
			v.setVisible(true);
		});
		
		btnAlergenosCentro = new JButton();
		ImageIcon imAlergenos = new ImageIcon("src\\imagenes\\alergenos.jpg");
		lblAlergenosCentro= new JLabel("ALÉRGENOS");
		btnAlergenosCentro.setIcon(imAlergenos);
		btnAlergenosCentro.setLayout(new BorderLayout());
		btnAlergenosCentro.setPreferredSize(new Dimension(imAlergenos.getIconWidth(), imAlergenos.getIconHeight()));	
		btnAlergenosCentro.setPreferredSize(new Dimension(150,400));
		lblAlergenosCentro.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlergenosCentro.setVerticalAlignment(SwingConstants.TOP);
		lblAlergenosCentro.setForeground(Color.WHITE); 
		lblAlergenosCentro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		btnAlergenosCentro.add(lblAlergenosCentro, BorderLayout.CENTER);
		btnAlergenosCentro.setMargin(margenBotones);
		pProductos.add(btnAlergenosCentro);
		
		pVolver = new JPanel();
		pVolver.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnVolver = new JButton("VOLVER");	
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setPreferredSize(new Dimension(120,30));
		btnVolver.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnVolver.setMargin(new Insets(10, 10, 10, 10));
		btnVolver.setBorderPainted(true);
		btnVolver.addActionListener((e)->{
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		pVolver.add(btnVolver);
		
		
		
		GridLayout productosLayout = new GridLayout(0,2,0,30);
		productosLayout.setHgap(30); 
		pProductos.setLayout(productosLayout);
		
		FlowLayout botonesLayout = new FlowLayout(FlowLayout.CENTER);
	    botonesLayout.setHgap(3); 
	    pBotones.setLayout(botonesLayout);
	    
	    FlowLayout botonVolverLayout = new FlowLayout(FlowLayout.CENTER);
	    botonVolverLayout.setHgap(3); 
	    pVolver.setLayout(botonVolverLayout);
	    
	    int espacioEntrePaneles1 = 100; 
	    pProductos.setBorder(new EmptyBorder(espacioEntrePaneles1, espacioEntrePaneles1, espacioEntrePaneles1, espacioEntrePaneles1 ));
	    
	    
	    pContenedor.add(pBotones, BorderLayout.NORTH);
	    pContenedor.add(pProductos, BorderLayout.CENTER);
	    pContenedor.add(pVolver, BorderLayout.SOUTH);
	    pPrincipal.add(pContenedor,BorderLayout.CENTER);
	    
	   
	    getContentPane().add(pPrincipal);
	    
	    barra = new JScrollPane(pPrincipal);
	    barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    getContentPane().add(barra);
	    
	    setVisible(true);
	    
		
	}

}