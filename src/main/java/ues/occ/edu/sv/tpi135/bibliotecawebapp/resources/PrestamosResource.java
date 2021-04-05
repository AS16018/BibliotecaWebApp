/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.PrestamosFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Prestamos;

/**
 *
 * @author christian
 */
@Path("prestamo")
@ApplicationScoped
public class PrestamosResource implements Serializable{
    
    public PrestamosResource(){
        
    }
    
    @Inject
    PrestamosFacade prestamosFacade;
    
    @GET
    @Path("findAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findAll() {
        List salida = null;
        try {
            if (prestamosFacade != null) {
                salida = prestamosFacade.findAll();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (salida == null) {
                salida = new ArrayList();
            }
        }
        return Response.ok(salida).build();
    }
    
    @GET
    @Path("buscarId/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Integer Id) {

        try {
            if (prestamosFacade != null && Id != null) {
                if (prestamosFacade.find(Id) == null) {
                    return Response.status(Response.Status.NOT_FOUND).entity("Prestamo no encontrado").build();
                } else {
                    return Response.ok(prestamosFacade.find(Id)).build();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return Response.noContent().build();
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response modificarUsuario(Prestamos prestamo) {
        try {
            if (prestamosFacade != null && prestamo != null) {
                prestamosFacade.edit(prestamo);
            }
            if (prestamo == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Datos nulos").build();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return Response.ok().build();
    }
}
