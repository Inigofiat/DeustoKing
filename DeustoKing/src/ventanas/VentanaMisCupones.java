package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import deustoking.Cliente;
import deustoking.Cupon;
import deustoking.Restaurante;

@SuppressWarnings("serial")
public class VentanaMisCupones extends JFrame{
	
	private JPanel pCentro, pDerecha, pIzquierda, pContenedor, pPrincipal, pSur;
	private JButton btVolver;
	private JScrollPane scroll;
	private Cliente cliente;
	private ArrayList<Cupon> cupones;
	private JFrame vActual, vAnterior;
	public static double descuento;
	
	public VentanaMisCupones(JFrame va) {
		descuento = 0;
		vActual=this;
		vAnterior=va;
		cupones = new ArrayList<>();
		cliente = VentanaInicioSesion.getCliente();
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pCentro = new PanelGif(new ImageIcon("imagenes/foto.png").getImage());
		pCentro.setBackground(Color.BLACK);

		
		pCentro.setOpaque(false);
		
		pDerecha = new JPanel();
		pDerecha.setBorder(new EmptyBorder(50,50,50,50));
		
		pIzquierda = new JPanel();
		pIzquierda.setBorder(new EmptyBorder(50,50,50,50));
		
		pSur = new JPanel();
		btVolver = new JButton("Volver");
		btVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vActual.dispose();
				vAnterior.setVisible(true);
				
			}
		});
		pSur.add(btVolver);
		pContenedor= new JPanel();
		pContenedor.setLayout(new BorderLayout());
		pContenedor.add(pCentro, BorderLayout.CENTER);
		pContenedor.add(pDerecha, BorderLayout.EAST);
		pContenedor.add(pIzquierda, BorderLayout.WEST);
		pContenedor.add(pSur, BorderLayout.SOUTH);
		pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());
		pPrincipal.add(pContenedor);
		
		scroll = new JScrollPane(pPrincipal);
		scroll.setOpaque(false);
		getContentPane().add(scroll, BorderLayout.CENTER);
		
		cargarCupones();
		
		pCentro.addMouseListener(new MouseAdapter() {
		
			

			
			@Override
			public void mouseClicked(MouseEvent e) {
								
				 if(e.getClickCount()==2) {
					int resp = JOptionPane.showConfirmDialog(null, "¿Seguro?");
					if (resp == 0) {
						Point p = e.getPoint();
						JLabel l = (JLabel) pCentro.getComponentAt(p);
						ImageIcon im = (ImageIcon) l.getIcon();
						String foto = im.getDescription();
						if( Restaurante.getMapaCupones().get(foto) != null) {
							Cupon c = Restaurante.getMapaCupones().get(foto);
							cliente.setPuntosAcumulados(cliente.getPuntosAcumulados()-c.getMinPuntos());
							Restaurante.volcarListaClientesAlFichero();
							borrarPanelCupones();
							//if(c.getDescuento()==10) {
								//VentanaFactura.setTotalPrecio(VentanaFactura.getTotalPrecio()-(VentanaFactura.getTotalPrecio()*0.10));
								descuento = descuento + c.getDescuento();
								System.out.println("DESCUENTO DEL CUPÓN: "+c.getDescuento());
							//}
						}
					}
				}
			}
		});
		
		setVisible(true);
	}
	
	private void cargarCupones() {
		System.out.println("Cargando los cupones...");
		for(String foto: Restaurante.getMapaCupones().keySet()) {
			Cupon c = Restaurante.getMapaCupones().get(foto);
			System.out.println(c.getMinPuntos()+" "+cliente.getPuntosAcumulados());
			if(c.getMinPuntos() <= cliente.getPuntosAcumulados()) {
				cupones.add(c);
				System.out.println("Cargamos el cupón "+c.getFoto());
				ImageIcon im = new ImageIcon(c.getFoto());
				im.setDescription(c.getFoto());
				JLabel l = new JLabel();
				l.setSize(600, 600);
				ImageIcon imConDimensiones = new ImageIcon(im.getImage().getScaledInstance(l.getWidth()	, l.getHeight()	, Image.SCALE_DEFAULT));
				imConDimensiones.setDescription(c.getFoto());
				l.setIcon(imConDimensiones);
				l.setOpaque(false);
				pCentro.add(l);
			}
		}
		
	}
	

	@SuppressWarnings("unused")
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
	
	private void borrarPanelCupones() {
		pCentro.removeAll();
		pCentro.updateUI();
	}

}