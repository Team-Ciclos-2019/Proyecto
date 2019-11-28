
package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.ReservaSimpleDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaSimpleMapper;
import java.util.Date;


public class MyBatisReservaSimpleDAO implements ReservaSimpleDAO {
    
    @Inject
    private ReservaSimpleMapper reservaSimpleMapper;
    
    @Override
    public void agregarReservaSimple(int reserva,Date horaInicio, Date horaFin,boolean activo) throws PersistenceException{
        try{
            reservaSimpleMapper.saveReservaSimple(reserva,horaInicio,horaFin,activo);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            
           e.printStackTrace();
        }
        
    }
}
