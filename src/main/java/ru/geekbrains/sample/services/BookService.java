package ru.geekbrains.sample.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import ru.geekbrains.sample.persistence.entities.Book;
import ru.geekbrains.sample.persistence.repositories.BookRepository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getReverseAllBooks() {
        List<Book> all = bookRepository.findAll();
        Collections.reverse(all);
        return all;
    }

    public Book getOne(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

}