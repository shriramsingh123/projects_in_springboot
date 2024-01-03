package com.sriram.security.StudentLogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
}
