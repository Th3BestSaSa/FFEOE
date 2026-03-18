package ficherosTexto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjemploRutas {
	
	public static void main(String[] args) {
		// Forma CORRECTA y multiplataforma:
		Path rutaSegura = Paths.get("documentos", "registros", "alumnos.txt");

		System.out.println("La ruta construida es: " + rutaSegura.toString());
		// En Windows imprimirá: documentos\registros\alumnos.txt
		// En Mac/Linux imprimirá: documentos/registros/alumnos.txt

		Path ruta = Paths.get("documentos", "datos.txt");
		if (Files.exists(ruta)) {
			System.out.println("El archivo existe.");
		} else {
			System.out.println("El archivo NO existe.");
		}
		// También podemos preguntar qué tipo de elemento es:
		if (Files.isDirectory(ruta)) {
			System.out.println("Es una carpeta.");
		} else if (Files.isRegularFile(ruta)) {
			System.out.println("Es un archivo normal.");
		}

	}

	public static void crearCarpeta() {
		// Queremos crear "archivos" y dentro "2023"
		Path rutaCarpeta = Paths.get("archivos", "2023");
		try {
			if (Files.notExists(rutaCarpeta)) {
				// createDirectories crea toda la ruta necesaria
				Files.createDirectories(rutaCarpeta);
				System.out.println("Carpeta creada con éxito.");
			} else {
				System.out.println("La carpeta ya existía.");
			}
		} catch (IOException e) {
			System.err.println("Error al crear la carpeta: " + e.getMessage());
		}
	}

}
