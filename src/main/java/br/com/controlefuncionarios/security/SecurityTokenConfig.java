package br.com.controlefuncionarios.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
	
	//http://andreybleme.com/2017-04-01/autenticacao-com-jwt-no-spring-boot/

	
	@Override
  	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/users").permitAll()
		.antMatchers("/response").permitAll()
		.antMatchers("/telefones").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/js/**").permitAll()
		.antMatchers("/images/**").permitAll()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.anyRequest().authenticated()
		.and()
		
		// filtra requisições de login
		.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
		
		// filtra outras requisições para verificar a presença do JWT no header
		.addFilterBefore(new JWTAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class); 
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// cria uma conta default
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("{noop}password")
			.roles("ADMIN");
	}

}
