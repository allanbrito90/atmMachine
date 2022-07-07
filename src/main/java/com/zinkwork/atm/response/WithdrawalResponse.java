package com.zinkwork.atm.response;

import com.zinkwork.atm.dto.AccountDto;
import com.zinkwork.atm.dto.NotesGivenDto;
import com.zinkwork.atm.model.NotesGiven;
import com.zinkwork.atm.model.Withdrawal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WithdrawalResponse {
    private AccountResponse account;
    private Integer operationValue;
    private List<NotesGivenDto> notesGiven;

    public WithdrawalResponse() {
    }

    public WithdrawalResponse(Withdrawal withdrawal) {
        BeanUtils.copyProperties(withdrawal, this);
        this.account = new AccountResponse();
        this.notesGiven = new ArrayList<>();
        BeanUtils.copyProperties(withdrawal.getAccount(), this.account);
        for(NotesGiven ng : withdrawal.getNotesGiven()) this.notesGiven.add(new NotesGivenDto(ng));
    }

}
