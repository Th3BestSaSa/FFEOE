package ficherosTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Ejercicio8 {
	private static final String PATRON_LINEA = "^REF\\d+,[^,]+,\\d+$";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path inputFile_norte = Paths.get("documentos", "almacen_norte.txt");
		Path inputFile_sur = Paths.get("documentos", "almacen_sur.txt");

		procesarArchivo(inputFile_norte, inputFile_sur);

	}

	private static void procesarArchivo(Path norte, Path sur) {
		TreeMap<String, Producto> mapa = new TreeMap<>();

		leerArchivo(norte, mapa);
		leerArchivo(sur, mapa);

		Path output = Paths.get("documentos", "inventario_global.txt");

		try (BufferedWriter writer = Files.newBufferedWriter(output)) {
			for (Producto p : mapa.values()) {
				if (p.cantidad > 0) {
					writer.write(p.getCodigo() + "," + p.getNombre() + "," + p.getCantidad());
					writer.newLine();
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerArchivo(Path ruta, TreeMap<String, Producto> mapa) {
		try (BufferedReader reader = Files.newBufferedReader(ruta)) {
			String linea;

			while ((linea = reader.readLine()) != null) {
				if (esLineaValida(linea)) {
					String[] partes = linea.split(",");

					String id = partes[0];
					String nombre = partes[1];
					int cantidad = Integer.parseInt(partes[2]);

					if (mapa.containsKey(id)) {
						mapa.get(id).cantidad += cantidad;
					} else {
						mapa.put(id, new Producto(id, nombre, cantidad));
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static boolean esLineaValida(String linea) {
		return linea.matches(PATRON_LINEA);
	}
}
