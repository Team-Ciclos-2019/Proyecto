package edu.eci.cvds.services;

import edu.eci.cvds.entities.Estudiante;
import edu.eci.cvds.entities.Recurso;
import java.sql.Date;
import java.util.List;

public interface ServiciosReserva{
    
    public Estudiante consultarEstudiante(int id) throws ExceptionServiciosReserva;
    public List<Estudiante> consultarEstudiantes() throws ExceptionServiciosReserva;
    public abstract void registrarRecurso(Recurso r) throws ExceptionServiciosReserva;
    public abstract void cambiarEstado(boolean var,int id) throws ExceptionServiciosReserva;
    public abstract void registrarReservaFutura(int estudiante, Recurso r, Date horaInicio, Date horaFin) throws ExceptionServiciosReserva;
     
     
}
