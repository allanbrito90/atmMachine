package com.zinkwork.atm.dto;

import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.model.NotesGiven;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class WithdrawalDto {
    private Account account;
    private Integer value;
    private NotesGiven notesGiven;
}
