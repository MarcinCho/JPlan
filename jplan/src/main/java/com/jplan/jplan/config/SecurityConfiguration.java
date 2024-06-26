package com.jplan.jplan.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import com.jplan.jplan.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
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

    // public UserDetailsManager userDetailsManager(DataSource dataSource) {
    // JdbcUserDetailsManager jdbcUserDetailsManager = new
    // JdbcUserDetailsManager(dataSource);

    // jdbcUserDetailsManager.setUsersByUsernameQuery(
    // "select username, password, active from user where username=?");

    // jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
    // "select user_id, role from user_roles where user_id=?");

    // return jdbcUserDetailsManager;
    // }

    // @Bean
    // public AuthenticationProvider authProvider() {
    // DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    // provider.setUserDetailsService(userDetailsService());
    // provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
    // return provider;
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable());

        // http.authorizeHttpRequests(customizer ->
        // customizer.requestMatchers("/api/**").permitAll());

        http.authorizeHttpRequests(customizer -> customizer
                .requestMatchers(HttpMethod.GET, "/").hasAnyRole("USER", "GLOBAL_ADMIN")
                .requestMatchers(HttpMethod.POST, "/register/users").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/users").hasAnyAuthority("USER")
                .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasAnyRole("USER")
                .anyRequest().authenticated());

        http.formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        // http.csrf(customizer -> customizer.disable())
        // .authorizeHttpRequests(
        // request -> request.anyRequest().authenticated());

        return http.build();
    }

}
