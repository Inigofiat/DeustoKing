package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class VentanaHamburguesas extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnH1, btnH2, btnH3, btnH4, btnVolver;
	private JLabel lblH1, lblH2, lblH3, lblH4;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	
	public VentanaHamburguesas(JFrame va, String nombre, String imagen) {
		super();
		vActual=this;
		vAnterior = va;
		setTitle("Hamburguesas");
		setBounds(-10, 0, 1800, 900);
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
		ImageIcon imNachos = new ImageIcon("src\\imagenes\\diablo.jpg");
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
		
		btnH2 = new JButton();
		ImageIcon imAros = new ImageIcon("src\\imagenes\\pulledpork.jpg");
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
		
		btnH3 = new JButton();
		ImageIcon imTequeños = new ImageIcon("src\\imagenes\\baking.jpg");
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
		
		pVolver = new JPanel();
		pVolver.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnVolver = new JButton("VOLVER A LA CARTA");	
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setPreferredSize(new Dimension(150,30));
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
	    
	    setVisible(true);
	}
	
}
