package ru.geekbrains.sample.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.sample.dto.CarDTO;
import ru.geekbrains.sample.persistence.entity.Car;

import java.util.Optional;
import java.util.UUID;


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

    public Optional<Car> find(String name) {
        Optional<Car> carOptional = carRepository.findByName(name);
        if (carOptional.isPresent()) {
            return carOptional;
        }
        return carOptional;
    }
}
