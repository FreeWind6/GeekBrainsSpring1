package ru.geekbrains.sample.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import ru.geekbrains.sample.dto.BookDTO;
import ru.geekbrains.sample.persistence.entities.Book;
import ru.geekbrains.sample.persistence.entities.School;
import ru.geekbrains.sample.persistence.repositories.BookRepository;
import ru.geekbrains.sample.persistence.repositories.SchoolRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getOne(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void postOne(BookDTO bookDTO) {
        bookRepository.save(Book.builder()
                .available(bookDTO.isAvailable())
                .name(bookDTO.getName())
                .created(bookDTO.getCreated())
                .description(bookDTO.getDescription())
                .build());
    }

    public void put(BookDTO bookDTO, UUID fromString) {
        bookRepository.deleteById(fromString);
        bookRepository.save(Book.builder()
                .available(bookDTO.isAvailable())
                .name(bookDTO.getName())
                .created(bookDTO.getCreated())
                .description(bookDTO.getDescription())
                .build());
    }

    public void delete(UUID fromString) {
        bookRepository.deleteById(fromString);
    }
}