package com.debuggeandoideas.app_security.repositories;


import com.debuggeandoideas.app_security.entites.ClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimsRepository extends JpaRepository<ClaimEntity, String> {

    @Query("select c from ClaimEntity c where c.user_id=:user_id")
    public List<ClaimEntity> getClaimsByUserId(Integer user_id);
}
