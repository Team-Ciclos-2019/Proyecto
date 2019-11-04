
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;


public interface RecursoDAO {
    
    public void save(Recurso r) throws PersistenceException;
    
}
