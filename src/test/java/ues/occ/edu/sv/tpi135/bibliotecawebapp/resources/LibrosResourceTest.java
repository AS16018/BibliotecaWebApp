/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp.resources;

import javax.ws.rs.core.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Libro;

/**
 *
 * @author aragon598
 */
public class LibrosResourceTest {
    
    public LibrosResourceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of findAll method, of class LibrosResource.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        LibrosResource instance = new LibrosResource();
        Response expResult = null;
        Response result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class LibrosResource.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer Id = null;
        LibrosResource instance = new LibrosResource();
        Response expResult = null;
        Response result = instance.findById(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearLibro method, of class LibrosResource.
     */
    @Test
    public void testCrearLibro() {
        System.out.println("crearLibro");
        Libro libro = null;
        LibrosResource instance = new LibrosResource();
        Response expResult = null;
        Response result = instance.crearLibro(libro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarLibro method, of class LibrosResource.
     */
    @Test
    public void testModificarLibro() {
        System.out.println("modificarLibro");
        Libro libro = null;
        LibrosResource instance = new LibrosResource();
        Response expResult = null;
        Response result = instance.modificarLibro(libro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteLibros method, of class LibrosResource.
     */
    @Test
    public void testDeleteLibros() {
        System.out.println("deleteLibros");
        Integer id = null;
        LibrosResource instance = new LibrosResource();
        Response expResult = null;
        Response result = instance.deleteLibros(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerUltimoId method, of class LibrosResource.
     */
    @Test
    public void testObtenerUltimoId() {
        System.out.println("obtenerUltimoId");
        LibrosResource instance = new LibrosResource();
        Integer expResult = null;
        Integer result = instance.obtenerUltimoId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
