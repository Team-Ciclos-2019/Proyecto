
package edu.eci.cvds.entities;

import java.util.Date;


public class RecursoReservado {
    
    private int id;
    private Recurso recurso;
    private Date inicio;
    private Date fin;
    private boolean activo;
    
    public RecursoReservado(int id, Recurso recurso,boolean activo, Date inicio,Date fin){
        this.id=id;
        this.recurso=recurso;
        this.activo=activo;
        this.inicio=inicio;
        this.fin=fin;
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
    
    public void setActivo(boolean activo){
        this.activo=activo;
    }
    
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
}
