package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

import deustoking.Cliente;

public class VentanaPerfil extends JFrame {

    private JPanel pCentro, pPrincipal, pContenedor, pSur;
    private JLabel lbNombre, nombre, lbApellidos, apellidos, lbTelefono, telefono, lbCorreo, correo, lbDireccion,
            direccion, lbNombreUsuario, nombreUsuario, lbContrasenia;
    private JPasswordField contrasenia;
    private JCheckBox mostrarContrasenia;
    private JFrame vActual, vAnterior;
    private JButton btnVolver;
    private Cliente cliente;

    public VentanaPerfil(JFrame va) {
        vActual = this;
        vAnterior = va;
        this.cliente = VentanaInicioSesion.getCliente();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);

        pCentro = new JPanel();
        pCentro.setLayout(new GridLayout(8, 2, 5, 5)); 

        pPrincipal = new JPanel();
        pPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 400));

        pContenedor = new JPanel();
        pContenedor.setLayout(new BorderLayout());
        
        pSur = new JPanel();
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vActual.dispose();
				vAnterior.setVisible(true);
				
			}
		});
        pSur.add(btnVolver);

        lbNombre = new JLabel("Nombre:");
        lbNombre.setFont(new Font("Tw", Font.BOLD, 14));
        nombre = new JLabel();
        nombre.setText(cliente.getNombre());
        nombre.setFont(new Font("Tw", Font.PLAIN, 14));

        lbApellidos = new JLabel("Apellidos:");
        lbApellidos.setFont(new Font("Tw", Font.BOLD, 14));
        apellidos = new JLabel();
        apellidos.setText(cliente.getApellidos());
        apellidos.setFont(new Font("Tw", Font.PLAIN, 14));

        lbTelefono = new JLabel("Teléfono:");
        lbTelefono.setFont(new Font("Tw", Font.BOLD, 14));
        telefono = new JLabel();
        telefono.setText(cliente.getTelefono());
        telefono.setFont(new Font("Tw", Font.PLAIN, 14));

        lbCorreo = new JLabel("Email:");
        lbCorreo.setFont(new Font("Tw", Font.BOLD, 14));
        correo = new JLabel();
        correo.setText(cliente.getCorreo());
        correo.setFont(new Font("Tw", Font.PLAIN, 14));

        lbDireccion = new JLabel("Dirección:");
        lbDireccion.setFont(new Font("Tw", Font.BOLD, 14));
        direccion = new JLabel();
        direccion.setText(cliente.getDireccion());
        direccion.setFont(new Font("Tw", Font.PLAIN, 14));

        lbNombreUsuario = new JLabel("Nombre de usuario:");
        lbNombreUsuario.setFont(new Font("Tw", Font.BOLD, 14));
        nombreUsuario = new JLabel();
        nombreUsuario.setText(cliente.getNombreUsuario());
        nombreUsuario.setFont(new Font("Tw", Font.PLAIN, 14));

        lbContrasenia = new JLabel("Contraseña:");
        lbContrasenia.setFont(new Font("Tw", Font.BOLD, 14));
        contrasenia = new JPasswordField();
        contrasenia.setText(cliente.getContrasenia());
        contrasenia.setEditable(false); 
        contrasenia.setFont(new Font("Tw", Font.PLAIN, 14));

        mostrarContrasenia = new JCheckBox("Mostrar contraseña");
        mostrarContrasenia.setFont(new Font("Tw", Font.PLAIN, 14));
        mostrarContrasenia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mostrarContrasenia.isSelected()) {
                    contrasenia.setEchoChar((char) 0); 
                } else {
                    contrasenia.setEchoChar('*'); 
                }
            }
        });

        pCentro.add(lbNombre);
        pCentro.add(nombre);
        pCentro.add(lbApellidos);
        pCentro.add(apellidos);
        pCentro.add(lbTelefono);
        pCentro.add(telefono);
        pCentro.add(lbCorreo);
        pCentro.add(correo);
        pCentro.add(lbDireccion);
        pCentro.add(direccion);
        pCentro.add(lbNombreUsuario);
        pCentro.add(nombreUsuario);
        pCentro.add(lbContrasenia);
        pCentro.add(contrasenia);
        pCentro.add(mostrarContrasenia);

        pContenedor.add(pCentro, BorderLayout.CENTER);
        pContenedor.add(pSur, BorderLayout.SOUTH);

        pPrincipal.add(pContenedor, BorderLayout.CENTER);

        getContentPane().add(pPrincipal);
        setVisible(true);
    }

}


