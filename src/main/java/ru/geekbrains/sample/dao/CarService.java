package ru.geekbrains.sample.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.sample.dto.CarDTO;
import ru.geekbrains.sample.persistence.entity.Car;


@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void save(CarDTO carDTO) {
        carRepository.save(
                Car.builder()
                        .name(carDTO.getName())
                        .build()
        );
    }
}
