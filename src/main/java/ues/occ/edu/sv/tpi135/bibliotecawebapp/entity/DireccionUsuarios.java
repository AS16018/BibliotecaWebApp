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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "direccion_usuarios", catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionUsuarios.findAll", query = "SELECT d FROM DireccionUsuarios d")})
public class DireccionUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 55)
    @Column(name = "ciudad", length = 55)
    private String ciudad;
    @Size(max = 55)
    @Column(name = "calle", length = 55)
    private String calle;
    @Column(name = "num_casa")
    private Integer numCasa;
    @Size(max = 50)
    @Column(name = "piso", length = 50)
    private String piso;
    @Size(max = 10)
    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_direccion", nullable = false)
    private Integer idDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDireccion")
    @JsonbTransient
    private List<Usuarios> usuariosList;

    public DireccionUsuarios() {
    }

    public DireccionUsuarios(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(Integer numCasa) {
        this.numCasa = numCasa;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionUsuarios)) {
            return false;
        }
        DireccionUsuarios other = (DireccionUsuarios) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.DireccionUsuarios[ idDireccion=" + idDireccion + " ]";
    }
    
}
