package edu.eci.cvds.services;

import edu.eci.cvds.entities.Estudiante;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.RecursoReservado;
import edu.eci.cvds.entities.ReservaSimple;
import edu.eci.cvds.persistence.PersistenceException;
import static edu.eci.cvds.services.ServiciosReserva.tipos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public interface ServiciosReserva{
    List<String> ubicaciones=new ArrayList<>(Arrays.asList("Centro","Oeste","Este"));
    List<String> tipos=new ArrayList<>(Arrays.asList("Computador", "Sala de estudio", "Tablero digital","Libro"));
    List<Integer> capacidades=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    public abstract Estudiante consultarIdEstudiante(String correo) throws PersistenceException;
    public abstract List<ReservaSimple> consultarReservaSimples() throws ExceptionServiciosReserva;
    public List<ReservaSimple> consultarReservaSimplesCanceladas() throws ExceptionServiciosReserva;
    public List<ReservaSimple> consultarReservaSimplesHorariosMasRecurrentes() throws ExceptionServiciosReserva;
    public List<ReservaSimple> consultarReservaSimplesHorariosMenosRecurrentes() throws ExceptionServiciosReserva;
    public abstract Recurso consultarRecurso(int id)throws ExceptionServiciosReserva;
    public abstract List<Integer> getCapacidades();
    public abstract List<String> getTipos();
    public abstract List<String> getUbicaciones();
    public abstract List<Recurso> consultarRecursosNoDisponibles() throws ExceptionServiciosReserva;
    public abstract List<Recurso> consultarRecursosDisponibles() throws ExceptionServiciosReserva;
    public List<Recurso> consultarRecursosMasUsados() throws ExceptionServiciosReserva;
    public List<Recurso> consultarRecursosMenosUsados() throws ExceptionServiciosReserva;
    public abstract  Estudiante consultarEstudiante(int id) throws ExceptionServiciosReserva;
    public abstract List<Estudiante> consultarEstudiantes() throws ExceptionServiciosReserva;
    public abstract List<Recurso> consultarRecursos() throws ExceptionServiciosReserva;
    public List<ReservaSimple> consultarReservaSimplesConRecurso(int idRecurso,int idEstudiante) throws ExceptionServiciosReserva;
    public List<ReservaSimple> consultarReservaSimplesCanceladasPorEstudiante(int idEstudiante) throws ExceptionServiciosReserva;
    public List<ReservaSimple> consultarReservaSimplesPorEstudiante(int idEstudiante) throws ExceptionServiciosReserva;
    public List<ReservaSimple> consultarReservaSimplesPasadasPorEstudiante(int idEstudiante) throws ExceptionServiciosReserva;
    public RecursoReservado consultarReserva(int idRecurso,int idEstudiante) throws ExceptionServiciosReserva ;
    public abstract void registrarRecurso(Recurso r) throws ExceptionServiciosReserva;
    public void registrarEstudiante(Estudiante estudiante) throws ExceptionServiciosReserva;
    public abstract void cambiarEstado(boolean var,int id) throws ExceptionServiciosReserva;
    public abstract void registrarReservaFutura(int id, Recurso r, Date horaInicio, Date horaFin,boolean activo, String tipo) throws ExceptionServiciosReserva;
    public void registrarReservaSimple(int reserva,int estudiante,Date horaInicio, Date horaFin, String Tipo) throws ExceptionServiciosReserva;
    public void cancelarReservasFuturasCompleta(int idRecurso,int idEstudiante) throws ExceptionServiciosReserva; 
    public void cancelarReservasFuturasAPartirFecha(int idRecurso,int idEstudiante,Date fecha) throws ExceptionServiciosReserva;
    public void cancelarReservaFuturaSimple(int idRecurso,int idEstudiante,Date fecha)  throws ExceptionServiciosReserva;    
        

}
