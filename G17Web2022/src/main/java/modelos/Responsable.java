package modelos;

public class Responsable extends Persona {

    private String Persona_usuario;

    public Responsable(String Persona_usuario, String nif, String usuario, String contrasena) {
        super(nif, usuario, contrasena);
        this.Persona_usuario = Persona_usuario;
    }

    public String getPersona_usuario() {
        return Persona_usuario;
    }

    public void setPersona_usuario(String Persona_usuario) {
        this.Persona_usuario = Persona_usuario;
    }
}
