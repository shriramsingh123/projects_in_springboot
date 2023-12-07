package com.information.services;

import com.information.entities.Student;

import java.util.List;

public interface StudentService {

    // save student
    Student saveStudent(Student student);

    // Get All Student
    List<Student> getAllStudent();

    // Get student By id
    Student getStudentById(int id);

}
