package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class TutorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Persona_usuario")
    private String personausuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "Empresa_cif")
    private String empresacif;

    public TutorPK() {
    }

    public TutorPK(String personausuario, String empresacif) {
        this.personausuario = personausuario;
        this.empresacif = empresacif;
    }

    public String getPersonausuario() {
        return personausuario;
    }

    public void setPersonausuario(String personausuario) {
        this.personausuario = personausuario;
    }

    public String getEmpresacif() {
        return empresacif;
    }

    public void setEmpresacif(String empresacif) {
        this.empresacif = empresacif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personausuario != null ? personausuario.hashCode() : 0);
        hash += (empresacif != null ? empresacif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TutorPK)) {
            return false;
        }
        TutorPK other = (TutorPK) object;
        if ((this.personausuario == null && other.personausuario != null) || (this.personausuario != null && !this.personausuario.equals(other.personausuario))) {
            return false;
        }
        if ((this.empresacif == null && other.empresacif != null) || (this.empresacif != null && !this.empresacif.equals(other.empresacif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.TutorPK[ personausuario=" + personausuario + ", empresacif=" + empresacif + " ]";
    }

}
