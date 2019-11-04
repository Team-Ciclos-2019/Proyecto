
package edu.eci.cvds.entities;

import edu.eci.cvds.*;

public class Estudiante {
    
    private int identificador;
    private String nombre;
    private String carrera;
    private boolean penalizado;
    
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
    
    public String getCarrera(){
        return carrera;
    }
    
    public void setCarrera(String carrera){
        this.carrera=carrera;
    }
    
    public boolean getPenalizado(){
        return penalizado;
    }
    
    public void setPenalizado(boolean penalizado){
        this.penalizado=penalizado;
    }
}
