package com.security.service;

import com.security.entity.StudentInfo;
import com.security.repository.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public StudentInfo student_save(StudentInfo studentInfo) {
        return studentInfoRepository.save(studentInfo);
    }

    @Override
    public List<StudentInfo> getAllStudent() {
        return studentInfoRepository.findAll();
    }

    public String addStudent(StudentInfo studentInfo){
        studentInfo.setPassword(passwordEncoder.encode(studentInfo.getPassword()));
        studentInfoRepository.save(studentInfo);
        return "successfully Added";
    }
}
