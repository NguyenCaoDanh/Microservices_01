package com.example.authservice.service;


import com.example.authservice.entity.Account;
import com.example.authservice.generic.IRepository;
import com.example.authservice.generic.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IService<Account, Integer>, UserDetailsService {
    IRepository<Account, Integer> getRepository();

}
