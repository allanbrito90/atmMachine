package com.zinkwork.atm.dto;

import com.zinkwork.atm.model.Account;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawalDto {
    private Account account;
    private Integer operationValue;

}
