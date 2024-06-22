package com.debuggeandoideas.app_security.entites;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.util.Optional;

@Data
@AllArgsConstructor
public class JWTResponse {

    private String jwt;
    private Integer user_id;
    private BigInteger rol_id;
    private String full_name;
    private String dni;
}
