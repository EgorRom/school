package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.EntityNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;


import java.util.Collection;

import java.util.stream.Collectors;

@Service
public class FacultyServiseImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyServiseImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty add(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty get(Long id) {
        logger.error("There is not faculty with id = " + id);
        return facultyRepository.findById(id).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    public Faculty update(Faculty faculty) {
        logger.info("Was invoked method for update faculty");
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty remove(Long id) {
        logger.error("There is not faculty with id = " + id);
        Faculty faculty = get(id);
        facultyRepository.deleteById(id);
        return faculty;
    }

    @Override
    public Collection<Faculty> getByNameOrColor(String name, String color) {
        logger.info("Was invoked method for get by name or color");
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(name, color);

    }

    @Override
    public Collection<Faculty> getAll() {
        logger.info("Was invoked method for get collection faculties");
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Student> getStudents(Long facultyId) {
        logger.info("Was invoked method for get students of faculty");
        return get(facultyId).getStudents();
    }
}
