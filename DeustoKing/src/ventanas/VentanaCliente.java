package ventanas;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

import deustoking.Cliente;
import deustoking.Restaurante;

public class VentanaCliente extends JFrame{
	private JPanel pNorte, pCentro;
	private JSlider sliderPts;
	private JLabel lblSaludo, lblCupon1, lblCupon2, lblCupon3, lblCupon4;
	private Cliente cliente;
	private int puntosCliente;
	
	public VentanaCliente(Cliente cliente) {
		this.cliente = cliente;
		this.puntosCliente = 0;
	
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
		pCentro.setLayout(new GridLayout(2,2));
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		

		lblSaludo = new JLabel("Hola, " + cliente.getId()+ cliente.getNombre() + cliente.getApellidos());
		sliderPts = new JSlider(0, 1000, 0);
		lblCupon1 = new JLabel("CUPÓN 1");
		lblCupon2 = new JLabel("CUPÓN 2");
		lblCupon3 = new JLabel("CUPÓN 3");
		lblCupon4 = new JLabel("CUPÓN 4");
		
		pNorte.add(lblSaludo);
		pNorte.add(sliderPts);
		pCentro.add(lblCupon1);
		pCentro.add(lblCupon2);
		pCentro.add(lblCupon3);
		pCentro.add(lblCupon4);
		

        Restaurante.miIcono(this, "/imagenes/CORONA.png");
		setVisible(true);
	}
	
     public void actualizarPuntosCliente(int puntosGanados) {
        puntosCliente += puntosGanados;
        sliderPts.setValue(puntosCliente);
     }
	
	 public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	    	Cliente cliente = new Cliente();
	        // Crea una instancia de VentanaCliente
	        VentanaCliente ventanaCliente = new VentanaCliente(cliente);
	    });
	 }
	 

}
