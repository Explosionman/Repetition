package ru.rybinskov.lesson7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rybinskov.lesson7.entities.Student;
import ru.rybinskov.lesson7.services.StudentService;

import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {

    @GetMapping
    public String getInfo(Model model) { ;
        return "info";
    }
}
