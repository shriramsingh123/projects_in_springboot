package com.security.controller;

import com.security.entity.StudentInfo;
import com.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@EnableMethodSecurity
public class StudentInfoController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String login_page(){
        return "<h1>Please Login Here</h1>";
    }

    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('USER')")
    public String welcome_page(){
        return "<h1>Welcome </h1>";
    }

    @PostMapping("/save")
    public StudentInfo save_student(@RequestBody StudentInfo studentInfo){
        return studentService.student_save(studentInfo);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public List<StudentInfo> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/new")
    public String addNewStudent(@RequestBody StudentInfo studentInfo){
        return studentService.addStudent(studentInfo);
    }

}
