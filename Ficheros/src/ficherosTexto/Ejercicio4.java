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

    private static void procesarArchivo(Path entrada, Path salida) {
        int totalLines = 0;
        boolean huboError = false;

        try (BufferedReader reader = Files.newBufferedReader(entrada);
             BufferedWriter writer = Files.newBufferedWriter(salida)) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                totalLines++;

                if (!esLineaValida(linea)) {
                    huboError = true;
                    continue; // Marcamos error pero seguimos para validar el resto
                }

                String lineaProcesada = anonimizarLinea(linea);
                writer.write(lineaProcesada);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error de lectura/escritura: " + e.getMessage());
            huboError = true;
        }

        finalizarProceso(salida, huboError, totalLines);
    }

    private static boolean esLineaValida(String linea) {
        return linea.matches(PATRON_LINEA) && linea.contains("@");
    }

    private static String anonimizarLinea(String linea) {
        String[] partes = linea.split("\\s*\\|\\s*");
        String id = partes[0];
        String nombre = partes[1];
        String email = partes[2];
        String telefono = partes[3];

        // Anonimizar Email: a*****@dominio.com
        String[] pEmail = email.split("@");
        String emailAnon = pEmail[0].charAt(0) + "*".repeat(pEmail[0].length() - 1) + "@" + pEmail[1];

        // Anonimizar Teléfono: XXXXXX123
        int visible = 3;
        String telAnon = "X".repeat(Math.max(0, telefono.length() - visible)) + 
                         telefono.substring(Math.max(0, telefono.length() - visible));

        return String.format("%s | %s | %s | %s", id, nombre, emailAnon, telAnon);
    }

    private static void finalizarProceso(Path salida, boolean huboError, int total) {
        if (huboError) {
            try {
                Files.deleteIfExists(salida);
                System.err.println("Se detectaron errores en el origen. El archivo de salida ha sido eliminado.");
            } catch (IOException e) {
                System.err.println("No se pudo limpiar el archivo tras el error.");
            }
        } else {
            System.out.println("Proceso finalizado con éxito. Líneas procesadas: " + total);
        }
    }
}