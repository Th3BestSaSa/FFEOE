package Ejercicio1;

import java.sql.*;
import java.util.Scanner;


public class Main {

	private static String nombre;
private static Scanner teclado= new Scanner(System.in);
	public static void main(String[] args) {

		int opcion;
		try {
			GestionDB.abrirConexion();
			do {
				opcion = mostrarMenu();
				tratarMenu(opcion);
			} while (opcion != 7);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int mostrarMenu() {
		int opcion;
		System.out.println("\n---Menu---");
		System.out.println("1. Insertar autor");
		System.out.println("2. Insertar libro");
		System.out.println("3. Consultar todos los autores");
		System.out.println("4. Consultar todos los libros");
		System.out.println("5. Modificar la temática de un libro");
		System.out.println("6. Eliminar libro");
		System.out.println("7. Salir \n");
		opcion =solicitarEnteroEnRango("Introduce la opción a elegir", 1, 7);
		return opcion;
	}

	

	public static void tratarMenu(int opcion) {

		try {
			switch (opcion) {
			case 1:
				insertarAutor();
				break;
			case 2:
				insertarLibro();
				break;
			case 3:
				consultaAutores();
				break;
			case 4:
				consultaLibros();
				break;
			case 5:
				cambiarTipo();
				break;
			case 6:
				eliminarLibro();
				
				break;
			case 7:
				cerrarConexion();
				break;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void eliminarLibro() throws SQLException {
		ResultSet resultadoQueryLibros =  LibrosDAO.consultarLibros();
		int isbn;
		
			isbn =solicitarEnteroPositivo("Introduce el isbn del libro que quieres");
			 LibrosDAO.eliminarLibro(isbn);
			System.out.println("Libro eliminado");
		}
	
	// controlar el error 
	private static void cambiarTipo() throws SQLException {
		ResultSet resultadoQueryLibros =  LibrosDAO.consultarLibros();
		int isbn;
		
		while (resultadoQueryLibros.next()) {
			System.out.println("Isbn: " + resultadoQueryLibros.getInt("Isbn"));
			System.out.println("Tipo: " + resultadoQueryLibros.getString("Tipo") + "\n");
			
			isbn = solicitarEnteroPositivo("Introduce el isbn del libro que quieres");
		}
	}

	

	private static void cerrarConexion() throws SQLException {
		System.out.println("Cerrando conexion...");
		GestionDB.cerrarConexion();
	}

	private static void consultaLibros() throws SQLException {
		ResultSet resultadoQueryLibros = LibrosDAO.consultarLibros();
	//	ResultSet sentencia = GestionBD.consultarLibros();
		
		while (resultadoQueryLibros.next()) {
			System.out.println("Isbn: " + resultadoQueryLibros.getInt("Isbn"));
			System.out.println("Editorial: " + resultadoQueryLibros.getString("Editorial"));
			System.out.println("Titulo: " + resultadoQueryLibros.getString("Titulo"));
			System.out.println("Idioma: " + resultadoQueryLibros.getString("Idioma"));
			System.out.println("Nombre del autor: " + resultadoQueryLibros.getString("nombreAutor"));
		int id_tema = resultadoQueryLibros.getInt("Id_Tematica");
		//String nombreTematica = sentencia.executeQuery("select Nombre from Tematica WHERE Id_Tematica =" + id_tema);
	}
	}
	private static void consultaAutores() throws SQLException {
		ResultSet resultadoQueryAutores = AutoresDAO.consultarAutores();

		while (resultadoQueryAutores.next()) {
			System.out.print("Id autor:" + resultadoQueryAutores.getInt("Id_Autor"));
			System.out.print(" N5ombre Autor:" + resultadoQueryAutores.getString("nombreAutor"));
			System.out.print(" Nacionalidad:" + resultadoQueryAutores.getString("Nacionalidad"));
			System.out.println(" Fecha de nacimiento:" + resultadoQueryAutores.getDate("FNacimiento"));
		}

		resultadoQueryAutores.close();
	}

	private static void insertarLibro() throws SQLException {
		int isbn,tipo;
		String editorial, titulo, idioma, nombre;

		isbn = solicitarEnteroPositivo("Introduce el Isbn del libro");
		editorial = solicitarCadena("Introduce la editorial del libro");
		titulo = solicitarCadena("Introduce el titulo del libro");
		idioma = solicitarCadena("Introduce el idioma del libro");
		nombre= solicitarCadena("Introduce el nombre del autor del libro");
		tipo = solicitarEnteroPositivo("Introduce el tipo del libro");

		ResultSet resultadoQueryAutoresPorNombre = AutoresDAO.consultarAutoresPorNombre(nombre);

		System.out.println("Autores: ");
		while (resultadoQueryAutoresPorNombre.next()) {
			System.out.print("Nombre del autor:" + resultadoQueryAutoresPorNombre.getString("nombreAutor"));
		}

		resultadoQueryAutoresPorNombre.close();

		LibrosDAO.insertarLibro(isbn, editorial, titulo, idioma, nombre, tipo);

		System.out.println("Se ha agregado correctamente el libro");
	}

	

	private static void insertarAutor() throws SQLException {
		int Id_Autor;
		String nombreAutor;
		String nacionalidad;
		String fechaNacimiento;
	
		Id_Autor=solicitarEnteroPositivo("Introduce el id del autor");
		nombre = solicitarCadena("Introduce el nombre del autor: ");
		nacionalidad = solicitarCadena("Introduce la nacionalidad del autor: ");
		fechaNacimiento = solicitarCadena("Introduce la fecha de nacimiento del autor (AAAA-MM-DD): ");
		AutoresDAO.insertarAutor(Id_Autor,nombre, nacionalidad, fechaNacimiento);
		System.out.println("Se ha agregado correctamente el autor");
	}
	 public static int solicitarEnteroEnRango(String mensaje, int min, int max) {

	        int num;

	        do {
	            System.out.print(mensaje + ": ");
	            num = Integer.teclado.nextLine();

	            if (num < min || num > max) {
	                System.out.println("Error. Debe estar entre " + min + " y " + max);
	            }

	        } while (num < min || num > max);

	        return num;
	    }

	    public static String solicitarCadena(String mensaje) {

	        System.out.print(mensaje + ": ");
	        teclado.nextLine(); // limpiar buffer
	        return teclado.nextLine();
	    }

	    public static int solicitarEnteroPositivo(String mensaje) {

	        int num;

	        do {
	            System.out.print(mensaje + ": ");
	            num = teclado.nextInt();

	            if (num <= 0) {
	                System.out.println("Error. Debe ser positivo.");
	            }

	        } while (num <= 0);

	        return num;
	    }
}
