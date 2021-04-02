/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "ejemplares", catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejemplares.findAll", query = "SELECT e FROM Ejemplares e")})
public class Ejemplares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ejemplar", nullable = false)
    private Integer idEjemplar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_adquisicion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdquisicion;
    @JoinTable(name = "ejemplares_prestamos", joinColumns = {
        @JoinColumn(name = "id_ejemplar", referencedColumnName = "id_ejemplar", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo", nullable = false)})
    @ManyToMany
    @JsonbTransient
    private List<Prestamos> prestamosList;
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro", nullable = false)
    @ManyToOne(optional = false)
    private Libro idLibro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEjemplar")
    @JsonbTransient
    private List<Reservas> reservasList;

    public Ejemplares() {
    }

    public Ejemplares(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Ejemplares(Integer idEjemplar, Date fechaAdquisicion) {
        this.idEjemplar = idEjemplar;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    @XmlTransient
    public List<Prestamos> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamos> prestamosList) {
        this.prestamosList = prestamosList;
    }

    public Libro getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }

    @XmlTransient
    public List<Reservas> getReservasList() {
        return reservasList;
    }

    public void setReservasList(List<Reservas> reservasList) {
        this.reservasList = reservasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEjemplar != null ? idEjemplar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejemplares)) {
            return false;
        }
        Ejemplares other = (Ejemplares) object;
        if ((this.idEjemplar == null && other.idEjemplar != null) || (this.idEjemplar != null && !this.idEjemplar.equals(other.idEjemplar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Ejemplares[ idEjemplar=" + idEjemplar + " ]";
    }

}
