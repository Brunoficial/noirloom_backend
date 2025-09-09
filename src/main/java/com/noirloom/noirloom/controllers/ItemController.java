package com.noirloom.noirloom.controllers;

import com.noirloom.noirloom.DTOs.ItemDto;
import com.noirloom.noirloom.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    public ItemService itemService;

    @GetMapping("/list")
    public ResponseEntity<List<ItemDto>> getItems() { return itemService.listItems(); }

    @GetMapping("/listById/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable Long id) { return itemService.listItemById(id) ; }

    @PostMapping("/create")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto data) { return itemService.createItem(data) ; }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) { return itemService.deleteItem(id) ; }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemDto data) throws Exception {
        return itemService.updateItem(data, id);
    }
}

