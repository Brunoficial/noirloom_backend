package com.noirloom.noirloom.controllers;

import com.noirloom.noirloom.DTOs.ItemDto;
import com.noirloom.noirloom.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("addItem/{userId}/{itemId}")
        public ResponseEntity addItemToCart(@PathVariable Long userId, @PathVariable Long itemId) { return cartService.addItemToCart(userId, itemId);
    }

    @DeleteMapping("removeItem/{userId}/{itemId}")
        public ResponseEntity removeItemFromCart(@PathVariable Long userId, @PathVariable Long itemId) { return cartService.removeItemFromCart(userId, itemId);
    }
}
