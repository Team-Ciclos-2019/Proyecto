
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;


public interface RecursoMapper {
    
    public void insertarRecurso(@Param("recurso")Recurso r);
    public void cambiarEstado(@Param("est") boolean var, @Param("ide") int id);
}
