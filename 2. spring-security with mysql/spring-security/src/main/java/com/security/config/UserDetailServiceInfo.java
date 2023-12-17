package com.security.config;

import com.security.entity.StudentInfo;
import com.security.repository.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailServiceInfo implements UserDetailsService {

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         Optional<StudentInfo> studentInfo= Optional.ofNullable(studentInfoRepository.findByStudentName(username));
         return studentInfo.map(UserInfoUserDetails::new)
                 .orElseThrow(()-> new UsernameNotFoundException("user not found"));


    }
}
