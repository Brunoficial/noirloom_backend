package com.noirloom.noirloom.repositories;

import com.noirloom.noirloom.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<CartModel, Long> {
}
