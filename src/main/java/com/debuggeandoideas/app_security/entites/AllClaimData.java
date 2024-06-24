package com.debuggeandoideas.app_security.entites;

import lombok.Data;

import java.util.List;

@Data
public class AllClaimData {

    private Integer beneficiary_id;
    private String creation_date;
    private String description;
    private String diagnostic_id;
    private String sinister_date;
    private String state;
    private Integer insured_id;
    private Integer analist_id;
    private String value;
    private List<FileEntity> documentos;
    private List<FileEntity> facturas;

}
