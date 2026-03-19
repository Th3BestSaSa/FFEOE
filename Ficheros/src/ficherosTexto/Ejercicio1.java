package ficherosTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio1 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println("NOMBRE CARPETA");
		String nombreCarpeta = teclado.nextLine();
		System.out.println("NOMBRE ARCHIVO");
		String nombreArchivo = teclado.nextLine();
		Path ruta = Paths.get(nombreCarpeta, nombreArchivo);
		contadorPalabrasPorLinea(ruta);
		System.out.println("Introduce una palabra para buscarla");
		String palabra = teclado.nextLine();

		String sb = buscarPalabra(palabra, ruta);
		System.out.println(sb);
		escribirLog("buscarTexto"+palabra+".txt", sb);
	}

public static void escribirLog(String ruta, String mensaje) {
		
	    Path path = Paths.get(ruta);
	    // StandardOpenOption.CREATE: Crea el archivo si no existe
	    // StandardOpenOption.APPEND: Añade al final sin sobrescribir
	    try (BufferedWriter bw = Files.newBufferedWriter(path, 
	            StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
	        
	        bw.write("[INFO] " + java.time.LocalDateTime.now() + " - " + mensaje);
	        bw.newLine(); // Salto de línea independiente del Sistema Operativo
	        
	    } catch (IOException e) {
	        System.err.println("No se pudo escribir en el archivo.");
	    }
	}
	private static String buscarPalabra(String palabra, Path ruta) {
		String linea;
		// CORRECCIÓN 1: Inicializar el StringBuilder en lugar de dejarlo en null
		StringBuilder sb = new StringBuilder();

		try (BufferedReader br = Files.newBufferedReader(ruta)) {
			int contadorGlobal = 0;
			int numeroLinea = 0; // Para rastrear en qué línea estamos

			while ((linea = br.readLine()) != null) {
				numeroLinea++;
				String[] palabrasEnLinea = linea.split(" "); // Mejorado: corta por cualquier espacio en blanco

				for (int i = 0; i < palabrasEnLinea.length; i++) {
					if (palabrasEnLinea[i].equalsIgnoreCase(palabra)) { // CORRECCIÓN 2: Ignorar mayúsculas/minúsculas suele ser mejor
						contadorGlobal++;
						// CORRECCIÓN 3: Guardar info relevante en el StringBuilder
						sb.append("Encontrada en línea ").append(numeroLinea).append("\n");
					}
				}
			}

			System.out.println("Total de veces encontrada: " + contadorGlobal);

		} catch (NoSuchFileException e) {
			System.err.println("Error: El archivo no existe.");
		} catch (IOException e) {
			System.err.println("Error de lectura: " + e.getMessage());
		}

		return sb.toString();
	}

	private static void contadorPalabrasPorLinea(Path ruta) {
		if (Files.notExists(ruta)) {
			System.out.println("El archivo no existe.");
		}
		String linea;
		// Uso de try-with-resources para cierre automático
		try (BufferedReader br = Files.newBufferedReader(ruta)) {

			while ((linea = br.readLine()) != null) {
				String[] s = linea.split(" ");
				System.out.println("Procesando: " + s.length);
			}
		} catch (NoSuchFileException e) {
			System.err.println("Error: El archivo no existe en la ruta especificada.");
		} catch (IOException e) {
			System.err.println("Error de lectura: " + e.getMessage());
		}
	}

}
