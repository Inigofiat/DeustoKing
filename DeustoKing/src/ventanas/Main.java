package ventanas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import basesDeDatos.BD;
import deustoking.Producto;
import deustoking.Restaurante;

public class Main {
	public static Logger logger = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {
		VentanaCargando vc= new VentanaCargando();
		try {
			logger.log(Level.INFO, "SE INICIA EL PROGRAMA DEUSTOKING");
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		Connection con = BD.initBD("deustoking.db");
		try {
			BD.crearTabla(con);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Restaurante.volcarCSVPersonasABD(con, "Clientes.csv");
		Restaurante.volcarCSVReservasABD(con, "reservas.csv");
		BD.insertarProducto(con, new Producto(0, "Hamburguesa", "Con patatas", 9.5));
		BD.cerrarBD(con);
	}
}
