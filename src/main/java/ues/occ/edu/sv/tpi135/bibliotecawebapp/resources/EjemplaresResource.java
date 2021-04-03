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
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.EjemplaresFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Ejemplares;

/**
 *
 * @author christian
 */
@Path("ejemplares")
@ApplicationScoped
public class EjemplaresResource implements Serializable {

    public EjemplaresResource(){
        
    }
    
    @Inject
    EjemplaresFacade ejemplarFacade;
    
    @GET
    @Path("findAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findAll() {
        List salida = null;
        try {
            if (ejemplarFacade != null) {
                salida = ejemplarFacade.findAll();
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
            if (ejemplarFacade != null && Id != null) {
                if (ejemplarFacade.find(Id) == null) {
                    return Response.status(Response.Status.NOT_FOUND).entity("Ejemplar no encontrado").build();
                } else {
                    return Response.ok(ejemplarFacade.find(Id)).build();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return Response.noContent().build();
    }

    @POST
    @Path("crear")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response crearEjemplares(Ejemplares ejemplar) {

        try {   
            if (ejemplarFacade != null && ejemplar != null) {
                ejemplar.setIdEjemplar(this.obtenerUltimoId());
                ejemplarFacade.create(ejemplar);
            }
            if (ejemplar == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Ejemplar nulo").build();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return Response.ok().build();
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response modificarEjemplares(Ejemplares ejemplar) {

        try {
            if (ejemplarFacade != null && ejemplar != null) {
                ejemplarFacade.edit(ejemplar);
            }
            if (ejemplar == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Datos nulos").build();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(value = MediaType.TEXT_PLAIN)
    public Response deleteEjemplares(@PathParam("id") Integer id) {
        List<Ejemplares> datoEliminar = null;
        try {
            if (ejemplarFacade != null) {
                if (id != null) {
                    datoEliminar = ejemplarFacade.findAll().stream().filter(t -> id == t.getIdEjemplar().intValue()).collect(Collectors.toList());
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity("El id va nulo").build();
                }
            }

            if (datoEliminar.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Ejemplar no encontrado").build();
            }
            Ejemplares datoE = datoEliminar.get(0);
            ejemplarFacade.remove(datoE);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return Response.ok().build();
    }
    
    public Integer obtenerUltimoId(){
        Integer idMayor = 0;
        try {
            if (ejemplarFacade != null) {
                idMayor = ejemplarFacade.findAll().stream().max((id1, id2) -> id1.getIdEjemplar()- id2.getIdEjemplar()).get().getIdEjemplar();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        if (idMayor == 0 || idMayor == null) {
            idMayor = 1;
        }
        else{
            idMayor = idMayor+1;
        }
        return idMayor;
    }
}
