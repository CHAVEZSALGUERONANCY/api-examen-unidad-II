package edu.utvt.attendance.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.service.ItemService;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {


    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item save(@RequestBody Item item) {
        return this.itemService.save(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable UUID id, @RequestBody Item item) {
        return this.itemService.update(id, item);
    }

    @GetMapping
    public List<Item> getAll() {
        return this.itemService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> findById(@PathVariable UUID id) {
        return this.itemService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        this.itemService.deleteById(id);
    }
}
