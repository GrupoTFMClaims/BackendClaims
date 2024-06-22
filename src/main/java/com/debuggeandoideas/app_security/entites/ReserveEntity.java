package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reserve")
public class ReserveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserve;
    private String sinister_date;
    private String value;
    private Integer claim_id;
}
