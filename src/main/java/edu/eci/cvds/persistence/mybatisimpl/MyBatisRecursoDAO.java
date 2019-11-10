package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

 

public class MyBatisRecursoDAO implements RecursoDAO{

    @Inject
    RecursoMapper recursoMapper;
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
 

}