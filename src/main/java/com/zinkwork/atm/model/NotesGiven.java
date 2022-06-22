package com.zinkwork.atm.model;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class NotesGiven extends AbstractModel {

    private Integer banknoteValue;
    private Integer quantity;

    public NotesGiven (Integer banknoteValue, Integer quantity){
        this.banknoteValue = banknoteValue;
        this.quantity = quantity;
    }

}
