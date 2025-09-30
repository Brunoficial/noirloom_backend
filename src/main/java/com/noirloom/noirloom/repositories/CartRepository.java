package com.noirloom.noirloom.repositories;

import com.noirloom.noirloom.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository  extends JpaRepository<CartModel, Long> {
    Optional<CartModel> findByUserId(Long userId);
}
