package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class VentanaRegistro extends JFrame{
	

private JPanel pSur, pPrincipal, pEste, pOeste;
private JLabel lblNombre, lblApellido, lblTlf, lblDireccion, lblEmail, lblNombreUsuario, lblContraseña, lblRepetirContraseña, lblRegistro, lblInicioSesion;
private JTextField txtNombre, txtApellido, txtTlf, txtDireccion, txtEmail, txtNombreUsuario;
private JPasswordField txtContraseña, txtRepetirContraseña;
private JButton btnRegistro, btnAtras, btnInicioSesion;
private JScrollPane scroll;
private static final String nomfichClientes = "Clientes.csv";



	public VentanaRegistro() {

	super();
	setVisible(true);
	setBounds(-10, 0, 1600, 823);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

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

	lblContraseña = new JLabel("  CONTRASEÑA: ");
	lblContraseña.setBorder(new EmptyBorder(0, 0, 10, 20));
	lblContraseña.setFont(new Font("Tw", Font.BOLD, 14));
	txtContraseña = new JPasswordField(20);
	
	pOeste.add(lblContraseña);
	pOeste.add(txtContraseña);
	pOeste.add(Box.createVerticalStrut(30));

	lblRepetirContraseña = new JLabel("  REPITE LA CONTRASEÑA: ");
	lblRepetirContraseña.setBorder(new EmptyBorder(0, 0, 10, 20));
	lblRepetirContraseña.setFont(new Font("Tw", Font.BOLD, 14));
	txtRepetirContraseña = new JPasswordField(20);

	pOeste.add(lblRepetirContraseña);
	pOeste.add(txtRepetirContraseña);
	pOeste.add(Box.createVerticalStrut(30));

	txtNombre.setColumns(40);
	txtApellido.setColumns(40);
	txtTlf.setColumns(40);
 	txtDireccion.setColumns(40);
   	txtEmail.setColumns(40);
   	txtNombreUsuario.setColumns(40);
   	txtContraseña.setColumns(40);
	txtRepetirContraseña.setColumns(40);

	pEste = new JPanel();
	pEste.setLayout(new BoxLayout(pEste, BoxLayout.Y_AXIS));
	lblInicioSesion = new JLabel("¿Ya tienes cuenta? Inicia sesion aqui");
	lblInicioSesion.setBorder(new EmptyBorder(0, 0, 10, 20));
	lblInicioSesion.setFont(new Font("Tw", Font.BOLD, 14));
	btnInicioSesion = new JButton("                    INCIA SESION                    ");

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
		VentanaPrincipal vpl = new VentanaPrincipal();
		vpl.setVisible(true);
	});
	
	btnInicioSesion.addActionListener((e) -> {
		VentanaInicioSesion vis = new VentanaInicioSesion();
		vis.setVisible(true);
	});

	}
	

	public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new VentanaRegistro();
	            }
	        });
	    }
}
