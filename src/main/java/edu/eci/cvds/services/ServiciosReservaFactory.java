package edu.eci.cvds.services;

import static com.google.inject.Guice.createInjector;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.services.impl.ServiciosReservaImpl;
import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

public class ServiciosReservaFactory {

        private static final ServiciosReservaFactory instance = new ServiciosReservaFactory();

	private static Optional<Injector> optInjector = Optional.empty();

	private ServiciosReservaFactory() {
	}

	private Injector myBatisInjector(String env, String pathResource, JdbcHelper jdbcHelper) {
		return createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				setEnvironmentId(env);
				install(jdbcHelper);
				setClassPathResource(pathResource);
				bind(ServiciosReserva.class).to(ServiciosReservaImpl.class);
				bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
				
			}
		});
	}

	public ServiciosReserva getBlogServices() {
		if (!optInjector.isPresent()) {
			optInjector = Optional.of(myBatisInjector("development", "mybatis-config.xml", JdbcHelper.MySQL));
		}

		return optInjector.get().getInstance(ServiciosReserva.class);
	}

	public static ServiciosReservaFactory getInstance() {
		return instance;
	}


}