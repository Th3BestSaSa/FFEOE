package Libreria;


public class Main {

    public static void main(String[] args) {

        int numero;
        int positivo;
        int rango;
        char caracter;
        char sn;
        String cadena;

        // Fuerza error escribiendo letras o símbolos
        numero = MiEntradaSalida.solicitarEntero("Introduce un número entero:");
        System.out.println("Número introducido: " + numero);

        // Fuerza error escribiendo negativo o letras
        positivo = MiEntradaSalida.solicitarEnteroPositivo("Introduce un número entero positivo:");
        System.out.println("Número positivo: " + positivo);

        // Fuerza error escribiendo fuera del rango o letras
        rango = MiEntradaSalida.solicitarEnteroEnRango("Introduce un número entre 1 y 10:", 1, 10);
        System.out.println("Número en rango: " + rango);

        // Fuerza error escribiendo número o dejando vacío
        caracter = MiEntradaSalida.solicitarCaracter("Introduce un carácter:");
        System.out.println("Carácter: " + caracter);

        // Fuerza error escribiendo otra letra distinta de S o N
        sn = MiEntradaSalida.solicitarCaracterSN("Introduce S o N:");
        System.out.println("Respuesta: " + sn);

        // Fuerza error dejando la línea vacía
        cadena = MiEntradaSalida.solicitarCadena("Introduce una cadena:");
        System.out.println("Cadena: " + cadena);

    }
}