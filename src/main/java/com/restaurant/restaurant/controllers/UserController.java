package com.restaurant.restaurant.controllers;

import com.restaurant.restaurant.models.User;
import com.restaurant.restaurant.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/rest")
public class UserController {
    final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @Secured(value = {"ROLE_ADMIN"})
    public String getAll(Model model){
        model.addAttribute("users",userService.getAll());
        return "users";
    }
    @GetMapping("/users/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public String getById( Model model,@PathVariable Integer id){
        model.addAttribute("user",userService.getById(id));
        return "user";
    }
    @PutMapping("/user/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public void updateUser (@PathVariable Integer id, @RequestBody User user){
        userService.update(id, user);
    }
    @PostMapping("/register")
    public String createUser (@RequestBody User user){
        userService.save(user);
        return "register";
    }
    @DeleteMapping("/user/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public void deleteUser (@PathVariable Integer id){
        userService.delete(id);
    }

    
}
