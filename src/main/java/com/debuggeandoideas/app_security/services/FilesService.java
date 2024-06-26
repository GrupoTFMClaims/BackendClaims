package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.FileEntity;
import com.debuggeandoideas.app_security.repositories.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilesService {
    FileRepository fileRepository;

    public List<FileEntity> getFilesByIdClaimAndType(Integer claim_id, String type_file){
        return fileRepository.getFilesByIdClaimAndType(claim_id, type_file);
    }

}
