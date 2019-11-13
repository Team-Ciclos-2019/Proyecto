
package edu.eci.cvds.entities;

import java.sql.Date;


public class RecursoReservado {
    
    private int id;
    private Recurso recurso;
    private Date horaInicio;
    private Date horaFin;
    private boolean activo;
    
    public RecursoReservado(int id, Recurso recurso,boolean activo, Date horaInicio,Date horaFin){
        this.id=id;
        this.recurso=recurso;
        this. activo=activo;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public boolean getActivo(){
        return activo;
    }
    
    public void setActivo(){
        this.activo=activo;
    }
    
    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date fechafinrenta) {
        this.horaFin = horaFin;
    }
}
