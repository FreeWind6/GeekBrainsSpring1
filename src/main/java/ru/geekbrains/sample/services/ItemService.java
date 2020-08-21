package ru.geekbrains.sample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.sample.dto.BookDTO;
import ru.geekbrains.sample.dto.ItemDTO;
import ru.geekbrains.sample.persistence.entities.Book;
import ru.geekbrains.sample.persistence.entities.Item;
import ru.geekbrains.sample.persistence.repositories.BookRepository;
import ru.geekbrains.sample.persistence.repositories.ItemRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    public Item getOne(UUID id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void postOne(ItemDTO itemDTO) {
        itemRepository.save(Item.builder()
                .available(itemDTO.isAvailable())
                .name(itemDTO.getName())
                .created(itemDTO.getCreated())
                .description(itemDTO.getDescription())
                .build());
    }

    public void put(ItemDTO itemDTO, UUID fromString) {
        itemRepository.deleteById(fromString);
        itemRepository.save(Item.builder()
                .available(itemDTO.isAvailable())
                .name(itemDTO.getName())
                .created(itemDTO.getCreated())
                .description(itemDTO.getDescription())
                .build());
    }

    public void delete(UUID fromString) {
        itemRepository.deleteById(fromString);
    }
}