package com.restaurant.restaurant.service;

import com.restaurant.restaurant.models.Role;
import com.restaurant.restaurant.models.User;
import com.restaurant.restaurant.repositories.RoleRepository;
import com.restaurant.restaurant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService{

    final
    UserRepository repository;
    final
    BCryptPasswordEncoder bCryptPasswordEncoder;
    final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder,RoleRepository roleRepository) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Set<Role> getRoles(Integer id) {
        return repository.getById(id).getRoles();
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.getById(id));
    }

    @Override
    public User update(Integer id, User newUser) {
        User oldUser = repository.getById(id);
        oldUser.setUsername(newUser.getUsername());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setId(newUser.getId());
        oldUser.setRoles(newUser.getRoles());
        repository.saveAndFlush(oldUser);

        return oldUser;
    }
}
