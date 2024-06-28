package com.debuggeandoideas.app_security.entites;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ReservClaimData{

    private ClaimEntity claim;
    private ReserveEntity reserve;
}
