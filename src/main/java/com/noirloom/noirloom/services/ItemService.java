package com.noirloom.noirloom.services;

import com.noirloom.noirloom.DTOs.ItemDto;
import com.noirloom.noirloom.mappers.ItemMapper;
import com.noirloom.noirloom.models.ItemModel;
import com.noirloom.noirloom.repositories.ItemRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
