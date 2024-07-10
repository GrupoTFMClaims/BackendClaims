package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.RoleEntity;
import com.debuggeandoideas.app_security.repositories.RolesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RolesService {

    RolesRepository rolesRepository;

    public RoleEntity getRolById(Integer rol_id){
        System.out.println("mi parametro" + rol_id);
        return rolesRepository.getRolById(rol_id);
    }

    public List<RoleEntity> getAllRoles(){
        return rolesRepository.getAllRoles();
    }
}
