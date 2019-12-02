
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Estudiante;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.RecursoReservado;
import edu.eci.cvds.entities.ReservaSimple;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.EstudianteDAO;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.ReservaSimpleDAO;
import edu.eci.cvds.services.ExceptionServiciosReserva;
import edu.eci.cvds.services.ServiciosReserva;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;


public class ServiciosReservaImpl implements ServiciosReserva,Serializable{
    
    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private EstudianteDAO estudianteDAO;
    @Inject
    private ReservaDAO reservaDAO;
    @Inject
    private ReservaSimpleDAO reservaSimpleDAO;
    
    private List<Recurso> filteredrecurso;
    

     
    @Override
    public List<Estudiante> consultarEstudiantes() throws ExceptionServiciosReserva {
        try {
            return estudianteDAO.consultarEstudiantes();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar estudiantes");
        }
    }
    
    @Override
    public Estudiante consultarEstudiante(int id) throws ExceptionServiciosReserva {
        try {
            return estudianteDAO.consultarEstudiante(id);
        } catch (PersistenceException e) {
              throw new ExceptionServiciosReserva("Error al consultar estudiantes");
        }
    }
    
    @Override
    public List<Recurso> consultarRecursos() throws ExceptionServiciosReserva{
	try {
            return recursoDAO.consultarRecursos();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar recurso");
        }
    }
    
    @Override
    public Recurso consultarRecurso(int id) throws ExceptionServiciosReserva{
        try {
            return recursoDAO.consultarRecurso(id);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar reserva");
            
        }
    }
    
    @Override
    public List<Recurso> consultarRecursosDisponibles() throws ExceptionServiciosReserva{
        try {
            return recursoDAO.consultarRecursosDisponibles();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar recurso");
        }
    }
    
    @Override
    public List<Recurso> consultarRecursosNoDisponibles() throws ExceptionServiciosReserva{
        try {
            return recursoDAO.consultarRecursosNoDisponibles();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar recurso");
        }
    }
    
    @Override
    public List<Recurso> consultarRecursosMasUsados() throws ExceptionServiciosReserva{
        try {
            return recursoDAO.consultarRecursosMasUsados();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar recursos");
        }
    }
    
    @Override
    public List<Recurso> consultarRecursosMenosUsados() throws ExceptionServiciosReserva{
        try {
            return recursoDAO.consultarRecursosMenosUsados();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar recursos");
        }
    }
    
    @Override
    public RecursoReservado consultarReserva(int idRecurso,int idEstudiante) throws ExceptionServiciosReserva {
        try {
            return reservaDAO.consultarReservaFutura(idRecurso,idEstudiante);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar reserva");
           
        }
    }
    
    @Override
    public List<ReservaSimple> consultarReservaSimples() throws ExceptionServiciosReserva{
        try{
            return reservaSimpleDAO.consultarReservaSimples();
        }
        catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar reservas simples");
        }
    }
    
    @Override
    public List<ReservaSimple> consultarReservaSimplesCanceladas() throws ExceptionServiciosReserva{
        try{
            return reservaSimpleDAO.consultarReservaSimplesCanceladas();
        }
        catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar reservas simples");
        }
    }
    
    @Override
    public List<ReservaSimple> consultarReservaSimplesConRecurso(int idRecurso,int idEstudiante) throws ExceptionServiciosReserva{
        try{
            return reservaSimpleDAO.consultarReservaSimplesConRecurso(idRecurso,idEstudiante);
        }
        catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar reservas simples");
            
        }
    }
    
    @Override
    public List<ReservaSimple> consultarReservaSimplesHorariosMasRecurrentes() throws ExceptionServiciosReserva{
        try{
            return reservaSimpleDAO.consultarReservaSimplesHorariosMasRecurrentes();
        }
        catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar reservas simples");
        }
    }
    
    @Override
    public List<ReservaSimple> consultarReservaSimplesHorariosMenosRecurrentes() throws ExceptionServiciosReserva{
        try{
            return reservaSimpleDAO.consultarReservaSimplesHorariosMenosRecurrentes();
        }
        catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al consultar reservas simples");
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
    @Transactional
    public void registrarEstudiante(Estudiante estudiante) throws ExceptionServiciosReserva {
        try {
            estudianteDAO.save(estudiante);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al registrar estudiante");
        }
    }
    
    @Override
    @Transactional
    public void registrarReservaFutura(int estudiante, Recurso r, Date horaInicio, Date horaFin,boolean activo,String tipo) throws ExceptionServiciosReserva{
        if(horaInicio.compareTo(horaFin)>0){
            throw new ExceptionServiciosReserva("Error, la fecha de inicio no puede ser después de la fecha final");
        }
        if((consultarEstudiante(estudiante)) == null)throw new ExceptionServiciosReserva("Error, el estudiante no esta registrado");
        if(r.getEstado()== false) throw new ExceptionServiciosReserva("Error, el recurso no está disponible");
        List<ReservaSimple> listaDeReservas=consultarReservaSimplesConRecurso(r.getID(),estudiante);
        for(int i=0; i<listaDeReservas.size();i++){
            
            if (horaInicio.compareTo(listaDeReservas.get(i).getInicio())>0 && horaInicio.compareTo(listaDeReservas.get(i).getFin())<0 
                    || horaFin.compareTo(listaDeReservas.get(i).getInicio())>0 && horaInicio.compareTo(listaDeReservas.get(i).getFin())<0)
            throw new ExceptionServiciosReserva("Error, ya hay una reserva existente a esa hora");   
        }
        long diff = horaFin.getTime() - horaInicio.getTime();
        if(diff/(60*60*1000) > 2 && "Simple".equals(tipo)) throw new ExceptionServiciosReserva("Error, la reserva Simple no se puede realizar por mas de 2 horas");
        try {
            estudianteDAO.agregarReservaFuturaAUsuario(estudiante,r.getID(),horaInicio,horaFin,activo);
            registrarReservaSimple(r.getID(),estudiante,horaInicio,horaFin,tipo);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al agregar "
                    +r.toString()+" al usuario "+estudiante);
        }
    }
    
    @Override
    @Transactional
    public void registrarReservaSimple(int recurso,int estudiante,Date horaInicio, Date horaFin, String tipo) throws ExceptionServiciosReserva{
        try{
            if(null != tipo)switch (tipo) {
                case "Simple":
                    reservaSimpleDAO.agregarReservaSimple(recurso,estudiante,horaInicio,horaFin,true);
                    break;
                case "Diaria":
                    while (horaFin.compareTo(horaInicio)>0){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(horaInicio);
                        cal.add(Calendar.HOUR, 2);
                        reservaSimpleDAO.agregarReservaSimple(recurso,estudiante,horaInicio,cal.getTime(),true);
                        cal.setTime(horaInicio);
                        cal.add(Calendar.DATE, 1);
                        horaInicio=cal.getTime();
                    }   break;
                case "Semanal":
                    while (horaFin.compareTo(horaInicio)>0){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(horaInicio);
                        cal.add(Calendar.HOUR, 2);
                        reservaSimpleDAO.agregarReservaSimple(recurso,estudiante,horaInicio,cal.getTime(),true);
                        cal.setTime(horaInicio);
                        cal.add(Calendar.DATE, 7);
                        horaInicio=cal.getTime();
                    }   break;
                case "Mensual":
                    while (horaFin.compareTo(horaInicio)>0){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(horaInicio);
                        cal.add(Calendar.HOUR, 2);
                        reservaSimpleDAO.agregarReservaSimple(recurso,estudiante,horaInicio,cal.getTime(),true);
                        cal.setTime(horaInicio);
                        cal.add(Calendar.MONTH, 1);
                        horaInicio=cal.getTime();
                    }   break;
                default:
                    break;
            }
        }catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al agregar reserva");
        }
    
    }
    
    @Override
    @Transactional
    public void cancelarReservasFuturasCompleta(int idRecurso,int idEstudiante) throws ExceptionServiciosReserva{
        if (consultarReserva(idRecurso,idEstudiante)== null)throw new ExceptionServiciosReserva("Error,la reserva no esta registrada");
        try{
            RecursoReservado reserva=consultarReserva(idRecurso,idEstudiante);
            Date today = Calendar.getInstance().getTime();
            if(today.compareTo(reserva.getFin())>0) throw new ExceptionServiciosReserva("Error, la reserva ya ha acabado");
            if(today.compareTo(reserva.getInicio())>0 && (today.compareTo(reserva.getFin())<0)) throw new ExceptionServiciosReserva("Error, la reserva ya ha empezado");
            reservaDAO.cancelarReservaFutura(idRecurso,idEstudiante);
        }
        catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al cancelar las reservas ");
        }
    }
    
    @Override
    @Transactional
    public void cancelarReservasFuturasAPartirFecha(int idRecurso,int idEstudiante,Date fecha) throws ExceptionServiciosReserva{
        if (consultarReserva(idRecurso,idEstudiante)== null)throw new ExceptionServiciosReserva("Error,la reserva no esta registrada");
        RecursoReservado reserva=consultarReserva(idRecurso,idEstudiante);
        Date today = Calendar.getInstance().getTime();
        if(today.compareTo(reserva.getFin())>0) throw new ExceptionServiciosReserva("Error, la reserva ya ha acabado");
        if(today.compareTo(reserva.getInicio())>0 && (today.compareTo(reserva.getFin())<0)) throw new ExceptionServiciosReserva("Error, la reserva ya ha empezado");
        try{
            List<ReservaSimple> listaDeReservas=consultarReservaSimplesConRecurso(idRecurso,idEstudiante);
            for(int i=0; i<listaDeReservas.size();i++){
                if (listaDeReservas.get(i).getInicio().compareTo(fecha)>0){
                    reservaSimpleDAO.cancelarReservaSimpleFutura(idRecurso,idEstudiante,listaDeReservas.get(i).getInicio());
                }
            }
        }
        catch (PersistenceException e) {
            throw new ExceptionServiciosReserva("Error al cancelar las reservas");
        }
    }
    
    @Override
    @Transactional
    public void cancelarReservaFuturaSimple(int idRecurso,int idEstudiante,Date fecha)  throws ExceptionServiciosReserva{
        if (consultarReserva(idRecurso,idEstudiante)== null)throw new ExceptionServiciosReserva("Error,la reserva no esta registrada");
        RecursoReservado reserva=consultarReserva(idRecurso,idEstudiante);
        Date today = Calendar.getInstance().getTime();
        if(today.compareTo(reserva.getFin())>0) throw new ExceptionServiciosReserva("Error, la reserva ya ha acabado");
        if(today.compareTo(reserva.getInicio())>0 && (today.compareTo(reserva.getFin())<0)) throw new ExceptionServiciosReserva("Error, la reserva ya ha empezado");
        try{
            reservaSimpleDAO.cancelarReservaSimpleFutura(idRecurso,idEstudiante,fecha);
        }
        catch (PersistenceException e) {
            
            throw new ExceptionServiciosReserva("Error al cancelar las reservas");
        }
    }
    
    @Override
    @Transactional
    public void cambiarEstado(boolean var,int id) throws ExceptionServiciosReserva {
        try{
            recursoDAO.setestado(var,id);
        }
        catch (PersistenceException e){
           throw new ExceptionServiciosReserva("Error al cambiar estado");
        }
    }
    
    @Override
     public List<String> getTipos() {
        return tipos;
    }
    @Override
    public List<String> getUbicaciones(){
        return ubicaciones;
    }
    @Override
    public List<Integer> getCapacidades(){
        return capacidades;
    }
    
}
