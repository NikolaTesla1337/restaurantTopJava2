package com.restaurant.restaurant.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "VOTES")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "voteTime")
    private LocalDateTime voteTime;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id")
    private Restaurant restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Vote vote = (Vote) o;
        return id != null && Objects.equals(id, vote.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
