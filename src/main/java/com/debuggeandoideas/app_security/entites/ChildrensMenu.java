package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
@Data
public class ChildrensMenu {

    private Integer id_menu;
    private String description;
    private String has_children;
    private Integer parent_id;
    private String icon;
    private String url;
    private Integer rol_id;
    private List<MenuEntity> childrens;
}
