package ventanas;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicProgressBarUI;

import deustoking.Restaurante;

@SuppressWarnings("serial")
public class VentanaCargando extends JFrame {
	
	private JProgressBar bProgreso;
	private JLabel lbImgPri;
	private JFrame vActual;
	
	public static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaCargando() {
		super();
		vActual=this;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cargando");
        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
		
		lbImgPri = new JLabel(new ImageIcon("imagenes\\DEUSTOKING.png"));
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
						final int progressValue = i;
						Thread.sleep(35); 
						
						SwingUtilities.invokeLater(new Runnable() {
		                    @Override
		                    public void run() {
		                        bProgreso.setValue(progressValue);
		                    }
		                });
					}
				}catch(InterruptedException ie) {
					logger.log(Level.WARNING, "SE HA INTERRUMPIDO LA CARGA ");
					JOptionPane.showMessageDialog(null, "Error al cargar la ventana", "Error", JOptionPane.ERROR_MESSAGE);
				}
				dispose();
				new VentanaPrincipal(vActual);
				vActual.setVisible(false);
			}
		});hilo.start();
		
		Restaurante.miIcono(this, "imagenes/CORONA.png");
		setVisible(true);
	}
}
