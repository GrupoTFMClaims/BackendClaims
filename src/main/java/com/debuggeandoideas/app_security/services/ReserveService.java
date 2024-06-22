package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.ReserveEntity;
import com.debuggeandoideas.app_security.repositories.ReserveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReserveService {

    ReserveRepository reserveRepository;

    public ReserveEntity getReserveByClaimId(Integer claim_id){

        return reserveRepository.getReserveByClaimId(claim_id);
    }

}
