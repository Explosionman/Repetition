package ru.rybinskov.lesson7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rybinskov.lesson7.entities.Student;

public interface StudentDao extends JpaRepository<Student, Long> {
}
