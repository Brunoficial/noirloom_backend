package com.noirloom.noirloom.repositories;

import com.noirloom.noirloom.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
