package com.debuggeandoideas.app_security.controllers;

import com.debuggeandoideas.app_security.entites.CompanyEntity;
import com.debuggeandoideas.app_security.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class CompanyController {
    CompanyService companyService;

    @GetMapping("/getCompany")
    public ResponseEntity<?> getCompany(){

        CompanyEntity company = companyService.getCompany();
        return ResponseEntity.ok(company);
    }

    @PostMapping("/updateCompany")
    public ResponseEntity<?> updateCompany(@RequestBody CompanyEntity company){
        CompanyEntity response = companyService.updateCompany(company);

        return ResponseEntity.ok(response);
    }
}
