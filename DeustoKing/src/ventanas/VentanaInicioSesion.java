package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import deustoking.Ciudad;
import deustoking.Cliente;
import deustoking.Restaurante;

public class VentanaInicioSesion extends JFrame {
	private JPanel pSur, pEste, pOeste, pFoto, pPrincipal;
	private JLabel lblNombreUsuario, lblContraseña, lblRegistro, lblFoto;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContraseña;
	private JButton btnRegistro, btnAtras, btnInicioSesion;
	private JScrollPane scroll;
	private static final String nomfichClientes = "ficheros/Clientes.csv";
	private JFrame vActual, vAnterior;
	private static Cliente cli;
	static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static Cliente getCliente() {
		return cli;
	}
	

	public VentanaInicioSesion(JFrame va) {
		
		super();
		vActual = this;
		vAnterior = va;

        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panelContenedor = new JPanel();
		panelContenedor.setLayout(new BorderLayout());
		
		pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());
		
		pOeste = new JPanel();
		pOeste.setLayout(new BoxLayout(pOeste, BoxLayout.Y_AXIS));
		
		lblNombreUsuario = new JLabel("USUARIO, EMAIL O TELÉFONO:");
		lblNombreUsuario.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblNombreUsuario.setFont(new Font("Tw", Font.BOLD, 14));
		txtNombreUsuario = new JTextField(20);
		pOeste.add(lblNombreUsuario);
		pOeste.add(txtNombreUsuario);
		pOeste.add(Box.createVerticalStrut(30));
		
		
		lblContraseña = new JLabel("  CONTRASEÑA: ");
		lblContraseña.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblContraseña.setFont(new Font("Tw", Font.BOLD, 14));
		txtContraseña = new JPasswordField(20);
		
		pOeste.add(lblContraseña);
		pOeste.add(txtContraseña);
		pOeste.add(Box.createVerticalStrut(30));
		
		txtNombreUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtContraseña.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		
		txtNombreUsuario.setColumns(40);
		txtContraseña.setColumns(40);
		    
		pEste = new JPanel();
		pEste.setLayout(new BoxLayout(pEste, BoxLayout.Y_AXIS));
		lblRegistro = new JLabel("¿No tienes cuenta? Regístrate aquí");
		lblRegistro.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblRegistro.setFont(new Font("Tw", Font.BOLD, 14));
		btnRegistro = new JButton("                    REGÍSTRATE                   ");
		
		pEste.add(lblRegistro);
		pEste.add(btnRegistro);
		pEste.add(Box.createVerticalStrut(30));
		
		
		pSur = new JPanel();
		pSur.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnAtras = new JButton("VOLVER");
		pSur.add(btnAtras);
		
		btnInicioSesion = new JButton("INICIO DE SESIÓN");
		pSur.add(btnInicioSesion);
		pOeste.setBorder(new EmptyBorder(200, 200, 200, 200 ));
		pEste.setBorder(new EmptyBorder(200, 200, 200, 200 ));
		    
		pFoto = new JPanel();
		pFoto.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon imagenIcon = new ImageIcon("imagenes\\logo.png");
		Image imagen = imagenIcon.getImage();
		Image imagenRedimensionada = imagen.getScaledInstance(200, 200, Image.SCALE_SMOOTH); 
		ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);
		lblFoto = new JLabel(imagenRedimensionadaIcon);    
		pFoto.add(lblFoto);
		   
		panelContenedor.add(pEste, BorderLayout.EAST);
		panelContenedor.add(pOeste, BorderLayout.WEST);
		panelContenedor.add(pSur, BorderLayout.SOUTH);
		panelContenedor.add(pFoto, BorderLayout.NORTH);
		
		pPrincipal.add(panelContenedor, BorderLayout.CENTER);
		getContentPane().add(pPrincipal);

		
		btnAtras.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON VOLVER");
			vActual.dispose();
			vAnterior.setVisible(true);

		});

		btnRegistro.addActionListener((e) -> {
			logger.log(Level.INFO, "SE ESTA ABRIENDO LA VENTANA REGISTRO");
			new VentanaRegistro(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});
		
		Restaurante.cargarClientesEnLista(nomfichClientes);

		btnInicioSesion.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA HECHO CLICK EN EL BOTON INCIO DE SESIÓN");
			
			String corrTlfUsu = txtNombreUsuario.getText();
			char[] contChar = txtContraseña.getPassword();
			String contrasenia = new String(contChar);
		
			if(corrTlfUsu.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Inserte el teléfono, el mail o el nombre de usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else if(contrasenia.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Inserte la contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else {
				Cliente cliente = Restaurante.buscarUsuario(corrTlfUsu);
				if(cliente==null || (!corrTlfUsu.equals(cliente.getCorreo()) && !corrTlfUsu.equals(cliente.getTelefono()) && !corrTlfUsu.equals(cliente.getNombreUsuario()))) {
					JOptionPane.showMessageDialog(null, "Nombre de usuario, correo electrónico o teléfono no válido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					if(!contrasenia.equals(cliente.getContrasenia())) {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "¡BIENVENIDO! "+ cliente.getNombreUsuario().toUpperCase(), "SESIÓN INICIADA", JOptionPane.INFORMATION_MESSAGE);
						cli=cliente;
						txtNombreUsuario.setText("");
						txtContraseña.setText("");
						JComboBox<Ciudad> ciudadComboBox = new JComboBox<>(Ciudad.values());
		                ciudadComboBox.setSelectedItem(null); 
	
		                Object[] message = {
		                        "Nombre y Apellidos:", cliente.getNombre() + " " + cliente.getApellidos(),
		                        "Teléfono:", cliente.getTelefono(),
		                        "Email:", cliente.getCorreo(),
		                        "Ciudad:", ciudadComboBox
		                };
	
		                int option = JOptionPane.showOptionDialog(null, message, "Datos del Usuario",
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
		}
		
		}

	});
		
		Restaurante.miIcono(this, "imagenes/CORONA.png");
		
		setVisible(true);
	
	}
	
}
	
	