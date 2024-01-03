package com.sriram.security.controller;

import com.sriram.security.entities.UserInfo;
import com.sriram.security.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String message(){
        return "Welcome Dear please login here";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserInfo userInfo){
          userService.registerUser(userInfo);
          return "Registered Successfully";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public List<UserInfo> getAllUser(){
        return userService.getAllUser();
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/{id}")
    public UserInfo getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

}
