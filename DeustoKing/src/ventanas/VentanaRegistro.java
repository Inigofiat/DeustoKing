package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import deustoking.Cliente;
import deustoking.Persona;
import deustoking.Restaurante;

public class VentanaRegistro extends JFrame{
	

	private JPanel pSur, pPrincipal, pEste, pOeste;
	private JLabel lblNombre, lblApellido, lblTlf, lblDireccion, lblEmail, lblNombreUsuario, lblContrasenia, lblRepetirContrasenia, lblRegistro, lblInicioSesion;
	private JTextField txtNombre, txtApellido, txtTlf, txtDireccion, txtEmail, txtNombreUsuario;
	private JPasswordField txtContrasenia, txtRepetirContrasenia;
	private JButton btnRegistro, btnAtras, btnInicioSesion;
	private JScrollPane scroll;
	private static final String nomfichClientes = "ficheros/Clientes.csv";
	private JFrame vActual, vAnterior;
	static Logger logger = Logger.getLogger(Main.class.getName());

	
	public VentanaRegistro(JFrame va) {

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

		pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());

		pOeste = new JPanel();
		pOeste.setLayout(new BoxLayout(pOeste, BoxLayout.Y_AXIS));

		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBorder(new EmptyBorder(0, 0, 10, 20)); 
		lblNombre.setFont(new Font("Tw", Font.BOLD, 14));
		txtNombre = new JTextField(20);
		
		pOeste.add(lblNombre);
		pOeste.add(txtNombre);
		pOeste.add(Box.createVerticalStrut(30));

		lblApellido = new JLabel("APELLIDO:");
		lblApellido.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblApellido.setFont(new Font("Tw", Font.BOLD, 14));
		txtApellido = new JTextField(20);

		pOeste.add(lblApellido);
		pOeste.add(txtApellido);
		pOeste.add(Box.createVerticalStrut(30));
	
		lblTlf = new JLabel("TELÉFONO:");
		lblTlf.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblTlf.setFont(new Font("Tw", Font.BOLD, 14));
		txtTlf = new JTextField(20);
	
		pOeste.add(lblTlf);
		pOeste.add(txtTlf);
		pOeste.add(Box.createVerticalStrut(30));
	
		lblDireccion = new JLabel("DIRECCIÓN:");
		lblDireccion.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblDireccion.setFont(new Font("Tw", Font.BOLD, 14));
		txtDireccion = new JTextField(20);
	
		pOeste.add(lblDireccion);
		pOeste.add(txtDireccion);
		pOeste.add(Box.createVerticalStrut(30));
	
		lblEmail = new JLabel("EMAIL:");
		lblEmail.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblEmail.setFont(new Font("Tw", Font.BOLD, 14));
		txtEmail = new JTextField();
	
		pOeste.add(lblEmail);
		pOeste.add(txtEmail);
		pOeste.add(Box.createVerticalStrut(30));
	
		lblNombreUsuario = new JLabel("NOMBRE DE USUARIO:");
		lblNombreUsuario.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblNombreUsuario.setFont(new Font("Tw", Font.BOLD, 14));
		txtNombreUsuario = new JTextField(20);
		pOeste.add(lblNombreUsuario);
		pOeste.add(txtNombreUsuario);
		pOeste.add(Box.createVerticalStrut(30));
	
		lblContrasenia = new JLabel("  CONTRASEÑA: ");
		lblContrasenia.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblContrasenia.setFont(new Font("Tw", Font.BOLD, 14));
		txtContrasenia = new JPasswordField(20);
		
		pOeste.add(lblContrasenia);
		pOeste.add(txtContrasenia);
		pOeste.add(Box.createVerticalStrut(30));
	
		lblRepetirContrasenia = new JLabel("  REPITE LA CONTRASEÑA: ");
		lblRepetirContrasenia.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblRepetirContrasenia.setFont(new Font("Tw", Font.BOLD, 14));
		txtRepetirContrasenia = new JPasswordField(20);

		pOeste.add(lblRepetirContrasenia);
		pOeste.add(txtRepetirContrasenia);
		pOeste.add(Box.createVerticalStrut(30));
	
		txtNombre.setColumns(40);
		txtApellido.setColumns(40);
		txtTlf.setColumns(40);
	 	txtDireccion.setColumns(40);
	   	txtEmail.setColumns(40);
	   	txtNombreUsuario.setColumns(40);
	   	txtContrasenia.setColumns(40);
		txtRepetirContrasenia.setColumns(40);
	
		pEste = new JPanel();
		pEste.setLayout(new BoxLayout(pEste, BoxLayout.Y_AXIS));
		lblInicioSesion = new JLabel("¿Ya tienes cuenta? Inicia sesión aquí");
		lblInicioSesion.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblInicioSesion.setFont(new Font("Tw", Font.BOLD, 14));
		btnInicioSesion = new JButton("                    INICIA SESIÓN                    ");
	
		pEste.add(lblInicioSesion);
		pEste.add(btnInicioSesion);
		pEste.add(Box.createVerticalStrut(30));
	
		pSur = new JPanel();
		pSur.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnAtras = new JButton("VOLVER");
		pSur.add(btnAtras);
		
		btnRegistro = new JButton("REGISTRO");
		pSur.add(btnRegistro);
	
		int espacioEntrePaneles1 = 150; 
	    pOeste.setBorder(new EmptyBorder(espacioEntrePaneles1, 300, espacioEntrePaneles1, espacioEntrePaneles1 ));
	    
	    int espacioEntrePaneles2 = 350; 
	    pEste.setBorder(new EmptyBorder(espacioEntrePaneles2, espacioEntrePaneles2, espacioEntrePaneles2, espacioEntrePaneles2 ));
		
		pPrincipal.add(pEste, BorderLayout.EAST);
		pPrincipal.add(pOeste, BorderLayout.WEST);
		pPrincipal.add(pSur, BorderLayout.SOUTH);
		
		getContentPane().add(pPrincipal);
		scroll = new JScrollPane();
 	
		btnAtras.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			new VentanaPrincipal(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});
		
		btnInicioSesion.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON INICIO SESIÓN");
			vActual.dispose();
			vActual.setVisible(false);
			new VentanaInicioSesion(vActual);
		});

		
		btnRegistro.addActionListener((e) -> {
			String nombre = txtNombre.getText();
			String apellido = txtApellido.getText();
			String telefono = txtTlf.getText();
			String direccion = txtDireccion.getText();
			String correo = txtEmail.getText();
			String nombreUsuario = txtNombreUsuario.getText();
			String contrasenia = new String(txtContrasenia.getPassword());
			
			if (Restaurante.registroCliente(nomfichClientes, nombre, apellido, telefono, direccion, correo, Persona.getContador(), 75, nombreUsuario, contrasenia,vActual)
					) {
				JOptionPane.showMessageDialog(vActual, "Registro realizado correctamente", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
				logger.log(Level.INFO, "SE HA REALIZADO EL REGISTRO");
				
			} else {
				//JOptionPane.showMessageDialog(vActual, "El usuario ya está registrado", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);

			}
		});	
		Restaurante.miIcono(this, "imagenes/CORONA.png");
		setVisible(true);
	}
}
