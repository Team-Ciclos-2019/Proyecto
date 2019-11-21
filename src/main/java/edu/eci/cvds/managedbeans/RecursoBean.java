package edu.eci.cvds.managedbeans;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ServiciosReserva;
import edu.eci.cvds.services.ExceptionServiciosReserva;
import edu.eci.cvds.services.ServiciosReservaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.util.List;



@ManagedBean(name = "recursoBean")
@SessionScoped
public class RecursoBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger( RecursoBean.class);
    private final ServiciosReserva ServiciosReserva;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;
    private int identificador;
    private boolean estado;
    private int disponibilidad;
    
    public RecursoBean(){
        ServiciosReserva = ServiciosReservaFactory.getInstance().getServiciosReserva();
    }


    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getDisponibilidad(){
        return disponibilidad;
    }
    public void setDisponibilidad(int disponibilidad){
        this.disponibilidad=disponibilidad;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(boolean estado){
        this.estado=estado;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void registrarRecurso(int identificador,String nombre,String tipo,String ubicacion,boolean estado,int capacidad,int disponibilidad){
        try{
            System.out.println("si");
            Recurso recurso = new Recurso(identificador,nombre,tipo,ubicacion,estado, capacidad,disponibilidad);
            System.out.println("recurso");
            ServiciosReserva.registrarRecurso(recurso);
            System.out.println("fin");

        } catch (ExceptionServiciosReserva e) {
            e.printStackTrace();
        }
    }
    public void cambiarEstado(boolean var, int id){
         try{
				System.out.println(this.estado);
				ServiciosReserva.cambiarEstado(var,id);
                this.setEstado(var);
				System.out.println("fin");
			 

        } catch (ExceptionServiciosReserva e) {
            e.printStackTrace();
        }
    }
    public  List<Recurso> consultarRecursos(){
	try{
			 
            System.out.println("lista");
            return ServiciosReserva.consultarRecursos();
          
        } catch (ExceptionServiciosReserva e) {
            e.printStackTrace();
            return null;
        }
    }
     public  List<Recurso> consultarRecursosDisponibles(){
         try{
			 
            System.out.println("lista");
            return ServiciosReserva.consultarRecursosDisponibles();
          
        } catch (ExceptionServiciosReserva e) {
            e.printStackTrace();
            return null;
        }
     }
     public  List<Recurso> consultarRecursosNoDisponibles(){
         try{
			 
            System.out.println("lista");
            return ServiciosReserva.consultarRecursosNoDisponibles();
          
        } catch (ExceptionServiciosReserva e) {
            e.printStackTrace();
            return null;
        }
     }

}
