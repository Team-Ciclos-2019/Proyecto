package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ExceptionServiciosReserva;
import edu.eci.cvds.services.ServiciosReserva;
import edu.eci.cvds.services.ServiciosReservaFactory;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.mybatis.guice.transactional.Transactional;


@Transactional
public class ServiciosReservaTest{
    
   
     private ServiciosReserva ServiciosReserva;
    
    
    
    public ServiciosReservaTest() {
         ServiciosReserva= ServiciosReservaFactory.getInstance().getBlogServices();
    }
   
    @Test
    public void testRegistrarRecurso(){
        Recurso recurso= new Recurso(2,"salon1","salon","Bloque G",true,3,11);
        try{
            ServiciosReserva.registrarRecurso(recurso);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testRegistrarRecursoErrorCapacidad(){
        Recurso recurso= new Recurso(1,"salon1","sala de estudio","Bloque G",true,-3,11);
        try{
            ServiciosReserva.registrarRecurso(recurso);
        }
        catch(Exception e){
            Assert.assertEquals(e.getMessage(),"Error, la capacidad no puede ser menor o igual a 0");
        }
    }

    @Test
    public void testRegistrarRecursoErrorDisponibilidad(){
        Recurso recurso= new Recurso(1,"salon1","sala de estudio","Bloque G",true,3,-11);
        try{
            ServiciosReserva.registrarRecurso(recurso);
        }
        catch(Exception e){
            Assert.assertEquals(e.getMessage(),"Error, la disponibilidad debe ser mayor que 0 horas");
        }
    }
   
    
    @Test
    public void testRegistrarRecursoErrorNulo(){
        Recurso recurso= null;
        try{
            ServiciosReserva.registrarRecurso(recurso);
        }
        catch(Exception e){
            Assert.assertEquals(e.getMessage(),"Error, el recurso no puede ser nulo");
        }
    }
  
    
    
}
