package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import deustoking.Ciudad;
import deustoking.Cliente;
import deustoking.Cupon;
import deustoking.Restaurante;

public class VentanaCliente extends JFrame{
	private JPanel pNorte, pCentro, pDerecha, pPrincipal, pContenedor;
	private JSlider sliderPts;
	private JLabel lblSaludo, lblCupon1, lblCupon2, lblCupon3, lblCupon4, lbPuntos, lbTiempo;
	private Cliente cliente;
	private JFrame vActual, vAnterior;
	private ArrayList<Cupon> cupones;
	static Logger logger = Logger.getLogger(Main.class.getName());
	private JMenuBar menu;
	private JScrollPane barra;
	private JMenu menuReserva, menuCarta, menuPerfil, menuCupon, menuHora;
	private JMenuItem itCarta, itMisCupones, itCupones, itReserva, itMiperfil, itMisReservas;
	PanelImagen imagenPanel;
	
	public VentanaCliente(JFrame va) {
		vActual = this;
		vAnterior = va;
		this.cliente = VentanaInicioSesion.getCliente();
		System.out.println("Tienes "+cliente.getPuntosAcumulados()+" puntos");
		cupones = new ArrayList<>();
	
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
		
		pNorte = new JPanel();
		pCentro = new JPanel();
		pDerecha=new JPanel();
		pCentro.setLayout(new GridLayout(2,2));
		
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
	
		
        pCentro.setLayout(new GridLayout(0, 2, 10, 30));
		

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
	
		
		menu.add(menuPerfil);
		menu.add(new JMenu("|")).setEnabled(false);
	    menu.add(menuReserva);
	    menu.add(new JMenu("|")).setEnabled(false);
	    menu.add(menuCarta);
	    menu.add(new JMenu("|")).setEnabled(false);
	    menu.add(menuCupon);
	    menu.add(Box.createHorizontalGlue());
	    menu.add(menuHora);
	    setJMenuBar(menu);
		
		pCentro.setOpaque(false);
		pNorte.setOpaque(false);
        Restaurante.miIcono(this, "imagenes/CORONA.png");
        setContentPane(pCentro);
		setVisible(true);
		
		barra = new JScrollPane(pPrincipal);
        barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        getContentPane().add(barra, BorderLayout.CENTER);
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
	

}


