package com.information.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails admin= User.withUsername("andres")
                .password(passwordEncoder().encode("andres"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("jessica")
                .password(passwordEncoder().encode("jessica"))
                .roles("user")
                .build();

        return new InMemoryUserDetailsManager(admin,user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/student/welcome").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/student/**")
                .authenticated().and().formLogin().and().build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
