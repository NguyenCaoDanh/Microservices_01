package com.example.userservice.dto.request;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;
    private String password;
}