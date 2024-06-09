package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(Integer minAge, Integer maxAge);

    @Query(value = "SELECT COUNT(id) FROM students", nativeQuery = true)
    Integer getStudentByAll();

    @Query(value = "SELECT AVG(age) FROM students", nativeQuery = true)
    Integer getStudentByAveragesAge();

    @Query(value = "SELECT * FROM students order by id DESC LIMIT 5", nativeQuery = true)
   List <Student> getStudentsByLastFive();

}
