package com.zinkwork.atm.dto;

import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.model.NotesGiven;
import com.zinkwork.atm.model.Withdrawal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class WithdrawalDto {
    private AccountDto account;
    private Integer operationValue;
    private List<NotesGivenDto> notesGiven;

    public WithdrawalDto() {
    }

    public WithdrawalDto(Withdrawal withdrawal) {
        BeanUtils.copyProperties(withdrawal, this);
        this.account = new AccountDto();
        this.notesGiven = new ArrayList<>();
        BeanUtils.copyProperties(withdrawal.getAccount(), this.account);
        for(NotesGiven ng : withdrawal.getNotesGiven()) this.notesGiven.add(new NotesGivenDto(ng));
    }

}
