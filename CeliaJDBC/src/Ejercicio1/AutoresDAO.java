package Ejercicio1;


import java.sql.*;


public class AutoresDAO {

    public static int insertarAutor(int id, String nombre, String nac, String fnac) throws SQLException {
        String sql = "INSERT INTO autor (Id_Autor, nombreAutor, Nacionalidad, Fnacimiento) VALUES (?, ?, ?, ?)";
        
        // Obtenemos la conexión de tu clase DataBaseConection
        try (Connection conection = DataBaseConection.getConnection();
             PreparedStatement pstmt = conection.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setString(3, nac);
            pstmt.setString(4, fnac);
            
            return pstmt.executeUpdate();
        }
    }

    public static ResultSet consultarAutores() throws SQLException {

		ResultSet resultadoQuery;
		Statement sentencia= GestionDB.getConexion().createStatement();
		resultadoQuery = sentencia.executeQuery("select * from autor");

		return resultadoQuery;
	}

	public static ResultSet consultarAutoresPorNombre(String nombre) throws SQLException{
		ResultSet resultadoQuery;
		Statement sentencia = GestionDB.getConexion().createStatement();
		resultadoQuery = sentencia.executeQuery("select * from autor WHERE nombreAutor LIKE '%" + nombre + "%'");

		return resultadoQuery;
		
	}
}