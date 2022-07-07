package com.zinkwork.atm.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponse {
    private String accountNumber;
    private BigDecimal openingBalance;
    private BigDecimal overdraft;
    private boolean active;
}
