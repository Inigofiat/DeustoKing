package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Renderer;import org.w3c.dom.xpath.XPathNSResolver;

import deustoking.Producto;
import deustoking.Restaurante;

public class VentanaTablaProductos extends JFrame{
	private ModeloProducto modeloProducto;
	private JTable tablaProductos;
	private JScrollPane scrollTablaProductos;
	private JPanel pContenedor, pPrincipal, pSur, pCentro, pNorte;
	private JFrame vActual, vAnterior;
	private JButton btnFactura, btnVolver;
	
	private Producto producto;
	
	public VentanaTablaProductos(JFrame va) {
		super();
		vActual=this;
		vAnterior = va;
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        
        producto = null;
        
        pContenedor = new JPanel();
        pContenedor.setLayout(new BorderLayout()); 
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());   
        pCentro = new JPanel();
        pCentro.setLayout(new BorderLayout());
        pSur = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 15, 15);
        pSur.setLayout(flowLayout);
        
        pNorte=new JPanel();
        FlowLayout flowLayout2 = new FlowLayout(FlowLayout.CENTER, 100, 15);
        pNorte.setLayout(flowLayout2);
        
        
        btnFactura = new JButton("Finalizar compra");
        btnFactura.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaFactura(vActual);
				vActual.dispose();
				
			}
		});
        
        btnVolver = new JButton("Añadir otro producto");
        btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vActual.dispose();
				vAnterior.setVisible(true);
				
			}
		});
        
        pSur.add(btnVolver);
        pSur.add(btnFactura);
       

        
        modeloProducto = new ModeloProducto(Restaurante.obtenerProductos());
        tablaProductos = new JTable(modeloProducto);
        this.tablaProductos.setRowHeight(50);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);

        
	    scrollTablaProductos = new JScrollPane(tablaProductos);
	    tablaProductos.setDefaultRenderer(Object.class, new RendererProducto());
	    
	    tablaProductos.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	                int filaSeleccionada = tablaProductos.getSelectedRow();
	                if (filaSeleccionada != -1) {
	                    Producto productoSeleccionado = modeloProducto.getProductoAtRow(filaSeleccionada);

	                    int opcion = JOptionPane.showOptionDialog(vActual,
	                            "Seleccione una acción para el producto seleccionado:",
	                            "Opciones del Producto", JOptionPane.YES_NO_CANCEL_OPTION,
	                            JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Eliminar", "Modificar Cantidad", "Modificar Producto"}, null);

	                    if (opcion == JOptionPane.YES_OPTION) {
	                        int confirmacion = JOptionPane.showConfirmDialog(vActual,
	                                "¿Está seguro que desea eliminar el producto de la cesta?",
	                                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

	                        if (confirmacion == JOptionPane.YES_OPTION) {
	                            modeloProducto.eliminarProducto(productoSeleccionado);
	                        }
	                    } else if (opcion == JOptionPane.NO_OPTION) {
	                        String cantidadStr = JOptionPane.showInputDialog(vActual, "Ingrese la nueva cantidad:");
	                        if (cantidadStr != null && !cantidadStr.isEmpty()) {
	                            int nuevaCantidad = Integer.parseInt(cantidadStr);
	                            productoSeleccionado.setCantidad(nuevaCantidad);
	                            modeloProducto.actualizarTabla();
	                        }
	                    } else if (opcion == JOptionPane.CANCEL_OPTION) {

	                        String nuevoNombre = JOptionPane.showInputDialog(vActual, "Ingrese las modificaciones del producto:");
	                        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
	                            productoSeleccionado.setModificacion(nuevoNombre);
	                            modeloProducto.setValueAt(nuevoNombre, filaSeleccionada, 4);
	                            tablaProductos.setModel(modeloProducto);
	                        }
	                    }
	                }
	            }
	        }
	    });

	    pCentro.add(scrollTablaProductos, BorderLayout.CENTER);
	    
	    pContenedor.add(pNorte, BorderLayout.NORTH);
	    pContenedor.add(pSur, BorderLayout.SOUTH);
	    pContenedor.add(pCentro, BorderLayout.CENTER);
	    pPrincipal.add(pContenedor,BorderLayout.CENTER);
	    
	    getContentPane().add(scrollPane);
	    getContentPane().add(pPrincipal);
	    setVisible(true);
	}
	
public static void main(String[] args) {
	new VentanaTablaProductos(null);
}
}
