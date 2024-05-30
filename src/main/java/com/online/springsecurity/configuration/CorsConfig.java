package com.online.springsecurity.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class CorsConfig {
	
//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
//		config.addAllowedHeader("*");
//	    config.addAllowedMethod("OPTION");
//	    config.addAllowedMethod("POST");   //add the methods you want to allow like 'GET', 'PUT',etc. using similar statements.
//	    config.addAllowedMethod("GET");
//	    source.registerCorsConfiguration("/**", config);
//	    return new CorsFilter(source);
//		
//	}
	
	   @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("*");  // Allowing all methods
	        source.registerCorsConfiguration("/**", config);
	        
	        return new CorsFilter(source);
	    }

}
