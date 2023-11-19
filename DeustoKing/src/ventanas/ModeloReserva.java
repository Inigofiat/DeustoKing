package ventanas;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import deustoking.Reserva;

public class ModeloReserva extends DefaultTableModel{
	private List<Reserva> listaReservas;
	private List<String> titulos = Arrays.asList("FECHA","HORA","NÚMERO DE COMENSALES");
	
	public ModeloReserva(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

	@Override
	public int getColumnCount() {
		return titulos.size();
	}

	@Override
	public String getColumnName(int column) {
		return titulos.get(column);
	}

	@Override
	public int getRowCount() {
		if(listaReservas == null)
			return 0;
		return listaReservas.size();
	}
	
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public Object getValueAt(int row, int column) {
		Reserva r = listaReservas.get(row);
		switch(column) {
		case 0: DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return r.getFecha().format(formatter);
		case 1:return r.getHora();
		case 2:return r.getnComensales();
		default: return null;
		}
	}
	


	
	
	
	

}
