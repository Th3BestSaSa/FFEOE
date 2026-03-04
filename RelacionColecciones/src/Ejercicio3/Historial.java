package Ejercicio3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Historial {
    private ArrayList<PaginaWeb> historialBusquedas;

    public Historial() {
        this.historialBusquedas = new ArrayList<>();
    }

    public void annadirNuevaVisitaPaginaWeb(PaginaWeb visita) throws VisitaPaginaWebException {
        if (!historialBusquedas.isEmpty()) {
            LocalDateTime ultimaFecha = historialBusquedas.get(historialBusquedas.size() - 1).getFecha();
            if (visita.getFecha().isBefore(ultimaFecha)) {
                throw new VisitaPaginaWebException("No se puede insertar una fecha anterior a la última registrada.");
            }
        }
        historialBusquedas.add(visita);
    }

    // --- CAMBIO AQUÍ: Ahora comparamos contra un objeto LocalDate ---
    public String consultarHistorialDelDia(int dia) {
        StringBuilder sb = new StringBuilder();
        boolean encontrado = false;
        String resultado;
        // Creamos una fecha "modelo" para comparar (usamos el año y mes actual)
        // Nota: Esto lanzará excepción si el día no es válido (ej: 31 de abril)
        LocalDate fechaBuscada = LocalDate.now().withDayOfMonth(dia);

        for (PaginaWeb p : historialBusquedas) {
            // Extraemos solo la parte de la fecha (LocalDate) del LocalDateTime de la página
            if (p.getFecha().toLocalDate().equals(fechaBuscada)) {
                sb.append(p).append("\n");
                encontrado = true;
            }
        }
        if (encontrado) {
            resultado = sb.toString();
        } else {
            resultado = "No hay visitas para el día " + dia;
        }
        
        return resultado;
    }

    // --- CAMBIO AQUÍ: Usamos LocalDate y LocalTime combinados ---
    public String consultarHistorialDelDiaYHora(int dia, int hora, int minutos) {
        StringBuilder sb = new StringBuilder();
        boolean encontrado = false;
        
        // Creamos los objetos de comparación
        LocalDate fechaBuscada = LocalDate.now().withDayOfMonth(dia);
        LocalTime horaBuscada = LocalTime.of(hora, minutos);
        String resultado;
        for (PaginaWeb p : historialBusquedas) {
            LocalDateTime f = p.getFecha();
            
            // Comparamos la fecha y la hora (ignorando segundos/nanosegundos)
            if (f.toLocalDate().equals(fechaBuscada) && 
                f.toLocalTime().withSecond(0).withNano(0).equals(horaBuscada)) {
                
                sb.append(p).append("\n");
                encontrado = true;
            }
        }
        if (encontrado) {
            resultado = sb.toString();
        } else {
            resultado = "No hay visitas para esa fecha y hora exacta.";
        }

        return resultado;
    }

    public void borrarHistorial() {
        historialBusquedas.clear();
    }

    @Override
    public String toString() {
        if (historialBusquedas.isEmpty()) return "El historial está vacío.";
        
        StringBuilder sb = new StringBuilder();
        sb.append("--- Historial de Navegación (Más reciente primero) ---\n");
        for (int i = historialBusquedas.size() - 1; i >= 0; i--) {
            sb.append(historialBusquedas.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}