package modelos;

import java.sql.Time;
import java.util.Date;

public class OfertaPracticas {

    private int idOfertaPracticas;
    private String descripcion;
    private String titulo;
    private String idiomas;
    private String requisitos;
    private Date fechaInicio;
    private String curso;
    private int duracion;
    private Time horaInicio;
    private Time horaSalida;
    private int plazas;
    private int salario;
    private String Tutor_Persona_usuario;
    private String Tutor_Empresa_cif;

    public OfertaPracticas(int idOfertaPracticas, String descripcion, String titulo, String idiomas, String requisitos, Date fechaInicio, String curso, int duracion, Time horaInicio, Time horaSalida, int plazas, int salario, String Tutor_Persona_usuario, String Tutor_Empresa_cif) {
        this.idOfertaPracticas = idOfertaPracticas;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.requisitos = requisitos;
        this.fechaInicio = fechaInicio;
        this.curso = curso;
        this.duracion = duracion;
        this.horaInicio = horaInicio;
        this.horaSalida = horaSalida;
        this.plazas = plazas;
        this.salario = salario;
        this.Tutor_Persona_usuario = Tutor_Persona_usuario;
        this.Tutor_Empresa_cif = Tutor_Empresa_cif;
    }

    public int getIdOfertaPracticas() {
        return idOfertaPracticas;
    }

    public void setIdOfertaPracticas(int idOfertaPracticas) {
        this.idOfertaPracticas = idOfertaPracticas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "OfertaPracticas{" + "idOfertaPracticas=" + idOfertaPracticas + ", descripcion=" + descripcion + ", titulo=" + titulo + ", idiomas=" + idiomas + ", requisitos=" + requisitos + ", fechaInicio=" + fechaInicio + ", curso=" + curso + ", duracion=" + duracion + ", horaInicio=" + horaInicio + ", horaSalida=" + horaSalida + ", plazas=" + plazas + ", salario=" + salario + ", Tutor_Persona_usuario=" + Tutor_Persona_usuario + ", Tutor_Empresa_cif=" + Tutor_Empresa_cif + '}';
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTutor_Persona_usuario() {
        return Tutor_Persona_usuario;
    }

    public void setTutor_Persona_usuario(String Tutor_Persona_usuario) {
        this.Tutor_Persona_usuario = Tutor_Persona_usuario;
    }

    public String getTutor_Empresa_cif() {
        return Tutor_Empresa_cif;
    }

    public void setTutor_Empresa_cif(String Tutor_Empresa_cif) {
        this.Tutor_Empresa_cif = Tutor_Empresa_cif;
    }

}
