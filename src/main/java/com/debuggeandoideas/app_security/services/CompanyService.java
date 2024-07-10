package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.CompanyEntity;
import com.debuggeandoideas.app_security.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {

    CompanyRepository companyRepository;

    public CompanyEntity getCompany(){
        return companyRepository.getCompany();
    }

    public CompanyEntity updateCompany(CompanyEntity company){
        return companyRepository.save(company);
    }
}
