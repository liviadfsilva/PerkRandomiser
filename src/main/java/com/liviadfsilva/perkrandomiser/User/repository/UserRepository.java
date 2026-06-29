package com.liviadfsilva.perkrandomiser.User.repository;

import com.liviadfsilva.perkrandomiser.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
