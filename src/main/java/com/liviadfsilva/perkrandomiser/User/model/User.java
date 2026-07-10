package com.liviadfsilva.perkrandomiser.User.model;

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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    // #TO-DO: add email

    @Column(name = "password_hash", nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_perks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "perk_id")
    )
    private Set<Perk> perks = new HashSet<>();
}
