package com.example.bookmyshowapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Enables Spring Security's web security features and integrates with Spring MVC.
@EnableWebSecurity
// Marks this class as a source of bean definitions for the Spring application context.
@Configuration
public class SecurityConfiguration {
    @Bean
    // Configures security rules for HTTP requests.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disables CSRF (Cross-Site Request Forgery) protection for requests matching the path signup (e.g., /signup).
        // Requests to /signup will not require a CSRF token (useful for endpoints like user registration forms or APIs).
        http.csrf(csrf -> csrf.ignoringRequestMatchers("signup"));
        return http.build();
    }

    @Bean
    // Defines a password encoder to securely hash and verify user passwords using the BCrypt algorithm.
    // Passwords will be hashed using BCrypt before being stored in the database.
    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
