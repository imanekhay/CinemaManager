package com.example.CinemaManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Allow H2 console access
                        .requestMatchers("/h2-console/**").permitAll()
                        // Allow access to login page
                        .requestMatchers("/login", "/styles/**", "/js/**").permitAll()
                        // Require authentication for everything else
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)  // after login, redirect to "/" (home page)
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                )
                // Needed to allow H2 console frames
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
                // Disable CSRF for H2 console (only for dev, don't do in prod)
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));

        return http.build();
    }

    // Simple in-memory user for testing
    @Bean
    public UserDetailsService users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password(passwordEncoder().encode("admin123"))
                        .roles("ADMIN")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
