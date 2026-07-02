package com.liviadfsilva.perkrandomiser.User.service;

import com.liviadfsilva.perkrandomiser.User.dto.UserRequest;
import com.liviadfsilva.perkrandomiser.User.model.User;
import com.liviadfsilva.perkrandomiser.User.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User registerUser(String username, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        return repository.save(user);
    }

    public User updateUser(Long id, UserRequest dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(dto.getUsername());

        String newPassword = dto.getPassword();
        if (newPassword != null && !newPassword.isEmpty()) {
            if (passwordEncoder.matches(newPassword, user.getPassword())) {
                throw new RuntimeException("New password must be different from previous password.");
            }

            user.setPassword(passwordEncoder.encode(newPassword));
        }

        return repository.save(user);
    }

    public void hardDeleteUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));

        repository.delete(user);
    }
}