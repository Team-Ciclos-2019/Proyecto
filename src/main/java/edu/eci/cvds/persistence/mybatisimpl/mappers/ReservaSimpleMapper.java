
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.ReservaSimple;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservaSimpleMapper {
    public List<ReservaSimple> consultarReservaSimples();
    public List<ReservaSimple> consultarReservaSimplesCanceladas();
    public List<ReservaSimple> consultarReservaSimplesHorariosMasRecurrentes();
    public List<ReservaSimple> consultarReservaSimplesHorariosMenosRecurrentes();
    public List<ReservaSimple> consultarReservaSimplesCanceladasPorEstudiante(@Param("ide") int idEstudiante);
    public List<ReservaSimple> consultarReservaSimplesPorEstudiante(@Param("ide") int idEstudiante);
    public List<ReservaSimple> consultarReservaSimplesPasadasPorEstudiante(@Param("ide") int idEstudiante);
    public void saveReservaSimple(@Param("idr") int idr,@Param("ide") int ide,@Param("FechaI") Date fechaInicio,@Param("FechaF") Date fechaFin,@Param("Activo")boolean activo);
    public List<ReservaSimple> consultarReservaSimpleConRecurso(@Param("idr") int idRecurso, @Param("ide") int idEstudiante);
    public void cancelarReservaSimpleFutura(@Param("idr")int idRecurso,@Param("ide")int idEstudiante,@Param("fechaIni") Date fechaInicio);
}
