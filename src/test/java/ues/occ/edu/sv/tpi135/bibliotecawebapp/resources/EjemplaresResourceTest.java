/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.resources;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.EjemplaresFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Ejemplares;

/**
 *
 * @author aragon598
 */
@ExtendWith(MockitoExtension.class)
public class EjemplaresResourceTest {
    
    public EjemplaresResourceTest() {
    }

    

    /**
     * Test of findAll method, of class EjemplaresResource.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        
        
        EjemplaresResource ejemplar = new EjemplaresResource();
        EjemplaresFacade ejFaMock = Mockito.mock(EjemplaresFacade.class);
        ejemplar.ejemplarFacade = ejFaMock;
        
        try {
            
            List salida = Mockito.mock(List.class);
            Mockito.when(ejFaMock.findAll()).thenReturn(salida);
            ejemplar.findAll();
            
            
        } catch (Exception e) {
        }
        
        try {
            assertThrows(Exception.class,() ->{
                Mockito.doThrow(Exception.class).when(ejFaMock).findAll();
            });
            ejemplar.findAll();
        } catch (Exception e) {
        }
    }

    /**
     * Test of findById method, of class EjemplaresResource.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        
        EjemplaresResource ejemplarR = new EjemplaresResource();
        EjemplaresFacade ejFaMock = Mockito.mock(EjemplaresFacade.class);
        ejemplarR.ejemplarFacade = ejFaMock;
        Integer id = 1;
        
        try {
            List<Ejemplares> listaEjemplare = new ArrayList<>();
            listaEjemplare.add(new Ejemplares(1));
            listaEjemplare.add(null);
            
            Mockito.when(ejFaMock.find(id)).thenReturn(listaEjemplare.get(1));
            ejemplarR.findById(id);
            
            Mockito.when(ejFaMock.find(id)).thenReturn(listaEjemplare.get(0));
            ejemplarR.findById(id);
            
            Assertions.assertEquals(Response.noContent().build().getStatus(), ejemplarR.findById(null).getStatus());
        } catch (Exception e) {
        }
        
        try {
            Assertions.assertThrows(Exception.class,()->{
                Mockito.doThrow(Exception.class).when(ejFaMock).find(id);
            });
            ejemplarR.findById(id);
        } catch (Exception e) {
        }
        
    }

    /**
     * Test of crearEjemplares method, of class EjemplaresResource.
     */
    @Test
    public void testCrearEjemplares() {
        System.out.println("crearEjemplares");
    }

    /**
     * Test of modificarEjemplares method, of class EjemplaresResource.
     */
    @Test
    public void testModificarEjemplares() {
        System.out.println("modificarEjemplares");
        Ejemplares ejemplar = null;
    }

    /**
     * Test of deleteEjemplares method, of class EjemplaresResource.
     */
    @Test
    public void testDeleteEjemplares() {
        System.out.println("deleteEjemplares");
    }

    /**
     * Test of obtenerUltimoId method, of class EjemplaresResource.
     */
    @Test
    public void testObtenerUltimoId() {
        System.out.println("obtenerUltimoId");
        EjemplaresResource ejR = new EjemplaresResource();
        EjemplaresFacade ejFaMock = Mockito.mock(EjemplaresFacade.class);
        ejR.ejemplarFacade = ejFaMock;
        Integer id = null;
        
        try {
            List<Ejemplares> listaEj = new ArrayList<>();
            listaEj.add(new Ejemplares(1));
            listaEj.add(new Ejemplares(2));
            
            Mockito.when(ejFaMock.findAll()).thenReturn(listaEj);
            id = listaEj.size();
            id = id +1;
            ejR.obtenerUltimoId();
            
        } catch (Exception e) {
        }
        try {
            Assertions.assertThrows(Exception.class, ()->{
                Mockito.doThrow(Exception.class).when(ejFaMock).findAll();
            });
            ejR.obtenerUltimoId();
        } catch (Exception e) {
        }
    }
    
}
