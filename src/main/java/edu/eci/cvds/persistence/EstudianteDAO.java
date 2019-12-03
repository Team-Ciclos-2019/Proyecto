
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Estudiante;
import java.util.Date;
import java.util.List;


public interface EstudianteDAO {
    public Estudiante consultarIdEstudiante(String correo) throws PersistenceException;
    public Estudiante consultarEstudiante(int id) throws PersistenceException;
    public List<Estudiante> consultarEstudiantes() throws PersistenceException;
    public void save(Estudiante estudiante) throws PersistenceException;
    public void agregarReservaFuturaAUsuario(int idUsuario, int idRecurso, Date horaInicio, Date horaFin,boolean activo)  throws PersistenceException;
}
