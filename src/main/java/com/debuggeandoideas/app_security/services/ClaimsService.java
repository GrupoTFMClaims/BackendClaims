package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.ClaimEntity;
import com.debuggeandoideas.app_security.entites.FileEntity;
import com.debuggeandoideas.app_security.entites.ReserveEntity;
import com.debuggeandoideas.app_security.repositories.ClaimsRepository;
import com.debuggeandoideas.app_security.repositories.FileRepository;
import com.debuggeandoideas.app_security.repositories.ReserveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClaimsService {

    ClaimsRepository claimsRepository;
    FileRepository fileRepository;
    ReserveRepository reserveRepository;

    public ClaimEntity saveClaim(ClaimEntity claim){
       return claimsRepository.save(claim);
    }

    public FileEntity saveFile(FileEntity file){
        return fileRepository.save(file);
    }

    public ReserveEntity saveReserve(ReserveEntity reserve){
        return reserveRepository.save(reserve);
    }

    public List<ClaimEntity> getAllClaimsByUserId(Integer user_id){
        return claimsRepository.getClaimsByUserId(user_id);
    }

}
