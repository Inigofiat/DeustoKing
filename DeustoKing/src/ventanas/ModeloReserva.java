package ventanas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import deustoking.Reserva;

@SuppressWarnings({ "serial", "unused" })
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
	public void setValueAt(Object aValue, int row, int column) {
		Reserva r = listaReservas.get(row);
		switch(column) {
		case 0:
			LocalDate ld = (LocalDate)aValue;
			Date d = Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			r.setFecha(d);break;
		case 1:r.setHora(aValue.toString());break;
		case 2: r.setnComensales(Integer.parseInt(aValue.toString()));
		
		}

	}

	@Override
	public Object getValueAt(int row, int column) {
		Reserva r = listaReservas.get(row);
		switch(column) {
		case 0:return r.getFechaStr();
		case 1:return r.getHora();
		case 2:return r.getnComensales();
		default: return null;
		}
	}
	
	public List<Reserva> getListaReservas() {
		return listaReservas;
	}
	
	public Reserva getReserva(int row) {
		return listaReservas.get(row);
	}


	
	
	
	

}
