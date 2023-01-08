package com.example.SpringWeb.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;

@Entity
@Table( name="alumno" )
public class Alumno extends Persona {
   
    @Column(name="persona_usuario")
    private String Persona_usuario;
    @Column(name="nota_media")
    private double notaMedia;
    @Column(name="carrera" )
    private String carrera;
    @Column(name="oferta_practicas_id_oferta_practicas")
    private Integer OfertaPracticas_idOfertaPracticas;
    public Alumno() {
       }

    public Alumno(String Persona_usuario, double notaMedia, String carrera, Integer OfertaPracticas_idOfertaPracticas, String nif, String usuario, String contrasena) {
        super(nif, usuario, contrasena);
        this.Persona_usuario = Persona_usuario;
        this.notaMedia = notaMedia;
        this.carrera = carrera;
        this.OfertaPracticas_idOfertaPracticas = OfertaPracticas_idOfertaPracticas;
    }

    public String getPersona_usuario() {
        return Persona_usuario;
    }

    public void setPersona_usuario(String Persona_usuario) {
        this.Persona_usuario = Persona_usuario;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getOfertaPracticas_idOfertaPracticas() {
        return OfertaPracticas_idOfertaPracticas;
    }

    public void setOfertaPracticas_idOfertaPracticas(Integer OfertaPracticas_idOfertaPracticas) {
        this.OfertaPracticas_idOfertaPracticas = OfertaPracticas_idOfertaPracticas;
    }

  
   

   
}
