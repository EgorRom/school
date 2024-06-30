package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;


public interface StudentService {

    Student add(Student student);

    Student get(Long id);

    Student update(Student student);

    Student remove(Long id);

    Collection<Student> getByAge(Integer minAge, Integer maxAge);

    Collection<Student> getAll();

    Faculty getFacultyOfStudent(Long studentId);

    Integer getStudentByAll();

    Integer getStudentByAveragesAge();

    List<Student> getStudentsByLastFive();

    Collection<String> getNamesByH();

    Double getAverageAgeByStream();

    void printStudents();

    void printStudentsSync();
}
