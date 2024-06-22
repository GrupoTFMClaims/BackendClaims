package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.MenuEntity;
import com.debuggeandoideas.app_security.repositories.MenuRepository;
import com.debuggeandoideas.app_security.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public List<MenuEntity> getMenu(Long id_rol, Integer parent_id){

        return menuRepository.getMenuByParentId(id_rol, parent_id);
    }
}
