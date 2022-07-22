package com.restaurant.restaurant.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RESTAURANTS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Dish> menu;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Vote> voteList;
}
