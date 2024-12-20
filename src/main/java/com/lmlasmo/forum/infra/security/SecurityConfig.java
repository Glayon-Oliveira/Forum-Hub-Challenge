package com.lmlasmo.forum.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.lmlasmo.forum.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
		
		return http.csrf(c -> c.disable())
				   .formLogin(f -> f.disable())
				   .httpBasic(Customizer.withDefaults())
				   .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				   .authorizeHttpRequests(a -> a.requestMatchers("/login", "/signup").permitAll()
						   .anyRequest().authenticated())
				   .addFilterBefore(jwtFilter, BasicAuthenticationFilter.class)
				   .build();		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConf) throws Exception {
		return authenticationConf.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
