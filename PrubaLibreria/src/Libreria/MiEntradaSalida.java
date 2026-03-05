package Libreria;
import java.util.Scanner;

import color.Color;

public class MiEntradaSalida {
    private static Scanner teclado = new Scanner(System.in);


    // Constructor
    public MiEntradaSalida() {
        super();
    }

    public static int solicitarEntero(String msg) {
        int numero = 0;
        boolean error;

        do {
            error = false;
            System.out.println(msg);
            try {
                numero = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
            	System.out.println(Color.colorize(Color.COLOR_PURPLE, "Error no es un número"));
           
                error = true;
            }
        } while (error);

        return numero;
    }

    public static int solicitarEnteroPositivo(String msg) {
        int numero = 0;
        boolean error;

        do {
            error = false;
            System.out.println(msg);
            try {
                numero = Integer.parseInt(teclado.nextLine());
                if (numero <= 0) {
                    error = true;
                }
            } catch (NumberFormatException e) {
            	System.out.println(Color.colorize(Color.COLOR_PURPLE, "Error no es un número"));
              
                error = true;
            }
        } while (error);

        return numero;
    }

    public static int solicitarEnteroEnRango(String msg, int limiteInferior, int limiteSuperior) {
        int numero = 0;
        boolean error;

        do {
            error = false;
            System.out.println(msg);
            try {
                numero = Integer.parseInt(teclado.nextLine());
                if (numero < limiteInferior || numero > limiteSuperior) {
                    error = true;
                }
            } catch (NumberFormatException e) {
            	System.out.println(Color.colorize(Color.COLOR_PURPLE, "Error no es un número"));
                error = true;
            }
        } while (error);

        return numero;
    }

    public static char solicitarCaracter(String msg) {
        char caracter;

        do {
            System.out.println(msg);
            String entrada = teclado.nextLine().trim();

            if (entrada.isEmpty()) {
            	System.out.println(Color.colorize(Color.COLOR_PURPLE,"Error no se ha introducido ningún carácter"));
              
                caracter = 0;
            } else {
                caracter = entrada.charAt(0);
            }

        } while (!Character.isAlphabetic(caracter));

        return caracter;
    }

    public static char solicitarCaracterSN(String msg) {
        char caracter;

        do {
            System.out.println(msg);
            String entrada = teclado.nextLine().trim();

            if (entrada.isEmpty()) {
            	System.out.println(Color.colorize(Color.COLOR_PURPLE,"Error no se ha introducido ningún carácter"));
                caracter = 0;
            } else {
                caracter = entrada.toUpperCase().charAt(0);
            }

        } while (!Character.isAlphabetic(caracter) || (caracter != 'S' && caracter != 'N'));

        return caracter;
    }

    public static String solicitarCadena(String msg) {
        String cadena;

        do {
            System.out.println(msg);
            cadena = teclado.nextLine();
        } while (cadena.length() == 0);

        return cadena;
    }
}