/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "reservas", catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r")})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva", nullable = false)
    private Integer idReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_reserva", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_finalizacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_reserva", nullable = false)
    private boolean estadoReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_incio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIncio;
    @JoinColumn(name = "id_ejemplar", referencedColumnName = "id_ejemplar", nullable = false)
    @ManyToOne(optional = false)
    private Ejemplares idEjemplar;
    @JoinColumn(name = "id_tipo_finalizacion", referencedColumnName = "id_tipo_finalizacion", nullable = false)
    @ManyToOne(optional = false)
    private TipoFinalizacionDeReserva idTipoFinalizacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Reservas() {
    }

    public Reservas(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reservas(Integer idReserva, Date fechaReserva, Date fechaFinalizacion, boolean estadoReserva, Date fechaIncio) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estadoReserva = estadoReserva;
        this.fechaIncio = fechaIncio;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public boolean getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Date getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public Ejemplares getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Ejemplares idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public TipoFinalizacionDeReserva getIdTipoFinalizacion() {
        return idTipoFinalizacion;
    }

    public void setIdTipoFinalizacion(TipoFinalizacionDeReserva idTipoFinalizacion) {
        this.idTipoFinalizacion = idTipoFinalizacion;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Reservas[ idReserva=" + idReserva + " ]";
    }
    
}
