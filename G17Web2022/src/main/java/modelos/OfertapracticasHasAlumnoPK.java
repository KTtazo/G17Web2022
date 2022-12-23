package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class OfertapracticasHasAlumnoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "OfertaPracticas_idOfertaPracticas")
    private int ofertaPracticasidOfertaPracticas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Alumno_Persona_usuario")
    private String alumnoPersonausuario;

    public OfertapracticasHasAlumnoPK() {
    }

    public OfertapracticasHasAlumnoPK(int ofertaPracticasidOfertaPracticas, String alumnoPersonausuario) {
        this.ofertaPracticasidOfertaPracticas = ofertaPracticasidOfertaPracticas;
        this.alumnoPersonausuario = alumnoPersonausuario;
    }

    public int getOfertaPracticasidOfertaPracticas() {
        return ofertaPracticasidOfertaPracticas;
    }

    public void setOfertaPracticasidOfertaPracticas(int ofertaPracticasidOfertaPracticas) {
        this.ofertaPracticasidOfertaPracticas = ofertaPracticasidOfertaPracticas;
    }

    public String getAlumnoPersonausuario() {
        return alumnoPersonausuario;
    }

    public void setAlumnoPersonausuario(String alumnoPersonausuario) {
        this.alumnoPersonausuario = alumnoPersonausuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ofertaPracticasidOfertaPracticas;
        hash += (alumnoPersonausuario != null ? alumnoPersonausuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertapracticasHasAlumnoPK)) {
            return false;
        }
        OfertapracticasHasAlumnoPK other = (OfertapracticasHasAlumnoPK) object;
        if (this.ofertaPracticasidOfertaPracticas != other.ofertaPracticasidOfertaPracticas) {
            return false;
        }
        if ((this.alumnoPersonausuario == null && other.alumnoPersonausuario != null) || (this.alumnoPersonausuario != null && !this.alumnoPersonausuario.equals(other.alumnoPersonausuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.OfertapracticasHasAlumnoPK[ ofertaPracticasidOfertaPracticas=" + ofertaPracticasidOfertaPracticas + ", alumnoPersonausuario=" + alumnoPersonausuario + " ]";
    }

}
