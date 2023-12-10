package baseDeDatos;

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
import deustoking.Producto;
import deustoking.Reserva;


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
	
	public static void crearTabla (Connection conn) throws SQLException{
		String sqlCliente = "CREATE TABLE IF NOT EXISTS Cliente (Nombre String, Apellidos String, Teléfono String, Correo String, Dirección String, Id int, PuntosAcumulados int, NombreUsuario String, Contraseña String)";
		String sqlReserva = "CREATE TABLE IF NOT EXISTS Reserva (IdentificadorReserva int,Fecha Date, Hora String, NúmeroComensales int)";
		String sqlProducto = "CREATE TABLE IF NOT EXISTS Producto(IdentificadorProducto int, Nombre String, Descripción String, Precio double)";
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sqlCliente);
			st.execute(sqlReserva);
			st.execute(sqlProducto);
			st.close();
			
		} catch (SQLException e) {
			throw e;
		}
	}
	
		public static void insertarCliente(Connection con, Cliente cliente){
			
			if(buscarCliente(con,cliente.getTelefono())==null){
				String sql = String.format("INSERT INTO Cliente VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s')", cliente.getNombre(), cliente.getApellidos(), cliente.getTelefono(),
						cliente.getCorreo(),cliente.getDireccion(),cliente.getId(),cliente.getPuntosAcumulados(), cliente.getNombreUsuario(), cliente.getContrasenia());
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
		if(buscarReserva(con, reserva.getId())==null) {
			String sql = String.format("INSERT INTO Reserva VALUES('%s','%s','%s','%s')", reserva.getId(), reserva.getFecha(), reserva.getHora(), reserva.getnComensales());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insertarProducto(Connection con, Producto producto) {
		if(buscarReserva(con, producto.getIdP())==null) {
			String sql = String.format("INSERT INTO Producto VALUES('%s','%s','%s','%s')", producto.getIdP(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Cliente buscarCliente(Connection con, String telefono) {
		String sql = String.format("SELECT * FROM Cliente WHERE Teléfono = '%s'", telefono);
		Cliente cliente= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");
				String telefonoS = rs.getString("Teléfono");
				String correo = rs.getString("Correo");
				String direccion = rs.getString("Dirección");
				int id = Integer.parseInt(rs.getString("Id"));
				int puntosAcumulados = Integer.parseInt(rs.getString("PuntosAcumulados"));
				String nombreUsuario = rs.getString("NombreUsuario");
				String contrasenia = rs.getString("Contraseña");
				
				cliente = new Cliente(nombre, apellidos, telefonoS, correo, direccion, id, puntosAcumulados, nombreUsuario, contrasenia);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	public static Reserva buscarReserva(Connection con, int id ) {
		String sql = String.format("SELECT * FROM Reserva WHERE IdentificadorReserva = '%s'", id);
		Reserva reserva=null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				int idS = Integer.parseInt(rs.getString("IdentificadorReserva"));
				String fecha = rs.getString("Fecha");
				String hora = rs.getString("Hora");
				int nComensales =Integer.parseInt(rs.getString("NúmeroComensales"));
				reserva = new Reserva(idS, fecha, hora, nComensales);
				
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserva;
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
				String telefonoS = rs.getString("Teléfono");
				String correo = rs.getString("Correo");
				String direccion = rs.getString("Dirección");
				int id = Integer.parseInt(rs.getString("Id"));
				int puntosAcumulados = Integer.parseInt(rs.getString("PuntosAcumulados"));
				String nombreUsuario = rs.getString("NombreUsuario");
				String contrasenia = rs.getString("Contraseña");
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
				String descripcion = rs.getString("Descripción");
				double precio = Double.parseDouble(rs.getString("Precio"));
				Producto producto = new Producto(id, nombre, descripcion, precio);
				lp.add(producto);
				
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
