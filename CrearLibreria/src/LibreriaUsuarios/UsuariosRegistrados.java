package LibreriaUsuarios;

import java.util.HashSet;
import java.util.Set;


public class UsuariosRegistrados {
    // Usamos un Set para evitar duplicados automáticamente
    private Set<Usuario> listaUsuarios;
    private final int MAX_USUARIOS = 1000;

    public UsuariosRegistrados() {
        this.listaUsuarios = new HashSet<>();
    }

    public int getContadorUsuarios() {
        return listaUsuarios.size();
    }

    public void annadirUsuario(Usuario nuevoUsuario) throws UsuariosException {
        if (listaUsuarios.size() >= MAX_USUARIOS) {
            throw new UsuariosException("Límite de "+ MAX_USUARIOS+" usuarios alcanzado.");
        }
        
        // .add() devuelve false si el usuario ya existe (basado en equals/hashCode)
        if (!listaUsuarios.add(nuevoUsuario)) {
            throw new UsuariosException("El usuario ya existe.");
        }
    }

    // Con HashSet no usamos índices, buscamos el objeto directamente
    private Usuario buscarUsuarioPorNombre(String nombreUsuario) {
    	Usuario usuario= null;
        for (Usuario u : listaUsuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario)) {
            	usuario= u;
            }
        }
        return usuario; // Si no existe, devolvemos null
    }

    public void cambiarUsuarioAInactivo(String nombreUsuario) throws UsuariosException {
        Usuario usuario = buscarUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            throw new UsuariosException("Usuario no encontrado.");
        }
        usuario.setActivo(false);
    }

    public void cambirUsuarioAActivo(String nombreUsuario) throws UsuariosException {
        Usuario usuario = buscarUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            throw new UsuariosException("Usuario no encontrado.");
        }
        usuario.setActivo(true);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Usuario u : listaUsuarios) {
            sb.append(u.toString()).append("\n");
        }
        return sb.toString();
    }

    public String toStringActivos() {
        StringBuilder sb = new StringBuilder();
        for (Usuario u : listaUsuarios) {
            if (u.isActivo()) {
                sb.append(u.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public String toStringInactivos() {
        StringBuilder sb = new StringBuilder();
        for (Usuario u : listaUsuarios) {
            if (!u.isActivo()) {
                sb.append(u.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}