
package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ServicioReservaFactory;
import edu.eci.cvds.services.ServiciosReserva;
import junit.framework.Assert;
import junit.framework.TestCase;


public class ServiciosReservaImplTest extends TestCase {

    ServiciosReserva servicio;
    
    public ServiciosReservaImplTest() {
        servicio = ServicioReservaFactory.getInstance().getServiciosAlquilerTesting();
    }
    
    /**
     * Test of registrarRecurso method, of class ServiciosReservaImpl.
     */
    public void testRegistrarRecurso(){
        Recurso recurso= new Recurso(1,"salon1","Bloque G",true,3,"8AM - 5PM");
        try{
            servicio.registrarRecurso(recurso);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     /**
     * Test of registrarRecurso method, of class ServiciosReservaImpl.
     
    public void testRegistrarRecurso2(){
        Recurso recurso= new Recurso(1,"salon1","Bloque G",true,3,"8AM - 5PM");
        try{
            servicio.registrarRecurso(recurso);
        }
        catch(Exception e){
            Assert.assertEquals(e.getMessage(),"Error al registrar el recurso"+ recurso.toString());
        }
    }
    * 
    */
    
}
