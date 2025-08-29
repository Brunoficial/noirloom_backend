package com.noirloom.noirloom.repositories;

import com.noirloom.noirloom.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {
}
