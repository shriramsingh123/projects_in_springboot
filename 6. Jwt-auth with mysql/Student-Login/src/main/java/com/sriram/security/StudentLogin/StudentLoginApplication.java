package com.sriram.security.StudentLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@SpringBootApplication
@EnableMethodSecurity
public class StudentLoginApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentLoginApplication.class, args);

	}

}
