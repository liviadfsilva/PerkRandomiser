package com.liviadfsilva.perkrandomiser.Category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liviadfsilva.perkrandomiser.Perk.model.Perk;
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
@Table(name = "categories")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Perk> perks = new HashSet<>();
}
