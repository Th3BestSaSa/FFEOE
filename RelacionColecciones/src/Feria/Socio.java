package Feria;

import java.time.LocalDate;
import java.util.Objects;

public class Socio {
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private LocalDate fechaNacimiento;
	private int idSocio;
	private static int contador = 1; // Para que el primero sea el 1

	public Socio(String dni, String apellidos, String nombre, String direccion, LocalDate fechaNacimiento) {
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.idSocio = contador++; // Asigna y luego suma
	}

	// Getters necesarios
	public String getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return apellidos + ", " + nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getIdSocio() {
		return idSocio;
	}

	@Override
	public String toString() {
		return "Nº " + idSocio + " - DNI: " + dni + " - " + getNombreCompleto() + " - F.Nac: " + fechaNacimiento;
	}

	// Para evitar duplicados por DNI (usado en el Main o Caseta)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return Objects.equals(dni, other.dni);
	}

}