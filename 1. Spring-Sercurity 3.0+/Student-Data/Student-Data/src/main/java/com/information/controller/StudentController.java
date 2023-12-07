package com.information.controller;


import com.information.entities.Student;
import com.information.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to security pages";

    }

    // post Student
    @PostMapping
    Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    // get all
    @GetMapping("/all")
    List<Student> getAllStudnt(){
        return studentService.getAllStudent();
    }

    // Get Student By id
    @GetMapping("/{id}")
    Student getOneStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }

}
