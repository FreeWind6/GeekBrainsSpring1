package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.sample.dao.CarRepository;
import ru.geekbrains.sample.dao.StudentRepository;
import ru.geekbrains.sample.persistence.entity.Car;
import ru.geekbrains.sample.persistence.entity.Student;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StudentRepository studentRepository;
    private final CarRepository carRepository;

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/students")
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentRepository.findAllStudents());
        return "student";
    }

    @PostMapping("/students")
    public String sendForm(@ModelAttribute Student student) {
        System.out.println(student);
        return "redirect:/student/";
    }

    @GetMapping("/cars")
    public String getCarPage(Model model) {
        model.addAttribute("cars", carRepository.findAllCar());
        return "car";
    }

    @PostMapping("/cars")
    public String sendCarsForm(@ModelAttribute Car car) {
        System.out.println(car);
        return "redirect:/car/";
    }

}