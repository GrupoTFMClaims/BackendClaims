package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.CustomerEntity;
import com.debuggeandoideas.app_security.entites.MenuEntity;
import com.debuggeandoideas.app_security.entites.MenuRolResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, String> {
    @Query("SELECT c FROM MenuEntity c WHERE c.rol_id =:rol_id and c.parent_id=:parent_id and c.status = 'activo'")
    public List<MenuEntity> getMenuByParentId(Long rol_id, Integer parent_id);

    @Query("SELECT c FROM MenuEntity c WHERE c.rol_id=:rol_id")
    public List<MenuEntity> getMenuByRol(Long rol_id);

    @Query("SELECT c FROM MenuEntity c")
    public List<MenuEntity> getAllMenu();
}
