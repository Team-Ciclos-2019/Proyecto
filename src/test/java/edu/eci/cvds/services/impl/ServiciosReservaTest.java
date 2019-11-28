package edu.eci.cvds.services.impl;

import com.google.inject.Singleton;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.RecursoReservado;
import edu.eci.cvds.services.ServiciosReserva;
import edu.eci.cvds.services.ServiciosReservaFactory;
import java.text.SimpleDateFormat;
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
    /**
    @Test
    public void testCancelarReservaCompleta(){
        try{
            Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
            ServiciosReserva.registrarReservaFutura(1,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 09:00:00"),true,"Simple");
            ServiciosReserva.cancelarReservasFuturas(recurso.getID());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    **/
    /**
    @Test
    public void testCancelarReservaFallidoTardeCompleta(){
        try{
            Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
            ServiciosReserva.registrarReservaFutura(1,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("21/11/2019 21:00:00"),
            new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("21/11/2019 22:00:00"),true,"Simple");
            ServiciosReserva.cancelarReservasFuturas(recurso.getID());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    **/
    
    @Test
    public void testCancelarReservaUsuarioCompletaNoExistente(){
        try{
            Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
            ServiciosReserva.registrarReservaFutura(2,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 08:00:00"),true,"Simple");
            ServiciosReserva.cancelarReservasFuturasCompleta(recurso.getID(),1);
        }
        catch(Exception e){
            Assert.assertEquals("Error, el estudiante no esta registrado",e.getMessage());
        }
    }
    
            
    
    @Test
    public void testRegistrarReservaFutura(){
        try{
            Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
            ServiciosReserva.registrarReservaFutura(1,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/07/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/07/2019 08:30:00"),true,"Simple");
        }
        catch(Exception e){
             System.out.println(e.getMessage() +" 4sfdg");
        }
    }
    
    
    @Test
    public void testRegistrarReservaFuturaFallidoHoraIncoherente(){
        try{
            Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
            ServiciosReserva.registrarReservaFutura(1,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 17:00:00"),
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 07:00:00"),true,"Simple");
        }
        catch(Exception e){
            Assert.assertEquals("Error, la fecha de inicio no puede ser después de la fecha final",e.getMessage());
        }
    }

    @Test
    public void testConsultarReservaFutura(){
        try{
            Recurso recurso= new Recurso(3,"salon1","salon","Bloque G",true,3,11);
            ServiciosReserva.registrarReservaFutura(1,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 07:00:00"),
            new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 08:30:00"),true,"Simple");
            ServiciosReserva.consultarReserva(recurso.getID(),1);
        }
        catch(Exception e){
            System.out.println(e.getMessage() );
        }
    }
    
    @Test
    public void testRegistrarReservaFuturaFallidoRecursoNoDisponible(){
        try{
            Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",false,3,11);
            ServiciosReserva.registrarReservaFutura(1,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 08:30:00"),true,"Simple");
        }
        catch(Exception e){
            Assert.assertEquals("Error, el recurso no está disponible",e.getMessage());
        }
    }
    
    @Test
    public void testRegistrarReservaFuturaFallidoEstudianteNoExistente(){
        try{
            Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",false,3,11);
            ServiciosReserva.registrarReservaFutura(2,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 08:30:00"),true,"Simple");
        }
        catch(Exception e){
            Assert.assertEquals("Error, el estudiante no esta registrado",e.getMessage());
        }
    }
    
    @Test
    public void testRegistrarReservaFuturaFallidoYaExistente(){
        try{
            Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
            ServiciosReserva.registrarReservaFutura(1,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/09/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/09/2019 08:30:00"),true,"Simple");
            ServiciosReserva.registrarReservaFutura(1,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/09/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("05/09/2019 08:30:00"),true,"Diaria");
        }
        catch(Exception e){
            Assert.assertEquals("Error, ya hay una reserva existente a esa hora",e.getMessage());
        }
    }
    
    @Test
    public void testconsultarReservaSimplesConRecurso(){
        try{
            Recurso recurso= new Recurso(1,"salon1","salon","Bloque G",true,3,11);
            ServiciosReserva.registrarReservaFutura(1,recurso,new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("01/08/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("05/08/2019 08:30:00"),true,"Diaria");
            System.out.println(ServiciosReserva.consultarReservaSimplesConRecurso(recurso.getID(),1));
        }
        catch(Exception e){
            System.out.println(e.getMessage() +"sfdg");
        }
    }
    
}
    

