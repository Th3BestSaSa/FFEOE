package ficherosTexto;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {
    private static final String PATRON_LINEA = "^(\\d+)\\s*\\|\\s*([^|]+)\\s*\\|\\s*([^|]+)\\s*\\|\\s*(\\d+)$";

    public static void main(String[] args) {
        Path inputFile = Paths.get("documentos", "clientes.txt");
        Path outputFile = Paths.get("documentos", "clientes_anonimos.txt");

        List<String> lineasAnonimizadas = new ArrayList<>();
        int totalLines = 0;
        int errorLines = 0;

        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalLines++;

                if (!line.matches(PATRON_LINEA)) {
                    errorLines++;
                }

                String[] partes = line.split("\\|");
                String id = partes[0];
                String nombre = partes[1];
                String email = partes[2];
                String telefono = partes[3];

                if (!email.contains("@")) {
                    errorLines++;
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

                lineasAnonimizadas.add(id + " | " + nombre + " | " + emailAninimo + " | " + telefonoAninimo);
            }

            if (errorLines > 0) {
                System.err.println("Se encontraron errores en " + errorLines + " líneas. No se creó el archivo de salida.");
            } else {
                // Solo se crea el archivo si no hay errores
                try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
                    for (String l : lineasAnonimizadas) {
                        writer.write(l);
                        writer.newLine();
                    }
                }
                System.out.println("Archivo de salida creado correctamente.");
            }

            System.out.println("Total de líneas procesadas: " + totalLines);
            System.out.println("Total de errores encontrados: " + errorLines);

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}