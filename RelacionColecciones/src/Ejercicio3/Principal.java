package Ejercicio3;

import java.util.Scanner;

public class Principal {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Historial miHistorial = new Historial();
        int opcion = 0;

        do {
            System.out.println("\n========== MENÚ HISTORIAL ==========");
            System.out.println("1. Nueva página consultada");
            System.out.println("2. Consultar historial completo");
            System.out.println("3. Consultar historial de un día");
            System.out.println("4. Consultar historial por día y hora");
            System.out.println("5. Borrar historial completo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce la URL: ");
                        String url = teclado.nextLine();
                        miHistorial.annadirNuevaVisitaPaginaWeb(new PaginaWeb(url));
                        System.out.println("Página registrada.");
                        break;
                    case 2:
                        System.out.println(miHistorial.toString());
                        break;
                    case 3:
                        System.out.print("Día (1-31): ");
                        int d = Integer.parseInt(teclado.nextLine());
                        System.out.println(miHistorial.consultarHistorialDelDia(d));
                        break;
                    case 4:
                        System.out.print("Día (1-31): ");
                        int dia = Integer.parseInt(teclado.nextLine());
                        System.out.print("Hora (0-23): ");
                        int h = Integer.parseInt(teclado.nextLine());
                        System.out.print("Minuto (0-59): ");
                        int m = Integer.parseInt(teclado.nextLine());
                        System.out.println(miHistorial.consultarHistorialDelDiaYHora(dia, h, m));
                        break;
                    case 5:
                        miHistorial.borrarHistorial();
                        System.out.println("Historial vaciado.");
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 6);
    }
}