package edu.eci.cvds.services.impl;

import com.google.inject.Singleton;
import edu.eci.cvds.entities.Estudiante;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ServiciosReserva;
import edu.eci.cvds.services.ServiciosReservaFactory;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import org.junit.Assert;
import org.junit.Test;


@SuppressWarnings("deprecation")
@Singleton
@Stateless
@ViewScoped

public class ServiciosReservaTest{
    
    
   
     private final ServiciosReserva ServiciosReserva;

    public ServiciosReservaTest() {
        this.ServiciosReserva = ServiciosReservaFactory.getInstance().getBlogServices();
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
            Assert.assertEquals("Error, la capacidad debe ser mayor que 0", e.getMessage());
        }
    }

    @Test
    public void testRegistrarRecursoErrorDisponibilidad(){
        Recurso recurso= new Recurso(1,"salon1","sala de estudio","Bloque G",true,3,-11);
        try{
            ServiciosReserva.registrarRecurso(recurso);
        }
        catch(Exception e){
            Assert.assertEquals("Error, la disponibilidad debe ser mayor que 0", e.getMessage());
        }
    }
  
    @Test
    public void testConsultarEstudiante(){
        try{
            ServiciosReserva.consultarEstudiante(1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testConsultarEstudianteFallido(){
        try{
            ServiciosReserva.consultarEstudiante(3);
        }
        catch(Exception e){
            Assert.assertEquals("Error al consultar estudiante", e.getMessage());
        }
    }
    
    @Test
    public void testConsultarRecursos(){
        Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
        Recurso recurso2= new Recurso(2,"salon1","salon","Bloque G",true,3,11);
        try{
            ServiciosReserva.registrarRecurso(recurso);
            ServiciosReserva.registrarRecurso(recurso2);
            ServiciosReserva.consultarRecursos();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testConsultarRecursosDisponibles(){
        Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
        Recurso recurso2= new Recurso(2,"salon1","salon","Bloque G",false,3,11);
        try{
            ServiciosReserva.registrarRecurso(recurso);
            ServiciosReserva.registrarRecurso(recurso2);
            ServiciosReserva.consultarRecursosDisponibles();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        } 
    }
    
    @Test
    public void testConsultarEstudiantes(){
        try{
            ServiciosReserva.consultarEstudiantes();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testCambiarEstado(){
        Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
        try{
            ServiciosReserva.registrarRecurso(recurso);
            ServiciosReserva.cambiarEstado(false, 1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
}
