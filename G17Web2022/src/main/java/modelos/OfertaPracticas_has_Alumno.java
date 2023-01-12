package modelos;

public class OfertaPracticas_has_Alumno {

    private int OfertaPracticas_idOfertaPracticas;
    private String Alumno_Persona_usuario;
    private int prioridad;

    public OfertaPracticas_has_Alumno(int OfertaPracticas_idOfertaPracticas, String Alumno_Persona_usuario, int prioridad) {
        this.OfertaPracticas_idOfertaPracticas = OfertaPracticas_idOfertaPracticas;
        this.Alumno_Persona_usuario = Alumno_Persona_usuario;
        this.prioridad = prioridad;
    }

    public int getOfertaPracticas_idOfertaPracticas() {
        return OfertaPracticas_idOfertaPracticas;
    }

    public void setOfertaPracticas_idOfertaPracticas(int OfertaPracticas_idOfertaPracticas) {
        this.OfertaPracticas_idOfertaPracticas = OfertaPracticas_idOfertaPracticas;
    }

    public String getAlumno_Persona_usuario() {
        return Alumno_Persona_usuario;
    }

    public void setAlumno_Persona_usuario(String Alumno_Persona_usuario) {
        this.Alumno_Persona_usuario = Alumno_Persona_usuario;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

}
