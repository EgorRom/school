package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;


import java.util.Collection;

public interface FacultyService {
    Logger logger = LoggerFactory.getLogger(FacultyService.class);
    Faculty add(Faculty faculty);

    Faculty get(Long id);

    Faculty update(Faculty faculty);

    Faculty remove(Long id);

    Collection<Faculty> getByNameOrColor(String name, String color);

    Collection<Faculty> getAll();

    Collection<Student> getStudents(Long facultyId);
}
