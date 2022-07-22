package com.restaurant.restaurant.service;

import com.restaurant.restaurant.models.Restaurant;
import com.restaurant.restaurant.models.Vote;
import com.restaurant.restaurant.repositories.RestaurantRepository;
import com.restaurant.restaurant.repositories.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantServiceImpl implements RestaurantService{
    final
    RestaurantRepository repository;
    final
    VoteRepository voteRepository;

    public RestaurantServiceImpl(RestaurantRepository repository,VoteRepository voteRepository) {
        this.repository = repository;
        this.voteRepository = voteRepository;
    }

    @Override
    public Restaurant getById(Integer id) {
        return repository.getById(id);

    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.getById(id));
    }

    @Override
    public void delete(Restaurant restaurant) {
        repository.delete(restaurant);
    }

    @Override
    public void save(Restaurant restaurant) {
        repository.saveAndFlush(restaurant);
    }

    @Override
    public Restaurant update(Integer id, Restaurant newRestaurant) {
        Restaurant oldRestaurant = repository.getById(id);
        oldRestaurant.setId(newRestaurant.getId());
        oldRestaurant.setMenu(newRestaurant.getMenu());
        oldRestaurant.setName(newRestaurant.getName());
        oldRestaurant.setVoteList(newRestaurant.getVoteList());
        repository.saveAndFlush(oldRestaurant);
        return oldRestaurant;
    }

    @Override
    public Restaurant getByVote(Vote vote) {
        return repository.getRestaurantByVoteListContaining(vote);
    }

    @Override
    public Restaurant getByVoteId(Integer voteId) {
        return repository.getRestaurantByVoteListContaining(voteRepository.getById(voteId));
    }
}
