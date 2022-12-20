package es.pildoras.SeguridadSpring.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="es.pildoras.SeguridadSpring")
@PropertySource("classpath:persistencia-mysql.properties")
public class App {
	
	@Autowired
	private Environment env;
	
	// Sistema de log para revisiones
	
	private Logger miLogger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
    
	// Definir un bean para seguridad
	
	@Bean
	public DataSource seguridadDataSource() {
		
		// Crear el pool de conexiones
		
		ComboPooledDataSource seguridadDataSource = new ComboPooledDataSource();
		
		// Establecer el driver JDBC
		
		try {
			seguridadDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Hacer log de las propiedades de conexión
		
		miLogger.info("URL de la BD: " + env.getProperty("jdbc.url"));
		miLogger.info("Usuario conectado a la BD: " + env.getProperty("jdbc.user"));
		
		// Establecer propiedades de conexión con BD
		
		seguridadDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		seguridadDataSource.setUser(env.getProperty("jdbc.user"));
		seguridadDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// Establecer propiedades del pool de conexiones
		
		seguridadDataSource.setInitialPoolSize(getPropPool("connection.poll.initialPoolSize"));
		seguridadDataSource.setMinPoolSize(getPropPool("connection.poll.minPoolSize"));
		seguridadDataSource.setMaxPoolSize(getPropPool("connection.poll.maxPoolSize"));
		seguridadDataSource.setMaxIdleTime(getPropPool("connection.poll.maxIdleTime"));
		
		return seguridadDataSource;
	}
	
	private int getPropPool(String nombreProp) {
		
		String propVal = env.getProperty(nombreProp);
		
		int propPool = Integer.parseInt(propVal);
		
		return propPool;
	}
}
