package ficherosTexto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio5 {
	private static final String PATRON_CADENA = "^F [A-z]{3,}\\.[A-z]{3}$";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path inputFile = Paths.get("documentos", "EjemploEjer5Correcto.txt");
		procesarArchivo(inputFile);
	}
	 private static void procesarArchivo(Path inputFile) {
		 boolean error = false;
	        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	           	
	                if (!validarLinea(linea)) {
	                    error = true;
	                }
	                String[]  s= linea.split(" ");
	                String str = s[1];
	                Path fileDeLinea = Paths.get("documentos",str);
	                Files.createFile(fileDeLinea);
	            }
	        } catch (IOException e) {
	            System.err.println("Error al procesar el archivo: " + e.getMessage());
	        }
	    }
	 private static boolean validarLinea(String linea) {
	        return linea.matches(PATRON_CADENA);
	    }
}
