
package edu.eci.cvds.persistence;

import java.util.Date;


public interface ReservaSimpleDAO {
 
    
    public void agregarReservaSimple(int reserva,Date horaInicio, Date horaFin,boolean activo)throws PersistenceException;
    
}
