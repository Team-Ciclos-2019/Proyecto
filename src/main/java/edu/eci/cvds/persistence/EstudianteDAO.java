
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Estudiante;
import java.util.List;


public interface EstudianteDAO {
    
    public Estudiante consultarEstudiante(int id) throws PersistenceException;
    public List<Estudiante> consultarEstudiantes() throws PersistenceException;
}
