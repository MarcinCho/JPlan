package com.jplan.jplan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jplan.jplan.config.jwt.AuthEntryPointJwt;
import com.jplan.jplan.config.jwt.AuthTokenFilter;
import com.jplan.jplan.service.UserDetailsServiceImpl;;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    public static final String USER = "USER"; // role_id == 1
    public static final String ADMIN = "ADMIN"; // role_id == 2
    public static final String MANAGER = "MANAGMENT"; // role_id == 3

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    // @Bean
    // UserDetailsService userDetailsService() {
    // return new UserDetailsServiceImpl();
    // };

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    };

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(customizer -> customizer
                        .requestMatchers(HttpMethod.GET, "/api/**").hasAnyAuthority(USER, ADMIN, MANAGER)
                        .requestMatchers(HttpMethod.POST, "/api/**").hasAnyAuthority(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/client/companies").hasAnyAuthority(USER)
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasAnyAuthority(USER)
                        .requestMatchers(HttpMethod.DELETE, "/auth/user").hasAnyAuthority(USER)
                        .requestMatchers(HttpMethod.GET, "auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "auth/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                        sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .cors(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
