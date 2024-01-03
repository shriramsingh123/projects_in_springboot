package com.sriram.security.StudentLogin.repository;

import com.sriram.security.StudentLogin.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentInfo,Long> {
    Optional<StudentInfo> findByEmail(String email);
}
