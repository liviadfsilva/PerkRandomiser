package com.liviadfsilva.perkrandomiser.User.service;

import com.liviadfsilva.perkrandomiser.Perk.model.Perk;
import com.liviadfsilva.perkrandomiser.Perk.repository.PerkRepository;
import com.liviadfsilva.perkrandomiser.User.dto.UserRequest;
import com.liviadfsilva.perkrandomiser.User.model.User;
import com.liviadfsilva.perkrandomiser.User.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final PerkRepository perkRepository;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, PerkRepository perkRepository){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.perkRepository = perkRepository;
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

    public User registerUser(UserRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getRawPassword());
        Set<Perk> perks = new HashSet<>(
                perkRepository.findAllById(request.getPerkIds()));

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encodedPassword);
        user.setPerks(perks);

        return repository.save(user);
    }

    // #TO-DO: add email
    public User updateUser(Long id, UserRequest request) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (request.getUsername() != null && !request.getUsername().isBlank()) {
            user.setUsername(request.getUsername());
        }

        String newPassword = request.getRawPassword();
        if (newPassword != null && !newPassword.isEmpty()) {
            if (passwordEncoder.matches(newPassword, user.getPassword())) {
                throw new RuntimeException("New password must be different from previous password.");
            }

            user.setPassword(passwordEncoder.encode(newPassword));
        }

        if (request.getPerkIds() != null) {
            Set<Perk> perks = new HashSet<>(
                    perkRepository.findAllById(request.getPerkIds()));
            user.setPerks(perks);
        }

        return repository.save(user);
    }

    public void hardDeleteUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));

        repository.delete(user);
    }
}