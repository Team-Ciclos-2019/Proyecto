package edu.eci.cvds.services;

import edu.eci.cvds.entities.Estudiante;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.RecursoReservado;
import java.util.Date;
import java.util.List;

public interface ServiciosReserva{
    public abstract List<Recurso> consultarRecursosDisponibles() throws ExceptionServiciosReserva;
    public abstract  Estudiante consultarEstudiante(int id) throws ExceptionServiciosReserva;
    public abstract List<Estudiante> consultarEstudiantes() throws ExceptionServiciosReserva;
    public abstract List<Recurso> consultarRecursos() throws ExceptionServiciosReserva;
    public abstract void registrarRecurso(Recurso r) throws ExceptionServiciosReserva;
    public void registrarEstudiante(Estudiante estudiante) throws ExceptionServiciosReserva;
    public abstract void cambiarEstado(boolean var,int id) throws ExceptionServiciosReserva;
    public abstract void registrarReservaFutura(int id, Recurso r, Date horaInicio, Date horaFin,boolean activo) throws ExceptionServiciosReserva;
    public void cancelarReservasFuturas(int id) throws ExceptionServiciosReserva; 
     
}
