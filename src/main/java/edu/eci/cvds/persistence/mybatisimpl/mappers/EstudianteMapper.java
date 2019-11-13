
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Estudiante;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface EstudianteMapper {
    
    public Estudiante consultarEstudiante(@Param("ide") int id);
    public List<Estudiante> consultarEstudiantes();
}
