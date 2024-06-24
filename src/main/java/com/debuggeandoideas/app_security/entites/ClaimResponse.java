package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data

public class ClaimResponse {
    private Integer id_claim;
    private String state;
    private String observation;
    private String value;
    private String creation_date;
    private String cod_diagnostic;
    private String diagnostic;
    private String sinister_date;
}
