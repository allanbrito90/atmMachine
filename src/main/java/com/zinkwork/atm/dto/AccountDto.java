package com.zinkwork.atm.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AccountDto {
    private String accountNumber;
    private Integer pin;
    private BigDecimal openingBalance;
    private BigDecimal overdraft;
    private boolean active;
}
