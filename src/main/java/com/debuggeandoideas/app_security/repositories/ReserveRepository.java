package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.ReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReserveRepository extends JpaRepository<ReserveEntity, String> {

    @Query("select c from ReserveEntity c where c.claim_id =:claim_id")
    public ReserveEntity getReserveByClaimId(Integer claim_id);
}
