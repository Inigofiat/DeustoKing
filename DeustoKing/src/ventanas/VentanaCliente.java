package ventanas;

import java.awt.BorderLayout;
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

import deustoking.Cliente;

public class VentanaCliente extends JFrame{
	private JPanel pNorte, pCentro;
	private JSlider sliderPts;
	private JLabel lblSaludo, lblCupon1, lblCupon2, lblCupon3, lblCupon4;
	private Cliente cliente;
	private int puntosCliente;
	
	public VentanaCliente() {
		this.cliente = cliente;
		this.puntosCliente = 0;
	
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setBounds(200, 100, 1100, 700);
		
		pNorte = new JPanel();
		pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(2,2));
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		

		lblSaludo = new JLabel("Hola, " + cliente.getIdCliente()+ cliente.getNombreC() + cliente.getApellidosC());
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
		
		lblCupon1.addMouseListener(new JLabelMouseListener("Información del Cupón 1"));
        lblCupon2.addMouseListener(new JLabelMouseListener("Información del Cupón 2"));
        lblCupon3.addMouseListener(new JLabelMouseListener("Información del Cupón 3"));
        lblCupon4.addMouseListener(new JLabelMouseListener("Información del Cupón 4"));

		
		setVisible(true);
	}
	
	private class JLabelMouseListener implements MouseListener{
		private String info;
		
		public JLabelMouseListener(String informacion) {
            this.info = info;
            
        }

		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			 JOptionPane.showMessageDialog(null, info, "Información del Cupón", JOptionPane.INFORMATION_MESSAGE);
        
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			
		}
		// Método para comprar un producto y actualizar los puntos del cliente
	    private void comprarProducto(int puntosGanados) {
	        puntosCliente += puntosGanados;
	        sliderPts.setValue(puntosCliente);
	    }
	    
		
	}

	

}
