/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import static org.junit.Assert.fail;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.LibroFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Libro;

/**
 *
 * @author aragon598
 */
@ExtendWith(MockitoExtension.class)
public class LibrosResourceTest {

    public LibrosResourceTest() {
    }

    @Test
    public void testFindAll() {
        LibrosResource librito = new LibrosResource();//instanciamos la clase a testear
        LibroFacade libroFacadeMock = Mockito.mock(LibroFacade.class);//mockeamos el facade
        librito.librofacade = libroFacadeMock;
        try {

            List<Libro> listaLibros = new ArrayList();
            listaLibros.add(new Libro(1));
            Mockito.when(libroFacadeMock.findAll()).thenReturn(listaLibros);//simulamos que al hacer el llamado al metodo findAll nos devuelva una lista de libros
            librito.findAll();
            listaLibros = null;
            Mockito.when(libroFacadeMock.findAll()).thenReturn(listaLibros);//emulamos el caso en quue la lista venga vacia o nula
            librito.findAll();

        } catch (Exception e) {
        }
        try {
           
            
            assertThrows(Exception.class, () -> {
                 Mockito.doThrow(Exception.class).when(libroFacadeMock).findAll();//cubrimos el escenario en el que se produzca una excepcion al momento de llamar al metodo findAll
            });
            librito.findAll();

        } catch (Exception e) {
        }

    }

    @Test
    public void testFindById() {

    }

    @Test
    public void testCrearLibro() {

    }

    @Test
    public void testModificarLibro() {

    }

    @Test
    public void testDeleteLibros() {

    }

    @Test
    public void testObtenerUltimoId() {

    }
}
