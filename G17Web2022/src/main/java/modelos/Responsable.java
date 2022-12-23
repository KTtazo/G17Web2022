package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "responsable")
@NamedQueries({
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r"),
    @NamedQuery(name = "Responsable.findByPersonausuario", query = "SELECT r FROM Responsable r WHERE r.personausuario = :personausuario")})
public class Responsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Persona_usuario")
    private String personausuario;
    @JoinColumn(name = "Persona_usuario", referencedColumnName = "usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Responsable() {
    }

    public Responsable(String personausuario) {
        this.personausuario = personausuario;
    }

    public String getPersonausuario() {
        return personausuario;
    }

    public void setPersonausuario(String personausuario) {
        this.personausuario = personausuario;
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
        hash += (personausuario != null ? personausuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.personausuario == null && other.personausuario != null) || (this.personausuario != null && !this.personausuario.equals(other.personausuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Responsable[ personausuario=" + personausuario + " ]";
    }

}
