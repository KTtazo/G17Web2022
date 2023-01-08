package com.example.SpringWeb.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name="oferta_practicas_has_alumno")
public class OfertaPracticas_has_Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="id_oferta_practicas")
    private int idOfertaPracticas; 
    @Column(name="oferta_practicas_id_oferta_practicas")
    private int OfertaPracticas_idOfertaPracticas;
    
    @ManyToOne
    @JoinColumn(name="alumno_persona_usuario")
    private String Alumno_Persona_usuario;
    public OfertaPracticas_has_Alumno() {
    }
 
    public OfertaPracticas_has_Alumno(int OfertaPracticas_idOfertaPracticas, String Alumno_Persona_usuario) {
        this.OfertaPracticas_idOfertaPracticas = OfertaPracticas_idOfertaPracticas;
        this.Alumno_Persona_usuario = Alumno_Persona_usuario;
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
    
}
