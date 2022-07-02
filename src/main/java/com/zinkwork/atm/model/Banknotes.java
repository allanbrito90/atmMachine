package com.zinkwork.atm.model;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Banknotes extends AbstractModel implements Comparable<Banknotes>{
    /*
    Banknotes
     */

    protected Integer banknoteValue;
    protected Integer quantity;

    @Override
    public int compareTo(Banknotes o) { return Integer.compare(this.banknoteValue,o.banknoteValue); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Banknotes banknotes = (Banknotes) o;
        return Objects.equals(banknoteValue, banknotes.banknoteValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), banknoteValue);
    }
}
