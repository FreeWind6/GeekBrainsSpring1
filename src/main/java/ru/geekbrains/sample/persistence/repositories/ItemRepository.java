package ru.geekbrains.sample.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.sample.persistence.entities.Item;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {}