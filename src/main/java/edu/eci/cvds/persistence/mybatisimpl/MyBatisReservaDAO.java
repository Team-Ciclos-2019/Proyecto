
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
    public RecursoReservado consultarReservaFutura(int idRecurso,int idEstudiante) throws PersistenceException{
        try{
            return recursoReservadoMapper.consultarReserva(idRecurso,idEstudiante);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void cancelarReservaFutura(int idRecurso,int idEstudiante) throws PersistenceException{
        try{
            recursoReservadoMapper.cancelarReserva(idRecurso,idEstudiante);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            
            throw new PersistenceException("Error al cancelar la reserva");
        }
    }
}
