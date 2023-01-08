package com.example.SpringWeb.modelo;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.io.Serializable;
    @Entity
    @Table (name="persona")
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

    
public class Persona implements Serializable {
    @Id
    @Column(name="usuario")
    private String usuario;
    
    @Column(name="nif")
    private String nif;
    
    @Column(name="contrasena")
    private String contrasena;
     public Persona() {
    }

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