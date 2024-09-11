package com.colak.springtutorial.config;

import com.colak.springtutorial.filter.CustomHeaderFilter;
import com.colak.springtutorial.filter.LoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new CustomHeaderFilter(), UsernamePasswordAuthenticationFilter.class) // Adding a Filter Before an Existing One
                .addFilterAfter(new LoggingFilter(), UsernamePasswordAuthenticationFilter.class) // Adding a Filter After an Existing One
                // addFilterAt(new CustomAuthenticationFilter(), BasicAuthenticationFilter.class) // Replacing an Existing Filter
                .authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
