package com.example.SpringWeb.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Entity
@Table(name="oferta_practicas")
public class OfertaPracticas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_oferta_practicas")
    private int idOfertaPracticas;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="titulo")
    private String titulo;
    @Column(name="idiomas")
    private String idiomas;
    @Column(name="requisitos")
    private String requisitos;
    @Column(name="fecha_inicio")
    private java.util.Date fechaInicio;
    @Column(name="curso")
    private String curso;
    @Column(name="tutor_persona_usuario")
    private String Tutor_Persona_usuario;
    @Column(name="tutor_empresa_cif")
    private String Tutor_Empresa_cif;
    public OfertaPracticas() {
    }

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
