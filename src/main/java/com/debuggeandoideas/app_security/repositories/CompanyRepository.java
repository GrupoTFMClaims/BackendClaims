package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {

    @Query("SELECT c FROM CompanyEntity c")
    public CompanyEntity getCompany();
}
