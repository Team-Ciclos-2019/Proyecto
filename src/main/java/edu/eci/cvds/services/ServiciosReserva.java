package edu.eci.cvds.services;

import edu.eci.cvds.entities.Recurso;

public interface ServiciosReserva{
    
     public abstract void registrarRecurso(Recurso r) throws ExceptionServiciosReserva;
     
     
}
