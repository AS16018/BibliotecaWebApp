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
import javax.ws.rs.Path;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.ReservasFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.UsuariosFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.EstadoUsuarios;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Reservas;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Usuarios;

/**
 *
 * @author aragon598
 */
@Path("reservas")
@ApplicationScoped
public class ReservasResource implements Serializable {

    public ReservasResource() {
    }

    @Inject
    ReservasFacade reservasFacade;
    @Inject
    UsuariosFacade usuarioFacade;

    @GET
    @Path("findAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findAll() {

        List datos = null;

        try {
            if (reservasFacade != null) {
                datos = reservasFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        } finally {
            if (datos == null) {
                datos = new ArrayList();
            }
        }

        return Response.ok(datos).build();
    }

    @GET
    @Path("buscarId/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Integer id) {

        try {
            if (reservasFacade != null && id != null) {
                if (reservasFacade.find(id) == null) {
                    return Response.status(Response.Status.NOT_FOUND).entity("No existe reserva").build();
                } else {
                    return Response.ok(reservasFacade.find(id)).build();
                }
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return Response.noContent().build();
    }

    @POST
    @Path("crear")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response nuevaReserva(Reservas reserva) {
        List noReservar = new ArrayList<Reservas>();
        Usuarios user;
        
        
        
        try {
            if (reservasFacade != null && reserva != null) {
                reserva.setIdReserva(this.ultimoId());
                user= usuarioFacade.find(reserva.getIdUsuario().getIdUsuario());
                if (user.getIdEstado().getIdEstado() != 2) {
                    if(reservasFacade.count() == 0){
                        reservasFacade.create(reserva);
                    }
                    noReservar = reservasFacade.findAll().stream().filter(f1 -> ((f1.getFechaIncio().compareTo(reserva.getFechaIncio()) == 0) || (f1.getFechaIncio().compareTo(reserva.getFechaIncio()) < 0) && ((f1.getFechaFinalizacion().compareTo(reserva.getFechaFinalizacion()) == 0) || (f1.getFechaFinalizacion().compareTo(reserva.getFechaFinalizacion()) > 0)))).collect(Collectors.toList());
                    if (noReservar.isEmpty()) {
                        reservasFacade.create(reserva);
                    } else {
                        return Response.ok(noReservar).build();//devuelvo una lista indicando las fechas en las que ya esta reservado el ejemplar
                    }

                } else {
                    return Response.status(Response.Status.NOT_ACCEPTABLE).entity("No se puede ejutar la reserva por que el usuario está en estado moroso").build();
                }
            }

            if (reserva == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Reserva vacía").build();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Response.ok().build();
    }

    @PUT
    @Path("editar")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarReserva(Reservas reserva) {

        try {
            if (reservasFacade != null && reserva != null) {
                reservasFacade.edit(reserva);
            }
            if (reserva == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Reserva incorrecta. Datos vacíos").build();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return Response.ok().build();
    }

    @DELETE
    @Path("eliminar/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response eliminarReserva(@PathParam("id") Integer id) {
        List<Reservas> eliminar = null;

        try {

            if (reservasFacade != null) {
                eliminar = reservasFacade.findAll().stream().filter(o -> id == o.getIdReserva().intValue()).collect(Collectors.toList());
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("ID vacío").build();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return Response.ok().build();
    }

    public Integer ultimoId() {

        Integer id = 0;

        try {

            if (reservasFacade != null && reservasFacade.count() > 0) {
                id = reservasFacade.findAll().stream().max((id1, id2) -> id1.getIdReserva() - id2.getIdReserva()).get().getIdReserva();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        if (id == 0 || id == null) {
            id = 1;
        } else {
            id = id + 1;
        }
        return id;

    }
}
