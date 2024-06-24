package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.BeneficiariosEntity;
import com.debuggeandoideas.app_security.repositories.BeneficiariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BeneficiariosService {

    BeneficiariosRepository beneficiariosRepository;

    public List<BeneficiariosEntity>getBeneficiariosByUserId(Long insured_id){

        return beneficiariosRepository.getBeneficiariosByUserId(insured_id);
    }
}
