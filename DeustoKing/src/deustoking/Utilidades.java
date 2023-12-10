package deustoking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {
	
public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public static String dateToString(Date d) {
		return sdf.format(d);
	}
	
	public static Date stringToDate(String s) {
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			return new Date(0); 
		}
	}

}
