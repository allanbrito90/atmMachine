package com.zinkwork.atm.model;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Banknotes extends AbstractModel {
    /*
    Banknotes
     */

    private Integer banknoteValue;
    private Integer quantity;

}
