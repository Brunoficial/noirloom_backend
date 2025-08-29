package com.noirloom.noirloom.controllers;

import com.noirloom.noirloom.DTOs.ItemDto;
import com.noirloom.noirloom.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    public ItemService itemService;

    @GetMapping("/list")
    public ResponseEntity<List<ItemDto>> getItems() { return itemService.listItems(); }
}
