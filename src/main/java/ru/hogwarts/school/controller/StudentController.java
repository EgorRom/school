package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
@Tag(name = "API для работы со студентами")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Создание студента")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student addedStudent = service.add(student);
        return ResponseEntity.ok(addedStudent);
    }

    @PutMapping
    @Operation(summary = "Обновление студента")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student updatedStudent = service.update(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление студента")
    public ResponseEntity<Student> remove(@PathVariable Long id) {
        Student deletedStudent = service.remove(id);
        return ResponseEntity.ok(deletedStudent);
    }

    @GetMapping("{id}")
    @Operation(summary = "Получение студента по id")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        Student student = service.get(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("by-age")
    @Operation(summary = "Получение студентов по возрасту")
    public ResponseEntity<Collection<Student>> getByAge(@RequestParam Integer minAge, @RequestParam Integer maxAge) {
        Collection<Student> student = service.getByAge(minAge, maxAge);
        return ResponseEntity.ok(student);
    }

    @GetMapping("all")
    @Operation(summary = "Получение всех студент")
    public ResponseEntity<Collection<Student>> getAll() {
        Collection<Student> student = service.getAll();
        return ResponseEntity.ok(student);
    }

    @GetMapping("faculty/{studentId}")
    @Operation(summary = "Получение факультета студента по id")
    public ResponseEntity<Faculty> getFacultyOfStudent(@PathVariable Long studentId) {
        Faculty faculty = service.getFacultyOfStudent(studentId);
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("students-by-all")
    @Operation(summary = "Получение колличества всех студентов")
    public Integer getStudentByAll() {
        return service.getStudentByAll();
    }

    @GetMapping("students-by-average-age")
    @Operation(summary = "Получение среднего возраста студентов")
    public Integer getStudentByAveragesAge() {
        return service.getStudentByAveragesAge();
    }

    @GetMapping("students-by-last-five")
    @Operation(summary = "Получение последних пяти студентов(по id)")
    public List<Student> getStudentsByLastFive() {
        return service.getStudentsByLastFive();
    }
}
