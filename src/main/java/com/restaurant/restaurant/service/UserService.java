package com.restaurant.restaurant.service;

import com.restaurant.restaurant.models.Role;
import com.restaurant.restaurant.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User getById(Integer id);
    List<User> getAll();
    User getByUsername(String username);
    Set<Role> getRoles(Integer id);
    void save (User user);
    void delete(User user);
    void delete(Integer id);
    User update(Integer id,User newUser);
}
