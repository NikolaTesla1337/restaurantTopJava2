package com.restaurant.restaurant.service;

import com.restaurant.restaurant.models.Restaurant;
import com.restaurant.restaurant.models.User;
import com.restaurant.restaurant.models.Vote;

import java.util.List;

public interface VoteService {
    Vote getById(Integer id);
    Vote getByRestaurant(Restaurant restaurant);
    Vote getByRestaurantID(Integer restaurantID);
    Vote getByUser(User user);
    Vote getByUserID(Integer userID);
    List<Vote> getAll();
    void save(Vote vote);
    void delete(Vote vote);
    void delete(Integer voteID);
    Vote update(Integer id,Vote newVote);
}
