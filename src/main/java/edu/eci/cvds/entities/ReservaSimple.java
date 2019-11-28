/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.entities;

import java.util.Date;

/**
 *
 * @author gemec
 */
public class ReservaSimple {
    
    private int id;
    private int estudiante;
    private int reserva;
    private java.sql.Timestamp inicio;
    private java.sql.Timestamp fin;
    private boolean activo;
    
    public ReservaSimple(int id,int reserva,int estudiante, java.sql.Timestamp inicio, java.sql.Timestamp fin, boolean activo){
        this.id=id;
        this.reserva=reserva;
        this.estudiante=estudiante;
        this.inicio=inicio;
        this.fin=fin;
        this.activo=activo;
    }
    
    public int getId(){
        return id;
    }
    
    public void set(int id){
        this.id=id;
    }
    
    public java.sql.Timestamp getInicio(){
        return inicio;
    }
    
    public void setInicio(java.sql.Timestamp inicio){
        this.inicio=inicio;
    }
    
    public java.sql.Timestamp getFin(){
        return fin;
    }
    
    public void setFin(java.sql.Timestamp fin){
        this.fin=fin;
    }
    
    public boolean getActivo(){
        return activo;
    }
    
    public void setActivo(boolean activo){
        this.activo=activo;
    }
    
    public int getReserva(){
        return reserva;
    }
    
    public void setReserva(int reserva){
        this.reserva=reserva;
    }
    
    public int getEstudiante(){
        return estudiante;
    }
    
    public void setEstudiante(int estudiante){
        this.estudiante=estudiante;
    }

}
