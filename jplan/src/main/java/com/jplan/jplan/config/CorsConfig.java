package com.jplan.jplan.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

List<String> allowedOrigin = new ArrayList<String>() {
{
add("http://localhost:3005");
}
};

@Bean
public CorsConfigurationSource corsConfigurationSource() {
CorsConfiguration configuration = new CorsConfiguration();
configuration.setAllowCredentials(true);
configuration.setAllowedOrigins(allowedOrigin);
configuration.addAllowedMethod("*");
configuration.addAllowedHeader("*");
UrlBasedCorsConfigurationSource source = new
UrlBasedCorsConfigurationSource();
source.registerCorsConfiguration("/**", configuration);
return source;
}

}
