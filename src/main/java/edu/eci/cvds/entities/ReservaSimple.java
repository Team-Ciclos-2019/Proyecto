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
    private Date inicio;
    private Date fin;
    private boolean activo;
    
    public ReservaSimple(int id, Date inicio, Date fin, boolean activo){
        this.id=id;
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
    
    public Date getInicio(){
        return inicio;
    }
    
    public void setInicio(Date inicio){
        this.inicio=inicio;
    }
    
    public Date getFin(){
        return fin;
    }
    
    public void setFin(Date fin){
        this.fin=fin;
    }
    
    public boolean getActivo(){
        return activo;
    }
    
    public void setActivo(boolean activo){
        this.activo=activo;
    }

}
