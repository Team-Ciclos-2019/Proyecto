
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
        try{
            recursoDAO.save(r);
        }
        catch (PersistenceException e){
           e.printStackTrace();
        }
    }
    @Override
    public void cambiarEstado(boolean var,int id) throws ExceptionServiciosReserva {
        try{
            recursoDAO.setestado(var,id);
        }
        catch (PersistenceException e){
           e.printStackTrace();
        }
    }
    
}
