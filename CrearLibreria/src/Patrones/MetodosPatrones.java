package Patrones;

import java.util.Scanner;

public class MetodosPatrones {
	private static final String PATRON_DNI = "^[0-9]{8}[A-z]$";
	private static final String PATRON_TELEFONO = "^(\\+34)?[6|9]{3}//-[0-9]{6}$";
	
	private static final String PATRON_CADENA_CON_UN_NUMERO=".*[0-9].*";
	private static final String PATRON_CODIGO_POSTAL = "^[1-9][0-9]{4}$";
	private static final String PATRON_CADENA_ALMENOS_UNA_MAYUSCULA=".*[A-Z].*";
	private static final String PATRON_CADENA_ALMENOS_UNA_MINUSCULA=".*[a-z].*";
	private static final String PATRON_NSS="[4|5][0-9][ ]?[0-9]{8}[ ]?[0-9]{2}";
	private static final String PATRON_MATRICULA = "^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$";
	private static final String PATRON_PASSWORD ="^(PATRON_CADENA_ALMENOS_UNA_MAYUSCULA)(PATRON_CADENA_ALMENOS_UNA_MINUSCULA)(PATRON_CADENA_CON_UN_NUMERO).{8,}$";
	private static final String PATRON_IBAN = "^ES[0-9]{2}([ ]?[0-9]{4}){5}$";
	private static final String PATRON_COLOR ="//#([A-Fa-f0-9]{3}|[A-Fa-f0-9]{6})";
	private static final String PATRON_FECHA ="^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[1-9]{4}$";
	private static final String PATRON_URL = "^( http://https://)?[A-z]{1,20}\\.[a-z]{1,3}$";
	private static final String PATRON_CADENA_TODO_MAYUSCULA="[A-Z]+";
	
	public static boolean comporobarDNI(String cadena) {
		return cadena.matches(PATRON_DNI);
	}
	public static boolean comporobarTelefono(String cadena) {
		return cadena.matches(PATRON_TELEFONO);
	}
	public static boolean tieneUnNumero(String cadena) {
	    return cadena.matches(PATRON_CADENA_CON_UN_NUMERO);
	}
	public boolean comporobarCodigoPostal(String cadena) {
		return cadena.matches(PATRON_CODIGO_POSTAL);
	}
	public boolean tieneUnaLetraMayuscula(String cadena) {
		return cadena.matches(PATRON_CADENA_ALMENOS_UNA_MAYUSCULA);
	}
	public static boolean tieneUnaLetraMinuscula(String cadena) {
	    return cadena.matches(PATRON_CADENA_ALMENOS_UNA_MINUSCULA);
	}
	public boolean validarNSS(String cadena) {
		return cadena.matches(PATRON_NSS);
	}
	public static boolean validarMatricula(String cadena) {
	    return cadena.matches(PATRON_MATRICULA);
	}
	public static boolean esPasswordSegura(String cadena) {
	    return cadena.matches(PATRON_PASSWORD);
	}
	public static boolean validarIBAN_ES(String cadena) {
	    return cadena.matches(PATRON_IBAN);
	}
	public static boolean validarColorHexadecimal(String cadena) {
	    return cadena.matches(PATRON_COLOR);
	}
	public static boolean validarFechaBasica(String cadena) {
	    return cadena.matches(PATRON_FECHA);
	}
	public static boolean validarURL(String cadena) {
	    return cadena.matches(PATRON_URL);
	}

}
