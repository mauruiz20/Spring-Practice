package es.pildoras.SeguridadSpring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource seguridadDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		UserBuilder usuarios = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(usuarios.username("Juan").password("123").roles("usuario", "ayudante", "administrador"))
		.withUser(usuarios.username("Antonio").password("123").roles("usuario"))
		.withUser(usuarios.username("Ana").password("123").roles("usuario", "ayudante"))
		.withUser(usuarios.username("Laura").password("123").roles("usuario", "ayudante", "administrador"));
		*/
		
		auth.jdbcAuthentication().dataSource(seguridadDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.authorizeRequests().anyRequest().authenticated().and().formLogin()
		http.authorizeRequests()
		.antMatchers("/").hasRole("usuario")
		.antMatchers("/administradores/**").hasRole("administrador")
		.antMatchers("/ayudantes/**").hasRole("ayudante")
		.and().formLogin()
		.loginPage("/miFormularioLogin")
		.loginProcessingUrl("/autenticacionUsuario")
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/acceso-denegado");
	}
	
	
}
