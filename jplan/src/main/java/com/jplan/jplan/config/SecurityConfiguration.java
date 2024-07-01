package com.jplan.jplan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public static final String ADMIN = "GLOBAL_ADMIN";
    public static final String USER = "USER";

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    };

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(customizer -> customizer
                        .requestMatchers(HttpMethod.GET, "/api/*...").hasAnyAuthority(USER, ADMIN)
                        .requestMatchers(HttpMethod.POST, "/api/*....").hasAnyAuthority(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/api/users").hasAnyAuthority(USER)
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasAnyAuthority(USER)
                        .requestMatchers("/", "/error", "/csrf", "swagger-ui.html", "/swagger-ui/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                        sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(Customizer.withDefaults());

        http.formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());

        return http.build();
    }

}
