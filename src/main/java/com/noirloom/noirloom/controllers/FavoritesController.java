package com.noirloom.noirloom.controllers;

import com.noirloom.noirloom.services.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    @Autowired
    FavoritesService favoritesService;

    @PostMapping("/addItem/{userId}/{itemId}")
        public ResponseEntity addItemToFavorites(@PathVariable Long userId, @PathVariable Long itemId) { return favoritesService.addItemToFavorites(userId, itemId);
    }

    @DeleteMapping("removeItem/{userId}/{itemId}")
        public ResponseEntity removeItemFromFavorites(@PathVariable Long userId, @PathVariable Long itemId) { return favoritesService.removeItemFromFavorites(userId, itemId);
    }
}
