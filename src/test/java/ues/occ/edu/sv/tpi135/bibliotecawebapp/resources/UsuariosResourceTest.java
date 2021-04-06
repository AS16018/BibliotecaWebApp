/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.UsuariosFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Login;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Usuarios;

/**
 *
 * @author aragon598
 */
public class UsuariosResourceTest {
    
    public UsuariosResourceTest() {
    }

    /**
     * Test of findAll method, of class UsuariosResource.
     */
    @Test
    public void testFindAll() {
        UsuariosResource usuarioR = new UsuariosResource();
        UsuariosFacade usuariosFacadeMock=Mockito.mock(UsuariosFacade.class);
        usuarioR.usuariosFacade = usuariosFacadeMock;
        
        try {
            List<Usuarios> listaSalida = new ArrayList<>();
            listaSalida.add(new Usuarios(1));
            
            Mockito.when(usuariosFacadeMock.findAll()).thenReturn(listaSalida);
            usuarioR.findAll();
            
            listaSalida= null;
            Mockito.when(usuariosFacadeMock.findAll()).thenReturn(listaSalida);
            usuarioR.findAll();
            
        } catch (Exception e) {
        }
        try {
            assertThrows(Exception.class, () ->{
                Mockito.doThrow(Exception.class).when(usuariosFacadeMock).findAll();
            });
            usuarioR.findAll();
        } catch (Exception e) {
        }
        
    }

    /**
     * Test of findById method, of class UsuariosResource.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        UsuariosResource usuarioR = new UsuariosResource();
        UsuariosFacade usuariosFacadeMock=Mockito.mock(UsuariosFacade.class);
        usuarioR.usuariosFacade = usuariosFacadeMock;
        Integer id = 1;
        try {
            List<Usuarios> listaUsuarios = new ArrayList<>();
            listaUsuarios.add(new Usuarios(1));
            listaUsuarios.add(null);
            Mockito.when(usuariosFacadeMock.find(id)).thenReturn(listaUsuarios.get(1));
            usuarioR.findById(id);
            
            Mockito.when(usuariosFacadeMock.find(id)).thenReturn(listaUsuarios.get(0));
            usuarioR.findById(id);
//            
//            Mockito.when(usuariosFacadeMock.find(null)).then((Answer<?>) Response.noContent().build());
//            usuarioR.findById(null);
            Assertions.assertEquals(Response.noContent().build().getStatus(), usuarioR.findById(null).getStatus());
        } catch (Exception e) {
        }
        
        try {
            assertThrows(Exception.class,() ->{
                Mockito.doThrow(Exception.class).when(usuariosFacadeMock).find(id);
            });
            usuarioR.findById(id);
        } catch (Exception e) {
        }
    }

    /**
     * Test of agregarUsuario method, of class UsuariosResource.
     */
    @Test
    public void testAgregarUsuario() {
        System.out.println("agregarUsuario");
        
    }

    /**
     * Test of login method, of class UsuariosResource.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        
    }

    /**
     * Test of modificarUsuario method, of class UsuariosResource.
     */
    @Test
    public void testModificarUsuario() {
        System.out.println("modificarUsuario");
        
    }

    /**
     * Test of deleteUsers method, of class UsuariosResource.
     */
    @Test
    public void testDeleteUsers() {
        System.out.println("deleteUsers");
        
    }

    /**
     * Test of obtenerUltimoId method, of class UsuariosResource.
     */
    @Test
    public void testObtenerUltimoId() {
        System.out.println("obtenerUltimoId");
        
    }
    
}
