package LibreriaUsuarios;

public class UsuariosRegistrados {
    private Usuario[] listaUsuarios;
    private int contadorUsuarios;
    private final int MAX_USUARIOS = 1000;

    public UsuariosRegistrados() {
        this.listaUsuarios = new Usuario[MAX_USUARIOS];
        this.contadorUsuarios = 0;
    }

    public int getContadorUsuarios() {
        return contadorUsuarios;
    }

    public void annadirUsuario(Usuario nuevoUsuario) throws UsuariosException {
        if (contadorUsuarios >= MAX_USUARIOS) {
            throw new UsuariosException("Límite de 1000 usuarios alcanzado.");
        }
        
        // Verificar si ya existe por nombre
        for (int i = 0; i < contadorUsuarios; i++) {
            if (listaUsuarios[i].equals(nuevoUsuario)) {
                throw new UsuariosException("El usuario ya existe.");
            }
        }

        listaUsuarios[contadorUsuarios] = nuevoUsuario;
        contadorUsuarios++;
    }

    private int buscarIndice(String nombreUsuario) {
    	int in=-1;
        for (int i = 0; i < contadorUsuarios; i++) {
            if (listaUsuarios[i].getNombreUsuario().equals(nombreUsuario)) {
                in=i;
            }
        }
        return in;
    }

    public void cambiarUsuarioAInactivo(String nombreUsuario) throws UsuariosException {
        int indice = buscarIndice(nombreUsuario);
        if (indice == -1) {
        	throw new UsuariosException("Usuario no encontrado.");
        }
        listaUsuarios[indice].setActivo(false);
    }

    public void cambirUsuarioAActivo(String nombreUsuario) throws UsuariosException {
        int indice = buscarIndice(nombreUsuario);
        if (indice == -1) {
        	throw new UsuariosException("Usuario no encontrado.");
        }
        listaUsuarios[indice].setActivo(true);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorUsuarios; i++) {
            sb.append(listaUsuarios[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public String toStringActivos() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorUsuarios; i++) {
            if (listaUsuarios[i].isActivo()) {
                sb.append(listaUsuarios[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public String toStringInactivos() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorUsuarios; i++) {
            if (!listaUsuarios[i].isActivo()) {
                sb.append(listaUsuarios[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }
}