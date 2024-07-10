package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users2")
public class UserEntity {
    @Id
    private int id_user;
    private String full_name;
    private String email;
    private  String password;
    private String dni;
    private int rol_id;
    private int id;
    private String status;
}
