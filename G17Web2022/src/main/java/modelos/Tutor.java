package modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tutor")
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t"),
    @NamedQuery(name = "Tutor.findByCargo", query = "SELECT t FROM Tutor t WHERE t.cargo = :cargo"),
    @NamedQuery(name = "Tutor.findByPersonausuario", query = "SELECT t FROM Tutor t WHERE t.tutorPK.personausuario = :personausuario"),
    @NamedQuery(name = "Tutor.findByEmpresacif", query = "SELECT t FROM Tutor t WHERE t.tutorPK.empresacif = :empresacif")})
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TutorPK tutorPK;
    @Size(max = 100)
    @Column(name = "cargo")
    private String cargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private Collection<Ofertapracticas> ofertapracticasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private Collection<Informepracticas> informepracticasCollection;
    @JoinColumn(name = "Empresa_cif", referencedColumnName = "cif", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "Persona_usuario", referencedColumnName = "usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public Tutor() {
    }

    public Tutor(TutorPK tutorPK) {
        this.tutorPK = tutorPK;
    }

    public Tutor(String personausuario, String empresacif) {
        this.tutorPK = new TutorPK(personausuario, empresacif);
    }

    public TutorPK getTutorPK() {
        return tutorPK;
    }

    public void setTutorPK(TutorPK tutorPK) {
        this.tutorPK = tutorPK;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Collection<Ofertapracticas> getOfertapracticasCollection() {
        return ofertapracticasCollection;
    }

    public void setOfertapracticasCollection(Collection<Ofertapracticas> ofertapracticasCollection) {
        this.ofertapracticasCollection = ofertapracticasCollection;
    }

    public Collection<Informepracticas> getInformepracticasCollection() {
        return informepracticasCollection;
    }

    public void setInformepracticasCollection(Collection<Informepracticas> informepracticasCollection) {
        this.informepracticasCollection = informepracticasCollection;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tutorPK != null ? tutorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutor)) {
            return false;
        }
        Tutor other = (Tutor) object;
        if ((this.tutorPK == null && other.tutorPK != null) || (this.tutorPK != null && !this.tutorPK.equals(other.tutorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Tutor[ tutorPK=" + tutorPK + " ]";
    }

}
