package ventanas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import deustoking.Reserva;

public class RendererReserva implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		switch(column) {
		case 0: 
			label.setText(value.toString());
			((JLabel)label).setOpaque(true);
			break;
			
		case 1:
			label.setText(value.toString());
			((JLabel)label).setOpaque(true);
			break;
		case 2:
			label = new JLabel(value.toString());
			((JLabel)label).setOpaque(true);
			break;
		}
		
		String numComensales = table.getValueAt(row, 2).toString();
		int numComensalesInt = Integer.parseInt(numComensales);
		if(column==2) {
			 if (numComensalesInt == 2) {
		        	label.setHorizontalAlignment(JLabel.CENTER);
		            label.setOpaque(true);
		            label.setBackground(new Color(138,249,132));
		            label.setForeground(Color.BLACK);
		        } else if (numComensalesInt == 3) {
		        	label.setHorizontalAlignment(JLabel.CENTER);
		            label.setOpaque(true);
		            label.setBackground(new Color(250,252,127));
		            label.setForeground(Color.BLACK);
		        } else if(numComensalesInt==4) {
		        	 label.setHorizontalAlignment(JLabel.CENTER);
		        	 label.setOpaque(true);
		             label.setBackground(new Color(250,72,252));
		             label.setForeground(Color.BLACK);
		        } else if(numComensalesInt==5) {
		        	label.setHorizontalAlignment(JLabel.CENTER);
		        	 label.setOpaque(true);
		             label.setBackground(new Color(255,91,91));
		             label.setForeground(Color.BLACK);
		        } else if(numComensalesInt==6) {
		        	label.setHorizontalAlignment(JLabel.CENTER);
		        	 label.setOpaque(true);
		             label.setBackground(new Color(141, 110, 99));
		             label.setForeground(Color.BLACK);
		        } else if(numComensalesInt==7) {
		        	 label.setHorizontalAlignment(JLabel.CENTER);
		        	 label.setOpaque(true);
		             label.setBackground(new Color(179,249,247));
		             label.setForeground(Color.BLACK);
		        } else if(numComensalesInt==8) {
		        	 label.setHorizontalAlignment(JLabel.CENTER);
		        	 label.setOpaque(true);
		             label.setBackground(new Color(249,157,76));
		             label.setForeground(Color.BLACK);
		        } else if(numComensalesInt==9) {
		        	 label.setHorizontalAlignment(JLabel.CENTER);
		        	 label.setOpaque(true);
		             label.setBackground(new Color(195,192,189));
		             label.setForeground(Color.BLACK);
		        } else if(numComensalesInt==10) {
		        	 label.setHorizontalAlignment(JLabel.CENTER);
		        	 label.setOpaque(true);
		             label.setBackground(new Color(81,92,252));
		             label.setForeground(Color.BLACK);
		        }
				
		}
       
		return label;
	}


}
