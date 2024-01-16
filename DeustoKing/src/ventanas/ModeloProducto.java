package ventanas;


import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import deustoking.Producto;


@SuppressWarnings("serial")
public class ModeloProducto extends DefaultTableModel{
	private List<Producto> listaProductos;
	private List<String> titulos = Arrays.asList("NOMBRE","CANTIDAD","DESCRIPCIÓN","PRECIO", "MODIFICACIÓN");
	
	public ModeloProducto(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
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
		if(listaProductos == null)
			return 0;
		return listaProductos.size();
	}
	
	
	
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		listaProductos.get(row).setModificacion(aValue.toString());
		fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Producto p = listaProductos.get(row);
		switch(column) {
	
		case 0: return p.getNombre();
		case 1: return p.getCantidad();
		case 2:return p.getDescripcion();
		case 3:return p.getPrecio()*p.getCantidad();
		case 4: return p.getModificacion();
		default: return null;
		}
	}
	

    public void eliminarProducto(Producto producto) {
        listaProductos.remove(producto);
        fireTableDataChanged(); 
    }
    public void actualizarTabla() {
        fireTableDataChanged(); 
    }

    public Producto getProductoAtRow(int row) {
        return listaProductos.get(row);
    }
}



