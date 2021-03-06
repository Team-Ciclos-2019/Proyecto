
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.ReservaSimple;
import java.util.Date;
import java.util.List;


public interface ReservaSimpleDAO {
 
    public List<ReservaSimple> consultarReservaSimples()throws PersistenceException;
    public List<ReservaSimple> consultarReservaSimplesCanceladas() throws PersistenceException;
    public List<ReservaSimple> consultarReservaSimplesHorariosMasRecurrentes() throws PersistenceException;
    public List<ReservaSimple> consultarReservaSimplesHorariosMenosRecurrentes() throws PersistenceException;
    public void agregarReservaSimple(int recurso,int estudiante,Date horaInicio, Date horaFin,boolean activo)throws PersistenceException;
    public List<ReservaSimple> consultarReservaSimplesConRecurso(int idRecurso,int idEstudiante) throws PersistenceException;
    public List<ReservaSimple> consultarReservaSimplesCanceladasPorEstudiante(int idEstudiante) throws PersistenceException;
    public List<ReservaSimple> consultarReservaSimplesPorEstudiante(int idEstudiante) throws PersistenceException;
    public List<ReservaSimple> consultarReservaSimplesPasadasPorEstudiante(int idEstudiante) throws PersistenceException;
    public void cancelarReservaSimpleFutura(int idRecurso,int idEstudiante,Date fechaInicio) throws PersistenceException;

}
