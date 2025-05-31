package com.example.authservice.client;


import com.example.authservice.dto.request.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "userservice")
public interface UserClient {

    @PutMapping("/api/users/update")
    void updateUser(@RequestBody UserRequest userRequest);
    @PostMapping("/api/users")
    void createUser(@RequestBody UserRequest userRequest);
}
