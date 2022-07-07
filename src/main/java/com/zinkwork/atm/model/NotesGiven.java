package com.zinkwork.atm.model;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class NotesGiven extends AbstractModel {

    @NotNull
    private Integer banknoteValue;

    @NotNull
    private Integer quantity;

    public NotesGiven (Integer banknoteValue, Integer quantity){
        this.banknoteValue = banknoteValue;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NotesGiven that = (NotesGiven) o;
        return Objects.equals(banknoteValue, that.banknoteValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), banknoteValue);
    }
}
