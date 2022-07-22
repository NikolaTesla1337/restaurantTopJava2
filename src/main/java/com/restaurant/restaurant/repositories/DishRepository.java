package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,Integer> {
}
