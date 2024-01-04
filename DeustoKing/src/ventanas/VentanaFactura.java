package ventanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import deustoking.Cliente;
import deustoking.Factura;
import deustoking.Producto;
import deustoking.Restaurante;

public class VentanaFactura extends JFrame {

    private DefaultListModel<Producto> modeloLista;
    private List<Producto> listaProductos;
    private JTextArea area;
    private JScrollPane scrollArea;
    private JButton btnPagar, btnVolver;
    private JLabel lbFactura, lbFechaYHora, lbTotal, lbFH, lbProductos, lbP;
    private DefaultListModel<String> modeloListaFinales;
    private JList<String> jListFinales;
    private JScrollPane scrollListaFinales;
    private JFrame vActual, vAnterior;
    private Factura factura;
    private JPanel pIzquierda, pDerecha, pArriba, pAbajo, pContenedor, pPrincipal;
    private Cliente cliente;


    public VentanaFactura(JFrame va) {
        super();
        vActual=this;
        vAnterior=va;
        
        cliente = VentanaInicioSesion.getCliente();

        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
                .getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        listaProductos = Restaurante.obtenerProductos();

        // Panel izquierdo
        pIzquierda = new JPanel();
        pIzquierda.setLayout(new BorderLayout());
        pIzquierda.setBorder(new EmptyBorder(100,100,100,100));

        // Panel contenedor
        pContenedor = new JPanel();
        pContenedor.setLayout(new BorderLayout());

        // Panel arriba
        pArriba = new JPanel();
        lbFactura = new JLabel(" FACTURA ");
        lbFactura.setFont(new Font("Tw", Font.BOLD, 20));
        pArriba.setBorder(new EmptyBorder(30,70,70,70));
        pArriba.add(lbFactura);

        // Panel derecha
        pDerecha = new JPanel();
        pDerecha.setLayout(new GridLayout(5, 2, 10, 10));
        pDerecha.setBorder(new EmptyBorder(100, 100, 100, 100));


        lbFechaYHora = new JLabel("Fecha y Hora:");
        lbFechaYHora.setFont(new Font("Tw", Font.BOLD, 14));
        lbFH = new JLabel();
        lbFH.setFont(new Font("Tw", Font.PLAIN, 14));
        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String horaActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        lbFH.setText(fechaActual + " a las " + horaActual);

        modeloListaFinales = new DefaultListModel<>();
        double totalPrecio = 0.0;

        for (Producto producto : listaProductos) {
            String formatoProducto = producto.getNombre() + " (x" + producto.getCantidad() + "): "+producto.getPrecio()+"(x "+producto.getPrecio()*producto.getCantidad()+")";
            modeloListaFinales.addElement(formatoProducto);
            totalPrecio += producto.getPrecio() * producto.getCantidad();
        }

        lbProductos = new JLabel("Productos Finales:");
        lbProductos.setFont(new Font("Tw", Font.BOLD, 14));
        jListFinales = new JList<>(modeloListaFinales);
        scrollListaFinales = new JScrollPane(jListFinales);

        lbP = new JLabel("Precio:");
        lbTotal = new JLabel("Total:");
        lbTotal.setFont(new Font("Tw", Font.BOLD, 14));
        lbP.setFont(new Font("Tw", Font.BOLD, 14));
        
        btnPagar= new JButton("Pagar");
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               double total = 0.0;
               for (Producto producto : listaProductos) {
				total +=producto.getPrecio()*producto.getCantidad();
               }
               sumarPuntos(total, 0);
               vActual.dispose();
            }
            
        });

        btnVolver = new JButton("Volver");
        
        pAbajo=  new JPanel();
        pAbajo.setBorder(new EmptyBorder(100,50,20,50));
        pAbajo.add(btnPagar);
        pAbajo.add(btnVolver);

        pDerecha.add(lbFechaYHora);
        pDerecha.add(lbFH);
        pDerecha.add(lbProductos);
        pDerecha.add(scrollListaFinales);
        pDerecha.add(lbP);
        pDerecha.add(lbTotal);
        pDerecha.setBorder(new EmptyBorder(70,70,70,70));

        lbTotal.setText(String.valueOf(totalPrecio));
        lbTotal.setFont(new Font("Tw", Font.PLAIN, 14));

        // Agregar componentes al panel contenedor
        pContenedor.add(pDerecha, BorderLayout.EAST);
        pContenedor.add(pArriba, BorderLayout.NORTH);
        pContenedor.add(pIzquierda, BorderLayout.WEST);
        pContenedor.add(pAbajo, BorderLayout.SOUTH);

        // Panel principal
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        area = new JTextArea();
        for (Producto producto : listaProductos) {
        	area.append(producto.toString());
        	for(int i=0;i<90;i++) {
        		area.append("*");
        	}
        	area.append("\n");
        }
        scrollArea = new JScrollPane(area);
        pIzquierda.add(scrollArea,BorderLayout.CENTER);
        
        pPrincipal.add(pContenedor, BorderLayout.CENTER);
        getContentPane().add(pPrincipal);
        setVisible(true);
    }

    private void sumarPuntos(double total, int puntosAcumulados) {
    	if(total>=1.0) {
    		puntosAcumulados += 5;
    		total-=1.0;
    		sumarPuntos(total, puntosAcumulados);
    	}else {
    		int puntosFinales = cliente.getPuntosAcumulados()+puntosAcumulados;
    		cliente.setPuntosAcumulados(puntosFinales);
    		Restaurante.volcarListaClientesAlFichero();
    		JOptionPane.showMessageDialog(this, "Gracias por su compra. Se han acumulado " + puntosAcumulados + " puntos. Total de puntos: " + 
    		puntosFinales, "Puntos acumulados", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
    

}

