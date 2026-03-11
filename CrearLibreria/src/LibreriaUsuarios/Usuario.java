package LibreriaUsuarios;

import java.util.Objects;

public class Usuario {
	private String nombreUsuario;
	private String contrasenna;
	private boolean activo;

	public Usuario(String nombreUsuario, String contrasenna, boolean activo) throws UsuariosException {
		this.nombreUsuario = nombreUsuario;
		setContraseña(contrasenna); // Validamos al construir
		this.activo = activo;
	}

	// Getters y Setters
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContraseña(String contrasenna) throws UsuariosException {
		if (contrasenna.length() < 8) {
			throw new UsuariosException("La contraseña debe tener al menos 8 caracteres.");
		}
		this.contrasenna = contrasenna;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Usuario: ").append(nombreUsuario).append("\n");
	    sb.append("Contraseña: ").append(contrasenna).append("\n");
	    sb.append("Estado: ").append(activo ? "Activo" : "Inactivo");
	    return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Usuario))
			return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(nombreUsuario, usuario.nombreUsuario);
	}
}