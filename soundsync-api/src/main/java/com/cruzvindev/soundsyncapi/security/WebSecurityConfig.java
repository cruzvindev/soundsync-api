package com.cruzvindev.soundsyncapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(authz -> authz.anyRequest().authenticated())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Desabilita a sessão do usuário(cookies)
			.csrf(csrf -> csrf.disable())
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}
	
	@Bean
	public UserDetailsService userDetails() {
		UserDetails user = User.builder()
				.username("vinicius")
				.password(passwordEncoder().encode("1234"))
				.roles("ADM")
				.build();
		
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
