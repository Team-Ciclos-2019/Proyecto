
package edu.eci.cvds.services;

import com.google.inject.Injector;

import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISRecursoDAO;
import edu.eci.cvds.services.impl.ServiciosReservaImpl;

public class ServicioReservaFactory {

   private static ServicioReservaFactory instance = new ServicioReservaFactory();

   private static Optional<Injector> optInjector;

   private Injector myBatisInjector(String env, String pathResource) {
       return createInjector(new XMLMyBatisModule() {
           @Override
           protected void initialize() {
               setEnvironmentId(env);
               setClassPathResource(pathResource);
               bind(RecursoDAO.class).to(MyBATISRecursoDAO.class);
               bind(ServiciosReserva.class).to(ServiciosReservaImpl.class);
           }
       });
   }

   private ServicioReservaFactory(){
       optInjector = Optional.empty();
   }

   public ServiciosReserva getServiciosAlquiler(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
       }

       return optInjector.get().getInstance(ServiciosReserva.class);
   }


   public ServiciosReserva getServiciosAlquilerTesting(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
       }

       return optInjector.get().getInstance(ServiciosReserva.class);
   }


   public static ServicioReservaFactory getInstance(){
       return instance;
   }

}
