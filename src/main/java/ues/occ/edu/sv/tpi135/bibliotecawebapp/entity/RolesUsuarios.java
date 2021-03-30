/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "roles_usuarios", catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolesUsuarios.findAll", query = "SELECT r FROM RolesUsuarios r")})
public class RolesUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;
    @Size(max = 15)
    @Column(name = "rol", length = 15)
    private String rol;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuarios idUsuario;

    public RolesUsuarios() {
    }

    public RolesUsuarios(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesUsuarios)) {
            return false;
        }
        RolesUsuarios other = (RolesUsuarios) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.RolesUsuarios[ idRol=" + idRol + " ]";
    }
    
}
