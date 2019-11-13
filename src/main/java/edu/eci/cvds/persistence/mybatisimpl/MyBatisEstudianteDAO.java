/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Estudiante;
import edu.eci.cvds.persistence.EstudianteDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.EstudianteMapper;
import java.util.List;

/**
 *
 * @author gemec
 */
public class MyBatisEstudianteDAO implements EstudianteDAO{
    
    @Inject
    private EstudianteMapper estudianteMapper;
    
    @Override
    public Estudiante consultarEstudiante(int id) throws PersistenceException{
        try{
            return estudianteMapper.consultarEstudiante(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los estudiante");
        }
    }
    
    @Override
    public List<Estudiante> consultarEstudiantes() throws PersistenceException{
        try{
            return estudianteMapper.consultarEstudiantes();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los estudiantes");
        }
    }
}
