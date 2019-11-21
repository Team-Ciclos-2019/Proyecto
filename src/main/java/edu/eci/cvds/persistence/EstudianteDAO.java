
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Estudiante;
import java.sql.Date;
import java.util.List;


public interface EstudianteDAO {
    
    public Estudiante consultarEstudiante(int id) throws PersistenceException;
    public List<Estudiante> consultarEstudiantes() throws PersistenceException;
    public void save(Estudiante estudiante) throws PersistenceException;
    public void agregarReservaFuturaAUsuario(int idUsuario, int idRecurso, Date horaInicio, Date horaFin)  throws PersistenceException;
}
