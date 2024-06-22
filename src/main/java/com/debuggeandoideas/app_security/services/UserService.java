package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.CustomerEntity;
import com.debuggeandoideas.app_security.repositories.CustomerRepository;
import com.debuggeandoideas.app_security.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CustomerEntity getUser(String email){
        return this.userRepository.getUserByEmail(email);
    }
}
