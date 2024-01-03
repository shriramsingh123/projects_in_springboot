package com.sriram.security.StudentLogin.service;

import com.sriram.security.StudentLogin.entity.StudentInfo;
import com.sriram.security.StudentLogin.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicesImpl implements StudentServices{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public StudentInfo register(StudentInfo studentInfo) {
        studentInfo.setPassword(passwordEncoder.encode(studentInfo.getPassword()));
        return studentRepository.save(studentInfo);
    }

    @Override
    public List<StudentInfo> getAllStudentData() {
        return studentRepository.findAll();
    }


}
