package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "menu")
@Data
public class MenuEntity {
    @Id
    private Integer id_menu;
    private String description;
    private String has_children;
    private Integer parent_id;
    private String icon;
    private String url;
    private Integer rol_id;
    private String status;
}
