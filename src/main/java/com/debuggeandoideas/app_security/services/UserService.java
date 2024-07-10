package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.CustomerEntity;
import com.debuggeandoideas.app_security.entites.UserEntity;
import com.debuggeandoideas.app_security.repositories.CustomerRepository;
import com.debuggeandoideas.app_security.repositories.UserRepository;
import com.debuggeandoideas.app_security.repositories.UserUpdateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserUpdateRepository userUpdateRepository;

    public CustomerEntity getUser(String email){
        return this.userRepository.getUserByEmail(email);
    }

    public CustomerEntity getUserById(Integer id_user){
        return userRepository.getUserById(id_user);
    }

    public List<CustomerEntity> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public List<CustomerEntity> getAllUsersByName(String name){
        return userRepository.getAllUsersByName(name);
    }

    public UserEntity updateUser(UserEntity user){
        return userUpdateRepository.save(user);
    }
}
