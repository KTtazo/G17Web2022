package com.example.SpringWeb.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;
@Entity
@Table( name="tutor" )
public class Tutor extends Persona {

    
    @Column(name="cargo")
    private String cargo;
    @Column(name="persona_usuario")
    private String Persona_usuario;
    @Column(name="empresa_cif")
    private String Empresa_cif;
    public Tutor() {
    }

    public Tutor(String cargo, String Persona_usuario, String Empresa_cif, String nif, String usuario, String contrasena) {
        super(nif, usuario, contrasena);
        this.cargo = cargo;
        this.Persona_usuario = Persona_usuario;
        this.Empresa_cif = Empresa_cif;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPersona_usuario() {
        return Persona_usuario;
    }

    public void setPersona_usuario(String Persona_usuario) {
        this.Persona_usuario = Persona_usuario;
    }

    public String getEmpresa_cif() {
        return Empresa_cif;
    }

    public void setEmpresa_cif(String Empresa_cif) {
        this.Empresa_cif = Empresa_cif;
    }
}
