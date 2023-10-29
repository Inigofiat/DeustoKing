package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

public class VentanaInicioSesion extends JFrame {
	private JPanel pSur, pEste, pOeste, pFoto, pPrincipal;
	private JLabel lblNombreUsuario, lblContraseña, lblRegistro, lblFoto;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContraseña;
	private JButton btnRegistro, btnAtras, btnInicioSesion;
	private JScrollPane scroll;
	private static final String nomfichClientes = "Clientes.csv";
	private JFrame vActual, vAnterior;
	

	public VentanaInicioSesion(JFrame va) {
		
		super();
		vActual = this;
		vAnterior = va;

		setBounds(-10, 0, 1600, 823);
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
		lblRegistro = new JLabel("¿No tienes cuenta? Registrate aqui");
		lblRegistro.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblRegistro.setFont(new Font("Tw", Font.BOLD, 14));
		btnRegistro = new JButton("                    REGISTRATE                   ");
		
		pEste.add(lblRegistro);
		pEste.add(btnRegistro);
		pEste.add(Box.createVerticalStrut(30));
		
		
		pSur = new JPanel();
		pSur.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnAtras = new JButton("VOLVER");
		pSur.add(btnAtras);
		
		btnInicioSesion = new JButton("INICIO DE SESION");
		pSur.add(btnInicioSesion);
		pOeste.setBorder(new EmptyBorder(200, 200, 200, 200 ));
		pEste.setBorder(new EmptyBorder(200, 200, 200, 200 ));
		
		/*pPrincipal.add(pEste, BorderLayout.EAST);
		pPrincipal.add(pOeste, BorderLayout.WEST);
		pPrincipal.add(pSur, BorderLayout.SOUTH);
		
		getContentPane().add(pPrincipal);
		scroll = new JScrollPane();
		
		pPrincipal.add(panelContenedor, BorderLayout.CENTER);
		getContentPane().add(pPrincipal);*/
		    
		pFoto = new JPanel();
		pFoto.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon imagenIcon = new ImageIcon("src\\imagenes\\logo.png");
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
			vActual.dispose();
			vAnterior.setVisible(true);

		});

		btnRegistro.addActionListener((e) -> {
			new VentanaRegistro(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});

		btnInicioSesion.addActionListener((e)-> {
		String nombreUsuario = txtNombreUsuario.getText();
		String contrasenia = txtContraseña.getText();
		Cliente cliente = buscarCliente(nombreUsuario);
		if(cliente == null) {
			JOptionPane.showMessageDialog(null, "Para poder iniciar sesión tienes que estar registrado","ERROR",JOptionPane.ERROR_MESSAGE);
			}else {
					if(cliente.getContrasenia().equals(contrasenia)) {
						JOptionPane.showMessageDialog(null, "Bienvenido!","SESIÓN INICIADA",JOptionPane.INFORMATION_MESSAGE);
						vAnterior.setVisible(true);
						vActual.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta","ERROR",JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		
		setVisible(true);

	}

	public static Cliente buscarCliente(String nombreUsuario) {
		boolean encontrado = false;
		int posicion = 0;
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = null;
			while(!encontrado && posicion<clientes.size()) {
				cliente = clientes.get(posicion);
				if(cliente.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
				}else {
					posicion++;
				}
		}
		if(encontrado) {
			return cliente;
		}else {
			return null;
		}	
	}
}
	
	