
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.services.ExceptionServiciosReserva;
import edu.eci.cvds.services.ServiciosReserva;
import javax.transaction.Transactional;


public class ServiciosReservaImpl implements ServiciosReserva{
    
    @Inject
    private RecursoDAO recursoDAO;
    
    @Override
    @Transactional
    public void registrarRecurso(Recurso r) throws ExceptionServiciosReserva {
        try{
            recursoDAO.save(r);
        }
        catch (PersistenceException e){
            throw new ExceptionServiciosReserva("Error al registrar el recurso" + r.toString(),e);
        }
    }
    
}
