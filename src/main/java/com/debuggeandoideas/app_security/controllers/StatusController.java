package com.debuggeandoideas.app_security.controllers;

import com.debuggeandoideas.app_security.entites.StatusEntity;
import com.debuggeandoideas.app_security.services.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
@AllArgsConstructor
public class StatusController {

    StatusService statusService;

    @GetMapping("/getStatus")
    public ResponseEntity<?> getStatus(){
        List<StatusEntity> response = statusService.getAllStatus();

        return ResponseEntity.ok(response);
    }
}
