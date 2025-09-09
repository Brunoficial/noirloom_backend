package com.noirloom.noirloom.services;

import com.noirloom.noirloom.DTOs.ItemDto;
import com.noirloom.noirloom.mappers.ItemMapper;
import com.noirloom.noirloom.models.ItemModel;
import com.noirloom.noirloom.repositories.ItemRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Transactional
    public ResponseEntity<List<ItemDto>> listItems() {
        List<ItemDto> items = itemRepository.findAll()
                .stream()
                .map((item) -> ItemMapper.mapToItemDTO(item))
                .toList();

        return ResponseEntity.ok(items);
    }

    @Transactional
    public ResponseEntity<ItemDto> listItemById(Long id) {
        Optional<ItemModel> itemEntity = itemRepository.findById(id);
        if (itemEntity.isEmpty()) {return ResponseEntity.notFound().build();}

        ItemDto item = ItemMapper.mapToItemDTO(itemEntity.get());
        return ResponseEntity.ok(item);
    }

    @Transactional
    public ResponseEntity<ItemDto> createItem(ItemDto data) {
        ItemModel newItem = ItemMapper.mapToItemModel(data);
        itemRepository.save(newItem);

        ItemDto newItemDto = ItemMapper.mapToItemDTO((newItem));
        return ResponseEntity.ok(newItemDto);
    }

    public ResponseEntity<Void> deleteItem(Long id) {
        Optional<ItemModel> item = itemRepository.findById(id);
        if (item.isEmpty()) return ResponseEntity.notFound().build();

        itemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<ItemDto> updateItem(ItemDto data, Long id) throws Exception{
        ItemModel itemEntity = itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));

        ItemModel updatedData = ItemMapper.mapToItemModel(data);
        BeanUtils.copyProperties(updatedData, itemEntity, "id");

        ItemModel updatedTask = itemRepository.save(itemEntity);
        ItemDto uptadedItemDto = ItemMapper.mapToItemDTO(updatedTask);
        return ResponseEntity.ok(uptadedItemDto);
    }
}


