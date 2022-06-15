package com.zinkwork.atm.model;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Account extends AbstractModel {

    /*
    ACCOUNT
     */

    @NotNull
    private String accountNumber;

    @NotNull
    private Integer pin;
    private BigDecimal openingBalance;
    private BigDecimal overdraft;
    private boolean active;
}
