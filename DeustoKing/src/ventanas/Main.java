package ventanas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
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
		Restaurante.volcarCSVPersonasABD(con, "ficheros/Clientes.csv");
		Restaurante.volcarCSVReservasABD(con, "ficheros/reservas.csv");
		
		BD.cerrarBD(con);
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader("conf/config.properties"));
			String nombreBD = properties.getProperty("nombreBD");
			String nombreAplicacion = properties.getProperty("nombreAplicacion");
			String fechaCreacion = properties.getProperty("fechaCreacion");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO EL ARCHIVO");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
