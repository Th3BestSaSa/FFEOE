package Ejercicio3;

import java.time.LocalDateTime;

public class PaginaWeb {
    private String nombre;
	private LocalDateTime fecha;
    
	public PaginaWeb(String nombre) throws VisitaPaginaWebException {
        if (nombre == null) {
            throw new VisitaPaginaWebException("La URL es nula");
        }

        this.nombre = nombre;
        this.fecha=LocalDateTime.now();
    }

    public String getNombre() {
        return nombre;
    }
    public LocalDateTime getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "PaginaWeb [nombre=" + nombre + ", fecha=" + fecha + "]";
	}
	
}
