package modelos;

import java.util.Date;

public class OfertaPracticas {

    private int idOfertaPracticas;
    private String descripcion;
    private String titulo;
    private String idiomas;
    private String requisitos;
    private java.util.Date fechaInicio;
    private String curso;
    private String Tutor_Persona_usuario;
    private String Tutor_Empresa_cif;

    public OfertaPracticas(int idOfertaPracticas, String descripcion, String titulo, String idiomas, String requisitos, Date fechaInicio, String curso, String Tutor_Persona_usuario, String Tutor_Empresa_cif) {
        this.idOfertaPracticas = idOfertaPracticas;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.requisitos = requisitos;
        this.fechaInicio = fechaInicio;
        this.curso = curso;
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
