package ficherosTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio4 {

	private static final String PATRON_LINEA = "^(\\d+)\\s*\\|\\s*([^|]+)\\s*\\|\\s*([^|]+)\\s*\\|\\s*(\\d+)$";

	public static void main(String[] args) {
		Path inputFile = Paths.get("documentos", "clientes.txt");
		Path outputFile = Paths.get("documentos", "clientes_anonimos.txt");

		procesarArchivo(inputFile, outputFile);
		
	}

	private static void procesarArchivo(Path inputFile, Path outputFile) {
		boolean error = false;

		try (BufferedReader reader = Files.newBufferedReader(inputFile);
				BufferedWriter writer = Files.newBufferedWriter(outputFile)) {

			String linea;
			while ((linea = reader.readLine()) != null) {

				if (!esLineaValida(linea)) {
					error = true;
				}

				String lineaProcesada = anonimizarLinea(linea);
				writer.write(lineaProcesada);
				writer.newLine();
			}

		} catch (IOException e) {
			System.err.println("Error de lectura/escritura: " + e.getMessage());
			error = true;
		}
		
		finalizarArchivo(outputFile,error);
	}

	private static void finalizarArchivo(Path outputFile, boolean error)  {
		// TODO Auto-generated method stub
		if (error) {
			try {
				Files.delete(outputFile);
				System.out.println("Se han encontrado fallos");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("falla por " + e.getMessage());
				
			}
		}
	}

	private static boolean esLineaValida(String linea) {
		return linea.matches(PATRON_LINEA) && linea.contains("@");
	}

	private static String anonimizarLinea(String linea) {
		boolean error = false;
		String[] partes = linea.split("\\|");
		String id = partes[0];
		String nombre = partes[1];
		String email = partes[2];
		String telefono = partes[3];

		if (!email.contains("@")) {
			error = true;

		}

		String[] partesEmail = email.split("@");
		String usuario = partesEmail[0];
		String dominio = partesEmail[1];

		// Para anonimizar el email
		StringBuilder emailAnon = new StringBuilder();
		emailAnon.append(usuario.charAt(0));
		for (int i = 1; i < usuario.length(); i++) {
			emailAnon.append('*');
		}

		emailAnon.append('@').append(dominio);
		// Para anonimizar el teléfono
		StringBuilder telefonoAnon = new StringBuilder();

		for (int i = 0; i < telefono.length() - 3; i++) {
			telefonoAnon.append('X');
		}
		telefonoAnon.append(telefono.substring(telefono.length() - 3));

		// Convertimos a String si lo necesitamos

		String emailAninimo = emailAnon.toString();
		String telefonoAninimo = telefonoAnon.toString();

		String resultado = id + " | " + nombre + emailAninimo + " | " + telefonoAninimo;
		return resultado;

	}
}
