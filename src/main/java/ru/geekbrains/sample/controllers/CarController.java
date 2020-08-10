package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.sample.dao.BookService;
import ru.geekbrains.sample.dao.CarService;
import ru.geekbrains.sample.dto.BookDTO;
import ru.geekbrains.sample.dto.CarDTO;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public void saveOne(CarDTO carDTO) {
        carService.save(carDTO);
    }

    @GetMapping
    public void findName(@RequestParam String name) {
        carService.find(name);
    }

}