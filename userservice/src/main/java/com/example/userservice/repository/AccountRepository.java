package com.example.userservice.repository;



import com.example.userservice.entity.Account;
import com.example.userservice.generic.IRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends IRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);

    Optional<Account> findByEmail(String email);
}
