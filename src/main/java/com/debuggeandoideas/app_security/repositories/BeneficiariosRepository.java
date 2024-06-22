package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.BeneficiariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BeneficiariosRepository extends JpaRepository<BeneficiariosEntity, String> {

    @Query("select c from BeneficiariosEntity c where c.user_id=:user_id")
    public List<BeneficiariosEntity> getBeneficiariosByUserId(Long user_id);

}
