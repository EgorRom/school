package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.EntityNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student add(Student student) {
        logger.debug("Was invoked method for create student");

        return studentRepository.save(student);
    }

    @Override
    public Student get(Long id) {
        logger.error("There is not student with id = " + id);
        return studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    public Student update(Student student) {
        logger.info("Was invoked method for update student");
        return studentRepository.save(student);
    }

    @Override
    public Student remove(Long id) {
        logger.error("There is not student with id = " + id);
        Student student = get(id);
        studentRepository.deleteById(id);
        return student;
    }

    @Override
    public Collection<Student> getByAge(Integer minAge, Integer maxAge) {
        logger.info("Was invoked method for get collection students by age");
        return studentRepository.findByAgeBetween(minAge, maxAge);


    }

    @Override
    public Collection<Student> getAll() {
        logger.info("Was invoked method for get collection students");
        return studentRepository.findAll();
    }

    @Override
    public Faculty getFacultyOfStudent(Long studentId) {
        logger.info("Was invoked method for get faculty of student");
        return get(studentId).getFaculty();

    }

    public Integer getStudentByAll() {
        logger.info("Was invoked method for get of students");
        return studentRepository.getStudentByAll();
    }

    public Integer getStudentByAveragesAge() {
        logger.info("Was invoked method for get student by averages age");
        return studentRepository.getStudentByAveragesAge();
    }

    public List<Student> getStudentsByLastFive() {
        logger.info("Was invoked method for get student by last five");
        return studentRepository.getStudentsByLastFive();
    }

    ;
}
