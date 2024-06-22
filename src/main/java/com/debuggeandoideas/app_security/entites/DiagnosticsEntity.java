package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "diagnostics")
public class DiagnosticsEntity {

    @Id
    private String cod_diagnostic;
    private String description;

}
