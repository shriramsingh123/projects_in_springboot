package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){

//        UserDetails admin = User.withUsername("martin")
//                .password(passwordEncoder.encode("martin"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.withUsername("kate")
//                .password(passwordEncoder().encode("kate"))
//                .roles("USER")
//                .build();

        return new UserDetailServiceInfo();
        }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
               return http.csrf().disable()
                       .authorizeHttpRequests()
                       .requestMatchers("/student/save","/student/new").permitAll()
                       .and()
                       .authorizeHttpRequests().requestMatchers("/student/**")
                       .authenticated().and().formLogin().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
