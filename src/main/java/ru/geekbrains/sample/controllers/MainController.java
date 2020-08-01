package ru.geekbrains.sample.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.sample.dto.Student;
import ru.geekbrains.sample.repository.StudentsRepository;

@Controller
public class MainController {

   @GetMapping("/")
   public String getIndexPage() {
      return "index";
   }

   StudentsRepository studentsRepository;

    @GetMapping("/studentsList")
    public String getStudentList(Model model) {
        model.addAttribute("students",studentsRepository.findAll());
        return "studentList";
    }

    @GetMapping("/profiles")
    public String getProfile(Model model, @RequestParam Long id) {
        model.addAttribute("profiles",studentsRepository.findById(id));
        return "profile";
    }

    @GetMapping("/students")
    public String getStudent() {
//        чтобы вывести список студентов нужно добавить бин StudentsRepository положить данные в Model
        return "student";
    }

    @PostMapping("/students")
    public String sendForm(@ModelAttribute Student student) {
        studentsRepository.init();
        studentsRepository.saveOrUpdateStudent(student);
        System.out.println(student);
        return "studentList";
    }
}