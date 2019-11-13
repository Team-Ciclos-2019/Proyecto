
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Estudiante;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.RecursoReservado;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.EstudianteDAO;
import edu.eci.cvds.services.ExceptionServiciosReserva;
import edu.eci.cvds.services.ServiciosReserva;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;


public class ServiciosReservaImpl implements ServiciosReserva,Serializable{
    
    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private EstudianteDAO estudianteDAO;
    
    @Override
    public Estudiante consultarEstudiante(int id) throws ExceptionServiciosReserva {
        try {
            return estudianteDAO.consultarEstudiante(id);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar estudiante");
        }
    }
    
    @Override
    public List<Estudiante> consultarEstudiantes() throws ExceptionServiciosReserva {
        try {
            return estudianteDAO.consultarEstudiantes();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar estudiantes");
        }
    }
    
    @Override
    @Transactional
    public void registrarRecurso(Recurso r) throws ExceptionServiciosReserva {
        if(r.getCapacidad()<=0){
           throw new ExceptionServiciosReserva("Error, la capacidad debe ser mayor que 0"); 
        }
        if(r.getDisponibilidad()<=0){
            throw new ExceptionServiciosReserva("Error, la disponibilidad debe ser mayor que 0");
        }
        try{
            recursoDAO.save(r);
        }
        catch (PersistenceException e){
           throw new ExceptionServiciosReserva("Error al registrar el recurso" + r.toString());
        }
    }
    
    @Override
    public void cambiarEstado(boolean var,int id) throws ExceptionServiciosReserva {
        try{
            recursoDAO.setestado(var,id);
        }
        catch (PersistenceException e){
           throw new ExceptionServiciosReserva("Error al cambiar estado");
        }
    }
    
    @Override
    @Transactional
    public void registrarReservaFutura(int id, Recurso r, Date horaInicio, Date horaFin) throws ExceptionServiciosReserva{
        if(horaInicio.compareTo(horaFin)>0){
            throw new ExceptionServiciosReserva("Error, la fecha de inicio no puede ser después de la fecha final");
        }
        //if(consultarEstudiante(docu)==null)throw new ExcepcionServiciosAlquiler("Error, el estudiante no esta registrado");
        //if(consultarItem(r.getID())==null)throw new ExcepcionServiciosAlquiler("Eror, el recurso no esta registrado");
        
        //for (RecursoReservado recursos:consultarEstudiante(id).getRentados()) {
        //    if (itemRentado.getItem().getId() == item.getId())
        //        throw new ExcepcionServiciosAlquiler("Este item con id: " + item.getId() + " ya se encuentra rentado");
        //}
        
    }
    
    /**
    @Override
    @Transactional
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
        LocalDate actual=date.toLocalDate();
        LocalDate entrega=actual.plusDays(numdias);
        if(numdias<1)throw  new ExcepcionServiciosAlquiler("el numero de dias debe ser mayor o igual a 1");
        if(consultarCliente(docu)==null)throw new ExcepcionServiciosAlquiler("El cliente no esta registrado");
        if(consultarItem(item.getId())==null)throw new ExcepcionServiciosAlquiler("El item no esta registrado");
        for (ItemRentado itemRentado:consultarCliente(docu).getRentados()) {
            if (itemRentado.getItem().getId() == item.getId())
                throw new ExcepcionServiciosAlquiler("Este item con id: " + item.getId() + " ya se encuentra rentado");
        }
        try {
            clienteDAO.agregarItemRentadoACliente(docu,item.getId(),date,java.sql.Date.valueOf(entrega));
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al agregar el item"
                    +item+" a los items rentados del cliente"+docu,e);
        }
    }
    */
    
}
