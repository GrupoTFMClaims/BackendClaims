package com.debuggeandoideas.app_security.controllers;


import com.debuggeandoideas.app_security.entites.BeneficiariosEntity;
import com.debuggeandoideas.app_security.services.BeneficiariosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class BeneficiariosController {

    BeneficiariosService beneficiariosService;

    @GetMapping("/beneficiarios/{user_id}")
    public ResponseEntity<?> getMenu(@PathVariable Long user_id){

        List<BeneficiariosEntity> beneficiarios = beneficiariosService.getBeneficiariosByUserId(user_id);
        return ResponseEntity.ok(beneficiarios);
    }
}
