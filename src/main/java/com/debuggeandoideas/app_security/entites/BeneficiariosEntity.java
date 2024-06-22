package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "beneficiaries")
public class BeneficiariosEntity {
    @Id
    private Integer id_beneficiarie;
    private String full_name;
    private Integer user_id;
}
