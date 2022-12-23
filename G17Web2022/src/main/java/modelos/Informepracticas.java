package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "informepracticas")
@NamedQueries({
    @NamedQuery(name = "Informepracticas.findAll", query = "SELECT i FROM Informepracticas i"),
    @NamedQuery(name = "Informepracticas.findByComentarios", query = "SELECT i FROM Informepracticas i WHERE i.comentarios = :comentarios"),
    @NamedQuery(name = "Informepracticas.findByNota", query = "SELECT i FROM Informepracticas i WHERE i.nota = :nota"),
    @NamedQuery(name = "Informepracticas.findByTutorPersonausuario", query = "SELECT i FROM Informepracticas i WHERE i.informepracticasPK.tutorPersonausuario = :tutorPersonausuario"),
    @NamedQuery(name = "Informepracticas.findByAlumnoPersonausuario", query = "SELECT i FROM Informepracticas i WHERE i.informepracticasPK.alumnoPersonausuario = :alumnoPersonausuario")})
public class Informepracticas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InformepracticasPK informepracticasPK;
    @Size(max = 1000)
    @Column(name = "comentarios")
    private String comentarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota")
    private float nota;
    @JoinColumn(name = "Alumno_Persona_usuario", referencedColumnName = "Persona_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumns({
        @JoinColumn(name = "Tutor_Persona_usuario", referencedColumnName = "Persona_usuario", insertable = false, updatable = false),
        @JoinColumn(name = "Tutor_Empresa_cif", referencedColumnName = "Empresa_cif")})
    @ManyToOne(optional = false)
    private Tutor tutor;

    public Informepracticas() {
    }

    public Informepracticas(InformepracticasPK informepracticasPK) {
        this.informepracticasPK = informepracticasPK;
    }

    public Informepracticas(InformepracticasPK informepracticasPK, float nota) {
        this.informepracticasPK = informepracticasPK;
        this.nota = nota;
    }

    public Informepracticas(String tutorPersonausuario, String alumnoPersonausuario) {
        this.informepracticasPK = new InformepracticasPK(tutorPersonausuario, alumnoPersonausuario);
    }

    public InformepracticasPK getInformepracticasPK() {
        return informepracticasPK;
    }

    public void setInformepracticasPK(InformepracticasPK informepracticasPK) {
        this.informepracticasPK = informepracticasPK;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (informepracticasPK != null ? informepracticasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informepracticas)) {
            return false;
        }
        Informepracticas other = (Informepracticas) object;
        if ((this.informepracticasPK == null && other.informepracticasPK != null) || (this.informepracticasPK != null && !this.informepracticasPK.equals(other.informepracticasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Informepracticas[ informepracticasPK=" + informepracticasPK + " ]";
    }

}
