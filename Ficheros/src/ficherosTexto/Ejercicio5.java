package ficherosTexto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio5 {
	private static final String PATRON_CADENA = "^F [A-z]{3,}\\.[A-z]{3}$";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 private static void procesarArchivo(Path inputFile, List<String> lineasAnonimizadas, int totalLineas, int errorLineas) {
	        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	            	totalLineas++;
	                if (!validarLinea(linea)) {
	                   errorLineas++;
	                }
String linea= "";
	            }
	        } catch (IOException e) {
	            System.err.println("Error al procesar el archivo: " + e.getMessage());
	        }
	    }
	 private static boolean validarLinea(String linea) {
	        return linea.matches(PATRON_CADENA);
	    }
}
