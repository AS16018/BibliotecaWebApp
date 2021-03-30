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
@Table(name = "multas_usuarios", catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MultasUsuarios.findAll", query = "SELECT m FROM MultasUsuarios m")})
public class MultasUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_multa", nullable = false)
    private Integer idMulta;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto", nullable = false)
    private double monto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public MultasUsuarios() {
    }

    public MultasUsuarios(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public MultasUsuarios(Integer idMulta, boolean estado, double monto) {
        this.idMulta = idMulta;
        this.estado = estado;
        this.monto = monto;
    }

    public Integer getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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
        hash += (idMulta != null ? idMulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MultasUsuarios)) {
            return false;
        }
        MultasUsuarios other = (MultasUsuarios) object;
        if ((this.idMulta == null && other.idMulta != null) || (this.idMulta != null && !this.idMulta.equals(other.idMulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.MultasUsuarios[ idMulta=" + idMulta + " ]";
    }
    
}
