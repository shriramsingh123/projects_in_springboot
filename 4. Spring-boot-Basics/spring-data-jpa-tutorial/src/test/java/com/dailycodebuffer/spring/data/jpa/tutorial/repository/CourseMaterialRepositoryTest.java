package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("D.S.A")
                .credit(6)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.facebook.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }


    @Test
    public void printAllCoursesMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println(courseMaterials);
    }




}