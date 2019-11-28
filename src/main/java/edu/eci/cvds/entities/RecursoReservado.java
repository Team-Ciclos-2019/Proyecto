
package edu.eci.cvds.entities;

import java.util.ArrayList;
import java.util.Date;


public class RecursoReservado {
    
    private int id;
    private int estudiante;
    private int recurso;
    private java.sql.Timestamp inicio;
    private java.sql.Timestamp fin;
    private boolean activo;
    private String tipo;
    private int duracion;
    private ArrayList<ReservaSimple> reservaRecurrente;
    
    public RecursoReservado(int id, int recurso ,int estudiante,boolean activo, java.sql.Timestamp inicio,java.sql.Timestamp fin, String tipo,ArrayList<ReservaSimple> reservaRecurrente, int duracion ){
        this.id=id;
        this.estudiante=estudiante;
        this.recurso=recurso;
        this.activo=activo;
        this.inicio=inicio;
        this.fin=fin;
        this.tipo=tipo;
        this.reservaRecurrente=reservaRecurrente;
        this.duracion=duracion;
    }
    
    public RecursoReservado(int id, int recurso,int estudiante,boolean activo,java.sql.Timestamp inicio,java.sql.Timestamp fin, String tipo){
        this.id=id;
        this.recurso=recurso;
        this.estudiante=estudiante;
        this.activo=activo;
        this.inicio=inicio;
        this.fin=fin;
        this.tipo=tipo;
        reservaRecurrente=new ArrayList();
        duracion=2;
    }
    public RecursoReservado(int id, int recurso,int estudiante, java.sql.Timestamp inicio,java.sql.Timestamp fin,boolean activo){
        this.id=id;
        this.recurso=recurso;
        this.estudiante=estudiante;
        this.activo=activo;
        this.inicio=inicio;
        this.fin=fin;
        reservaRecurrente=new ArrayList();
        duracion=2;
    }
    
    public int getId(){
        return id;
    }
    public int getEstudiante(){
        return estudiante;
    }
    public void setEstudiante(int estudiante){
        this.estudiante=estudiante;
    }
    public void setId(int id){
        this.id=id;
    }
    
    public int getRecurso() {
        return recurso;
    }

    public void setRecurso(int recurso) {
        this.recurso = recurso;
    }

    public boolean getActivo(){
        return activo;
    }
    
    public void setActivo(boolean activo){
        this.activo=activo;
    }
    
    public java.sql.Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(java.sql.Timestamp inicio) {
        this.inicio = inicio;
    }

    public java.sql.Timestamp getFin() {
        return fin;
    }

    public void setFin(java.sql.Timestamp fin) {
        this.fin = fin;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    
    public int getDuracion(){
        return duracion;
    }
    
    public void setDuracion(int duracion){
        this.duracion=duracion;
    }
    
    public ArrayList<ReservaSimple> getReservaRecurrente(){
        return reservaRecurrente;
    }
    
    public void setReservaRecurrente(ArrayList<ReservaSimple> reservaRecurrente){
        this.reservaRecurrente=reservaRecurrente;
    }
}
