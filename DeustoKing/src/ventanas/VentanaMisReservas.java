package ventanas;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.JDatePicker;

import deustoking.Cliente;
import deustoking.Reserva;
import deustoking.Restaurante;

@SuppressWarnings("serial")
public class VentanaMisReservas extends JFrame{
	private static ModeloReserva modeloTablaReservas;
	private static JTable tablaReserva;
	private JScrollPane scrollTablaReserva;
	private JPanel pContenedor, pPrincipal, pCentro, pNorte, pSur;
	private JFrame vActual, vAnterior;
	private JLabel lbInfo;
	private JButton btnVolver;
	Cliente cliente;
	
	public VentanaMisReservas(JFrame va) {
		super();
		Restaurante.cargarReservasEnLista("ficheros/reservas.csv");
		vActual = this;
		vAnterior = va;
		cliente = VentanaInicioSesion.getCliente();
        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		pNorte= new JPanel();
		pCentro= new JPanel();
		pSur = new JPanel();
		
		pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());
		
		pContenedor = new JPanel();
		pContenedor.setLayout(new BorderLayout());
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vAnterior.setVisible(true);
				vActual.dispose();
				
			}
		});
		
		pSur.add(btnVolver);
		
		lbInfo = new JLabel("Para modificar/borrar una reserva debe hacer doble click sobre la reserva que desea modificar");
		
		pNorte.add(lbInfo);
		
		
		
		List<Reserva> lr =Restaurante.obtenerReservasCliente(cliente.getTelefono());
		System.out.println("Reservas obtenidas: " + lr);
		modeloTablaReservas = new ModeloReserva(lr);
		tablaReserva = new JTable(modeloTablaReservas);
	    scrollTablaReserva = new JScrollPane(tablaReserva);
	    
	    tablaReserva.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                	int row = tablaReserva.getSelectedRow();
                    int col = tablaReserva.getSelectedColumn();
                    int option = JOptionPane.showOptionDialog(vActual,
                            "Seleccione una opción:",
                            "Modificar Reserva",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{"Modificar Fecha", "Modificar Hora", "Modificar Comensales"},
                            null);

                    if (option == JOptionPane.CLOSED_OPTION) {
                        return; 
                    }

                    switch (option) {
                        case 0:
                            modificarFecha(row, col);
                            break;
                        case 1:
                            modificarHora(row, col);
                            break;
                        case 2:
                            modificarComensales(row, col);
                            break;
                    }
                }
            }
        });
	    pCentro.add(scrollTablaReserva, BorderLayout.CENTER);
	    
	    pCentro.setBorder(new EmptyBorder(200, 200, 200, 200 ));
		    
		
		pContenedor.add(pNorte, BorderLayout.NORTH);
		pContenedor.add(pCentro, BorderLayout.CENTER);
		pContenedor.add(pSur, BorderLayout.SOUTH);
		
		pPrincipal.add(pContenedor);
		
		setContentPane(pContenedor);
		
		setVisible(true);
		
		
	    }
	
	 private void modificarFecha(int row, int col) {
		 if (tablaReserva.getRowCount() > 0 && row >= 0 && row < tablaReserva.getRowCount()) {
	       

	        JDatePicker fecha = new JDatePicker();

	        int option = JOptionPane.showOptionDialog(vActual,
	                fecha,
	                "Modificar Fecha",
	                JOptionPane.OK_CANCEL_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                null,
	                null);

	        if (option == JOptionPane.OK_OPTION) {
	        	GregorianCalendar calendar = (GregorianCalendar) fecha.getModel().getValue();
	        	ZonedDateTime zonedDateTime = calendar.toZonedDateTime();
                LocalDate fechaLocal = zonedDateTime.toLocalDate();
                ((ModeloReserva)tablaReserva.getModel()).setValueAt(fechaLocal, row, 0);
	        }
		 }
	    }

    private void modificarHora(int row, int col) {
    	String[] horas = { "12:30", "13:30", "14:30", "15:30", "20:30", "21:30", "22:30", "23:30" };
        String nuevaHora = (String) JOptionPane.showInputDialog(null,
                "Seleccione la nueva hora:",
                "Modificar Hora",
                JOptionPane.PLAIN_MESSAGE,
                null,
                horas,
                tablaReserva.getValueAt(row, col));

        if (nuevaHora != null) {
        	((ModeloReserva)tablaReserva.getModel()).setValueAt(nuevaHora, row, 1);
        }
    }
    

    private void modificarComensales(int row, int col) {
    	
        SpinnerNumberModel snm = new SpinnerNumberModel(2, 2, 10, 1);
        

        JSpinner spinner = new JSpinner(snm);
        int option = JOptionPane.showOptionDialog(null,
                spinner,
                "Modificar Comensales",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);

        if (option == JOptionPane.OK_OPTION) {
            tablaReserva.setValueAt(spinner.getValue(), row, 2);
            Restaurante.volcarListaReservasAlFichero();
        }
    }
    	 
        
	    
}
