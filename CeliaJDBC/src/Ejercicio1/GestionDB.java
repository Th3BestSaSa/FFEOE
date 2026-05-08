package Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionDB {
	private static final String URL_BD = "jdbc:mysql://localhost:3306/libros";
	private static final String CONTRASENNA = "";
	private static final String USUARIO = "root";
	private static Connection conexion;

	public static void abrirConexion() throws SQLException {

		conexion = DriverManager.getConnection(URL_BD, USUARIO, CONTRASENNA);

	}

	public static void cerrarConexion() throws SQLException {

		conexion.close();

	}

	public static Connection getConexion() {
		return conexion;
	}
	
}
