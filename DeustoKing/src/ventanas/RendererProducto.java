package ventanas;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class RendererProducto implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
	
		/*Descripción*/
		int cont = 0;
		String nuevo = "";
		
		String texto = ((ModeloProducto)table.getModel()).getValueAt(row, 2).toString();
		for(int i=0;i<texto.length();i++) {
			if(texto.charAt(i)!='\n') {
				nuevo = nuevo + texto.charAt(i);
				if((i+1)%50==0) {
					nuevo = nuevo + "\n";
					cont++;
				}
			}
		}
		if(cont>2)
			table.setRowHeight(row, cont*25);
	
		
		/*Modificaciones*/
		int contm = 0;
		String nuevom = "";
		
		String textom = ((ModeloProducto)table.getModel()).getValueAt(row, 4).toString();
		for(int i=0;i<textom.length();i++) {
			if(textom.charAt(i)!='\n') {
				nuevom = nuevom + textom.charAt(i);
				if((i+1)%50==0) {
					nuevom = nuevom + "\n";
					contm++;
				}
			}
		}
		if(contm>2)
			table.setRowHeight(row, contm*25);
	
		
		switch(column) {
		case 0: 
			label.setText(value.toString());
			((JLabel)label).setOpaque(true);
		
			return label;
			//break;
			
		case 1:
			label.setText(value.toString());
			((JLabel)label).setOpaque(true);
			return label;
			
		case 2:
			
			JTextArea area = new JTextArea(nuevo);
			return area;
		
			
		case 3:
			label = new JLabel(value.toString());
			label.setHorizontalAlignment(JLabel.CENTER);

			((JLabel)label).setOpaque(true);
			return label;
			
		case 4:
			JTextArea areaM = new JTextArea(nuevom);
			return areaM;
			
		default : return null;
			
		}
	
		
		
	}


}







