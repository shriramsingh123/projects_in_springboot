package com.sriram.security.StudentLogin.security;

import com.sriram.security.StudentLogin.entity.StudentInfo;
import com.sriram.security.StudentLogin.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentInfoDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<StudentInfo> studentInfo = studentRepository.findByEmail(email);
        return studentInfo.map(StudentInfoStudentDetails::new).orElseThrow(()->
                new UsernameNotFoundException("Student Not Found"));
    }
}
