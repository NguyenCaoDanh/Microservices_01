package com.example.userservice.controller;

import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void createUser(@RequestBody UserRequest request) {
        User user = new User();
        user.setAccountId(request.getAccountId());
        user.setFullName(request.getFullName());
        userRepository.save(user);
    }
    @PutMapping("/update")
    public User updateUserByAccountId(@RequestBody UserRequest userRequest) {
        return userRepository.findByAccountId(userRequest.getAccountId())
                .map(user -> {
                    user.setFullName(userRequest.getFullName());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found for accountId: " + userRequest.getAccountId()));
    }
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
}
