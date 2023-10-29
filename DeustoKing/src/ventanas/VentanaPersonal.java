package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import deustoking.Personal;

public class VentanaPersonal extends JFrame{
	private JPanel pCentro, pNorte, pMesas;
	private JLabel lblSaludo, lblMesasAtendidas, lblHoras, lblSueldo, lblPuesto;
	private DefaultTableModel modeloTablaMesas;
	private JTable tablaMesas;
	private JScrollPane scrollTablaMesas;
	private FlowLayout layoutTblMesas;
	private Personal personal; 
	
	
	
	public VentanaPersonal (Personal personal) {
		this.personal = personal;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setBounds(200, 100, 1100, 700);
		
		pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(2, 1)); 
		pNorte = new JPanel();
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		
		lblSaludo = new JLabel("Hola, " + personal.getIdPersonal() + personal.getNombreP() + personal.getApellidosP());
      	lblHoras = new JLabel("HORAS TOTALES" + personal.getHorasTrabajadas());
		lblSueldo = new JLabel("SUELDO" + personal.getSueldo());
		lblPuesto = new JLabel("PUESTO" + personal.getPuesto());
		
		pNorte.add(lblSaludo);
      	
		//Creación de la tabla, modelo de la tabla y scroll de la tabla
		modeloTablaMesas = new DefaultTableModel();
		Object [] titulos = {"MAÑANA", "TARDE"};
		modeloTablaMesas.setColumnIdentifiers(titulos);
        tablaMesas = new JTable(modeloTablaMesas);
        scrollTablaMesas = new JScrollPane(tablaMesas);
        
        //Creación de un nuevo panel para la JLabel mesas atendidas y la tabla
        JPanel pMesas = new JPanel();
        pMesas.setLayout(new GridLayout(2, 1));
        JLabel lblMesasAtendidas = new JLabel("MESAS ATENDIDAS");
        pMesas.add(lblMesasAtendidas);
        pMesas.add(scrollTablaMesas);

        pCentro.add(pMesas);
        pCentro.add(lblHoras);
        pCentro.add(lblSueldo);
        pCentro.add(lblPuesto);
		
	
		setVisible(true);
		
		
	}
	
	
}
