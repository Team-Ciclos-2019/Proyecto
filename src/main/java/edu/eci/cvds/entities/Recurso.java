
package edu.eci.cvds.entities;

import edu.eci.cvds.*;


public class Recurso {
    
    private int identificador;
    private String nombre;
    private String ubicacion;
    private boolean estado;
    private int capacidad;
    private String tiempo_de_disponibilidad;
    
    
    
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