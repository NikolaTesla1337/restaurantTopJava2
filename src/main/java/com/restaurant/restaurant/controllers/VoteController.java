package com.restaurant.restaurant.controllers;

import com.restaurant.restaurant.models.Vote;
import com.restaurant.restaurant.service.VoteServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/rest")
public class VoteController {

    final VoteServiceImpl voteService;

    public VoteController(VoteServiceImpl voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/votes")
    @Secured(value = {"ROLE_ADMIN"})
    public String getAll (Model model) {
        model.addAttribute("votes",voteService.getAll());
        return "votes";
    }
    @GetMapping("/votes/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public String getById(Model model, @PathVariable Integer id){
        model.addAttribute("vote",voteService.getById(id));
        return "vote";
    }
    @DeleteMapping("/votes/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public void delete(@PathVariable Integer id){
        voteService.delete(id);
    }
    @PostMapping
    @Secured(value = {"ROLE_USER","ROLE_ADMIN"})
    public void create(@RequestBody Vote vote){
        voteService.save(vote);
    }
    @PutMapping("/votes/{id}")
    @Secured(value = {"ROLE_USER","ROLE_ADMIN"})
    public void update (@RequestBody Vote vote, @PathVariable Integer id){
        voteService.update(id,vote);
    }


}
