package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "claims")
public class ClaimEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_claim;
    private String cod;
    private String description;
    private String state;
    private String creation_date;
    private String sinister_date;
    private Integer user_id;
    private Integer beneficiary_id;
    private String diagnostic_id;
}
