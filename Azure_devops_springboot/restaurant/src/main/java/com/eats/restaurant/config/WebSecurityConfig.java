package com.eats.restaurant.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    public static final String ADMIN = "admin";
    public static final String USER = "user";
    @Autowired
    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .requestMatchers(HttpMethod.GET, "/uber-eats", "/uber-eats/**").permitAll()
               .requestMatchers( HttpMethod.GET,"/uber-eats", "/uber-eats/*").hasRole(ADMIN)
               .requestMatchers( HttpMethod.GET,"/uber-eats/menudetails").hasAnyRole(ADMIN, USER)
               .anyRequest().authenticated();
        http.oauth2ResourceServer().jwt()
                        .jwtAuthenticationConverter(jwtAuthConverter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}
