package com.zinkwork.atm.model;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import com.zinkwork.atm.enumeration.EnumOperation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Withdrawal extends AbstractModel {

    @ManyToOne
    private Account account;

    private LocalDateTime withdrawalDate;
    private EnumOperation operation;
    private Integer operationValue;

}
