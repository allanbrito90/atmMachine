package com.zinkwork.atm.model;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import com.zinkwork.atm.enumeration.EnumOperation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Withdrawal extends AbstractModel {

    @ManyToOne
    private Account account;

    private LocalDateTime withdrawalDate;
    @Enumerated(EnumType.STRING)
    private EnumOperation operation;
    private Integer operationValue;

    @OneToMany
    private List<NotesGiven> notesGiven;

}
