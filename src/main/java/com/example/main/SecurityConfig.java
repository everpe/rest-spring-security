package com.example.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.main.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@Bean //instancia de ámbitp singleton para ser usada en otras partes
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	
	/**
	 * Contruye la autenticación con un Proveedor de usuarios
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		//Simula lo que se tenia en aplication properties usuarios por Memoria
		/*auth
			.inMemoryAuthentication()
			.withUser("user")
				.password("1234")
				.roles("USER")
				.and()
			.withUser("admin")	
				.password("1234")
				.roles("USER","ADMIN");	
		*/
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}
	
	/**
	 * Cualquier Petición que entra debe estar autenticada
	 */
	/*@Override
	public void configure(HttpSecurity http) throws Exception {
		 http
          .authorizeRequests()          
          .anyRequest()          
          .authenticated()
          .and()
          .httpBasic();
	}*/
	
	
	
}
