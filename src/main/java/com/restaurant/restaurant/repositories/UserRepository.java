package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
