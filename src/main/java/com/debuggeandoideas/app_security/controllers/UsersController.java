package com.debuggeandoideas.app_security.controllers;

import com.debuggeandoideas.app_security.entites.ClaimEntity;
import com.debuggeandoideas.app_security.entites.ClaimResponse;
import com.debuggeandoideas.app_security.entites.CustomerEntity;
import com.debuggeandoideas.app_security.entites.ReserveEntity;
import com.debuggeandoideas.app_security.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class UsersController {

    UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(){

        List<CustomerEntity> response = userService.getAllUsers();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllUsersByName/{name}")
    public ResponseEntity<?> getAllUsersByName(@PathVariable String name){

        List<CustomerEntity> response = userService.getAllUsersByName("%"+name+"%");

        return ResponseEntity.ok(response);
    }
}
