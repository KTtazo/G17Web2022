package modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumno")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByPersonausuario", query = "SELECT a FROM Alumno a WHERE a.personausuario = :personausuario"),
    @NamedQuery(name = "Alumno.findByNotaMedia", query = "SELECT a FROM Alumno a WHERE a.notaMedia = :notaMedia"),
    @NamedQuery(name = "Alumno.findByCarrera", query = "SELECT a FROM Alumno a WHERE a.carrera = :carrera"),
    @NamedQuery(name = "Alumno.findByCreditosCursados", query = "SELECT a FROM Alumno a WHERE a.creditosCursados = :creditosCursados")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Persona_usuario")
    private String personausuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notaMedia")
    private float notaMedia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "carrera")
    private String carrera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditosCursados")
    private short creditosCursados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<Informepracticas> informepracticasCollection;
    @JoinColumn(name = "OfertaPracticas_idOfertaPracticas", referencedColumnName = "idOfertaPracticas")
    @ManyToOne
    private Ofertapracticas ofertaPracticasidOfertaPracticas;
    @JoinColumn(name = "Persona_usuario", referencedColumnName = "usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<OfertapracticasHasAlumno> ofertapracticasHasAlumnoCollection;

    public Alumno() {
    }

    public Alumno(String personausuario) {
        this.personausuario = personausuario;
    }

    public Alumno(String personausuario, float notaMedia, String carrera, short creditosCursados) {
        this.personausuario = personausuario;
        this.notaMedia = notaMedia;
        this.carrera = carrera;
        this.creditosCursados = creditosCursados;
    }

    public String getPersonausuario() {
        return personausuario;
    }

    public void setPersonausuario(String personausuario) {
        this.personausuario = personausuario;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public short getCreditosCursados() {
        return creditosCursados;
    }

    public void setCreditosCursados(short creditosCursados) {
        this.creditosCursados = creditosCursados;
    }

    public Collection<Informepracticas> getInformepracticasCollection() {
        return informepracticasCollection;
    }

    public void setInformepracticasCollection(Collection<Informepracticas> informepracticasCollection) {
        this.informepracticasCollection = informepracticasCollection;
    }

    public Ofertapracticas getOfertaPracticasidOfertaPracticas() {
        return ofertaPracticasidOfertaPracticas;
    }

    public void setOfertaPracticasidOfertaPracticas(Ofertapracticas ofertaPracticasidOfertaPracticas) {
        this.ofertaPracticasidOfertaPracticas = ofertaPracticasidOfertaPracticas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Collection<OfertapracticasHasAlumno> getOfertapracticasHasAlumnoCollection() {
        return ofertapracticasHasAlumnoCollection;
    }

    public void setOfertapracticasHasAlumnoCollection(Collection<OfertapracticasHasAlumno> ofertapracticasHasAlumnoCollection) {
        this.ofertapracticasHasAlumnoCollection = ofertapracticasHasAlumnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personausuario != null ? personausuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.personausuario == null && other.personausuario != null) || (this.personausuario != null && !this.personausuario.equals(other.personausuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Alumno[ personausuario=" + personausuario + " ]";
    }

}
