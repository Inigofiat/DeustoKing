package basesDeDatos;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import deustoking.Cliente;
import deustoking.Cupon;
import deustoking.Producto;
import deustoking.PuestoTrabajo;
import deustoking.Reserva;
import deustoking.TipoProducto;
import deustoking.Trabajador;


public class BD {
	
	/*** 
	 * Método que inicia la conexión 
	 * @param nombreBD deustoking.db
	 * @return devuelve la conexión
	 */
	
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
	
	/***
	 * Método que borra las tablas creadas
	 * @param con conexión de la base de datos
	 * @throws SQLException lanza una excepción en caso de que no se encuentre base de datos
	 */
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
	
	/***
	 * Método que crea las tablas de la base de datos
	 * @param conn la conexión de la base de datos
	 * @throws SQLException lanza una excepción en caso de no se encuentre la base de datos
	 */
	
	public static void crearTabla (Connection conn) throws SQLException{
		String sqlCliente = "CREATE TABLE IF NOT EXISTS Cliente (Nombre String, Apellidos String, Telefono String, Correo String, Direccion String, Id INTEGER PRIMARY KEY AUTOINCREMENT, PuntosAcumulados int, NombreUsuario String, Contrasenia String)";
		String sqlReserva = "CREATE TABLE IF NOT EXISTS Reserva (Nombre String, Telefono String, Correo String, IdentificadorReserva INTEGER PRIMARY KEY AUTOINCREMENT,Fecha String, Hora String, NumeroComensales int)";
		String sqlProducto = "CREATE TABLE IF NOT EXISTS Producto(IdentificadorProducto int, Nombre String, Descripcion String, Precio float, Cantidad int, Modificacion String, TipoProducto String, Imagen String, ListaProductos String)";
		String sqlTrabajador = "CREATE TABLE IF NOT EXISTS Trabajador(Nombre String, Apellidos String, Telefono String, Correo String, Direccion String, Id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "Sueldo float, NombreTrabajador String, Dni String, Puesto String)";
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
	
	/***
	 * Método que inserta los clientes a la base de datos
	 * @param con la conexión de la base de datos
	 * @param cliente que se inserta en la base de datos
	 */
	
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
		
		/***
		 * Método que inserta los trabajadores en la base de datos
		 * @param con conexión de la base de datos
		 * @param t trabajador que se inserta a la base de datos
		 */
		
		public static void insertarTrabajador(Connection con, Trabajador t){
			
			if(buscarCliente(con,t.getDni())==null){
				String sql = String.format("INSERT INTO Trabajador(Nombre, Apellidos, Telefono, Correo, Direccion,Sueldo, NombreTrabajador, Dni, Puesto) VALUES('%s','%s','%s','%s','%s','%f','%s', '%s', '%s')", 
						t.getNombre(), t.getApellidos(),t.getTelefono(),t.getCorreo(),t.getDireccion(),t.getSueldo(),t.getNombreTrabajador(),t.getDni(),t.getPuesto());
				try {
					Statement st = con.createStatement();
					st.executeUpdate(sql);
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	/***
	 * Método que inserta las reservas a la base de datos
	 * @param con la conexión de la base de datos
	 * @param reserva que se inserta a la base de datos
	 */
	
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
	
	/***
	 * Método que inserta los cupones a la base de datos
	 * @param con conexión de la base de datos
	 * @param cupon que se inserta a la base de datos
	 */
	
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
	
	/***
	 * Método que añade un producto a la base de datos.
	 * @param con Conexión de la base de datos
	 * @param p producto que se añade a la base de datos
	 */
	
	public static void insertarProducto(Connection con, Producto p) {
		if(buscarProducto(con, p.getIdP())==null) {
			String lista = "";
			if(p.getListaProductos()!=null) {
				for(Producto pr: p.getListaProductos()) {
					lista = lista + pr.getIdP() + ":";
				}
			}
			try {
				PreparedStatement pst = con.prepareStatement("INSERT INTO Producto VALUES(?,?,?,?,?,?,?,?,?)");
				pst.setInt(1, p.getIdP());
				pst.setString(2, p.getNombre());
				pst.setString(3, p.getDescripcion());
				pst.setFloat(4, p.getPrecio());
				pst.setInt(5, p.getCantidad());
				pst.setString(6,p.getModificacion());
				pst.setString(7,p.getTipoProducto().toString());
				pst.setString(8,p.getImagen());
				pst.setString(9,lista);
				pst.executeUpdate();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/***
	 * Método que busca el cliente en la base de datos
	 * @param con Conexión de la base de datos
	 * @param telefono parametro que se le pasa para buscar un cliente
	 * @return devuelve el cliente 
	 */

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
	
	/***
	 * Método que busca el trabajador en la base de datos por DNI
	 * @param con la conexion de la base de datos
	 * @param dni parametro que se le pasa para buscar un trabajador
	 * @return devuelve el trabajador
	 */
	
	public static Trabajador buscarTrabajador(Connection con, String dni) {
		String sql = String.format("SELECT * FROM Cliente WHERE Dni = '%s'", dni);
		Trabajador trabajador= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");
				String telefono = rs.getString("Telefono");
				String correo = rs.getString("Correo");
				String direccion = rs.getString("Direccion");
				int id = Integer.parseInt(rs.getString("Id"));
				float sueldo = rs.getFloat("Sueldo");
				String nombreTrabajador= rs.getString("NombreUsuario");
				String dniS = rs.getString("Dni");
				PuestoTrabajo puesto = PuestoTrabajo.valueOf(rs.getString("Puesto"));
				trabajador = new Trabajador(nombre, apellidos, telefono, correo, direccion, id, sueldo, nombreTrabajador, dniS, puesto);
				
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trabajador;
	}
	
	/***
	 * Método que busca los productos por id en la base de datos
	 * @param con conexión de la base de datos
	 * @param id parametro con el que se van a buscar los productos
	 * @return devuelve el producto
	 */
	
	public static Producto buscarProducto(Connection con, int id) {
		String sql = String.format("SELECT * FROM Producto WHERE IdentificadorProducto = %d",id);
		Producto producto= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				int idP= rs.getInt("IdentificadorProducto");
				String nombre = rs.getString("Nombre");
				String descripcion = rs.getString("Descripcion");
				float precio = rs.getFloat("Precio");
				int cantidad = rs.getInt("Cantidad");
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
	
	/***
	 * Método que busca la reserva en la base de datos por teléfono 
	 * @param con conexión de la base de datos
	 * @param telefono parametro con el que se va a buscar la reserva
	 * @return devuelve la reserva
	 */
	
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
	
	
	/***
	 * Método que busca los cupones en la base de datos
	 * @param con conexión de la base de datos
	 * @param foto para buscar el cupón con dicha foto
	 * @return devuelve el cupón
	 */
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
	
	/***
	 * Método que obtiene la lista de clientes de la base de datos
	 * @param con conexión de la base de datos
	 * @return devuelve la lista de clientes
	 */
	
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
	
	/***
	 * Método que obtiene la lista de los productos de la base de datos
	 * @param con conexión de la base de datos
	 * @return devuelve la lista de los productos
	 */
	
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
	
	/***
	 * Método que cierra la base de datos
	 * @param con conexión de la base de datos
	 */
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
