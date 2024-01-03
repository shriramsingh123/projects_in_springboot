package com.sriram.security.StudentLogin.service;

import com.sriram.security.StudentLogin.entity.StudentInfo;

import java.util.List;

public interface StudentServices {
    StudentInfo register(StudentInfo studentInfo);

    List<StudentInfo> getAllStudentData();
}
