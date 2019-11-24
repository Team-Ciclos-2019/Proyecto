
package edu.eci.cvds.entities;

import java.util.ArrayList;
import java.util.Date;


public class RecursoReservado {
    
    private int id;
    private Recurso recurso;
    private Date inicio;
    private Date fin;
    private boolean activo;
    private String tipo;
    private ArrayList<ReservaSimple> reservaRecurrente;
    
    public RecursoReservado(int id, Recurso recurso,boolean activo, Date inicio,Date fin, String tipo,ArrayList<ReservaSimple> reservaRecurrente ){
        this.id=id;
        this.recurso=recurso;
        this.activo=activo;
        this.inicio=inicio;
        this.fin=fin;
        this.tipo=tipo;
        this.reservaRecurrente=reservaRecurrente;
    }
    
    public RecursoReservado(int id, Recurso recurso,boolean activo, Date inicio,Date fin, String tipo){
        this.id=id;
        this.recurso=recurso;
        this.activo=activo;
        this.inicio=inicio;
        this.fin=fin;
        this.tipo=tipo;
        reservaRecurrente=new ArrayList();
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
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    
    public ArrayList<ReservaSimple> getReservaRecurrente(){
        return reservaRecurrente;
    }
    
    public void setReservaRecurrente(ArrayList<ReservaSimple> reservaRecurrente){
        this.reservaRecurrente=reservaRecurrente;
    }
}
