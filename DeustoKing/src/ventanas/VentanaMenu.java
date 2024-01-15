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
import javax.swing.JCheckBox;
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

import deustoking.Producto;
import deustoking.Restaurante;
import deustoking.TipoProducto;

public class VentanaMenu extends JFrame {
	
	private JPanel pTitulo;
	private static JPanel pProductos;
	private JPanel pPrincipal;
	private JPanel pVolver;
	private JPanel pContenedor;
	private JButton btnM1, btnM2, btnM3, btnM4, btnVolver;
	private JLabel lblM1, lblM2, lblM3, lblM4;
	private JScrollPane barra; 
	private JLabel lblTitulo;
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());
	private JMenuBar menu;
	private JMenu menuDesplegable;
	private JMenuItem itCompra;
	private static String ciudad;

	
	public VentanaMenu(JFrame va, String lbNombre, String imagen, String nombre) {
		super();
		ciudad=nombre;
		vActual=this;
		vAnterior=va;
		setTitle("MENÚ");
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
        
        lblTitulo = new JLabel(lbNombre);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.TOP);
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
        
        pProductos = new JPanel();
        obtenerMenu();
        
		
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
				logger.log(Level.INFO, "SE HA HECHO CLICK EN LA CESTA");
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
	    barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    getContentPane().add(barra);
	    
	    Restaurante.miIcono(this, "imagenes/CORONA.png");
	    setVisible(true);
	}
	
	private static void obtenerMenu() {
		System.out.println("CARGANDO LOS MENUS");
		pProductos.removeAll();
		for(Producto p: Restaurante.getListaProductosFichero()) {
			if( p.getTipoProducto().equals(TipoProducto.MENU) && p.getNombre().toLowerCase().contains(ciudad.toLowerCase())) {				
				for(Producto pr: p.getListaProductos()) {
					crearBoton("imagenes/"+pr.getImagen(), pr.getNombre(),dividirDescripcionPorPalabras(pr.getDescripcion()), pr.getPrecio());
				}
			}
		}
	}
	
	private static JButton crearBoton(String foto, String nombreProducto, String descripcion, float precio) {
		JButton boton = new JButton();
		ImageIcon imagen = new ImageIcon(foto);
		JLabel etiqueta = new JLabel(nombreProducto);
		Insets margenBotones = new Insets(10, 10, 10, 10);
		boton.setIcon(imagen);
	    boton.setLayout(new BorderLayout());
	    boton.setPreferredSize(new Dimension(imagen.getIconWidth(), imagen.getIconHeight()));
	    boton.setPreferredSize(new Dimension(150, 350));
	    etiqueta.setHorizontalAlignment(SwingConstants.LEFT);
	    etiqueta.setVerticalAlignment(SwingConstants.TOP);
	    etiqueta.setForeground(Color.WHITE);
	    etiqueta.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
	    boton.add(etiqueta, BorderLayout.CENTER);
	    boton.setMargin(margenBotones);
	    boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Restaurante.informacionProductos(nombreProducto, descripcion, precio);
				
			}
		});
	    
	    try {
			pProductos.add(boton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return boton;

	}
	
	
	
	private static String dividirDescripcionPorPalabras(String descripcion) {
	    StringBuilder descripcionFormateada = new StringBuilder();
	    int palabrasPorLinea = 18;
	    int contadorPalabras = 0;

	    String[] palabras = descripcion.split("\\s+");

	    for (String palabra : palabras) {
	        descripcionFormateada.append(palabra).append(" ");
	        contadorPalabras++;

	        if (contadorPalabras % palabrasPorLinea == 0) {
	            descripcionFormateada.append("\n");
	        }
	    }

	    return descripcionFormateada.toString().trim(); 
	}
	
}
