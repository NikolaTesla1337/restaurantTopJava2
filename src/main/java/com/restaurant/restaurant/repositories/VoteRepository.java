package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.models.Restaurant;
import com.restaurant.restaurant.models.User;
import com.restaurant.restaurant.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Integer> {
    Vote getByRestaurant(Restaurant restaurant);
    Vote getByRestaurantId(Integer restaurantID);
    Vote getByUser(User user);
    Vote getByUserId(Integer userID);
}
