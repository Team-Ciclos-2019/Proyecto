package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;

public class MyBatisRecursoDAO implements RecursoDAO{

    @Inject
    RecursoMapper recursoMapper;
    
    public void save(Recurso r) throws PersistenceException{ 
        try{
            recursoMapper.insertarRecurso(r);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            e.printStackTrace();
        } 
        
    }

}