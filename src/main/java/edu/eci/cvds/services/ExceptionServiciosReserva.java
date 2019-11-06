package edu.eci.cvds.services;


public class ExceptionServiciosReserva extends Exception {
    
    public ExceptionServiciosReserva(){
        super();
    }
    
    public ExceptionServiciosReserva(String message){
        super(message);
    }
    
    public ExceptionServiciosReserva(String string, Throwable cause) {
        super(string, cause);
    }
}