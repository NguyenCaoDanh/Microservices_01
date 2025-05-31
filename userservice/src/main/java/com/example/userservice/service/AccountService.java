package com.example.userservice.service;



import com.example.userservice.entity.Account;
import com.example.userservice.generic.IRepository;
import com.example.userservice.generic.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IService<Account, Integer>, UserDetailsService {
    IRepository<Account, Integer> getRepository();

}
