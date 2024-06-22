package com.debuggeandoideas.app_security.controllers;

import com.debuggeandoideas.app_security.entites.ChildrensMenu;
import com.debuggeandoideas.app_security.entites.MenuEntity;
import com.debuggeandoideas.app_security.services.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@RequestMapping
public class MenuController {

    private MenuService menuService;

    @GetMapping("/menu/{id_rol}")
    public ResponseEntity<?> getMenu(@PathVariable Long id_rol){

        List<ChildrensMenu> menuFinal = recursiveDataMenu(id_rol, 0);
        return ResponseEntity.ok(menuFinal);
    }

    private List<ChildrensMenu> recursiveDataMenu(Long id_rol, Integer parent_id){

            List<ChildrensMenu> menuFinal = new ArrayList<ChildrensMenu>();
            List<MenuEntity> menuItems = menuService.getMenu(id_rol, parent_id);

            for (Integer i = 0 ; i< menuItems.size(); i++){
                MenuEntity menuItem = menuItems.get(i);
                ChildrensMenu item = new ChildrensMenu();
                            item.setId_menu(menuItem.getId_menu());
                            item.setDescription(menuItem.getDescription());
                            item.setHas_children(menuItem.getHas_children());
                            item.setParent_id(menuItem.getParent_id());
                            item.setIcon(menuItem.getIcon());
                            item.setUrl(menuItem.getUrl());
                            item.setRol_id(menuItem.getRol_id());

                if(item.getHas_children().equals("true")){
                    item.setChildrens(menuService.getMenu(id_rol, menuItem.getId_menu()));
                }
                menuFinal.add(item);
            }
        return menuFinal;
    }
}
