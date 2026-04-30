package Ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibrosDAO {
	private static Connection conexion;
	public static int cambiarTematica(String tipo, int isbn) throws SQLException {
		int filasAfectadas;

		Statement sentencia = conexion.createStatement();
		filasAfectadas = sentencia.executeUpdate("UPDATE `libro` SET `Id_Tematica` = '("+tipo+")' WHERE `libro`.`Isbn` = '("+isbn +")'");
		
		return filasAfectadas;
	}
	public static ResultSet consultarLibros() throws SQLException {

		ResultSet resultadoQuery;
		Statement sentencia = conexion.createStatement();
		resultadoQuery = sentencia.executeQuery("select * from libro");
				
		return resultadoQuery;

	}
	public static int insertarLibro(int isbn, String editorial, String titulo, String idioma, String nombreAutor, int tipo)
			throws SQLException {

		int filasAfectadas;
		if (tipo >6) {
			throw new SQLException ("No existe esa tematica");
		}
		Statement sentencia = conexion.createStatement();
		filasAfectadas = sentencia.executeUpdate("INSERT INTO libro VALUES " + "(" + isbn + ", '" + editorial + "', '"
				+ titulo + "', '" + idioma + "','" + nombreAutor + "', '" + tipo + "')");
		//para hacer la lista de las tematicas debo hacer un select

		return filasAfectadas;
	}
	public static boolean eliminarLibro(int isbn) throws SQLException {
	    String sql = "DELETE FROM libro WHERE Isbn = ?";
	    
	    try (Connection con = DataBaseConection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {
	        
	        pstmt.setInt(1, isbn);
	        int filasAfectadas = pstmt.executeUpdate();
	        
	        // Retorna true si se eliminó al menos un registro
	        return filasAfectadas > 0;
	    }
	}
}
