package com.restaurant.restaurant.service;

import com.restaurant.restaurant.models.Restaurant;
import com.restaurant.restaurant.models.Vote;

import java.util.List;

public interface RestaurantService {
    Restaurant getById(Integer id);
    List<Restaurant> getAll();
    void delete (Integer id);
    void delete (Restaurant restaurant);
    void save(Restaurant restaurant);
    Restaurant update(Integer id,Restaurant newRestaurant);
    Restaurant getByVote (Vote vote);
    Restaurant getByVoteId (Integer voteId);



}
