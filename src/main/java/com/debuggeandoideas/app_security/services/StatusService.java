package com.debuggeandoideas.app_security.services;

import com.debuggeandoideas.app_security.entites.StatusEntity;
import com.debuggeandoideas.app_security.repositories.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatusService {

    StatusRepository statusRepository;

    public List<StatusEntity> getAllStatus(){
        return statusRepository.getAllStatus();
    }

}
