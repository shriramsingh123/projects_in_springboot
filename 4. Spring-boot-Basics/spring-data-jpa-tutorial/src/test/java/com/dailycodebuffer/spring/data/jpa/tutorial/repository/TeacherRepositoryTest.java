package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){

        Course courseAlgo = Course.builder()
                .title("Algo")
                .credit(5)
                .build();

        Course courseAlgoJava = Course.builder()
                .title("Java")
                .credit(5)
                .build();

        Course courseAlgoPython = Course.builder()
                .title("python")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Andres ")
                .lastName("Estwan")
              //  .courses(List.of(courseAlgo,courseAlgoJava,courseAlgoPython))
                .build();

        teacherRepository.save(teacher);
    }

}