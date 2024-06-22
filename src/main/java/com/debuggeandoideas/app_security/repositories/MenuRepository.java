package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.CustomerEntity;
import com.debuggeandoideas.app_security.entites.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, String> {
    @Query("SELECT c FROM MenuEntity c WHERE c.rol_id =:rol_id and c.parent_id=:parent_id")
    public List<MenuEntity> getMenuByParentId(Long rol_id, Integer parent_id);
}
