
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.services.ExceptionServiciosReserva;
import edu.eci.cvds.services.ServiciosReserva;
import java.io.Serializable;


public class ServiciosReservaImpl implements ServiciosReserva,Serializable{
    
    @Inject
    private RecursoDAO recursoDAO;
    
    @Override
    public void registrarRecurso(Recurso r) throws ExceptionServiciosReserva {
        if(r.getCapacidad()<=0){
            throw new ExceptionServiciosReserva("Error, la capacidad no puede ser menor o igual a 0");
        }
        if(r.getDisponibilidad()<=0){
            throw new ExceptionServiciosReserva("Error, la disponibilidad debe ser mayor que 0 horas");
        }
        if(r==null){
            throw new ExceptionServiciosReserva("Error, el recurso no puede ser nulo");
        }
        try{
            recursoDAO.save(r);
        }
        catch (PersistenceException e){
           throw new ExceptionServiciosReserva("Error al registrar el recurso" + r.toString(),e);
        }
    }
    
}
