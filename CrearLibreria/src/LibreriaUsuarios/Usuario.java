package LibreriaUsuarios;

import java.util.Objects;

public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private boolean activo;

    public Usuario(String nombreUsuario, String contraseña, boolean activo) throws UsuariosException {
        this.nombreUsuario = nombreUsuario;
        setContraseña(contraseña); // Validamos al construir
        this.activo = activo;
    }

    // Getters y Setters
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getContraseña() { return contraseña; }
    
    public void setContraseña(String contraseña) throws UsuariosException {
        if (contraseña.length() < 8 || !contraseña.matches(".*\\d.*")) {
            throw new UsuariosException("La contraseña debe tener al menos 8 caracteres y un número.");
        }
        this.contraseña = contraseña;
    }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        String estado = activo ? "Activo" : "Inactivo";
        return String.format("Usuario: %s Contraseña: %s %s", nombreUsuario, contraseña, estado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombreUsuario, usuario.nombreUsuario);
    }
}