package com.noirloom.noirloom.mappers;

import com.noirloom.noirloom.DTOs.CartDto;
import com.noirloom.noirloom.models.CartModel;
import com.noirloom.noirloom.models.UserModel;
import com.noirloom.noirloom.repositories.ItemRepository;
import com.noirloom.noirloom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CartMapper {

    @Autowired
    private static UserRepository userRepository;

    @Autowired
    private static ItemRepository itemRepository;

    @Autowired
    private static ItemMapper itemMapper;

    public static CartDto mapToCartDTO(CartModel cart) {
        return new CartDto(
                cart.getId(),

                (cart.getUser()).getId(),

                (cart.getItems())
                        .stream()
                        .map((item) -> ItemMapper.mapToItemDTO(item))
                        .toList()
        );
    }

    public static CartModel mapToCartModel(CartDto data) {
        return new CartModel(
                data.getId(),

                (userRepository.findById((data.getId()))).get(),

                (data.getItems())
                        .stream()
                        .map((itemDto) -> ItemMapper.mapToItemModel(itemDto))
                        .toList()
        );
    }
}
