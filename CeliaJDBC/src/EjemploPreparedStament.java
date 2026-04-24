import java.sql.*;
import java.util.Scanner;

public class EjemploPreparedStament {

	private static final String URL_BD = "jdbc:mysql://localhost:3306/libros";
	private static final String CONTRASENNA = "";
	private static final String USUARIO = "root";
	

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		try (Connection conexion = DriverManager.getConnection(URL_BD, USUARIO, CONTRASENNA);) {

			String nombreAutor = solicitarCadena("Introduce nombre de un autor:"); // nombre autor
			String nac = solicitarCadena("Introduce nacionalidad"); // nacionalidad autor
			String fnacAutor = solicitarCadena("Introduce fecha de nacimiento del autor(aaaa-mm-dd):"); // fecha
																										// nacimiento
																										// autor

			insertarAutor(conexion, nombreAutor, nac, fnacAutor);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void insertarAutor(Connection conexion, String nombreAutor, String nac, String fnacAutor) {
		int filasAfectadas;

		// construir orden INSERT
		String sql = " INSERT INTO Autor (Nombre, Nacionalidad, FNacimiento) VALUES (?, ?, ?)";
		System.out.println(sql);

		// Preparamos la sentencia
		try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {

			// Mediante los metodos setter del objeto PreparedStatement establecemos los
			// valores a enviar a la BD.
			sentencia.setString(1, nombreAutor);
			sentencia.setString(2, nac);

			// Convertir el String fnacAutor con la fecha de nacimiento del autor en un
			// objeto java.sql.Date para poder introducirlo en la BD.
			java.sql.Date fechaNacimiento = null;

			fechaNacimiento = java.sql.Date.valueOf(fnacAutor);

			// Mediante los metodos setter del objeto PreparedStatement establecemos los
			// valores a enviar a la BD.
			sentencia.setDate(3, fechaNacimiento);

			filasAfectadas = sentencia.executeUpdate();
			System.out.println("Filas afectadas: " + filasAfectadas);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private static String solicitarCadena(String msg) {
		String cadena;
		System.out.println(msg);
		cadena = teclado.nextLine();
		return cadena;
	}

}
