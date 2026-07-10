package com.liviadfsilva.perkrandomiser.Perk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liviadfsilva.perkrandomiser.Category.model.Category;
import com.liviadfsilva.perkrandomiser.User.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perks")
public class Perk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "perk_categories",
            joinColumns = @JoinColumn(name = "perk_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "perks")
    private Set<User> users = new HashSet<>();

}