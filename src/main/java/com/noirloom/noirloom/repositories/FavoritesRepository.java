package com.noirloom.noirloom.repositories;

import com.noirloom.noirloom.models.FavoritesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FavoritesRepository extends JpaRepository<FavoritesModel, Long> {
}
