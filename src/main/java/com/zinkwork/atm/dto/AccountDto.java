package com.zinkwork.atm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
    private String accountNumber;
    private Integer pin;
    private BigDecimal openingBalance;
    private BigDecimal overdraft;
    private boolean active;
}
