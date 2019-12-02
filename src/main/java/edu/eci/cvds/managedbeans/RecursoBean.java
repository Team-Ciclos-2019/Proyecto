package edu.eci.cvds.managedbeans;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.ReservaSimple;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ServiciosReserva;
import edu.eci.cvds.services.ExceptionServiciosReserva;
import static edu.eci.cvds.services.ServiciosReserva.ubicaciones;
import edu.eci.cvds.services.ServiciosReservaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;



@ManagedBean(name = "recursoBean")
@ViewScoped
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
    private List<Recurso> filteredRecurso;
    private ScheduleModel eventModel = new DefaultScheduleModel();;
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    public RecursoBean(){
        ServiciosReserva = ServiciosReservaFactory.getInstance().getServiciosReserva();
    }
    public List<String> getUbicaciones(){
        return ServiciosReserva.getUbicaciones();
    }
    public void registrarReservaFutura(int id,int re, Date horaInicio, Date horaFin,boolean activo) throws ExceptionServiciosReserva{
        Recurso tempo= consultarRecurso(re);
        event = new DefaultScheduleEvent(tempo.getNombre() ,horaInicio, horaFin);
        ServiciosReserva.registrarReservaFutura(id,tempo,horaInicio,horaFin,activo,"Diaria");
        eventModel.addEvent(event);
        eventModel.updateEvent(event);
         
        event = new DefaultScheduleEvent();

    }
     public void loadEvents() throws ExceptionServiciosReserva{
        eventModel = new DefaultScheduleModel();
        List<ReservaSimple> reservas = ServiciosReserva.consultarReservaSimples();
        reservas.stream().map((reserva) -> {
            try {
                event = new DefaultScheduleEvent((consultarRecurso(reserva.getReserva())).getNombre()+"  "+(Integer.toString(reserva.getReserva())), reserva.getInicio(), reserva.getFin());
            } catch (ExceptionServiciosReserva ex) {
                java.util.logging.Logger.getLogger(RecursoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            return reserva;
        }).forEachOrdered((_item) -> {
            eventModel.addEvent(event);
        });

    }
    
     
   
    
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("",(Date) selectEvent.getObject(),(Date) selectEvent.getObject(),"simple");
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void deleteEvent() {
        eventModel.deleteEvent(event);
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
    public List<ReservaSimple> consultarReservaSimples() throws ExceptionServiciosReserva{
       
            return ServiciosReserva.consultarReservaSimples();
        
       
    }
     public Recurso consultarRecurso(int id) throws ExceptionServiciosReserva{
         return ServiciosReserva.consultarRecurso(id);
     }
    public List<String> getTipos() {
        return ServiciosReserva.getTipos();
    }
    public List<Integer> getCapacidades(){
        return ServiciosReserva.getCapacidades();
    }
    public List<Recurso> getFilteredRecurso(){
         return filteredRecurso;
    }
     public void setFilteredRecurso(List<Recurso> filteredRecurso) {
        this.filteredRecurso = filteredRecurso;
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
            Recurso recurso = new Recurso(identificador,nombre,tipo,ubicacion,estado,capacidad,disponibilidad);
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
