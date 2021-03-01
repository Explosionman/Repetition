package ru.rybinskov.lesson7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rybinskov.lesson7.entities.Student;
import ru.rybinskov.lesson7.services.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/new")
    public String getFormNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "new-student";
    }

    @PostMapping("/new")
    public String addNewStudent(@ModelAttribute Student student) {
        studentService.saveOrUpdate(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String getFormEditStudent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "edit-student";
    }

    @PostMapping("/edit")
    public String editStudent(@ModelAttribute Student student) {
        studentService.saveOrUpdate(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(Model model, @PathVariable("id") Long id) {
        studentService.removeById(id);
        return "redirect:/students";
    }

}
