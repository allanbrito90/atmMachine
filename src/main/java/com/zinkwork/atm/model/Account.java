package com.zinkwork.atm.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Account {

    /*
    ACCOUNT
     */

    @Id
    private String accountNumber;
    private Integer pin;
    private BigDecimal openingBalance;
    private BigDecimal overdraft;
}
