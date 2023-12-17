package com.security.repository;

import com.security.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,Long> {
    StudentInfo findByStudentName(String username);
}
