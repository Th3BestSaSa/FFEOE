import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class EjercicioPractica1 {
	private static Scanner teclado = new Scanner(System.in);
	private static final String URL_BD = "jdbc:mysql://localhost:3306/libros";
	private static final String CONTRASENNA = "";
	private static final String USUARIO = "root";
	

	public static void main(String[] args)  {

		try (Connection conexion = DriverManager.getConnection(URL_BD, USUARIO, CONTRASENNA);
				Statement sentencia = conexion.createStatement();) {
			int Id_Autor;
			String nombre;
			String nacionalidad;
			String fechaNacimiento;
		
			Id_Autor=solicitarEntero("Introduce el id del autor");
			nombre =solicitarCadena("Introduce el nombre del autor: ");
			nacionalidad = solicitarCadena("Introduce la nacionalidad del autor: ");
			fechaNacimiento =solicitarCadena("Introduce la fecha de nacimiento del autor (AAAA-MM-DD): ");
			
			int numeroAct = sentencia
					.executeUpdate("INSERT INTO Autor VALUES (" + Id_Autor + ", '" + nombre + "', '" + nacionalidad + "', '" + fechaNacimiento + "')");

			System.out.println(numeroAct);
			System.out.println("OPERACION REALIZADA CORRECTAMENTE");
	}catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	}
	private static String solicitarCadena(String mensaje) {
	    System.out.print(mensaje);
	    return teclado.nextLine();
	}

	private static int solicitarEntero(String mensaje) {
	    System.out.print(mensaje);
	    return Integer.parseInt(teclado.nextLine());
	}
	
}
