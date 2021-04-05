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
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.DireccionUsuariosFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.UsuariosFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.DireccionUsuarios;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Login;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Usuarios;

/**
 *
 * @author christian
 */
@Path("user")
@ApplicationScoped
public class UsuariosResource implements Serializable {

    public UsuariosResource() {

    }

    @Inject
    UsuariosFacade usuariosFacade;
    @Inject
    DireccionUsuariosFacade direccionFacade;

    @GET
    @Path("findAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findAll() {
        List salida = null;
        try {
            if (usuariosFacade != null) {
                salida = usuariosFacade.findAll();
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
            if (usuariosFacade != null && Id != null) {
                if (usuariosFacade.find(Id) == null) {
                    return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
                } else {
                    return Response.ok(usuariosFacade.find(Id)).build();
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
    public Response agregarUsuario(Usuarios user) {
        DireccionUsuarios direccion;
        try {
            if (usuariosFacade != null && user != null) {
                if (user.getNombre() != null && user.getIdEstado().getIdEstado() != null && user.getIdRol().getIdRol() != null) {
                    user.setIdUsuario(this.obtenerUltimoId());
                    direccion = user.getIdDireccion();
                    if (direccionFacade != null && direccion != null) {
                        direccion.setIdDireccion(user.getIdUsuario());
                        direccionFacade.create(direccion);
                    }
                    user.setIdDireccion(direccion);
                    usuariosFacade.create(user);
                }else{
                    return Response.status(Response.Status.BAD_REQUEST).entity("Error al crear un nuevo usuario, verifique que los campos obligatorios no vayan nulos").build();
                }

            }
            if (user == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Usuario nulo").build();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return Response.ok().build();
    }

    @POST
    @Path("auth")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response login(Login login) {
        List<Usuarios> usuario = null;
        String mensaje = null;

        try {

            if (usuariosFacade != null && login != null) {
                usuario = usuariosFacade.findAll().stream().filter(e -> e.getCorreo().equals(login.getCorreo())).collect(Collectors.toList());
            }
            if (login == null) {
                mensaje = "";
                return Response.status(Response.Status.BAD_REQUEST).entity(mensaje).build();
            }

        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        if (usuario == null || usuario.size() < 1) {
            mensaje = "Error. El email " + login.getCorreo() + " no está registrado.";

            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(mensaje).build();
        } else if (!usuario.get(0).getPassword().equals(login.getPassword())) {
            mensaje = "La contraseña que intenta ingresar es inválida, por favor intente nuevamente";
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(mensaje).build();
        }

        return Response.status(Response.Status.ACCEPTED).entity("Success login").build();
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response modificarUsuario(Usuarios user) {
        DireccionUsuarios direccion;
        try {
            if (usuariosFacade != null && user != null) {

                direccion = user.getIdDireccion();
                if (direccionFacade != null && direccion != null) {
                    direccionFacade.edit(direccion);
                }
                usuariosFacade.edit(user);
            }
            if (user == null) {
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
    public Response deleteUsers(@PathParam("id") Integer id) {
        List<Usuarios> datoEliminar = null;
        
        try {
            if (usuariosFacade != null) {
                if (id != null) {
                    datoEliminar = usuariosFacade.findAll().stream().filter(t -> id == t.getIdUsuario().intValue()).collect(Collectors.toList());
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity("El id va nulo").build();
                }
            }

            if (datoEliminar.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }
            Usuarios datoE = datoEliminar.get(0);
            
            direccionFacade.remove(datoE.getIdDireccion());
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return Response.ok().build();
    }

    public Integer obtenerUltimoId() {
        Integer idMayor = 0;

        try {

            if (usuariosFacade != null) {
                idMayor = usuariosFacade.findAll().stream().max((id1, id2) -> id1.getIdUsuario() - id2.getIdUsuario()).get().getIdUsuario();
            }

        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        if (idMayor == 0 || idMayor == null) {
            idMayor = 1;
        } else {
            idMayor = idMayor + 1;
        }
        return idMayor;
    }
}
