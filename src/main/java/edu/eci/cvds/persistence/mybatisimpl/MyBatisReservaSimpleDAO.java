
package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.ReservaSimple;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.ReservaSimpleDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaSimpleMapper;
import java.util.Date;
import java.util.List;


public class MyBatisReservaSimpleDAO implements ReservaSimpleDAO {
    
    @Inject
    private ReservaSimpleMapper reservaSimpleMapper;
    
     @Override
    public List<ReservaSimple> consultarReservaSimples(){
         try{
            return reservaSimpleMapper.consultarReservaSimples();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            
           e.printStackTrace();
           return null;
           
        }
    }
    
    @Override
    public void agregarReservaSimple(int recurso,int estudiante,Date horaInicio, Date horaFin,boolean activo) throws PersistenceException{
        try{
            reservaSimpleMapper.saveReservaSimple(recurso,estudiante,horaInicio,horaFin,activo);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {

        }
    }
    
    @Override    
    public List<ReservaSimple> consultarReservaSimplesConRecurso(int idRecurso,int idEstudiante) throws PersistenceException{
        try{
            return reservaSimpleMapper.consultarReservaSimpleConRecurso(idRecurso,idEstudiante);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar reservas simples");
        }
    }
    
    @Override 
    public void cancelarReservaSimpleFutura(int idRecurso,int idEstudiante,Date fechaInicio) throws PersistenceException{
        try{
            reservaSimpleMapper.cancelarReservaSimpleFutura(idRecurso,idEstudiante,fechaInicio);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException("Error al cancelar reserva simples");
        }
    }
    
}
        

