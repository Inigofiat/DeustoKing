package ventanas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
	static Logger logger = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {
		VentanaCargando vc= new VentanaCargando();
		try {
			logger.log(Level.INFO, "SE INICIA EL PROGRAMA DEUSTOKING");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
