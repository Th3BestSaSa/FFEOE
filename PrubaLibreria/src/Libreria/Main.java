package Libreria;



public class Main {

    public static void main(String[] args) {

        int numero;
        int positivo;
        int rango;
        char caracter;
        char sn;
        String cadena;

        // Fuerza error escribiendo letras o símbolosMiEntradaSalida.solicitarEntero("Introduce un número entero:");
        numero = LibreriaMiEntradaSalida.MiEntradaSalida.solicitarEntero("Introduce un número entero:");
        System.out.println("Número introducido: " + numero);

        // Fuerza error escribiendo negativo o letras
        positivo =LibreriaMiEntradaSalida.MiEntradaSalida.solicitarEnteroPositivo("Introduce un número entero positivo:");
        System.out.println("Número positivo: " + positivo);

        // Fuerza error escribiendo fuera del rango o letras
        rango = LibreriaMiEntradaSalida.MiEntradaSalida.solicitarEnteroEnRango("Introduce un número entre 1 y 10:", 1, 10);
        System.out.println("Número en rango: " + rango);

        // Fuerza error escribiendo número o dejando vacío
        caracter =LibreriaMiEntradaSalida.MiEntradaSalida.solicitarCaracter("Introduce un carácter:");
        System.out.println("Carácter: " + caracter);

        // Fuerza error escribiendo otra letra distinta de S o N
        sn = LibreriaMiEntradaSalida.MiEntradaSalida.solicitarCaracterSN("Introduce S o N:");
        System.out.println("Respuesta: " + sn);

        // Fuerza error dejando la línea vacía
        cadena =LibreriaMiEntradaSalida.MiEntradaSalida.solicitarCadena("Introduce una cadena:");
        System.out.println("Cadena: " + cadena);

    }
}