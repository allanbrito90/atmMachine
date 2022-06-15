package com.zinkwork.atm.model;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Banknotes extends AbstractModel implements Comparable<Banknotes>{
    /*
    Banknotes
     */

    private Integer banknoteValue;
    private Integer quantity;

    @Override
    public int compareTo(Banknotes o) { return Integer.compare(this.banknoteValue,o.banknoteValue); }
}
