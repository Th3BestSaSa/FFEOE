package ficherosTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio3 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Path inputFile = Paths.get("documentos", "server_logs.txt");
		Path outputFile = Paths.get("documentos", "errors_report.txt");
		int totalLines = 0;
		int errorLines = 0;
		String n ="Si";
		try (BufferedReader reader = Files.newBufferedReader(inputFile);
				BufferedWriter writer = Files.newBufferedWriter(outputFile);) {
			String line;
			if (Files.isRegularFile(outputFile)) {
				System.out.println("Se perdera la informacion del archivo");
				n = teclado.nextLine();
			}
			if (n.equalsIgnoreCase("si")) {

				while ((line = reader.readLine()) != null) {
					totalLines++;
					if (line.contains("[ERROR]")) {
						writer.write(line);
						writer.newLine();
						errorLines++;
					}
				}
			}
			System.out.println("Procesamiento finalizado.");
			System.out.println("Total de líneas procesadas: " + totalLines);
			System.out.println("Total de errores encontrados: " + errorLines);

		} catch (IOException e) {
			System.err.println("Error al procesar el archivo: " + e.getMessage());
		}
	}
}