/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi135.bibliotecawebapp;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author christian
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application{
    
    public Set<Class<?>> getClases(){
        Set<Class<?>> recursos = new HashSet<>();
        agregarLosRecursos(recursos);
        return recursos;
    }
    
    private void agregarLosRecursos(Set<Class<?>> recursos){
        recursos.add(ues.occ.edu.sv.tpi135.bibliotecawebapp.resources.DatosResource.class);
    }
    
}
