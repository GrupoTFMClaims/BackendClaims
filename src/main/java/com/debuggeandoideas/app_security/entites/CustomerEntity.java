package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "users2")
@Data
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private String full_name;
    private String email;
    private  String password;
    private String dni;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private List<RoleEntity> roles;
}
