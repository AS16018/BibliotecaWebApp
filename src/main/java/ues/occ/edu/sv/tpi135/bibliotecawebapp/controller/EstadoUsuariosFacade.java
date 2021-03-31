/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.EstadoUsuarios;

/**
 *
 * @author christian
 */
@Stateless
public class EstadoUsuariosFacade extends AbstractFacade<EstadoUsuarios> {

    @PersistenceContext(unitName = "bibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoUsuariosFacade() {
        super(EstadoUsuarios.class);
    }
    
}
