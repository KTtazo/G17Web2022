package modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ofertapracticas_has_alumno")
@NamedQueries({
    @NamedQuery(name = "OfertapracticasHasAlumno.findAll", query = "SELECT o FROM OfertapracticasHasAlumno o"),
    @NamedQuery(name = "OfertapracticasHasAlumno.findByOfertaPracticasidOfertaPracticas", query = "SELECT o FROM OfertapracticasHasAlumno o WHERE o.ofertapracticasHasAlumnoPK.ofertaPracticasidOfertaPracticas = :ofertaPracticasidOfertaPracticas"),
    @NamedQuery(name = "OfertapracticasHasAlumno.findByAlumnoPersonausuario", query = "SELECT o FROM OfertapracticasHasAlumno o WHERE o.ofertapracticasHasAlumnoPK.alumnoPersonausuario = :alumnoPersonausuario"),
    @NamedQuery(name = "OfertapracticasHasAlumno.findByPrioridad", query = "SELECT o FROM OfertapracticasHasAlumno o WHERE o.prioridad = :prioridad")})
public class OfertapracticasHasAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OfertapracticasHasAlumnoPK ofertapracticasHasAlumnoPK;
    @Column(name = "prioridad")
    private Short prioridad;
    @JoinColumn(name = "Alumno_Persona_usuario", referencedColumnName = "Persona_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "OfertaPracticas_idOfertaPracticas", referencedColumnName = "idOfertaPracticas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ofertapracticas ofertapracticas;

    public OfertapracticasHasAlumno() {
    }

    public OfertapracticasHasAlumno(OfertapracticasHasAlumnoPK ofertapracticasHasAlumnoPK) {
        this.ofertapracticasHasAlumnoPK = ofertapracticasHasAlumnoPK;
    }

    public OfertapracticasHasAlumno(int ofertaPracticasidOfertaPracticas, String alumnoPersonausuario) {
        this.ofertapracticasHasAlumnoPK = new OfertapracticasHasAlumnoPK(ofertaPracticasidOfertaPracticas, alumnoPersonausuario);
    }

    public OfertapracticasHasAlumnoPK getOfertapracticasHasAlumnoPK() {
        return ofertapracticasHasAlumnoPK;
    }

    public void setOfertapracticasHasAlumnoPK(OfertapracticasHasAlumnoPK ofertapracticasHasAlumnoPK) {
        this.ofertapracticasHasAlumnoPK = ofertapracticasHasAlumnoPK;
    }

    public Short getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Short prioridad) {
        this.prioridad = prioridad;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Ofertapracticas getOfertapracticas() {
        return ofertapracticas;
    }

    public void setOfertapracticas(Ofertapracticas ofertapracticas) {
        this.ofertapracticas = ofertapracticas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ofertapracticasHasAlumnoPK != null ? ofertapracticasHasAlumnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertapracticasHasAlumno)) {
            return false;
        }
        OfertapracticasHasAlumno other = (OfertapracticasHasAlumno) object;
        if ((this.ofertapracticasHasAlumnoPK == null && other.ofertapracticasHasAlumnoPK != null) || (this.ofertapracticasHasAlumnoPK != null && !this.ofertapracticasHasAlumnoPK.equals(other.ofertapracticasHasAlumnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.OfertapracticasHasAlumno[ ofertapracticasHasAlumnoPK=" + ofertapracticasHasAlumnoPK + " ]";
    }

}
