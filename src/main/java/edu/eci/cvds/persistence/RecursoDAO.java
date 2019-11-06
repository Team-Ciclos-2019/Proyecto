
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;


public interface RecursoDAO {
    
    public void save(Recurso r) throws PersistenceException;
    
     public void setestado(boolean var,int id) throws PersistenceException;
    
}
