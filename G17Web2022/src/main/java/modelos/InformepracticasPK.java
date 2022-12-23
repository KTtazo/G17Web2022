package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class InformepracticasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tutor_Persona_usuario")
    private String tutorPersonausuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Alumno_Persona_usuario")
    private String alumnoPersonausuario;

    public InformepracticasPK() {
    }

    public InformepracticasPK(String tutorPersonausuario, String alumnoPersonausuario) {
        this.tutorPersonausuario = tutorPersonausuario;
        this.alumnoPersonausuario = alumnoPersonausuario;
    }

    public String getTutorPersonausuario() {
        return tutorPersonausuario;
    }

    public void setTutorPersonausuario(String tutorPersonausuario) {
        this.tutorPersonausuario = tutorPersonausuario;
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
        hash += (tutorPersonausuario != null ? tutorPersonausuario.hashCode() : 0);
        hash += (alumnoPersonausuario != null ? alumnoPersonausuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformepracticasPK)) {
            return false;
        }
        InformepracticasPK other = (InformepracticasPK) object;
        if ((this.tutorPersonausuario == null && other.tutorPersonausuario != null) || (this.tutorPersonausuario != null && !this.tutorPersonausuario.equals(other.tutorPersonausuario))) {
            return false;
        }
        if ((this.alumnoPersonausuario == null && other.alumnoPersonausuario != null) || (this.alumnoPersonausuario != null && !this.alumnoPersonausuario.equals(other.alumnoPersonausuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.InformepracticasPK[ tutorPersonausuario=" + tutorPersonausuario + ", alumnoPersonausuario=" + alumnoPersonausuario + " ]";
    }

}
