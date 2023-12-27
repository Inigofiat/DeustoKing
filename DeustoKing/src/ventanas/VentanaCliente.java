package ventanas;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

import deustoking.Cliente;
import deustoking.Cupon;
import deustoking.Restaurante;

public class VentanaCliente extends JFrame{
	private JPanel pNorte, pCentro;
	private JSlider sliderPts;
	private JLabel lblSaludo, lblCupon1, lblCupon2, lblCupon3, lblCupon4;
	private Cliente cliente;
	private JFrame vActual, vAnterior;
	private ArrayList<Cupon> cupones;
	
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
		pCentro.setLayout(new GridLayout(2,2));
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		

		lblSaludo = new JLabel("Hola, "+cliente.getNombreUsuario());
		sliderPts = new JSlider(0, 1000, 0);
		sliderPts.setValue(cliente.getPuntosAcumulados());
		sliderPts.setMajorTickSpacing(200);
		sliderPts.setPaintLabels(true);
		sliderPts.setPaintTicks(true);

		cargarPanelCupones();
		pCentro.updateUI();
		
		pNorte.add(lblSaludo);
		pNorte.add(sliderPts);
		
		pCentro.addMouseListener(new MouseAdapter() {
			

			
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				JLabel l = (JLabel) pCentro.getComponentAt(p);
				ImageIcon im = (ImageIcon) l.getIcon();
				String foto = im.getDescription();
				Cupon c = Restaurante.getMapaCupones().get(foto);
				cliente.setPuntosAcumulados(cliente.getPuntosAcumulados()-c.getMinPuntos());
				System.out.println("Has seleccionado el cupón: "+c.getFoto());
				System.out.println("Te quedan "+cliente.getPuntosAcumulados()+ " puntos");
				Restaurante.volcarListaClientesAlFichero();
				actualizarPanelCupones();
				pCentro.updateUI();
			}
				

		});
		
		
        Restaurante.miIcono(this, "/imagenes/CORONA.png");
		setVisible(true);
	}
	
	private void cargarPanelCupones() {
		System.out.println("Cargando los cupones...");
		for(String foto: Restaurante.getMapaCupones().keySet()) {
			Cupon c = Restaurante.getMapaCupones().get(foto);
			System.out.println(c.getMinPuntos()+" "+cliente.getPuntosAcumulados());
			if(c.getMinPuntos() <= cliente.getPuntosAcumulados()) {
				cupones.add(c);
				System.out.println("Cargamos el cupón "+c.getFoto());
				ImageIcon im = new ImageIcon("imagenes//CUPON.png" + c.getFoto());
				im.setDescription(c.getFoto());
				JLabel l = new JLabel(im);
				pCentro.add(l);
			}
		}
		
		
	}
	
	private void actualizarPanelCupones() {
		int i=0;
		while(i<cupones.size()) {
			Cupon c = cupones.get(i);
			if(c.getMinPuntos() > cliente.getPuntosAcumulados()) {
				cupones.remove(i);
				pCentro.remove(i);
			}else{
				i++;
			}
		}
	}
	
	
	


}
