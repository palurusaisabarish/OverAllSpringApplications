package com.example.demo.Securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;


@Configuration
@EnableWebSecurity
public class SpringSecurity {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	 
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider  provider = new DaoAuthenticationProvider();
		//we are working with database so DAO - Data Access Object
		
		
		provider.setUserDetailsService(userDetailsService); 
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return provider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity hs) throws Exception {
		
		hs
		
			.csrf(customizer ->  customizer.disable())
		    .authorizeHttpRequests(request -> request
		    		.requestMatchers("register","login")  //for this two I did not need to check for creditionals
		    		.permitAll()
		    		.anyRequest()
		    		.authenticated())
		    //.formLogin(Customizer.withDefaults())
		    .logout(Customizer.withDefaults())// Enable form-based login
		    .httpBasic(Customizer.withDefaults())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		
		return hs.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}



















//@Bean
//public UserDetailsService userDetailsService() { 
//	
//	UserDetails user = org.springframework.security.core.userdetails.User
//			.withDefaultPasswordEncoder()
//			.username("sabarish")
//			.password("sabarish@123")
//			.roles("USER")
//			.build();
//	
//	UserDetails admin = org.springframework.security.core.userdetails.User
//			.withDefaultPasswordEncoder()
//			.username("admin")
//			.password("admin@123")
//			.roles("ADMIN")
//			.build();
//	
//	return new InMemoryUserDetailsManager(user, admin);
//}
