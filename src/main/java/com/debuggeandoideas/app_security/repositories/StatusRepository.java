package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusRepository extends JpaRepository<StatusEntity, String> {

    @Query("SELECT c FROM StatusEntity c")
    public List<StatusEntity> getAllStatus();
}
