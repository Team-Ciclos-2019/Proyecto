
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Estudiante;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface EstudianteMapper {
    
    public Estudiante consultarEstudiante(@Param("ide") int id);
    public List<Estudiante> consultarEstudiantes();
    public void agregarUsuario(@Param("usuario") Estudiante estudiante);
    public void agregarRecursoAUsuario(@Param("ide") int id,@Param("idr") int idr,@Param("FechaI") Date fechaInicio,@Param("FechaF") Date fechaFin,@Param("Activo")boolean activo);
}
