import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploInsert {

	
	private static final String URL_BD = "jdbc:mysql://localhost:3306/libros";
	private static final String CONTRASENNA = "";
	private static final String USUARIO = "root";
	


	public static void main(String[] args) {

		try (Connection conexion = DriverManager.getConnection(URL_BD, USUARIO, CONTRASENNA);
				Statement sentencia = conexion.createStatement();) {

			int numeroAct = sentencia
					.executeUpdate("INSERT INTO Autor VALUES  " + "(999, 'Otro', 'Britanica', '1990-09-15')");

			System.out.println(numeroAct);
			System.out.println("OPERACION REALIZADA CORRECTAMENTE");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
