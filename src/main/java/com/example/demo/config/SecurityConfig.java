package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	SecurityFilterChain securityFilterChain;
	
//	//fyi passwordEncoder inquire input password and hashed pass in DB
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//		    .withUser("admin")
//		    .password(passwordEncoder().encode("123456"))
//		    .roles("ADMIN");
//	}

}
