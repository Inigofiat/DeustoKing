package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.constraints.DateSelectionConstraint;

import deustoking.Cliente;
import deustoking.Reserva;
import deustoking.Restaurante;

public class VentanaReserva extends JFrame{
	
	private JDatePicker datePicker;
	private JComboBox<String> horas;
	private JComboBox<Integer> nComensales;
	private JLabel lbDate, lbReserva;
	private JButton btnReservar;
	private JPanel pPrincipal, pCentro, pContenedor, pSur, pNorte;
    private static final String nomfichReservas = "reservas.csv";
    
    Restaurante restaurante;
    Cliente cliente;

	public VentanaReserva() {
        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        
        restaurante = new Restaurante();
        cliente = new Cliente();
        
        pContenedor = new JPanel();
        pContenedor.setLayout(new BorderLayout());
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        pCentro = new JPanel();
        pCentro.setLayout(new FlowLayout());
        pNorte = new JPanel();
        pNorte.setLayout(new FlowLayout(FlowLayout.LEFT));
        pSur = new JPanel();
        pSur.setLayout(new FlowLayout());
        
        lbDate = new JLabel("Fecha");
		datePicker = new JDatePicker();
		datePicker.setPreferredSize(new Dimension(200, datePicker.getPreferredSize().height));
		horas = new JComboBox<>();
		horas.setPreferredSize(new Dimension(200, horas.getPreferredSize().height));
        horas.setBackground(Color.WHITE);
        nComensales = new JComboBox<>();
        nComensales.setPreferredSize(new Dimension(200, nComensales.getPreferredSize().height));
        nComensales.setBackground(Color.WHITE);
        lbReserva = new JLabel("Reservas");
        lbReserva.setFont(new Font("Arial Black", Font.BOLD, 30));
        pNorte.add(lbReserva);
        btnReservar = new JButton("Reservar");
        btnReservar.setPreferredSize(new Dimension(650, btnReservar.getPreferredSize().height));
        btnReservar.setFont(new Font("Arial", Font.BOLD, 17));
        pSur.add(btnReservar);

        
        for (int i = 2; i < 11; i++) {
            nComensales.addItem(i);
        }

        String[] horasArray = { "12:30", "13:30", "14:30", "15:30", "20:30", "21:30", "22:30", "23:30" };
        for (String hora : horasArray) {
            horas.addItem(hora);
        }
        
        getContentPane().add(pPrincipal);

        setTitle("Ventana de Reserva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        datePicker.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GregorianCalendar calendar = (GregorianCalendar) datePicker.getModel().getValue();
                ZonedDateTime zonedDateTime = calendar.toZonedDateTime();
                LocalDate fechaLocal = zonedDateTime.toLocalDate();
                lbDate.setText(fechaLocal.toString());
            }
        });
        
        datePicker.addDateSelectionConstraint(new DateSelectionConstraint() {

            @Override
            public boolean isValidSelection(DateModel<?> arg0) {
                GregorianCalendar calendar = (GregorianCalendar) arg0.getValue();

                if (calendar != null) {
                    ZonedDateTime zonedDateTime = calendar.toZonedDateTime();
                    LocalDate fechaLocal = zonedDateTime.toLocalDate();
                    if (fechaLocal.isBefore(LocalDate.now()) || fechaLocal.isAfter(LocalDate.now().plusWeeks(1))) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        });
        
        btnReservar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reservar();
				
			}
		});
        int espacioEntrePaneles1 = 100;
        pNorte.setBorder(new EmptyBorder(espacioEntrePaneles1, espacioEntrePaneles1, espacioEntrePaneles1,
                espacioEntrePaneles1));
        int espacioEntrePaneles2 = 180;
        pCentro.setBorder(new EmptyBorder(espacioEntrePaneles2, espacioEntrePaneles2, espacioEntrePaneles2,
                espacioEntrePaneles2));
        int espacioEntrePaneles3 = 180;
        pSur.setBorder(new EmptyBorder(espacioEntrePaneles3, espacioEntrePaneles3, espacioEntrePaneles3,
                espacioEntrePaneles3));

        FlowLayout norteLayout = new FlowLayout(FlowLayout.LEFT);
        norteLayout.setHgap(0);
        pNorte.setLayout(norteLayout);

        FlowLayout centroLayout = new FlowLayout(FlowLayout.RIGHT);
        centroLayout.setHgap(25);
        pCentro.setLayout(centroLayout);

        FlowLayout surLayout = new FlowLayout(FlowLayout.RIGHT);
        surLayout.setHgap(25);
        pSur.setLayout(surLayout);

        pCentro.add(horas);
        pCentro.add(nComensales);
        pCentro.add(datePicker);
        pNorte.add(lbReserva);
        pSur.add(btnReservar);

        pContenedor.add(pCentro, BorderLayout.EAST);
        pContenedor.add(pNorte, BorderLayout.NORTH);
        pContenedor.add(pSur, BorderLayout.SOUTH);

        pPrincipal.add(pContenedor, BorderLayout.CENTER);


	}
	
	private void reservar() {
	    GregorianCalendar calendar = (GregorianCalendar) datePicker.getModel().getValue();

	    // Convierte GregorianCalendar a LocalDate
	    LocalDate fechaLocal = calendar.toZonedDateTime().toLocalDate();

	    String hora = (String) horas.getSelectedItem();
	    int comensales = (int) nComensales.getSelectedItem();
	    

	    Reserva reserva = new Reserva(fechaLocal, hora, comensales, cliente.getCorreo());

	    // Utiliza tu método para guardar la reserva en el fichero
	    restaurante.guardarReservasEnFichero(reserva, nomfichReservas);

    }

}
