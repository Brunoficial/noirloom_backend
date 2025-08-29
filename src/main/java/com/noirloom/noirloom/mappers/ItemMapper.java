package com.noirloom.noirloom.mappers;

import com.noirloom.noirloom.DTOs.ItemDto;
import com.noirloom.noirloom.models.ItemModel;

public class ItemMapper {
    public static ItemDto mapToItemDTO(ItemModel item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getType(),
                item.getSex(),
                item.getCostPrice(),
                item.getSellPrice()
        );
    }

    public static ItemModel mapToItemModel(ItemDto itemDto) {
        return new ItemModel(
                itemDto.getId(),
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getType(),
                itemDto.getSex(),
                itemDto.getCostPrice(),
                itemDto.getSellPrice()
        );
    }
}
