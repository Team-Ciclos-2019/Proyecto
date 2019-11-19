
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Estudiante;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.RecursoReservado;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.EstudianteDAO;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.services.ExceptionServiciosReserva;
import edu.eci.cvds.services.ServiciosReserva;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;


public class ServiciosReservaImpl implements ServiciosReserva,Serializable{
    
    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private EstudianteDAO estudianteDAO;
    @Inject
    private ReservaDAO reservaDAO;
    
    @Override
    public Estudiante consultarEstudiante(int id) throws ExceptionServiciosReserva {
        try {
            return estudianteDAO.consultarEstudiante(id);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar estudiante");
        }
    }
    @Override
    public List<Recurso> consultarRecursos() throws ExceptionServiciosReserva{
	try {
            return recursoDAO.consultarRecursos();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar recurso");
        }
    }
     @Override
     public List<Recurso> consultarRecursosDisponibles() throws ExceptionServiciosReserva{
        try {
            return recursoDAO.consultarRecursosDisponibles();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar recurso");
        }
     }
    @Override
    public List<Estudiante> consultarEstudiantes() throws ExceptionServiciosReserva {
        try {
            return estudianteDAO.consultarEstudiantes();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar estudiantes");
        }
    }
    
    @Override
    @Transactional
    public void registrarRecurso(Recurso r) throws ExceptionServiciosReserva {
        if(r.getCapacidad()<=0){
           throw new ExceptionServiciosReserva("Error, la capacidad debe ser mayor que 0"); 
        }
        if(r.getDisponibilidad()<=0){
            throw new ExceptionServiciosReserva("Error, la disponibilidad debe ser mayor que 0");
        }
        try{
            recursoDAO.save(r);
        }
        catch (PersistenceException e){
           throw new ExceptionServiciosReserva("Error al registrar el recurso" + r.toString());
        }
    }
    
    @Override
    public void cambiarEstado(boolean var,int id) throws ExceptionServiciosReserva {
        try{
            recursoDAO.setestado(var,id);
        }
        catch (PersistenceException e){
           throw new ExceptionServiciosReserva("Error al cambiar estado");
        }
    }
    
    @Override
    @Transactional
    public void registrarReservaFutura(int id, Recurso r, Date horaInicio, Date horaFin) throws ExceptionServiciosReserva{
        if(horaInicio.compareTo(horaFin)>0){
            throw new ExceptionServiciosReserva("Error, la fecha de inicio no puede ser después de la fecha final");
        }
        if(consultarEstudiante(id)==null)throw new ExceptionServiciosReserva("Error, el estudiante no esta registrado");
        //if(consultarRecurso(r.getID())==null)throw new ExceptionServiciosReserva("Eror, el recurso no esta registrado");
        List<Estudiante> listaEstudiantes = consultarEstudiantes();
        for (int i=0; i< listaEstudiantes.size();i++){
            listaEstudiantes.get(i).getID();
            ArrayList<RecursoReservado> listaRecursos= listaEstudiantes.get(i).getRecursos();
            for (int j=0; j<listaRecursos.size(); j++){
                if(listaRecursos.get(j).getRecurso()== r){
                    throw new ExceptionServiciosReserva("Este recurso ya se encuentra rentado");
                }
            }
        }
         try {
            estudianteDAO.agregarReservaFuturaAUsuario(id,r.getID(),horaInicio,horaFin);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al agregar el recurso"
                    +r.toString()+" al usuario "+id);
        }
        
        
    }
    
    @Override
    @Transactional
    public void cancelarReservasFuturas(int id) throws ExceptionServiciosReserva{
        //if (consultarReserva(id)== null)throw new ExceptionServiciosReserva("Error,la reserva no está registrada")
        try{
            reservaDAO.cancelarReservaFutura(id);
        }
        catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al agregar la reserva " + id);
        }
    }
    
    
}
