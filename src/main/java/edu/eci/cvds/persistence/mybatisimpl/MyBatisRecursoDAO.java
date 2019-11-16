package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import java.util.List;

 

public class MyBatisRecursoDAO implements RecursoDAO{

    @Inject
    private RecursoMapper recursoMapper;
    @Override
    public void save(Recurso r) throws PersistenceException{ 
        try{
            recursoMapper.insertarRecurso(r);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            e.printStackTrace();
        } 
        
    }
    @Override
    public void setestado(boolean var,int id) throws PersistenceException{
         try{
            recursoMapper.cambiarEstado(var,id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            e.printStackTrace();
        } 
    
    
    }
    
    @Override
    public List<Recurso> consultarRecursos() throws PersistenceException{

        try{
            return (recursoMapper.consultarRecursos());
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            e.printStackTrace();
            return null;
        } 
      
    }
    @Override
    public List<Recurso> consultarRecursosDisponibles() throws PersistenceException{
         try{
            return (recursoMapper.consultarRecursosDisponibles());
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            e.printStackTrace();
            return null;
        } 
     }
 

}