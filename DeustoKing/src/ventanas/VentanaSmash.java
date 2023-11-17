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

public class VentanaSmash extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnS1, btnS2, btnS3, btnS4, btnVolver;
	private JLabel lblS1, lblS2, lblS3, lblS4;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	
	public VentanaSmash(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("Smash Burger");
		setBounds(-10, 0, 1800, 900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pContenedor = new JPanel();
		pContenedor.setLayout(new BorderLayout());
        
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        
        pTitulo = new JPanel();
        pTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        lblTitulo = new JLabel("SMASH BURGERS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnS1 = new JButton();
		ImageIcon imNachos = new ImageIcon("src\\imagenes\\s1.jpg");
		lblS1 = new JLabel("SMASHHHH");
		btnS1.setIcon(imNachos);
		btnS1.setLayout(new BorderLayout());
		btnS1.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnS1.setPreferredSize(new Dimension(150,350));
		lblS1.setHorizontalAlignment(SwingConstants.LEFT);
		lblS1.setVerticalAlignment(SwingConstants.TOP);
		lblS1.setForeground(Color.WHITE); 
		lblS1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnS1.add(lblS1, BorderLayout.CENTER);
		btnS1.setMargin(margenBotones);
		pProductos.add(btnS1);
		
		btnS2 = new JButton();
		ImageIcon imAros = new ImageIcon("src\\imagenes\\smash1.jpg");
		lblS2 = new JLabel("DON KING");
		btnS2.setIcon(imAros);
		btnS2.setLayout(new BorderLayout());
		btnS2.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnS2.setPreferredSize(new Dimension(150,350));
		lblS2.setHorizontalAlignment(SwingConstants.LEFT);
		lblS2.setVerticalAlignment(SwingConstants.TOP);
		lblS2.setForeground(Color.WHITE); 
		lblS2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnS2.add(lblS2, BorderLayout.CENTER);
		btnS2.setMargin(margenBotones);
		pProductos.add(btnS2);
		
		btnS3 = new JButton();
		ImageIcon imTequeños = new ImageIcon("src\\imagenes\\s3.png");
		lblS3 = new JLabel("CIELO");
		btnS3.setIcon(imTequeños);
		btnS3.setLayout(new BorderLayout());
		btnS3.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnS3.setPreferredSize(new Dimension(150,350));
		lblS3.setHorizontalAlignment(SwingConstants.LEFT);
		lblS3.setVerticalAlignment(SwingConstants.TOP);
		lblS3.setForeground(Color.WHITE); 
		lblS3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnS3.add(lblS3, BorderLayout.CENTER);
		btnS3.setMargin(margenBotones);
		pProductos.add(btnS3);
		
		btnS4 = new JButton();
		ImageIcon imAlitas = new ImageIcon("src\\imagenes\\s4.jpg");
		lblS4 = new JLabel("SANWING");
		btnS4.setIcon(imAlitas);
		btnS4.setLayout(new BorderLayout());
		btnS4.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnS4.setPreferredSize(new Dimension(150,350));
		lblS4.setHorizontalAlignment(SwingConstants.LEFT);
		lblS4.setVerticalAlignment(SwingConstants.TOP);
		lblS4.setForeground(Color.WHITE); 
		lblS4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnS4.add(lblS4, BorderLayout.CENTER);
		btnS4.setMargin(margenBotones);
		pProductos.add(btnS4);
		
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
