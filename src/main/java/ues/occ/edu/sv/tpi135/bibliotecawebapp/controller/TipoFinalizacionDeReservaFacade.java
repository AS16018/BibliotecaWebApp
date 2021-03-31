/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.TipoFinalizacionDeReserva;

/**
 *
 * @author aragon598
 */
@Stateless
public class TipoFinalizacionDeReservaFacade extends AbstractFacade<TipoFinalizacionDeReserva> {

    @PersistenceContext(unitName = "bibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoFinalizacionDeReservaFacade() {
        super(TipoFinalizacionDeReserva.class);
    }
    
}
