package com.debuggeandoideas.app_security.repositories;


import com.debuggeandoideas.app_security.entites.ClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimsRepository extends JpaRepository<ClaimEntity, String> {

    @Query("select c from ClaimEntity c where c.insured_id=:insured_id")
    public List<ClaimEntity> getClaimsByInsuredId(Integer insured_id);

    @Query("select c from ClaimEntity c where c.analist_id=:analist_id")
    public List<ClaimEntity> getClaimsByAnalistId(Integer analist_id);

    @Query("select c from ClaimEntity c where c.beneficiary_id=:beneficiary_id")
    public List<ClaimEntity> getClaimsByBeneficiaryId(Integer beneficiary_id);

}
