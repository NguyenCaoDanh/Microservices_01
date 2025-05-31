package com.example.userservice.service.impl;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
