    package com.noirloom.noirloom.services;

    import com.noirloom.noirloom.DTOs.ItemDto;
    import com.noirloom.noirloom.mappers.ItemMapper;
    import com.noirloom.noirloom.models.CartModel;
    import com.noirloom.noirloom.models.ItemModel;
    import com.noirloom.noirloom.repositories.CartRepository;
    import com.noirloom.noirloom.repositories.ItemRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;

    @Service
    public class CartService {

        @Autowired
        CartRepository cartRepository;

        @Autowired
        ItemRepository itemRepository;

        public ResponseEntity addItemToCart(Long userId, Long itemId) {
            CartModel cart = (cartRepository.findByUserId(userId)).get();
            ItemModel item = (itemRepository.findById(itemId)).get();

            cart.getItems().add(item);
            cartRepository.save(cart);
            return ResponseEntity.ok().build();
        }

        public ResponseEntity removeItemFromCart (Long userId, Long itemId) {
            CartModel cart = (cartRepository.findByUserId(userId)).get();
            ItemModel item = (itemRepository.findById(itemId)).get();

            cart.getItems().remove(item);
            cartRepository.save(cart);
            return ResponseEntity.ok().build();
        }
    }
