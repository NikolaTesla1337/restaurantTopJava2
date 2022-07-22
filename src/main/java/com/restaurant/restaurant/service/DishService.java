package com.restaurant.restaurant.service;

import com.restaurant.restaurant.models.Dish;
import com.restaurant.restaurant.models.Restaurant;

import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();

    Dish getById(Integer id);

    void save(Dish dish);

    void delete(Dish dish);

    void delete(Integer id);

    Dish update(Integer id,Dish newDish);

    Integer getRestaurantId(Integer id);
}
