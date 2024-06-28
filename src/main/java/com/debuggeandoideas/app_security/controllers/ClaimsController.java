package com.debuggeandoideas.app_security.controllers;

import com.debuggeandoideas.app_security.entites.*;
import com.debuggeandoideas.app_security.services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    DiagnosticsService diagnosticsService;
    UserService userService;
    BeneficiariosService beneficiariosService;

    @GetMapping("/getAllClaimsInsured/{insured_id}")
    public ResponseEntity<?>getAllClaimsByInsured(@PathVariable Integer insured_id){

        List<ClaimResponse> response = new ArrayList<>();
        List<ClaimEntity> claims = claimsService.getAllClaimsByInsuredId(insured_id);
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

    @GetMapping("/getAllClaimsAnalist/{analist_id}")
    public ResponseEntity<?>getAllClaimsByAnalist(@PathVariable Integer analist_id){

        List<ClaimResponse> response = new ArrayList<>();
        List<ClaimEntity> claims = claimsService.getAllClaimsByAnalistId(analist_id);
        for(Integer i= 0; i<claims.size(); i++){
            ClaimResponse itemResponse = new ClaimResponse();
            ClaimEntity claim = claims.get(i);
            ReserveEntity reserve = reserveService.getReserveByClaimId(claim.getId_claim());
            DiagnosticsEntity diagnostic = diagnosticsService.getDiagnosticById(claim.getDiagnostic_id());
            CustomerEntity usuario = userService.getUserById(claim.getInsured_id());
            BeneficiariosEntity beneficiary = beneficiariosService.getBeneficiarioById(claim.getBeneficiary_id());


            itemResponse.setId_claim(claim.getId_claim());
            itemResponse.setId_beneficiary(claim.getBeneficiary_id());
            itemResponse.setInsured_id(claim.getInsured_id());
            itemResponse.setAnalist_id(claim.getAnalist_id());
            itemResponse.setId_reserve(reserve.getId_reserve());
            itemResponse.setState(claim.getState());
            itemResponse.setObservation(claim.getDescription());
            itemResponse.setValue(reserve.getValue());
            itemResponse.setCreation_date(claim.getCreation_date());
            itemResponse.setCod_diagnostic(diagnostic.getCod_diagnostic());
            itemResponse.setDiagnostic(diagnostic.getDescription());
            itemResponse.setSinister_date(claim.getSinister_date());
            itemResponse.setFull_name(usuario.getFull_name());
            itemResponse.setDni(usuario.getDni());
            itemResponse.setBeneficiary_name(beneficiary.getFull_name());
            response.add(itemResponse);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllClaimByBeneficiary/{id_beneficiary}")
    public ResponseEntity<?>getClaimsByBeneficiary(@PathVariable Integer id_beneficiary){
            List<ReservClaimData> response = new ArrayList<>();
            List<ClaimEntity> claims = claimsService.getAllClaimsByBeneficiaryId(id_beneficiary);

            for(Integer i = 0; i<claims.size(); i++){
                ReservClaimData item = new ReservClaimData();
                ClaimEntity claim = claims.get(i);
                ReserveEntity reserve = reserveService.getReserveByClaimId(claim.getId_claim());

                item.setClaim(claim);
                item.setReserve(reserve);

                response.add(item);
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
        claim.setInsured_id(allclaim.getInsured_id());
        claim.setAnalist_id(2);
        claim = claimsService.saveClaim(claim);

        ReserveEntity reserve = new ReserveEntity();
                      reserve.setSinister_date(claim.getSinister_date());
                      reserve.setValue(allclaim.getValue());
                      reserve.setClaim_id(claim.getId_claim());
                      reserve.setReimbursement(0f);
                      reserve.setUncovered_expenses(0f);
                      reserve.setCoinsurance(0f);
                      reserve.setDeductible(0f);

                     saveReserve(reserve);
        //saveFile(allclaim.getFacturas(), claim.getId_claim());
        //saveFile(allclaim.getDocumentos(), claim.getId_claim());

        return ResponseEntity.ok(claim);
    }

    @PostMapping("/saveReserve")
    public ResponseEntity<ResponseMessage> saveReserveFront(@RequestBody ReserveEntity reserve){
        saveReserve(reserve);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("su pago se registro con éxito"));
    }

    @PostMapping("/updateStateClaim")
    public ResponseEntity<?> updateStateClaim(@RequestBody ClaimEntity claim){
        ClaimEntity response = claimsService.updateStateClaim(claim);
        return ResponseEntity.ok(response);
    }
    private void saveReserve(ReserveEntity reserve){
        reserve = claimsService.saveReserve(reserve);
    }



}
