
package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.RecursoReservado;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoReservadoMapper;


public class MyBatisReservaDAO implements ReservaDAO {
    @Inject
    private RecursoReservadoMapper recursoReservadoMapper;
    
    
    @Override
    public RecursoReservado consultarReservaFutura(int id) throws PersistenceException{
        try{
            return recursoReservadoMapper.consultarReserva(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void cancelarReservaFutura(int id) throws PersistenceException{
        try{
            recursoReservadoMapper.cancelarReserva(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            
            throw new PersistenceException("Error al cancelar la reserva");
        }
    }
}
