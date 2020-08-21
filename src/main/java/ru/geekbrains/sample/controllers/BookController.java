package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.sample.dto.BookDTO;
import ru.geekbrains.sample.services.BookService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    public final BookService bookService;

    @GetMapping
    public String getIndexPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/{id}")
    public String getBookPage(@PathVariable String id, Model model) {
        model.addAttribute("book", bookService.getOne(UUID.fromString(id)));
        return "book";
    }

    @PostMapping
    public String postBookPage(@RequestBody BookDTO bookDTO) {
        bookService.postOne(bookDTO);
        return "book";
    }

    //изменить
    @PutMapping("/{id}")
    public String putBookPage(@RequestBody BookDTO bookDTO, @RequestBody String id) {
        bookService.put(bookDTO, UUID.fromString(id));
        return "book";
    }

    @DeleteMapping("/{id}")
    public String deleteBookPage(@RequestBody String id) {
        bookService.delete(UUID.fromString(id));
        return "book";
    }
}
