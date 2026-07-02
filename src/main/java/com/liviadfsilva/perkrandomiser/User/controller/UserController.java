package com.liviadfsilva.perkrandomiser.User.controller;

import com.liviadfsilva.perkrandomiser.User.dto.UserRequest;
import com.liviadfsilva.perkrandomiser.User.dto.UserResponse;
import com.liviadfsilva.perkrandomiser.User.model.User;
import com.liviadfsilva.perkrandomiser.User.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    // #TO-DO: add email
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest dto) {
        User user = service.registerUser(dto.getUsername(), dto.getPassword());

        UserResponse response = new UserResponse(user.getUsername());
        return ResponseEntity.ok(response);
    }

    // #TO-DO: add email
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequest dto) {
        User user = service.updateUser(id, dto);

        UserResponse response = new UserResponse(user.getUsername());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.hardDeleteUser(id);
    }
}
