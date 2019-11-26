
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.Date;
import org.apache.ibatis.annotations.Param;

public interface ReservaSimpleMapper {
    
    public void saveReservaSimple(@Param("idr") int idr,@Param("FechaI") Date fechaInicio,@Param("FechaF") Date fechaFin,@Param("Activo")boolean activo);
}
