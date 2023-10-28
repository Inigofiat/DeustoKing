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

public class VentanaEntrantes extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnNachos, btnArosCebolla, btnTequeños, btnAlitas, btnVolver;
	private JLabel lblNachos, lblArosCebolla, lblTequeños, lblAlitas;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	
	public VentanaEntrantes() {
		super();
		vActual=this;
		
		setTitle("Entrantes");
		setBounds(-10, 0, 1800, 900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pContenedor = new JPanel();
		pContenedor.setLayout(new BorderLayout());
        
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        
        pTitulo = new JPanel();
        pTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        lblTitulo = new JLabel("ENTRANTES");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnNachos = new JButton();
		ImageIcon imNachos = new ImageIcon("src\\imagenes\\nachos.jpeg");
		lblNachos = new JLabel("NACHOS");
		btnNachos.setIcon(imNachos);
		btnNachos.setLayout(new BorderLayout());
		btnNachos.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnNachos.setPreferredSize(new Dimension(150,350));
		lblNachos.setHorizontalAlignment(SwingConstants.LEFT);
		lblNachos.setVerticalAlignment(SwingConstants.TOP);
		lblNachos.setForeground(Color.WHITE); 
		lblNachos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnNachos.add(lblNachos, BorderLayout.CENTER);
		btnNachos.setMargin(margenBotones);
		pProductos.add(btnNachos);
		
		btnArosCebolla = new JButton();
		ImageIcon imAros = new ImageIcon("src\\imagenes\\aros.jpg");
		lblArosCebolla = new JLabel("AROS DE CEBOLLA");
		btnArosCebolla.setIcon(imAros);
		btnArosCebolla.setLayout(new BorderLayout());
		btnArosCebolla.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnArosCebolla.setPreferredSize(new Dimension(150,350));
		lblArosCebolla.setHorizontalAlignment(SwingConstants.LEFT);
		lblArosCebolla.setVerticalAlignment(SwingConstants.TOP);
		lblArosCebolla.setForeground(Color.WHITE); 
		lblArosCebolla.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnArosCebolla.add(lblArosCebolla, BorderLayout.CENTER);
		btnArosCebolla.setMargin(margenBotones);
		pProductos.add(btnArosCebolla);
		
		btnTequeños = new JButton();
		ImageIcon imTequeños = new ImageIcon("src\\imagenes\\tequeños.jpg");
		lblTequeños = new JLabel("TEQUEÑOS");
		btnTequeños.setIcon(imTequeños);
		btnTequeños.setLayout(new BorderLayout());
		btnTequeños.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnTequeños.setPreferredSize(new Dimension(150,350));
		lblTequeños.setHorizontalAlignment(SwingConstants.LEFT);
		lblTequeños.setVerticalAlignment(SwingConstants.TOP);
		lblTequeños.setForeground(Color.WHITE); 
		lblTequeños.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnTequeños.add(lblTequeños, BorderLayout.CENTER);
		btnTequeños.setMargin(margenBotones);
		pProductos.add(btnTequeños);
		
		btnAlitas = new JButton();
		ImageIcon imAlitas = new ImageIcon("src\\imagenes\\alitas.jpg");
		lblAlitas = new JLabel("ALITAS");
		btnAlitas.setIcon(imAlitas);
		btnAlitas.setLayout(new BorderLayout());
		btnAlitas.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnAlitas.setPreferredSize(new Dimension(150,350));
		lblAlitas.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlitas.setVerticalAlignment(SwingConstants.TOP);
		lblAlitas.setForeground(Color.WHITE); 
		lblAlitas.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnAlitas.add(lblAlitas, BorderLayout.CENTER);
		btnAlitas.setMargin(margenBotones);
		pProductos.add(btnAlitas);
		
		pVolver = new JPanel();
		pVolver.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnVolver = new JButton("VOLVER A LA CARTA");	
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setPreferredSize(new Dimension(150,30));
		btnVolver.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnVolver.setMargin(new Insets(10, 10, 10, 10));
		btnVolver.setBorderPainted(true);
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
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaEntrantes();
            }
        });
    }
}
