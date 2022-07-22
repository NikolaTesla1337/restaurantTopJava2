package com.restaurant.restaurant.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DISHES")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private Long price;
    @OneToOne
    @JoinColumn(name = "id")
    private Restaurant restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Dish dish = (Dish) o;
        return id != null && Objects.equals(id, dish.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
