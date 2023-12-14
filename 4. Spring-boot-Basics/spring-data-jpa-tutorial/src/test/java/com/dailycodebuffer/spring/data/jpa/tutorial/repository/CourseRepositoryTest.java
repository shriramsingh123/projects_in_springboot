package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();

        System.out.println(courses);

    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Priyanka ")
                .lastName("Bharti")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    // Pagination
    @Test
    public void findAllPaginatation(){

        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithThreeRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        Long totalPages = Long.valueOf(courseRepository.findAll(firstPageWithThreeRecords).getTotalPages());

        System.out.println("Total Pages : "+totalPages);
        System.out.println("Total Elements : "+totalElements);


        System.out.println(courses);
    }

    // Sorting
    @Test
    public void findAllSorting(){

        Pageable pageable = PageRequest.of(0,2, Sort.by("title"));

        System.out.println("Sorted : "+courseRepository.findAll(pageable).getContent());
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Kate ")
                .lastName("Winslet")
                .build();

        Student student = Student.builder()
                .firstName("shri Ram ")
                .lastName("Singh")
                .emailId("shri@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);

    }
}