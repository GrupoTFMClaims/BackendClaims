package com.debuggeandoideas.app_security.controllers;

import com.debuggeandoideas.app_security.services.DiagnosticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class DiagnosticsController {

    DiagnosticsService diagnosticsService;

    @GetMapping("/diagnostics")
    public ResponseEntity<?> getDiagnostics(){
        return ResponseEntity.ok(diagnosticsService.getDiagnostics());
    }

}
