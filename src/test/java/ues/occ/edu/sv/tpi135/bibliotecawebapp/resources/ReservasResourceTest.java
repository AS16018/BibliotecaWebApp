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
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

import java.util.*;

import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.EjemplaresFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.controller.ReservasFacade;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Ejemplares;
import ues.occ.edu.sv.tpi135.bibliotecawebapp.entity.Reservas;

/**
 *
 * @author aragon598
 */
public class ReservasResourceTest {
    
    public ReservasResourceTest() {
    }


    /**
     * Test of findAll method, of class ReservasResource.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ReservasResource reservaR = new ReservasResource();
        ReservasFacade reservaFaMock = Mockito.mock(ReservasFacade.class);
        reservaR.reservasFacade = reservaFaMock;

        try {
            List<Reservas> ejLista = new ArrayList<>();
            ejLista.add(new Reservas(1));

            Mockito.when(reservaFaMock.findAll()).thenReturn(ejLista);
            reservaR.findAll();
            
            ejLista = null;
            Mockito.when(reservaFaMock.findAll()).thenReturn(ejLista);
            reservaR.findAll();


        } catch (Exception e) {
            //TODO: handle exception
        }
        try {
            Assertions.assertThrows(Exception.class, ()->{
                Mockito.doThrow(Exception.class).when(reservaFaMock).findAll();
            });
            reservaR.findAll();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    /**
     * Test of findById method, of class ReservasResource.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        
        ReservasResource reservaR = new ReservasResource();
        ReservasFacade reservaFaMock = Mockito.mock(ReservasFacade.class);
        reservaR.reservasFacade = reservaFaMock;
        Integer id = 1;

        try {
            List<Reservas> lReservas = new ArrayList<>();
            lReservas.add(new Reservas(1));
            lReservas.add(null);

            Mockito.when(reservaFaMock.find(id)).thenReturn(lReservas.get(0));
            reservaR.findById(id);

            Mockito.when(reservaFaMock.find(id)).thenReturn(lReservas.get(1));
            reservaR.findById(id);
            Assertions.assertEquals(Response.noContent().build().getStatus(), reservaR.findById(null).getStatus());


        } catch (Exception e) {
            //TODO: handle exception
        }
        try {
            Assertions.assertThrows(Exception.class,()->{
                Mockito.doThrow(Exception.class).when(reservaFaMock).find(id);
            });
            reservaR.findById(id);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    /**
     * Test of nuevaReserva method, of class ReservasResource.
     */
    @Test
    public void testNuevaReserva() throws Exception {
        System.out.println("nuevaReserva");
        // String string = "";
        // ReservasResource instance = new ReservasResource();
        // Response expResult = null;
        // Response result = instance.nuevaReserva(string);

    }

    /**
     * Test of editarReserva method, of class ReservasResource.
     */
    @Test
    public void testEditarReserva() {
        System.out.println("editarReserva");



    }

    /**
     * Test of eliminarReserva method, of class ReservasResource.
     */
    @Test
    public void testEliminarReserva() {
        System.out.println("eliminarReserva");

    }

    /**
     * Test of ultimoId method, of class ReservasResource.
     */
    @Test
    public void testUltimoId() {
        ReservasResource reservaR = new ReservasResource();
        ReservasFacade reservaFaMock = Mockito.mock(ReservasFacade.class);
        reservaR.reservasFacade = reservaFaMock;
        Integer id= null;

        try {
            List<Reservas> lReservas = new ArrayList<>();
            lReservas.add(new Reservas(1));
            lReservas.add(new Reservas(2));

            Mockito.when(reservaFaMock.findAll()).thenReturn(lReservas);
            id = lReservas.size();
            id = id +1;
            reservaR.ultimoId();


        } catch (Exception e) {
            //TODO: handle exception
        }

        try {
            Assertions.assertThrows(Exception.class, ()->{
                Mockito.doThrow(Exception.class).when(reservaFaMock).findAll().stream().max((id1, id2) -> id1.getIdReserva() - id2.getIdReserva()).get().getIdReserva();
            });
            reservaR.findAll();
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
    
}
