package ventanas;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import deustoking.Cliente;

@SuppressWarnings("serial")
public class ModeloCliente extends DefaultTableModel{
	private List<Cliente> listaClientes;
	private List<String> titulos = Arrays.asList("NOMBRE","TÉLEFONO", "CORREO");
	
	public ModeloCliente(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
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
		if(listaClientes == null)
			return 0;
		return listaClientes.size();
	
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public Object getValueAt(int row, int column) {
		Cliente c = listaClientes.get(row);
		switch(column) {
		case 0:return c.getNombre();
		case 1:return c.getTelefono();
		case 2:return c.getCorreo();
		default: return null;
		}
	}
	
	
	
	

}
