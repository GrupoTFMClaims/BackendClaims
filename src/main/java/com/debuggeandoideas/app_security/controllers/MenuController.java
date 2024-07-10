package com.debuggeandoideas.app_security.controllers;

import com.debuggeandoideas.app_security.entites.ChildrensMenu;
import com.debuggeandoideas.app_security.entites.MenuEntity;
import com.debuggeandoideas.app_security.entites.MenuRolResponse;
import com.debuggeandoideas.app_security.entites.RoleEntity;
import com.debuggeandoideas.app_security.services.MenuService;
import com.debuggeandoideas.app_security.services.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@RequestMapping
public class MenuController {

    private MenuService menuService;
    private RolesService rolesService;

    @GetMapping("/menu/{id_rol}")
    public ResponseEntity<?> getMenu(@PathVariable Long id_rol){

        List<ChildrensMenu> menuFinal = recursiveDataMenu(id_rol, 0);
        return ResponseEntity.ok(menuFinal);
    }

    @GetMapping("/menuByRol/{id_rol}")
    public ResponseEntity<?> geMenuByRol(@PathVariable Long id_rol){
        List <MenuEntity> menu =  menuService.getMenuByRol(id_rol);
        return ResponseEntity.ok(menu);
    }

    @GetMapping("/allMenuByRol")
    public ResponseEntity<?> getAllMenuByRol(){
        List <MenuEntity> menu = menuService.getAllMenu();
        List <MenuRolResponse> response =  new ArrayList<MenuRolResponse>();
        for(Integer i = 0 ; i< menu.size(); i++){
            RoleEntity rol = rolesService.getRolById(menu.get(i).getRol_id());
            MenuRolResponse item = new MenuRolResponse();

            item.setId_menu(menu.get(i).getId_menu());
            item.setDescription(menu.get(i).getDescription());
            item.setHas_children(menu.get(i).getHas_children());
            item.setParent_id(menu.get(i).getParent_id());
            item.setIcon(menu.get(i).getIcon());
            item.setUrl(menu.get(i).getUrl());
            item.setRol_id(menu.get(i).getRol_id());
            item.setStatus(menu.get(i).getStatus());
            item.setDescription_rol(rol.getName());
            response.add(item);
        }
        return ResponseEntity.ok(response);
    }


    @PostMapping("/updateMenu")
    public ResponseEntity<?> updateMenu(@RequestBody List<MenuEntity> menu){

        for(Integer i = 0 ; i< menu.size(); i++){
            menuService.UpdateMenu(menu.get(i));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new MenuRolResponse());
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
