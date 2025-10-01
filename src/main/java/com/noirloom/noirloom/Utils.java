package com.noirloom.noirloom;

import com.noirloom.noirloom.models.CartModel;
import com.noirloom.noirloom.models.FavoritesModel;
import com.noirloom.noirloom.models.UserModel;
import com.noirloom.noirloom.repositories.CartRepository;
import com.noirloom.noirloom.repositories.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    FavoritesRepository favoritesRepository;

    public void createUserOrphans(UserModel user) {

        // Creating user's shopping cart
        CartModel userCart = new CartModel();
        userCart.setUser(user);

        // Creating user's favorite items list
        FavoritesModel userFavorites = new FavoritesModel();
        userFavorites.setUser(user);

        // Saving all entities
        cartRepository.save(userCart);
        favoritesRepository.save(userFavorites);
    }
}
