package ru.rybinskov.lesson7.services;

import ru.rybinskov.lesson7.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void saveOrUpdate(Student student);

    void removeById(Long id);

    Student findById(Long id);

    List<Student> getAll();
}
