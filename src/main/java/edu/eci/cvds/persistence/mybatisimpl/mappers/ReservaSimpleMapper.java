
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.ReservaSimple;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservaSimpleMapper {
    
    public void saveReservaSimple(@Param("idr") int idr,@Param("ide") int ide,@Param("FechaI") Date fechaInicio,@Param("FechaF") Date fechaFin,@Param("Activo")boolean activo);
    public List<ReservaSimple> consultarReservaSimpleConRecurso(@Param("idr") int idRecurso, @Param("ide") int idEstudiante);

}
