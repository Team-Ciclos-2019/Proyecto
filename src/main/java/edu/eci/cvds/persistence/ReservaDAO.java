/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.RecursoReservado;

/**
 *
 * @author gemec
 */
public interface ReservaDAO {
    
    
    public RecursoReservado consultarReservaFutura(int id) throws PersistenceException;
    public void cancelarReservaFutura(int id) throws PersistenceException; 
}
