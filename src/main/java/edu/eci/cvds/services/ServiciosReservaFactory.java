package edu.eci.cvds.services;

import static com.google.inject.Guice.createInjector;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.EstudianteDAO;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.ReservaSimpleDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisEstudianteDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisReservaDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisReservaSimpleDAO;
import edu.eci.cvds.services.impl.ServiciosReservaImpl;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

public class ServiciosReservaFactory {

        private static final ServiciosReservaFactory instance = new ServiciosReservaFactory();
        private static Injector injector;
        private static Injector testingInjector;
	

	private ServiciosReservaFactory() {
            injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServiciosReserva.class).to(ServiciosReservaImpl.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
                bind(EstudianteDAO.class).to(MyBatisEstudianteDAO.class);
                bind(ReservaDAO.class).to(MyBatisReservaDAO.class);
                bind(ReservaSimpleDAO.class).to(MyBatisReservaSimpleDAO.class);
            }
        }
        );
            testingInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
                bind(ServiciosReserva.class).to(ServiciosReservaImpl.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
                bind(EstudianteDAO.class).to(MyBatisEstudianteDAO.class);
                bind(ReservaDAO.class).to(MyBatisReservaDAO.class);
                bind(ReservaSimpleDAO.class).to(MyBatisReservaSimpleDAO.class);
            }
        }
        );
	}

	
        public ServiciosReserva getServiciosReserva(){
            return injector.getInstance(ServiciosReserva.class);
        }
	public ServiciosReserva getBlogServices() {
		return testingInjector.getInstance(ServiciosReserva.class);
	}

	public static ServiciosReservaFactory getInstance() {
		return instance;
	}


}