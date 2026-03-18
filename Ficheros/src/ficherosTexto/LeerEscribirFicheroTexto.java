package ficherosTexto;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class LeerEscribirFicheroTexto {

	public static void main(String[] args) {

		escribirLog("ejemplo.txt", "Primer mensaje");
		escribirLog("ejemplo.txt", "Segundo mensaje");
		escribirLog("ejemplo.txt", "Tercer mensaje");
		escribirLog("ejemplo.txt", "Cuarto mensaje");

		leerArchivo("ejemplo.txt");
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

	
	public static void leerArchivo(String ruta) {
		String linea;
		Path path = Paths.get(ruta);

		// Uso de try-with-resources para cierre automático
		try (BufferedReader br = Files.newBufferedReader(path)) {

			while ((linea = br.readLine()) != null) {
				System.out.println("Procesando: " + linea);
			}
		} catch (NoSuchFileException e) {
			System.err.println("Error: El archivo no existe en la ruta especificada.");
		} catch (IOException e) {
			System.err.println("Error de lectura: " + e.getMessage());
		}
	}
}
