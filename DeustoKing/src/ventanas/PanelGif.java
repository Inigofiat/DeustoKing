package ventanas;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelGif extends JPanel{
	Image imagen;
	
	public PanelGif(Image i) {
		imagen = i;
		setLayout(new GridLayout(0, 2,30,10));
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D)g;
		if(imagen == null) {
			super.paintComponent(g);
		}else {
			gr.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(),this);
		}
	}
} 