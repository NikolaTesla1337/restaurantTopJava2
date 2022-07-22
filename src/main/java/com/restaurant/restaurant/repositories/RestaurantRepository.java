package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.models.Restaurant;
import com.restaurant.restaurant.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    Restaurant getRestaurantByVoteListContaining (Vote vote);
}
