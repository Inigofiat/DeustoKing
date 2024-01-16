package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import deustoking.Ciudad;
import deustoking.Cliente;
import deustoking.Producto;
import deustoking.Restaurante;
import deustoking.TipoProducto;

@SuppressWarnings("serial")
public class VentanaCliente extends JFrame{
	private JPanel pNorte;
	private static JPanel pCentro;
	private JPanel pDerecha;
	private JPanel pPrincipal;
	private JPanel pContenedor, pSur;
	private JSlider sliderPts;
	private JLabel lblSaludo, lbPuntos, lbTiempo;
	private Cliente cliente;
	private JFrame vActual;
	static Logger logger = Logger.getLogger(Main.class.getName());
	private JMenuBar menu;
	private JMenu menuReserva, menuCarta, menuPerfil, menuCupon, menuHora, menuCarro;
	private JMenuItem itCarta, itMisCupones, itCupones, itReserva, itMiperfil, itMisReservas, itCarro;
	PanelImagen imagenPanel;
	private JButton btnCerrarSesion;
	
	public VentanaCliente(JFrame va) {
		vActual = this;
		this.cliente = VentanaInicioSesion.getCliente();
		System.out.println("Tienes "+cliente.getPuntosAcumulados()+" puntos");
		new ArrayList<>();
	
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        
        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vActual.dispose();
				
			}
		});
		
		pNorte = new JPanel();
		pCentro = new JPanel();
		pDerecha=new JPanel();
		pContenedor = new JPanel();
		pContenedor.setLayout(new BorderLayout());
		pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());
		pSur=new JPanel();
		pSur.add(btnCerrarSesion);
		
		lbTiempo = new JLabel();
        lbTiempo.setFont(new Font("Arial", Font.PLAIN, 24));
        lbTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        pDerecha.add(lbTiempo);
     
          // Obtener la hora actual
         
	        Timer timer = new Timer();
	        timer.scheduleAtFixedRate(new TimerTask() {
	            @Override
	            public void run() {
	                mostrarTiempo();
	            }
	        }, 0, 1000);
	
		
        pCentro.setLayout(new GridLayout(0, 3));
        obtenerExtra();
		

		lblSaludo = new JLabel("Hola, "+cliente.getNombreUsuario());
		sliderPts = new JSlider(0, 1000, 0);
		sliderPts.setValue(cliente.getPuntosAcumulados());
		sliderPts.setMajorTickSpacing(200);
		sliderPts.setPaintLabels(true);
		sliderPts.setPaintTicks(true);
		sliderPts.setEnabled(false);
		lbPuntos = new JLabel("Tienes " + sliderPts.getValue() + " puntos");
		sliderPts.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbPuntos.setText("Tienes " + sliderPts.getValue() + " puntos");
            }
        });
		
				
		pNorte.add(lblSaludo);
		pNorte.add(sliderPts);
		pNorte.add(lbPuntos);
		

		menu = new JMenuBar();
		menuCarta = new JMenu();
		ImageIcon iconoC = new ImageIcon("imagenes/carta.png");
	    Image imagenEscaladaC = iconoC.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	    iconoC = new ImageIcon(imagenEscaladaC);
	    menuCarta.setIcon(iconoC);
		itCarta = new JMenuItem("Elija su ciudad");
		itCarta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<Ciudad> ciudadComboBox = new JComboBox<>(Ciudad.values());
                ciudadComboBox.setSelectedItem(null); 

                Object[] message = {
                        "Ciudad:", ciudadComboBox
                };

                int option = JOptionPane.showOptionDialog(null, message, null,
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    Ciudad ciudadSeleccionada = (Ciudad) ciudadComboBox.getSelectedItem();
                    if (ciudadSeleccionada != null) {
                        switch (ciudadSeleccionada) {
                            case BILBO:
                                new VentanaCarta(vActual, "BILBO");
                                break;
                            case DONOSTI:
                            	new VentanaCarta(vActual, "DONOSTI");
                                break;
                            case GASTEIZ:
                            	new VentanaCarta(vActual, "GASTEIZ");
                            	break;
                           
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione una ciudad válida", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
			}
				
			}
		});
		menuCarta.add(itCarta);

		
		menuCupon = new JMenu();
		ImageIcon iconoCu = new ImageIcon("imagenes/cupon.png");
	    Image imagenEscaladaCu = iconoCu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	    iconoCu = new ImageIcon(imagenEscaladaCu);
	    menuCupon.setIcon(iconoCu);
		itMisCupones = new JMenuItem("Mis cupones");
		itCupones=new JMenuItem("Cupones");
		itCupones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaCupones(vActual);
				vActual.dispose();
				
			}
		});
		itMisCupones = new JMenuItem("Mis cupones");
		itMisCupones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMisCupones(vActual);
				
			}
		});
		menuCupon.add(itMisCupones);
		menuCupon.add(itCupones);
		
		
		menuReserva = new JMenu();
		ImageIcon iconoR = new ImageIcon("imagenes/reserva.jpg");
	    Image imagenEscaladaR = iconoR.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	    iconoR = new ImageIcon(imagenEscaladaR);
	    menuReserva.setIcon(iconoR);
		itReserva= new JMenuItem("Realizar reserva");
		itReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaReserva(vActual);
				vActual.setVisible(false);
				vActual.dispose();
				
			}
		});
		itMisReservas = new JMenuItem("Mis reservas");
		itMisReservas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMisReservas(vActual);
				vActual.dispose();
				
			}
		});
		menuReserva.add(itReserva);
		menuReserva.add(itMisReservas);
		
		menuPerfil = new JMenu();
		ImageIcon iconoP = new ImageIcon("imagenes/perfil.png");
	    Image imagenEscaladaP = iconoP.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	    iconoP = new ImageIcon(imagenEscaladaP);
	    menuPerfil.setIcon(iconoP);
		itMiperfil = new JMenuItem("Mi perfil");
		itMiperfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPerfil(vActual);
				vActual.setVisible(false);
				vActual.dispose();
				
			}
		});
		menuPerfil.add(itMiperfil);
		
		menuHora=new JMenu();
		menuHora.setText(obtenerHoraActual());
		menuHora.setFont(new Font("Arial", Font.PLAIN, 18));
	    menuCarro = new JMenu();
	    ImageIcon icono = new ImageIcon("imagenes/carro.png");
	    Image imagenEscalada = icono.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	    icono = new ImageIcon(imagenEscalada);
	    menuCarro.setIcon(icono);
	    menuCarro.setFont(new Font("Tw", Font.BOLD, 12));
	    menuCarro.setForeground(new Color(0,0,0));
	    itCarro = new JMenuItem("Cesta");
	    itCarro.setFont(new Font("Tw", Font.PLAIN, 12));
	    itCarro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaTablaProductos(vActual);
				vActual.dispose();
				
			}
		});
	    menuCarro.add(itCarro);
		
		menu.add(menuPerfil);
		menu.add(new JMenu("|")).setEnabled(false);
	    menu.add(menuReserva);
	    menu.add(new JMenu("|")).setEnabled(false);
	    menu.add(menuCarta);
	    menu.add(new JMenu("|")).setEnabled(false);
	    menu.add(menuCupon);
	    menu.add(new JMenu("|")).setEnabled(false);
	    menu.add(menuCarro);
	    menu.add(Box.createHorizontalGlue());
	    menu.add(menuHora);
	    setJMenuBar(menu);
		
	    pCentro.setBorder(new EmptyBorder(50, 50, 50, 50));
		pCentro.setOpaque(false);
		pNorte.setOpaque(false);
        Restaurante.miIcono(this, "imagenes/CORONA.png");
        pContenedor.add(pNorte, BorderLayout.NORTH);
        pContenedor.add(pCentro, BorderLayout.CENTER);
        pContenedor.add(pSur, BorderLayout.SOUTH);
        pPrincipal.add(pContenedor, BorderLayout.CENTER);
        setContentPane(pPrincipal);
		setVisible(true);
		
	}
	
	private void mostrarTiempo() {
        SwingUtilities.invokeLater(() -> {
            menuHora.setText(obtenerHoraActual());
        });
    }

    private String obtenerHoraActual() {
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return horaActual.format(formatter);
    }
    
    private static void obtenerExtra() {
    	pCentro.removeAll();
    	for(Producto p: Restaurante.getListaProductosFichero()) {
    		System.out.println(p);
			if( p.getTipoProducto().equals(TipoProducto.EXTRA)) {
				System.out.println(p);
				crearBoton("imagenes/"+p.getImagen(), p.getNombre(), dividirDescripcionPorPalabras(p.getDescripcion()), p.getPrecio());
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
			pCentro.add(boton);
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


