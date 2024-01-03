package com.sriram.security.StudentLogin.controller;

import com.sriram.security.StudentLogin.entity.AuthRequest;
import com.sriram.security.StudentLogin.entity.StudentInfo;
import com.sriram.security.StudentLogin.service.JwtService;
import com.sriram.security.StudentLogin.service.StudentServices;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String message(){
        return "Welcome Dear What's up";
    }

    @PostMapping("/register")
    public StudentInfo register(@RequestBody StudentInfo studentInfo){
        System.out.println("Data register phase 1");

        return studentServices.register(studentInfo);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<StudentInfo> getAllStudent(){
        return studentServices.getAllStudentData();
    }

    @PostMapping("/authenticate")
    public String authenticateAndGateToken(@RequestBody AuthRequest authRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request ! ");
        }

    }


}
