

package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISRecursoDAO;
import edu.eci.cvds.services.ServiciosReserva;
import edu.eci.cvds.services.impl.ServiciosReservaImpl;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;



public class GuiceContextListener implements ServletContextListener {
    
   
   
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}
    
  
  
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {

                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // Laboratories
                bind(ServiciosReserva.class).to(ServiciosReservaImpl.class);
                bind(RecursoDAO.class).to(MyBATISRecursoDAO.class);
            }
        }
        );

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }
        
}