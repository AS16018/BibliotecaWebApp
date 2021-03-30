/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "libro", catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libro", nullable = false)
    private Integer idLibro;
    @Size(max = 100)
    @Column(name = "titulo", length = 100)
    private String titulo;
    @Size(max = 100)
    @Column(name = "autor", length = 100)
    private String autor;
    @Column(name = "num_paginas")
    private Integer numPaginas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLibro")
    private List<Ejemplares> ejemplaresList;

    public Libro() {
    }

    public Libro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    @XmlTransient
    public List<Ejemplares> getEjemplaresList() {
        return ejemplaresList;
    }

    public void setEjemplaresList(List<Ejemplares> ejemplaresList) {
        this.ejemplaresList = ejemplaresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Libro[ idLibro=" + idLibro + " ]";
    }
    
}
