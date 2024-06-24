package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.DiagnosticsEntity;
import com.debuggeandoideas.app_security.repositories.DiagnosticsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiagnosticsService {

    DiagnosticsRepository diagnosticsRepository;

    public List<DiagnosticsEntity> getDiagnostics(){
        return diagnosticsRepository.getDiagnostics();
    }

    public DiagnosticsEntity getDiagnosticById(String cod_diagnostic){
        return diagnosticsRepository.getDiagnosticById(cod_diagnostic);
    }
}
