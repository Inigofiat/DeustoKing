package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
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

import deustoking.Restaurante;

public class VentanaPostres extends JFrame {
	
	private JPanel pTitulo, pProductos, pPrincipal, pVolver, pContenedor;
	private JButton btnTartaQueso, btnTartaLotus, btnHelado, btnBatido, btnVolver;
	private JLabel lblTartaQueso, lblTataLotus, lblHelado, lblBatido;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	
	public VentanaPostres(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		setTitle("Postres");
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
        
        lblTitulo = new JLabel("POSTRES");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
		pProductos.setLayout(new GridLayout(0, 2, 0 ,10));
		Insets margenBotones = new Insets(50, 50, 50, 50);
		
		btnTartaQueso = new JButton();
		ImageIcon imNachos = new ImageIcon("src\\imagenes\\cheesecake.jpg");
		lblTartaQueso = new JLabel("CHEESECAKE");
		btnTartaQueso.setIcon(imNachos);
		btnTartaQueso.setLayout(new BorderLayout());
		btnTartaQueso.setPreferredSize(new Dimension(imNachos.getIconWidth(), imNachos.getIconHeight()));	
		btnTartaQueso.setPreferredSize(new Dimension(150,350));
		lblTartaQueso.setHorizontalAlignment(SwingConstants.LEFT);
		lblTartaQueso.setVerticalAlignment(SwingConstants.TOP);
		lblTartaQueso.setForeground(Color.WHITE); 
		lblTartaQueso.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnTartaQueso.add(lblTartaQueso, BorderLayout.CENTER);
		btnTartaQueso.setMargin(margenBotones);
		pProductos.add(btnTartaQueso);
		
		btnTartaLotus = new JButton();
		ImageIcon imAros = new ImageIcon("src\\imagenes\\lotuscake.jpg");
		lblTataLotus = new JLabel("LOTUSCAKE");
		btnTartaLotus.setIcon(imAros);
		btnTartaLotus.setLayout(new BorderLayout());
		btnTartaLotus.setPreferredSize(new Dimension(imAros.getIconWidth(), imAros.getIconHeight()));	
		btnTartaLotus.setPreferredSize(new Dimension(150,350));
		lblTataLotus.setHorizontalAlignment(SwingConstants.LEFT);
		lblTataLotus.setVerticalAlignment(SwingConstants.TOP);
		lblTataLotus.setForeground(Color.WHITE); 
		lblTataLotus.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnTartaLotus.add(lblTataLotus, BorderLayout.CENTER);
		btnTartaLotus.setMargin(margenBotones);
		pProductos.add(btnTartaLotus);
		
		btnHelado = new JButton();
		ImageIcon imTequeños = new ImageIcon("src\\imagenes\\helado.jpg");
		lblHelado = new JLabel("FROZEN DEUSTOKING");
		btnHelado.setIcon(imTequeños);
		btnHelado.setLayout(new BorderLayout());
		btnHelado.setPreferredSize(new Dimension(imTequeños.getIconWidth(), imTequeños.getIconHeight()));	
		btnHelado.setPreferredSize(new Dimension(150,350));
		lblHelado.setHorizontalAlignment(SwingConstants.LEFT);
		lblHelado.setVerticalAlignment(SwingConstants.TOP);
		lblHelado.setForeground(Color.WHITE); 
		lblHelado.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnHelado.add(lblHelado, BorderLayout.CENTER);
		btnHelado.setMargin(margenBotones);
		pProductos.add(btnHelado);
		
		btnBatido = new JButton();
		ImageIcon imAlitas = new ImageIcon("src\\imagenes\\batido.jpg");
		lblBatido = new JLabel("DEUSHAKE");
		btnBatido.setIcon(imAlitas);
		btnBatido.setLayout(new BorderLayout());
		btnBatido.setPreferredSize(new Dimension(imAlitas.getIconWidth(), imAlitas.getIconHeight()));	
		btnBatido.setPreferredSize(new Dimension(150,350));
		lblBatido.setHorizontalAlignment(SwingConstants.LEFT);
		lblBatido.setVerticalAlignment(SwingConstants.TOP);
		lblBatido.setForeground(Color.WHITE); 
		lblBatido.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		btnBatido.add(lblBatido, BorderLayout.CENTER);
		btnBatido.setMargin(margenBotones);
		pProductos.add(btnBatido);
		
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
	    
	    Restaurante.miIcono(this, "/imagenes/CORONA.png");
	    
	    setVisible(true);
	}
}
