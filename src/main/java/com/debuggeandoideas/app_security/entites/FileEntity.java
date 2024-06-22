package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="files_claims")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_file;
    private String path_file;
    private String name;
    private Integer claim_id;
    private String type_file;
}
