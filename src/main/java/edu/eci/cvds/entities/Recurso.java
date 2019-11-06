
package edu.eci.cvds.entities;

import edu.eci.cvds.*;


public class Recurso {
    
    private int identificador;
    private String nombre;
    private String tipo;
    private String ubicacion;
    private boolean estado;
    private int capacidad;
    private int disponibilidad;
    
    public Recurso(int identificador,String nombre,String tipo,String ubicacion,boolean estado,int capacidad,int disponibilidad){
        this.identificador=identificador;
        this.nombre=nombre;
        this.tipo=tipo;
        this.ubicacion=ubicacion;
        this.estado=estado;
        this.capacidad=capacidad;
        this.disponibilidad=disponibilidad;
        
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public int getDisponibilidad(){
        return disponibilidad;
    }
    public void setDisponibilidad(int disponibilidad){
        this.disponibilidad = disponibilidad;
    }
    public int getID(){
        return identificador;
    }
    
    public void setID(int identificador){
        this.identificador =identificador;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getUbicacion(){
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion){
        this.ubicacion=ubicacion;
    }
    
    public boolean getEstado(){
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado=estado;
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    
    @Override
    public String toString() {
        return "Recurso{" +  " id=" + identificador + ", nombre=" + nombre + '}';
    }
}
