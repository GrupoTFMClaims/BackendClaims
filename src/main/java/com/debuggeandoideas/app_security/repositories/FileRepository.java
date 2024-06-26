package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, String> {

    @Query("select c from FileEntity c where c.claim_id =:claim_id and c.type_file =:type_file")
    public List<FileEntity> getFilesByIdClaimAndType(Integer claim_id, String type_file);

}
