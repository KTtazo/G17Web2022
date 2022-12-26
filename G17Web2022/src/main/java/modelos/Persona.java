package modelos;

public class Persona {

    private String nif;
    private String usuario;
    private String contrasena;

    public Persona(String nif, String usuario, String contrasena) {
        this.nif = nif;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
