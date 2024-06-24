package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.DiagnosticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiagnosticsRepository extends JpaRepository<DiagnosticsEntity, String> {

    @Query("select c from DiagnosticsEntity c")
    public List<DiagnosticsEntity> getDiagnostics();

    @Query("select c from DiagnosticsEntity c where c.cod_diagnostic =:cod_diagnostic")
    public DiagnosticsEntity getDiagnosticById(String cod_diagnostic);
}
