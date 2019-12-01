
package edu.eci.cvds.entities;

import java.util.ArrayList;

public class Estudiante {
    
    private int identificador;
    private String nombre;
    private String carrera;
    private boolean penalizado;
    private ArrayList<RecursoReservado> recursos;
    
    public Estudiante(){
        super();
    }
    
    public Estudiante(int identificador,String nombre, String carrera,boolean penalizado, ArrayList<RecursoReservado> recursos){
        this.identificador=identificador;
        this.nombre=nombre;
        this.carrera=carrera;
        this.penalizado=penalizado;
        this.recursos=recursos;
    }
    
    
    public Estudiante(int identificador,String nombre, String carrera, boolean penalizado){
        this.identificador=identificador;
        this.nombre=nombre;
        this.carrera=carrera;
        this.penalizado=penalizado;
        recursos=new ArrayList();
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
    
    public ArrayList<RecursoReservado> getRecursos(){
        return recursos;
    }
    
    public void setRecurso(ArrayList<RecursoReservado> recursos){
        this.recursos=recursos;
    }
}
