package com.restaurant.restaurant.service;

import com.restaurant.restaurant.models.Restaurant;
import com.restaurant.restaurant.models.User;
import com.restaurant.restaurant.models.Vote;
import com.restaurant.restaurant.repositories.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoteServiceImpl implements VoteService {
    final
    VoteRepository repository;

    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vote getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public Vote getByRestaurant(Restaurant restaurant) {
        return repository.getByRestaurant(restaurant);
    }

    @Override
    public Vote getByRestaurantID(Integer restaurantID) {
        return repository.getByRestaurantId(restaurantID);
    }

    @Override
    public Vote getByUser(User user) {
        return repository.getByUser(user);
    }

    @Override
    public Vote getByUserID(Integer userID) {
        return repository.getByUserId(userID);
    }

    @Override
    public List<Vote> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Vote vote) {
        repository.saveAndFlush(vote);
    }

    @Override
    public void delete(Vote vote) {
        repository.delete(vote);
    }

    @Override
    public void delete(Integer voteID) {
        repository.deleteById(voteID);
    }

    @Override
    public Vote update(Integer id, Vote newVote) {
        Vote oldVote = repository.getById(id);
        oldVote.setVoteTime(newVote.getVoteTime());
        oldVote.setId(newVote.getId());
        oldVote.setUser(newVote.getUser());
        oldVote.setRestaurant(newVote.getRestaurant());
        repository.saveAndFlush(oldVote);
        return oldVote;
    }
}
