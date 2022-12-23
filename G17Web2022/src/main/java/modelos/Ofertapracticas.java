package modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ofertapracticas")
@NamedQueries({
    @NamedQuery(name = "Ofertapracticas.findAll", query = "SELECT o FROM Ofertapracticas o"),
    @NamedQuery(name = "Ofertapracticas.findByIdOfertaPracticas", query = "SELECT o FROM Ofertapracticas o WHERE o.idOfertaPracticas = :idOfertaPracticas"),
    @NamedQuery(name = "Ofertapracticas.findByDescripcion", query = "SELECT o FROM Ofertapracticas o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "Ofertapracticas.findByTitulo", query = "SELECT o FROM Ofertapracticas o WHERE o.titulo = :titulo"),
    @NamedQuery(name = "Ofertapracticas.findByIdiomas", query = "SELECT o FROM Ofertapracticas o WHERE o.idiomas = :idiomas"),
    @NamedQuery(name = "Ofertapracticas.findByRequisitos", query = "SELECT o FROM Ofertapracticas o WHERE o.requisitos = :requisitos"),
    @NamedQuery(name = "Ofertapracticas.findByHoraInicio", query = "SELECT o FROM Ofertapracticas o WHERE o.horaInicio = :horaInicio"),
    @NamedQuery(name = "Ofertapracticas.findByPlazas", query = "SELECT o FROM Ofertapracticas o WHERE o.plazas = :plazas"),
    @NamedQuery(name = "Ofertapracticas.findByHoraSalida", query = "SELECT o FROM Ofertapracticas o WHERE o.horaSalida = :horaSalida"),
    @NamedQuery(name = "Ofertapracticas.findBySalario", query = "SELECT o FROM Ofertapracticas o WHERE o.salario = :salario"),
    @NamedQuery(name = "Ofertapracticas.findByDuracion", query = "SELECT o FROM Ofertapracticas o WHERE o.duracion = :duracion"),
    @NamedQuery(name = "Ofertapracticas.findByFechaInicio", query = "SELECT o FROM Ofertapracticas o WHERE o.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Ofertapracticas.findByCurso", query = "SELECT o FROM Ofertapracticas o WHERE o.curso = :curso")})
public class Ofertapracticas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOfertaPracticas")
    private Integer idOfertaPracticas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 45)
    @Column(name = "idiomas")
    private String idiomas;
    @Size(max = 200)
    @Column(name = "requisitos")
    private String requisitos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaInicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plazas")
    private short plazas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaSalida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Column(name = "salario")
    private Short salario;
    @Column(name = "duracion")
    private Short duracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "curso")
    private String curso;
    @JoinColumns({
        @JoinColumn(name = "Tutor_Persona_usuario", referencedColumnName = "Persona_usuario"),
        @JoinColumn(name = "Tutor_Empresa_cif", referencedColumnName = "Empresa_cif")})
    @ManyToOne(optional = false)
    private Tutor tutor;
    @OneToMany(mappedBy = "ofertaPracticasidOfertaPracticas")
    private Collection<Alumno> alumnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofertapracticas")
    private Collection<OfertapracticasHasAlumno> ofertapracticasHasAlumnoCollection;

    public Ofertapracticas() {
    }

    public Ofertapracticas(Integer idOfertaPracticas) {
        this.idOfertaPracticas = idOfertaPracticas;
    }

    public Ofertapracticas(Integer idOfertaPracticas, String descripcion, String titulo, Date horaInicio, short plazas, Date horaSalida, Date fechaInicio, String curso) {
        this.idOfertaPracticas = idOfertaPracticas;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.horaInicio = horaInicio;
        this.plazas = plazas;
        this.horaSalida = horaSalida;
        this.fechaInicio = fechaInicio;
        this.curso = curso;
    }

    public Integer getIdOfertaPracticas() {
        return idOfertaPracticas;
    }

    public void setIdOfertaPracticas(Integer idOfertaPracticas) {
        this.idOfertaPracticas = idOfertaPracticas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public short getPlazas() {
        return plazas;
    }

    public void setPlazas(short plazas) {
        this.plazas = plazas;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Short getSalario() {
        return salario;
    }

    public void setSalario(Short salario) {
        this.salario = salario;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
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
        hash += (idOfertaPracticas != null ? idOfertaPracticas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofertapracticas)) {
            return false;
        }
        Ofertapracticas other = (Ofertapracticas) object;
        if ((this.idOfertaPracticas == null && other.idOfertaPracticas != null) || (this.idOfertaPracticas != null && !this.idOfertaPracticas.equals(other.idOfertaPracticas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Ofertapracticas[ idOfertaPracticas=" + idOfertaPracticas + " ]";
    }

}
