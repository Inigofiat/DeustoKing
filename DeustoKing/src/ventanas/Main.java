package ventanas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import basesDeDatos.BD;
import deustoking.Restaurante;

public class Main {
	public static Logger logger = Logger.getLogger(Main.class.getName());
	public static String nombreBD,nombreAplicacion,fechaCreacion, nombreFicheroClientes, nombreFicheroReservas, nombreFicheroTrabajadores, nombreFicheroProductos, nombreFicheroCupones;
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		VentanaCargando vc= new VentanaCargando();
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader("conf/config.properties"));
			nombreBD = properties.getProperty("nombreBD");
			nombreAplicacion = properties.getProperty("nombreAplicacion");
			fechaCreacion = properties.getProperty("fechaCreacion");
			nombreFicheroClientes = properties.getProperty("nombreFicheroClientes");
			nombreFicheroProductos =  properties.getProperty("nombreFicheroProductos");
			nombreFicheroCupones =  properties.getProperty("nombreFicheroCupones");
			nombreFicheroTrabajadores =  properties.getProperty("nombreFicheroTrabajadores");
			nombreFicheroReservas =  properties.getProperty("nombreFicheroReservas");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO EL ARCHIVO");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			logger.log(Level.INFO, "SE INICIA EL PROGRAMA DEUSTOKING");
		} catch (Exception e) {

			e.printStackTrace();
		}
		Connection con = BD.initBD(nombreBD);
		try {
			BD.borrarTabla(con);
			BD.crearTabla(con);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Restaurante.volcarCSVPersonasABD(con, nombreFicheroClientes);
		Restaurante.volcarCSVReservasABD(con, nombreFicheroReservas);
		Restaurante.cargarCupones();
		Restaurante.volcarCSVProductosABD(con, nombreFicheroProductos);
		Restaurante.volcarCSVCuponesABD(con, nombreFicheroCupones);
		Restaurante.volcarCSVCTrabajadorABD(con, nombreFicheroTrabajadores);
		
	
		BD.cerrarBD(con);
		Restaurante.cargarProductosEnLista(nombreFicheroProductos);		
	}
}
