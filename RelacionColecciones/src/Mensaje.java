import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Mensaje {
	public String nombreRemitente;
	public String texto;
	public LocalDateTime fechaYHora;
	public Mensaje(String nombreRemitente, String texto, LocalDateTime fechaYHora) {
		super();
		this.nombreRemitente = nombreRemitente;
		this.texto = texto;
		this.fechaYHora = LocalDateTime.now();
	}
	
	public String getNombreRemitente() {
		return nombreRemitente;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	

	@Override
	public String toString() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
	    return "Mensaje [nombreRemitente=" + nombreRemitente 
	            + ", texto=" + texto 
	            + ", fechaYHora=" + fechaYHora.format(formatter) 
	            + "]";
	}
}
