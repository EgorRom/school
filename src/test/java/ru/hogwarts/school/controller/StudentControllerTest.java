package ru.hogwarts.school.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private StudentController studentController;
    @Autowired
    private TestRestTemplate restTemplate;
     final String NAME = "Name";
     final int AGE = 20;
    @Test
	void contextLoads() throws Exception {
		Assertions.assertThat(studentController).isNotNull();}
    @Test
    void createTest() throws Exception {
        Student student = new Student();
        student.setName(NAME);
        student.setAge(AGE);
        Assertions.assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isNotEmpty();

    }

    @Test
    void update() {
    }

    @Test
    void remove() {
    }

    @Test
    void getTest() throws Exception {
        Student student = new Student();
        student.setName(NAME);
        student.setAge(AGE);
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class))
                .isNotEmpty();

    }

    @Test
    void getByAge() {
        Student student1 = new Student();
        student1.setName(NAME);
        student1.setAge(AGE);
        Student student2 = new Student();
        student2.setName("NAME");
        student2.setAge(15);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class))
                ;

    }




}