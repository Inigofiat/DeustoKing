package basesDeDatos;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import deustoking.Cliente;
import deustoking.Cupon;
import deustoking.Producto;
import deustoking.Reserva;
import deustoking.TipoProducto;


public class BD {
	
	public static Connection initBD(String nombreBD) {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:datos/" + nombreBD);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
		
	}
	
	public static void borrarTabla(Connection con) throws SQLException{
		String sqlCliente = "DROP TABLE IF EXISTS Cliente";
		String sqlReserva= "DROP TABLE IF EXISTS Reserva";
		String sqlProducto= "DROP TABLE IF EXISTS Producto";
		String sqlTrabajador= "DROP TABLE IF EXISTS Trabajador";
		String sqlCupon= "DROP TABLE IF EXISTS Cupon";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sqlCliente);
			st.executeUpdate(sqlReserva);
			st.executeUpdate(sqlProducto);
			st.executeUpdate(sqlTrabajador);
			st.executeUpdate(sqlCupon);
			
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static void crearTabla (Connection conn) throws SQLException{
		String sqlCliente = "CREATE TABLE IF NOT EXISTS Cliente (Nombre String, Apellidos String, Telefono String, Correo String, Direccion String, Id INTEGER PRIMARY KEY AUTOINCREMENT, PuntosAcumulados int, NombreUsuario String, Contrasenia String)";
		String sqlReserva = "CREATE TABLE IF NOT EXISTS Reserva (Nombre String, Telefono String, Correo String, IdentificadorReserva INTEGER PRIMARY KEY AUTOINCREMENT,Fecha String, Hora String, NumeroComensales int)";
		String sqlProducto = "CREATE TABLE IF NOT EXISTS Producto(IdentificadorProducto int, Nombre String, Descripcion String, Precio float, Cantidad int, Modificacion String, TipoProducto String, Imagen String, ListaProductos String)";
		String sqlTrabajador = "CREATE TABLE IF NOT EXISTS Trabajador(Nombre String, Apellidos String, Telefono String, Correo String, Direccion String, Id INTEGER PRIMARY KEY AUTOINCREMENT, HorasTrabajadas float,"
				+ "Sueldo float, NombreTrabajador String, Contrasenia String, Dni String, Puesto String)";
		String sqlCupon = "CREATE TABLE IF NOT EXISTS Cupon(MinPuntos Int, Descuento double, Foto String, Nombre String)";
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sqlCliente);
			st.executeUpdate(sqlReserva);
			st.executeUpdate(sqlProducto);
			st.executeUpdate(sqlTrabajador);
			st.execute(sqlCupon);
			st.close();
			
		} catch (SQLException e) {
			throw e;
		}
	}
	
		public static void insertarCliente(Connection con, Cliente cliente){
			
			if(buscarCliente(con,cliente.getTelefono())==null){
				String sql = String.format("INSERT INTO Cliente(Nombre,Apellidos,Telefono,Correo,Direccion,PuntosAcumulados,NombreUsuario,Contrasenia) VALUES('%s','%s','%s','%s','%s','%d','%s','%s')", cliente.getNombre(),
						cliente.getApellidos(), cliente.getTelefono(),cliente.getCorreo(), cliente.getDireccion(), cliente.getPuntosAcumulados() , cliente.getNombreUsuario(),cliente.getContrasenia());
				try {
					Statement st = con.createStatement();
					st.executeUpdate(sql);
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	public static void insertarReserva(Connection con, Reserva reserva) {
		if(buscarReserva(con, reserva.getTelefono())==null) {
			String sql = String.format("INSERT INTO Reserva (Nombre, Telefono,Correo,Fecha,Hora,NumeroComensales)VALUES('%s','%s','%s','%s','%s','%d')", reserva.getNombre(),reserva.getTelefono(),reserva.getCorreo(),
					reserva.getFechaStr(),reserva.getHora(),reserva.getnComensales());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insertarCupon(Connection con, Cupon cupon) {
		if(buscarCupon(con, cupon.getFoto())==null) {
			String sql = String.format("INSERT INTO Cupon(MinPuntos,Descuento,Foto,Nombre)VALUES('%d','%f', '%s','%s')", cupon.getMinPuntos(),cupon.getDescuento(),cupon.getFoto(),cupon.getDescripcion());
			
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	

	public static Cliente buscarCliente(Connection con, String telefono) {
		String sql = String.format("SELECT * FROM Cliente WHERE Telefono = '%s'", telefono);
		Cliente cliente= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");
				String telefonoS = rs.getString("Telefono");
				String correo = rs.getString("Correo");
				String direccion = rs.getString("Direccion");
				int id = Integer.parseInt(rs.getString("Id"));
				int puntosAcumulados = Integer.parseInt(rs.getString("PuntosAcumulados"));
				String nombreUsuario = rs.getString("NombreUsuario");
				String contrasenia = rs.getString("Contrasenia");
				
				cliente = new Cliente(nombre, apellidos, telefonoS, correo, direccion, id, puntosAcumulados, nombreUsuario, contrasenia);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	public static Producto buscarProducto(Connection con, int id) {
		String sql = String.format("SELECT * FROM Producto WHERE IdentificadorProducto = '%d'",id);
		Producto producto= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				int idP= rs.getInt(rs.getString("IdentificadorProducto"));
				String nombre = rs.getString("Nombre");
				String descripcion = rs.getString("Descripcion");
				float precio = rs.getFloat(rs.getString("Precio"));
				int cantidad = rs.getInt(rs.getString("Cantidad"));
				TipoProducto tipo = TipoProducto.valueOf(rs.getString("TipoProducto"));
				String imagen = rs.getString("Imagen");
				List<Producto> productos = new ArrayList<>();
				for (Producto p : productos) {
					int idPr = rs.getInt("IdentificadorProducto");
					if(p.getIdP()==idPr) {
						productos.add(p);
					}
					
				}
			
				
				producto = new Producto(idP, nombre, descripcion, precio, cantidad, descripcion, tipo, imagen, productos);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}
	
	public static Reserva buscarReserva(Connection con, String telefono ) {
		String sql = String.format("SELECT * FROM Reserva WHERE Telefono = '%s'", telefono);
		Reserva reserva=null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				int id = Integer.parseInt(rs.getString("IdentificadorReserva"));
				String fecha = rs.getString("Fecha");
				String hora = rs.getString("Hora");
				int nComensales =Integer.parseInt(rs.getString("NumeroComensales"));
				String nombre = rs.getString("Nombre");
				String telefonoS = rs.getString("Telefono");
				String correo = rs.getString("Correo");
				reserva = new Reserva(id, nombre, telefonoS, correo, fecha, hora, nComensales);
				
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserva;
	}
	
	public static Cupon buscarCupon(Connection con, String foto) {
		String sql = String.format("SELECT * FROM Cupon WHERE Foto ='%s'", foto);
		Cupon cupon = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				int minPuntos = Integer.parseInt(rs.getString("MinPuntos"));
				String descuentoString = rs.getString("Descuento").replace(",", ".");
	            double descuento = Double.parseDouble(descuentoString);
				String fotoS = rs.getString("Foto");
				String nombre = rs.getString("Nombre");
				cupon = new Cupon(minPuntos, descuento, fotoS, nombre);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cupon;
		
	}
	
	public static List<Cliente> obtenerListaClientes(Connection con){
		String sql = "SELECT * FROM Cliente";
		List<Cliente> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");
				String telefonoS = rs.getString("Telefono");
				String correo = rs.getString("Correo");
				String direccion = rs.getString("Direccion");
				int id = Integer.parseInt(rs.getString("Id"));
				int puntosAcumulados = Integer.parseInt(rs.getString("PuntosAcumulados"));
				String nombreUsuario = rs.getString("NombreUsuario");
				String contrasenia = rs.getString("Contrasenia");
				Cliente cliente = new Cliente(nombre, apellidos, telefonoS, correo, direccion, id, puntosAcumulados, nombreUsuario, contrasenia);
				l.add(cliente);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return l;
	}
	
	public static List<Producto> obtenerListaProductos(Connection con){
		String sql = "SELECT * FROM Producto";
		List<Producto> lp = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString("IdentificadorProducto"));
				String nombre = rs.getString("Nombre");
				String descripcion = rs.getString("Descripcion");
				float precio = Float.parseFloat(rs.getString("Precio"));
				int cantidad = Integer.parseInt(rs.getString("Cantidad"));
				String modificacion = rs.getString("Modificacion");
				TipoProducto tipo = TipoProducto.valueOf(rs.getString("TipoProducto"));
				String imagen = rs.getString("Imagen");
				Producto p = new Producto(id, nombre, descripcion, precio, cantidad, modificacion, tipo, imagen, null);
				lp.add(p);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lp;
		
	}
	public static void cerrarBD(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
