package com.example.SpringWeb.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;
@Entity
@Table( name="responsable" )
public class Responsable extends Persona  {
    
    @Column(name="persona_usuario")
    private String Persona_usuario;
    public Responsable() {
    }

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
