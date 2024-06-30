package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;

import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;


import java.util.Collection;

@RestController
@RequestMapping("faculty")
@Tag(name = "API для работы со факультетами")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @PostMapping
    @Operation(summary = "Создание факультета")
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty) {
        Faculty addedFaculty = facultyService.add(faculty);
        return ResponseEntity.ok(addedFaculty);
    }

    @PutMapping
    @Operation(summary = "Обновление факультета")
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.update(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление факультета")
    public ResponseEntity<Faculty> remove(@PathVariable Long id) {
        Faculty deletedFaculty = facultyService.remove(id);
        return ResponseEntity.ok(deletedFaculty);
    }

    @GetMapping("{id}")
    @Operation(summary = "Получение факультета по id")
    public ResponseEntity<Faculty> get(@PathVariable Long id) {
        Faculty student = facultyService.get(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("by-color")
    @Operation(summary = "Получение факультетов по цвету либо названию")
    public ResponseEntity<Collection<Faculty>> getByColorOrName(@RequestParam(required = false) String name, @RequestParam(required = false) String color) {
        Collection<Faculty> faculty = facultyService.getByNameOrColor(name, color);
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("all")
    @Operation(summary = "Получение всех факультетов")
    public ResponseEntity<Collection<Faculty>> getAll() {
        Collection<Faculty> faculty = facultyService.getAll();
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("student/{facultyId}")
    @Operation(summary = "Получение всех студентов факультета")
    public ResponseEntity<Collection<Student>> getStudentOfFaculty(@PathVariable Long facultyId) {
        Collection<Student> faculty = facultyService.getStudents(facultyId);
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("get-longest-faculty-name")
    @Operation(summary = "Получение самого длинного названия факультета")
    public ResponseEntity<String> getLongestFacultyName() {
        return ResponseEntity.ok(facultyService.getLongestFacultyName());
    }
}
