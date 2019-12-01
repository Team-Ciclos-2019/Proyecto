
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import java.util.List;


public interface RecursoDAO {
    
    public void save(Recurso r) throws PersistenceException;
    
    public Recurso consultarRecurso(int id)throws PersistenceException;
    
    public void setestado(boolean var,int id) throws PersistenceException;
    
    public List<Recurso> consultarRecursos() throws PersistenceException;
    
    public List<Recurso> consultarRecursosDisponibles() throws PersistenceException;
    
    public List<Recurso> consultarRecursosNoDisponibles() throws PersistenceException;
    
    public List<Recurso> consultarRecursosMasUsados() throws PersistenceException;
    
    public List<Recurso> consultarRecursosMenosUsados() throws PersistenceException;
    
}
