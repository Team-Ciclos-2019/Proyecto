
package edu.eci.cvds.entities;

import java.util.ArrayList;

public class Estudiante {
    
    private java.lang.Integer identificador;
    private String nombre;
    private String carrera;
    private String correo;
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
     public Estudiante(String correo){
        this.correo=correo;
    }
    
    public java.lang.Integer getID(){
        return identificador;
    }
    
    public void setID(java.lang.Integer identificador){
        this.identificador =identificador;
    }
    
    public String getNombre(){
        return nombre;
    }
     public String getCorreo(){
        return correo;
    }
     public void setCorreo(String correo){
        this.correo=correo;
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
