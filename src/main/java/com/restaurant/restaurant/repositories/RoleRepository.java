package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
