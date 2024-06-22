package com.debuggeandoideas.app_security.controllers;

import com.debuggeandoideas.app_security.entites.*;
import com.debuggeandoideas.app_security.services.ClaimsService;
import com.debuggeandoideas.app_security.services.ReserveService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class ClaimsController {

    ClaimsService claimsService;
    ReserveService reserveService;

    @GetMapping("/getAllClaims/{user_id}")
    public ResponseEntity<?>getAllClaimsByUser(@PathVariable Integer user_id){

        List<ClaimResponse> response = new ArrayList<>();
        List<ClaimEntity> claims = claimsService.getAllClaimsByUserId(user_id);
        for(Integer i= 0; i<claims.size(); i++){
            ClaimResponse itemResponse = new ClaimResponse();
            ClaimEntity claim = claims.get(i);
            ReserveEntity reserve = reserveService.getReserveByClaimId(claim.getId_claim());
            itemResponse.setId_claim(claim.getId_claim());
            itemResponse.setState(claim.getState());
            itemResponse.setObservation(claim.getDescription());
            itemResponse.setValue(reserve.getValue());
            response.add(itemResponse);
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping("/saveClaim")
    public ResponseEntity saveClaim(@RequestBody AllClaimData allclaim){
        ClaimEntity claim = new ClaimEntity();
        claim.setCod("");
        claim.setBeneficiary_id(allclaim.getBeneficiary_id());
        claim.setCreation_date(allclaim.getCreation_date());
        claim.setDescription(allclaim.getDescription());
        claim.setDiagnostic_id(allclaim.getDiagnostic_id());
        claim.setState(allclaim.getState());
        claim.setSinister_date(allclaim.getSinister_date());
        claim.setUser_id(allclaim.getUser_id());
        System.out.println("mi claim" + claim);
        claim = claimsService.saveClaim(claim);

        saveReserve(claim, allclaim.getValue());
        saveFile(allclaim.getFacturas(), claim.getId_claim());
        saveFile(allclaim.getDocumentos(), claim.getId_claim());


        return ResponseEntity.ok(allclaim);
    }

    private void saveReserve(ClaimEntity claim, String value){
        ReserveEntity reserve = new ReserveEntity();
        reserve.setClaim_id(claim.getId_claim());
        reserve.setSinister_date(claim.getSinister_date());
        reserve.setValue(value);
        reserve = claimsService.saveReserve(reserve);
    }

    private void saveFile(List<FileEntity> files, Integer claim_id){

        for(Integer i = 0; i<files.size(); i++){

            FileEntity file = files.get(i);
            file.setClaim_id(claim_id);
            file = claimsService.saveFile(file);
        }
    }

}
