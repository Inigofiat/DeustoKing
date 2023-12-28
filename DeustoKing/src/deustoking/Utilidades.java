package deustoking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {
	
public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/***
	 * Este método convierte de un Date a String
	 * 
	 * @param d Date, la fehca
	 * @return devuelve la fecha en formato String
	 */
	public static String dateToString(Date d) {
		return sdf.format(d);
	}
	
	/***
	 * Este método convierte un String a Date
	 * 
	 * @param s String
	 * @return devuelve el String en formato Date
	 */
	
	public static Date stringToDate(String s) {
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			return new Date(0); 
		}
	}

}
