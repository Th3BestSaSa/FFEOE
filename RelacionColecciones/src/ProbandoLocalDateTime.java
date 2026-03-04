
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ProbandoLocalDateTime {

	public static void main(String[] args) {

		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime despues;
		int resultadoComparacion;

		// Crear un objeto LocalDateTime con fecha y hora actual
		System.out.println("Ahora " + ahora);
		System.out.println("Dia " + ahora.getDayOfMonth() + " Mes " + ahora.getMonthValue() + "-" + ahora.getMonth());
		System.out.println(
				"Hora " + ahora.getHour() + " Minutos " + ahora.getMinute() + " Segundos " + ahora.getSecond());

		// Comparacion de fechas
		despues = LocalDateTime.now();
		System.out.println("Despues " + despues);

		resultadoComparacion = ahora.compareTo(despues);

		if (resultadoComparacion > 0)
			System.out.println("Ahora mayor que despues");
		else {
			if (resultadoComparacion < 0)
				System.out.println("Ahora menor que despues");
			else
				System.out.println("Iguales");
		}
		
		//Obtener un LocalDate (solo fecha) a partir del LocalDateTime
		LocalDate soloFecha=ahora.toLocalDate();
		System.out.println("Esto es solo la fecha " + soloFecha);
		LocalTime soloHora=ahora.toLocalTime();
		System.out.println("Esto es solo la hora " + soloHora);
		
		System.out.println("\n");

		// Crear un objeto LocalDateTime a partir de un String
		String fechaInicialHora = "2022-12-31T12:05";
		LocalDateTime fechaHoraTomada = LocalDateTime.parse(fechaInicialHora);

		// Mostrar la fecha con diferentes formatos
		System.out.println("Nueva fecha creada " +fechaHoraTomada);
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MM uuuu hh mm");
		
		System.out.println(" Con nuevo formato: " + df.format(fechaHoraTomada));
		df = DateTimeFormatter.ofPattern("dd MMM uuuu");
		System.out.println(" Con nuevo formato: " + df.format(fechaHoraTomada));

	}
}
