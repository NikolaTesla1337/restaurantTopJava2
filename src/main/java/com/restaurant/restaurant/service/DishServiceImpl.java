package com.restaurant.restaurant.service;

import com.restaurant.restaurant.models.Dish;
import com.restaurant.restaurant.models.Restaurant;
import com.restaurant.restaurant.repositories.DishRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class DishServiceImpl implements DishService{

    final
    DishRepository repository;

    public DishServiceImpl(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dish> getAllDishes() {
        return repository.findAll();
    }

    @Override
    public Dish getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public void save(Dish dish) {
        repository.save(dish);
    }

    @Override
    public void delete(Dish dish) {
        repository.delete(dish);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.getById(id));
    }

    @Override
    public Dish update(Integer id, Dish newDish) {
        Dish oldDish = repository.getById(id);
        oldDish.setId(newDish.getId());
        oldDish.setName(newDish.getName());
        oldDish.setPrice(newDish.getPrice());
        oldDish.setRestaurant(newDish.getRestaurant());
        repository.saveAndFlush(oldDish);
        return oldDish;
    }

    @Override
    public Integer getRestaurantId(Integer id) {
        Restaurant restaurant = repository.getById(id).getRestaurant();
        return restaurant.getId();
    }
}
