package com.security.service;


import com.security.entity.StudentInfo;

import java.util.List;

public interface StudentService {
    StudentInfo student_save(StudentInfo studentInfo);

    List<StudentInfo> getAllStudent();

    public String addStudent(StudentInfo studentInfo);
}
