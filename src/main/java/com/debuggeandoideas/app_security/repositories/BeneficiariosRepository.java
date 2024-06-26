package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.BeneficiariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BeneficiariosRepository extends JpaRepository<BeneficiariosEntity, String> {

    @Query("select c from BeneficiariosEntity c where c.insured_id=:insured_id")
    public List<BeneficiariosEntity> getBeneficiariosByUserId(Long insured_id);

    @Query("select c from BeneficiariosEntity c where c.id_beneficiarie=:id_beneficiarie")
    public BeneficiariosEntity getBeneficiarioById(Integer id_beneficiarie);
}
