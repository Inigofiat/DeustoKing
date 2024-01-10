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
	public static String nombreBD, nombreAplicacion, fechaCreacion;
	public static void main(String[] args) {
		VentanaCargando vc= new VentanaCargando();
		Properties properties = new Properties();
		try {
			logger.log(Level.INFO, "SE INICIA EL PROGRAMA DEUSTOKING");
		} catch (Exception e) {
			logger.log(Level.WARNING, "NO SE HA PODIDO CARGAR LA VENTANA CARGANDO");	
		}
		
		Connection con = BD.initBD(nombreBD);
		try {
			BD.crearTabla(con);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Restaurante.volcarCSVPersonasABD(con, "ficheros/Clientes.csv");
		Restaurante.volcarCSVReservasABD(con, "ficheros/reservas.csv");
		Restaurante.volcarCSVCuponesABD(con, "ficheros/Cupones.csv");
		Restaurante.cargarCupones();
		
		BD.cerrarBD(con);
		
		
		try {
			properties.load(new FileReader("conf/config.properties"));
			nombreBD = properties.getProperty("nombreBD");
			nombreAplicacion = properties.getProperty("nombreAplicacion");
			fechaCreacion = properties.getProperty("fechaCreacion");
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO");
		} catch (IOException e) {
			logger.log(Level.WARNING, "SE HA INTERRUMPIDO LA OPERACIÓN DE CARGA DEL FICHERO PROPERTIES");	
			
		}
	}
}
