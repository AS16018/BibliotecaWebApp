/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "tipo_finalizacion_de_reserva", catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFinalizacionDeReserva.findAll", query = "SELECT t FROM TipoFinalizacionDeReserva t")})
public class TipoFinalizacionDeReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_finalizacion", nullable = false)
    private Integer idTipoFinalizacion;
    @Size(max = 100)
    @Column(name = "tipo_finalizacion", length = 100)
    private String tipoFinalizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoFinalizacion")
    @JsonbTransient
    private List<Reservas> reservasList;

    public TipoFinalizacionDeReserva() {
    }

    public TipoFinalizacionDeReserva(Integer idTipoFinalizacion) {
        this.idTipoFinalizacion = idTipoFinalizacion;
    }

    public Integer getIdTipoFinalizacion() {
        return idTipoFinalizacion;
    }

    public void setIdTipoFinalizacion(Integer idTipoFinalizacion) {
        this.idTipoFinalizacion = idTipoFinalizacion;
    }

    public String getTipoFinalizacion() {
        return tipoFinalizacion;
    }

    public void setTipoFinalizacion(String tipoFinalizacion) {
        this.tipoFinalizacion = tipoFinalizacion;
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
        hash += (idTipoFinalizacion != null ? idTipoFinalizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFinalizacionDeReserva)) {
            return false;
        }
        TipoFinalizacionDeReserva other = (TipoFinalizacionDeReserva) object;
        if ((this.idTipoFinalizacion == null && other.idTipoFinalizacion != null) || (this.idTipoFinalizacion != null && !this.idTipoFinalizacion.equals(other.idTipoFinalizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.TipoFinalizacionDeReserva[ idTipoFinalizacion=" + idTipoFinalizacion + " ]";
    }
    
}
