package com.liviadfsilva.perkrandomiser.User.repository;

import com.liviadfsilva.perkrandomiser.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
