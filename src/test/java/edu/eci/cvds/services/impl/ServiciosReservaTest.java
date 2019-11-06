package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ServiciosReservaFactory;
import edu.eci.cvds.services.ServiciosReserva;
import org.apache.ibatis.session.SqlSession;


public class ServiciosReservaTest{
    
/**    
    @Inject
    private SqlSession sqlSession;
    
    ServiciosReserva servicio;
    
    
    
    public ServiciosReservaTest() {
        servicio = ServiciosReservaFactory.getInstance().getServiciosBibliotecaTesting();
    }
*/    
    /**
     * Test of registrarRecurso method, of class ServiciosReservaImpl.

    
    public void testRegistrarRecurso(){
        Recurso recurso= new Recurso(2,"salon1","salon","Bloque G",true,3,13);
        try{
            servicio.registrarRecurso(recurso);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
     */    
    /**
     * Test of registrarRecurso method, of class ServiciosReservaImpl.
     
    public void testRegistrarRecursoErrorCapacidad(){
        Recurso recurso= new Recurso(1,"salon1","Bloque G",true,-3,13);
        try{
            servicio.registrarRecurso(recurso);
        }
        catch(Exception e){
            Assert.assertEquals(e.getMessage(),"Error, la capacidad no puede ser menor o igual a 0");
        }
    }
    * 
    */
    
    /**
     * Test of registrarRecurso method, of class ServiciosReservaImpl.
     
    public void testRegistrarRecursoErrorDisponibilidad(){
        Recurso recurso= new Recurso(1,"salon1","Bloque G",true,3,-13);
        try{
            servicio.registrarRecurso(recurso);
        }
        catch(Exception e){
            Assert.assertEquals(e.getMessage(),"Error, la disponibilidad debe ser mayor que 0 horas");
        }
    }
    * 
    */
    
    /**
     * Test of registrarRecurso method, of class ServiciosReservaImpl.
     
    public void testRegistrarRecursoErrorNulo(){
        Recurso recurso= null;
        try{
            servicio.registrarRecurso(recurso);
        }
        catch(Exception e){
            Assert.assertEquals(e.getMessage(),"Error, el recurso no puede ser nulo");
        }
    }
    * 
    */
    
    
}
