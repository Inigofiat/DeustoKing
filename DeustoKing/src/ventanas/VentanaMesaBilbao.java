package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class VentanaMesaBilbao extends JFrame {
	private JPanel pNorte,pCentro,pSur,pCentroIzquierda,pCentroDerecha;
	private JButton btnMesa1, btnMesa2, btnMesa3,btnMesa4,btnMesa5,btnMesa6,btnAtras;
	private JFrame vActual,vAnterior;
	private JLabel lblTitulo;
	

	public VentanaMesaBilbao(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		
		setBounds(-10, 0, 1800, 970);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Mesas disponibles en Bilbao");
		
		pNorte = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pCentro = new JPanel(new GridLayout(1, 2));
		pSur = new JPanel();
		pCentroIzquierda = new JPanel(new GridLayout(2, 4));
		pCentroDerecha = new JPanel(new GridLayout(4, 6));
		pCentro.add(pCentroIzquierda);
		pCentro.add(pCentroDerecha);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		lblTitulo = new JLabel("Reserva una mesa en Bilbao: ");
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		pNorte.add(lblTitulo);
		
		btnMesa1= new JButton("Mesa 1");
		btnMesa1.setPreferredSize(new Dimension(250,350));
		btnMesa1.setMargin(new Insets(10, 10, 10, 10));
		btnMesa1.setBackground(new Color(162,240,163));
		pCentroIzquierda.add(btnMesa1);
		
		
		btnMesa2= new JButton("Mesa 2");
		pCentroIzquierda.add(btnMesa2);
		btnMesa2.setPreferredSize(new Dimension(250,350));
		btnMesa2.setMargin(new Insets(10, 10, 10, 10));
		btnMesa2.setBackground(new Color(162,240,163));
		
		btnMesa3= new JButton("Mesa 3");
		pCentroIzquierda.add(btnMesa3);
		btnMesa3.setPreferredSize(new Dimension(250,350));
		btnMesa3.setMargin(new Insets(10, 10, 10, 10));
		btnMesa3.setBackground(new Color(162,240,163));
		
		btnMesa4= new JButton("Mesa 4");
		pCentroIzquierda.add(btnMesa4);
		btnMesa4.setPreferredSize(new Dimension(250,350));
		btnMesa4.setMargin(new Insets(10, 10, 10, 10));
		btnMesa4.setBackground(new Color(162,240,163));
		
		btnMesa5= new JButton("Mesa 5");
		pCentroDerecha.add(btnMesa5);
		btnMesa5.setPreferredSize(new Dimension(250,350));
		btnMesa5.setMargin(new Insets(10, 10, 10, 10));
		btnMesa5.setBackground(new Color(162,240,163));
		
		btnMesa6= new JButton("Mesa 6");
		pCentroDerecha.add(btnMesa6);
		btnMesa6.setPreferredSize(new Dimension(250,350));
		btnMesa6.setMargin(new Insets(10, 10, 10, 10));
		btnMesa6.setBackground(new Color(162,240,163));
		
		
		btnAtras = new JButton("ATRAS"); 
		pSur.add(btnAtras);
		
		int espacioEntrePaneles =50;
		pCentroIzquierda.setBorder(new EmptyBorder(espacioEntrePaneles, espacioEntrePaneles, espacioEntrePaneles, espacioEntrePaneles));
		pCentroDerecha.setBorder(new EmptyBorder(espacioEntrePaneles, espacioEntrePaneles, espacioEntrePaneles, espacioEntrePaneles));

		FlowLayout btLayout = new FlowLayout();   
		btLayout.setHgap(40);
		pCentroDerecha.setLayout(btLayout);
		pCentroIzquierda.setLayout(btLayout);
		
		
		btnAtras.addActionListener((e)->{
			vActual.dispose();
			vAnterior.setVisible(true);
		});
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaMesaBilbao(null);
            }
        });
    }
	
}


