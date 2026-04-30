package Ejercicio1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConection {
	private static Connection connection = null;
// Datos de configuración (Idealmente irían en un .properties)
	private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
	private static final String USER = "root";
	private static final String PASS = "password";

// Constructor privado para evitar instanciación externa
	private DataBaseConection() {
	}

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
// En versiones modernas de Java, Class.forName no es obligatorio
// pero se suele incluir por compatibilidad con drivers antiguos.
			connection = DriverManager.getConnection(URL, USER, PASS);
		}
		return connection;
	}
}