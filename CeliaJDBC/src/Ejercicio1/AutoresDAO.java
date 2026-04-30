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

    public static void consultarAutores() throws SQLException {
        String sql = "SELECT * FROM autor";
        
        try (Connection con = DataBaseConection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id_Autor") + " - Nombre: " + rs.getString("nombreAutor"));
            }
        }
    }
}