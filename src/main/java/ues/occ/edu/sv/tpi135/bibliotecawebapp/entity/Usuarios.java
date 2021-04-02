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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuarios", catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Size(max = 100)
    @Column(name = "apellido", length = 100)
    private String apellido;
    @Size(max = 150)
    @Column(name = "correo", length = 150)
    private String correo;
    @Size(max = 255)
    @Column(name = "password", length = 255)
    private String password;
    @Size(max = 8)
    @Column(name = "Column1", length = 8)
    private String column1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    @JsonbTransient
    private List<MultasUsuarios> multasUsuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    @JsonbTransient
    private List<Reservas> reservasList;
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false)
    @ManyToOne(optional = false)
    private DireccionUsuarios idDireccion;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    @ManyToOne(optional = false)
    private EstadoUsuarios idEstado;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @ManyToOne(optional = false)
    private RolesUsuario idRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    @JsonbTransient
    private List<Prestamos> prestamosList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    @XmlTransient
    public List<MultasUsuarios> getMultasUsuariosList() {
        return multasUsuariosList;
    }

    public void setMultasUsuariosList(List<MultasUsuarios> multasUsuariosList) {
        this.multasUsuariosList = multasUsuariosList;
    }

    @XmlTransient
    public List<Reservas> getReservasList() {
        return reservasList;
    }

    public void setReservasList(List<Reservas> reservasList) {
        this.reservasList = reservasList;
    }

    public DireccionUsuarios getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(DireccionUsuarios idDireccion) {
        this.idDireccion = idDireccion;
    }

    public EstadoUsuarios getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoUsuarios idEstado) {
        this.idEstado = idEstado;
    }

    public RolesUsuario getIdRol() {
        return idRol;
    }

    public void setIdRol(RolesUsuario idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public List<Prestamos> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamos> prestamosList) {
        this.prestamosList = prestamosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
