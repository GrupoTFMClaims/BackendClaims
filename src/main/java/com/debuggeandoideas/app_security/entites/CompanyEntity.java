package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    private Integer id_company;
    private String name;
    private String ruc;
    private String header;
    private String footer;

}
