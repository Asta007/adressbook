package com.asta.dev.adressbook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean

    // HALTE : this function works just find, these red line are alert saying that
    // those method are depricated but this does not affect the code..... for now

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated();
        http
                .oauth2ResourceServer()
                .jwt();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll() // Accès libre à l'index et home
//                .antMatchers("/contact/**").hasRole("user") // Protéger les endpoints de contact
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login();
//    }
}
