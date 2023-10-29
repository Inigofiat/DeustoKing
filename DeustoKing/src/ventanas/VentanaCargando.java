package ventanas;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class VentanaCargando extends JFrame {
	
	private JProgressBar bProgreso;
	private JLabel lbImgPri;
	private JFrame vActual;

	
	public VentanaCargando() {
		vActual=this;
		setBounds(-10, 0, 1800, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cargando");
		
		lbImgPri = new JLabel(new ImageIcon("src\\imagenes\\DEUSTOKING.png"));
		lbImgPri.setLayout(new BorderLayout());
		
		bProgreso = new JProgressBar(0,100);
		bProgreso.setStringPainted(true); 
		bProgreso.setForeground(new Color(239,184,16));
		
		bProgreso.setUI(new BasicProgressBarUI() {
             protected Color getSelectionBackground() {
                 return new Color(0,0,0); 
             }
             
             protected Color getSelectionForeground() {
                 return new Color(0,0,0);
             }
         });
		
		lbImgPri.add(bProgreso, BorderLayout.SOUTH);
		getContentPane().setBackground(new Color(218,218,218));
		getContentPane().add(lbImgPri);
		
		Thread hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					for (int i = 0; i < 101; i++) {
						Thread.sleep(60); 
						bProgreso.setValue(i);
					}
				}catch(InterruptedException ie) {
					JOptionPane.showMessageDialog(null, "Error al cargar la ventana", "Error", JOptionPane.ERROR_MESSAGE);
				}
				dispose();
				new VentanaPrincipal();
				vActual.setVisible(false);
			}
		});hilo.start();
		setVisible(true);
	}
}
