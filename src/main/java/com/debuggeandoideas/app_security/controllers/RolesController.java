package com.debuggeandoideas.app_security.controllers;

import com.debuggeandoideas.app_security.entites.RoleEntity;
import com.debuggeandoideas.app_security.services.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class RolesController  {

    RolesService rolesService;

    @GetMapping("/getRoles")
    public ResponseEntity<?> getAllRoles(){

        List<RoleEntity> roles = rolesService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
}
