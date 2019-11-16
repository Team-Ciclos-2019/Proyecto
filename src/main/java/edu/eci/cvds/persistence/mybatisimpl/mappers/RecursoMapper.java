
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface RecursoMapper {
    public List<Recurso> consultarRecursosDisponibles();
    public List<Recurso> consultarRecursos();
    public void insertarRecurso(@Param("recurso")Recurso r);
    public void cambiarEstado(@Param("est") boolean var, @Param("ide") int id);
}
