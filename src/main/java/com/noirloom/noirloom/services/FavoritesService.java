package com.noirloom.noirloom.services;

import com.noirloom.noirloom.models.CartModel;
import com.noirloom.noirloom.models.FavoritesModel;
import com.noirloom.noirloom.models.ItemModel;
import com.noirloom.noirloom.repositories.CartRepository;
import com.noirloom.noirloom.repositories.FavoritesRepository;
import com.noirloom.noirloom.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FavoritesService {

    @Autowired
    FavoritesRepository favoritesRepository;

    @Autowired
    ItemRepository itemRepository;

    public ResponseEntity addItemToFavorites(Long userId, Long itemId) {
        FavoritesModel favorite = (favoritesRepository.findByUserId(userId)).get();
        ItemModel item = (itemRepository.findById(itemId)).get();

        favorite.getItems().add(item);
        favoritesRepository.save(favorite);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity removeItemFromFavorites (Long userId, Long itemId) {
        FavoritesModel favorite = (favoritesRepository.findByUserId(userId)).get();
        ItemModel item = (itemRepository.findById(itemId)).get();

        favorite.getItems().remove(item);
        favoritesRepository.save(favorite);
        return ResponseEntity.ok().build();
    }
}
