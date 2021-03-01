package ru.rybinskov.lesson7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rybinskov.lesson7.dao.StudentDao;
import ru.rybinskov.lesson7.entities.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentDao.save(student);
    }

    @Override
    public void removeById(Long id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentDao.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }
}
