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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.PrestamosFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Prestamos;

/**
 *
 * @author christian
 */
@ExtendWith(MockitoExtension.class)
public class PrestamosResourceTest {
    
    public PrestamosResourceTest() {
    }
    /**
     * Test of findAll method, of class PrestamosResource.
     */
    @Test
    public void testFindAll() {
        PrestamosResource prestamo = new PrestamosResource();//instanciamos la clase a testear
        PrestamosFacade prestamoFacadeMock = Mockito.mock(PrestamosFacade.class);//mockeamos el facade
        prestamo.prestamosFacade = prestamoFacadeMock;
        try {

            List<Prestamos> lista = new ArrayList();
            
            lista = null;
            Mockito.when(prestamoFacadeMock.findAll()).thenReturn(lista);//emulamos el caso en quue la lista venga vacia o nula
            prestamo.findAll();
            lista.add(new Prestamos(1));
            Mockito.when(prestamoFacadeMock.findAll()).thenReturn(lista);//simulamos que al hacer el llamado al metodo findAll nos devuelva una lista de libros
            Assertions.assertEquals(Response.ok(), prestamo.findAll());
            

            
        } catch (Exception e) {
        }
        try {

            assertThrows(Exception.class, () -> {
                Mockito.doThrow(Exception.class).when(prestamoFacadeMock).findAll();//cubrimos el escenario en el que se produzca una excepcion al momento de llamar al metodo findAll
            });
            prestamo.findAll();

        } catch (Exception e) {
        }
    }

    /**
     * Test of findById method, of class PrestamosResource.
     */
    @Test
    public void testFindById() {
        
        PrestamosResource prestamo = new PrestamosResource();//instanciamos la clase a testear
        PrestamosFacade prestamoFacadeMock = Mockito.mock(PrestamosFacade.class);//mockeamos el facade
        prestamo.prestamosFacade = prestamoFacadeMock;
                int num = 1;
        try {

            
            Mockito.when(prestamoFacadeMock.find(Mockito.anyInt())).thenReturn(null);
            prestamo.findById(num);
            
            Prestamos pre = new Prestamos(num);
            Mockito.when(prestamoFacadeMock.find(Mockito.anyInt())).thenReturn(pre);
            Assertions.assertEquals(pre, prestamo.findById(num).getEntity());
        } catch (Exception e) {
        }
        try {
            assertThrows(Exception.class, () -> {
                Mockito.doThrow(Exception.class).when(prestamoFacadeMock).find(Mockito.anyInt());//cubrimos el escenario en el que se produzca una excepcion al momento de llamar al metodo findAll
            });
            prestamo.findById(num);
            
            Assertions.assertEquals(Response.noContent().build().getStatus(), prestamo.findById(null).getStatus());
            

        } catch (Exception e) {
        }
    }
    
}
