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
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.LibroFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Libro;

/**
 *
 * @author christian
 */
@Path("libros")
@ApplicationScoped
public class LibrosResource implements Serializable{
    
    public LibrosResource(){
        
    }
    
    @Inject
    LibroFacade librofacade;
    
    @GET
    @Path("findAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findAll() {
        List salida = null;
        try {
            if (librofacade != null) {
                salida = librofacade.findAll();
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
            if (librofacade != null && Id != null) {
                if (librofacade.find(Id) == null) {
                    return Response.status(Response.Status.NOT_FOUND).entity("Libro no encontrado").build();
                } else {
                    return Response.ok(librofacade.find(Id)).build();
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
    public Response crearLibro(Libro libro) {

        try {   
            if (librofacade != null && libro != null) {
                libro.setIdLibro(this.obtenerUltimoId());
                librofacade.create(libro);
            }
            if (libro == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Libro nulo").build();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return Response.ok().build();
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response modificarLibro(Libro libro) {

        try {
            if (librofacade != null && libro != null) {
                librofacade.edit(libro);
            }
            if (libro == null) {
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
    public Response deleteLibros(@PathParam("id") Integer id) {
        List<Libro> datoEliminar = null;
        try {
            if (librofacade != null) {
                if (id != null) {
                    datoEliminar = librofacade.findAll().stream().filter(t -> id == t.getIdLibro().intValue()).collect(Collectors.toList());
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity("El id va nulo").build();
                }
            }

            if (datoEliminar.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Librp no encontrado").build();
            }
            Libro datoE = datoEliminar.get(0);
            librofacade.remove(datoE);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return Response.ok().build();
    }
    
    public Integer obtenerUltimoId(){
        Integer idMayor = 0;
        try {
            if (librofacade != null) {
                idMayor = librofacade.findAll().stream().max((id1, id2) -> id1.getIdLibro()- id2.getIdLibro()).get().getIdLibro();
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
