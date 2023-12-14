package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("shriramsingh@gmail.com")
                .firstName("Shri Ram ")
                .lastName("Singh")
//                .guardianName("Vinod Singh")
//                .guardianEmail("vinod@gmail.com")
//                .guardianMobile("888898767898")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void studentWithGuardianDetail(){

        Guardian guardian = Guardian.builder()
                .name("Martin")
                .email("martin@gmail.com")
                .mobile("88868676788")
                .build();

        Student student = Student.builder()
                .firstName("jessica ")
                .emailId("jessica@gmail.com")
                .lastName("jelly")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("jessica ");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("je");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =studentRepository.findByGuardianName("Martin");
        System.out.println(students);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("jessica@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("jessica@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        System.out.println(studentRepository.getStudentByEmailAddressNativeNamedParam("jessica@gmail.com"));
    }

    @Test
    public void updateStudentByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Jandy",
                "jessica@gmail.com"
        );
    }

}