package ficherosTexto;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Ejercicio7 {
	private static final String PATRON_LINEA = "^\\s*(\\d+)\\s*\\|\\s*([^|]+)\\s*\\|\\s*([^|]+)\\s*\\|\\s*(\\d+(\\.\\d+)?)\\s*$";

	public static void main(String[] args) {
		Path inputFile = Paths.get("documentos", "alumnos.txt");
		Path outputFile = Paths.get("documentos", "alumnosOrdenadosPorNota.txt");

		procesarArchivo(inputFile, outputFile);
	}

	private static void procesarArchivo(Path input, Path output) {
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		boolean formatoCorrecto = true;

		try (BufferedReader reader = Files.newBufferedReader(input)) {
			String linea;
			int numLinea = 1;

			while ((linea = reader.readLine()) != null) {

				if (esLineaValida(linea)) {
					String[] partes = linea.split("\\|");
					listaAlumnos.add(new Alumno(partes[0].trim(), partes[1].trim(), partes[2].trim(),
							Double.parseDouble(partes[3].trim())));
				} else {
					System.err.println("Error de formato en la línea " + numLinea + ": " + linea);
					formatoCorrecto = false;

				}
				numLinea++;
			}

			if (formatoCorrecto && !listaAlumnos.isEmpty()) {
				// Ordenar de mayor a menor nota
				Collections.sort(listaAlumnos, new Comparator<Alumno>() {

					@Override
					public int compare(Alumno o1, Alumno o2) {
						// TODO Auto-generated method stub
						return Double.compare(o1.getNota(), o2.getNota());
					}

				});

				// Escribir el nuevo archivo
				escribirArchivo(output, listaAlumnos);
				System.out.println("Archivo generado con éxito: " + output.getFileName());
			}

		} catch (IOException e) {
			System.err.println("Error al acceder a los archivos: " + e.getMessage());
		}
	}

	private static boolean esLineaValida(String linea) {
		return linea.matches(PATRON_LINEA) && linea.contains("@");
	}

	private static void escribirArchivo(Path output, ArrayList<Alumno> alumnos) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(output)) {
			for (Alumno a : alumnos) {
				writer.write(a.toString());
				writer.newLine();
			}
		}
	}
}