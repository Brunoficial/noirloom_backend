package com.noirloom.noirloom.mappers;

import com.noirloom.noirloom.DTOs.ItemDTO;
import com.noirloom.noirloom.models.ItemModel;

public class ItemMapper {
    public static ItemDTO mapToItemDTO(ItemModel item) {
        return new ItemDTO(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getType(),
                item.getSex(),
                item.getCostPrice(),
                item.getSellPrice()
        );
    }

    public static ItemModel mapToItemModel(ItemDTO itemDTO) {
        return new ItemModel(
                itemDTO.getId(),
                itemDTO.getName(),
                itemDTO.getDescription(),
                itemDTO.getType(),
                itemDTO.getSex(),
                itemDTO.getCostPrice(),
                itemDTO.getSellPrice()
        );
    }
}
