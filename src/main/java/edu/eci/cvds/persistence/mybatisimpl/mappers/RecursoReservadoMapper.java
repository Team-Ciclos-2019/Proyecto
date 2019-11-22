
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.RecursoReservado;
import org.apache.ibatis.annotations.Param;


public interface RecursoReservadoMapper {
    
    public RecursoReservado consultarReserva(@Param("idr") int id);
    public void cancelarReserva(@Param("idr") int id);
    
}
