package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.sample.dto.BookDTO;
import ru.geekbrains.sample.dto.ItemDTO;
import ru.geekbrains.sample.services.BookService;
import ru.geekbrains.sample.services.ItemService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    public final ItemService itemService;

    @GetMapping
    public String getIndexPage(Model model) {
        model.addAttribute("item", itemService.getAllItem());
        return "index";
    }

    @GetMapping("/{id}")
    public String getBookPage(@PathVariable String id, Model model) {
        model.addAttribute("item", itemService.getOne(UUID.fromString(id)));
        return "item";
    }

    @PostMapping
    public String postBookPage(@RequestBody ItemDTO itemDTO) {
        itemService.postOne(itemDTO);
        return "item";
    }

    //изменить
    @PutMapping("/{id}")
    public String putBookPage(@RequestBody ItemDTO itemDTO, @RequestBody String id) {
        itemService.put(itemDTO, UUID.fromString(id));
        return "item";
    }

    @DeleteMapping("/{id}")
    public String deleteBookPage(@RequestBody String id) {
        itemService.delete(UUID.fromString(id));
        return "item";
    }
}
