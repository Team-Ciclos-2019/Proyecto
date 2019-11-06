package edu.eci.cvds.services.client;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ServiciosReserva;
import edu.eci.cvds.services.ExceptionServiciosReserva;
import edu.eci.cvds.services.ServiciosReservaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author user
 */
@Named
@Stateless
@ViewScoped
@ManagedBean(name="recursoBean",eager =true)

public class RecursoBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    private final ServiciosReserva serviciosReserva;

    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;
    private int identificador;
    private boolean estado;
    private int disponibilidad;

    public RecursoBean(){
        serviciosReserva = ServiciosReservaFactory.getInstance().getServiciosBiblioteca();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getIdentificadorInterno() {
        return identificador;
    }

    public void setIdentificadorInterno(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRecursoTipo() {
        return tipo;
    }

    

    public void setRecursoTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void registrarRecurso() {
        try{
            System.out.println("si");
            Recurso recurso = new Recurso(identificador,nombre,tipo,ubicacion,estado, capacidad,disponibilidad);
            System.out.println("recurso ");
            serviciosReserva.registrarRecurso(recurso);
            System.out.println("fin");
            facesError("Registro exitoso");

        } catch (ExceptionServiciosReserva e) {
            facesError(e.getMessage());
        }
    }
    /**
     * Adds a new SEVERITY_ERROR FacesMessage for the ui
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage("Registro: ", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "error"));
    }

}
