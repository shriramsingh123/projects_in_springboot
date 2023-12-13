package com.dailycodebuffer.springboot.tutorial.repository;


import com.dailycodebuffer.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String name);
}
