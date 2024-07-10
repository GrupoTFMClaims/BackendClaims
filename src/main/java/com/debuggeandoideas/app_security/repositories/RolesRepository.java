package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolesRepository extends JpaRepository<RoleEntity, String> {

    @Query("SELECT c FROM RoleEntity c where c.id=:rol_id")
    public RoleEntity getRolById(Integer rol_id);

    @Query("SELECT c FROM RoleEntity c ")
    public List<RoleEntity> getAllRoles();
}
