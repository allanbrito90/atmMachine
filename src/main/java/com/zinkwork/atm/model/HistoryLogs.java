package com.zinkwork.atm.model;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import com.zinkwork.atm.enumeration.EnumOperation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Entity
public class HistoryLogs extends AbstractModel {

    @ManyToOne
    private Account account;

    private EnumOperation operation;
    private BigDecimal operationValue;

}
