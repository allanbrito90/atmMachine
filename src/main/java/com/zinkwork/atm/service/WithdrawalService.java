package com.zinkwork.atm.service;

import com.zinkwork.atm.abstractClasses.AbstractService;
import com.zinkwork.atm.enumeration.EnumOperation;
import com.zinkwork.atm.exception.InsufficientFunds;
import com.zinkwork.atm.exception.InvalidValueException;
import com.zinkwork.atm.exception.NotEnoughBanknotesException;
import com.zinkwork.atm.exception.WrongPassword;
import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.model.Banknotes;
import com.zinkwork.atm.model.Withdrawal;
import com.zinkwork.atm.repository.NotesGivenRepository;
import com.zinkwork.atm.repository.WithdrawalRepository;
import com.zinkwork.atm.utils.BanknoteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WithdrawalService extends AbstractService<Long, Withdrawal, WithdrawalRepository> {

    @Autowired
    private BanknotesService banknotesService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private NotesGivenService notesGivenService;

    public Withdrawal orderWithdrawal(String accountNumber, Integer pin, Integer value) throws WrongPassword, InsufficientFunds, InvalidValueException, NotEnoughBanknotesException {
        Withdrawal withdrawal = new Withdrawal();
        //check account number and password
        Account account = accountService.checkAccountNumberAndPin(accountNumber, pin);
        if(account == null) throw new WrongPassword();
        withdrawal.setAccount(account);
        //Check if customer have funds
        if(account.getOpeningBalance().add(account.getOverdraft()).intValue() < value) throw new InsufficientFunds();
        //Get available notes
        List<Banknotes> banknotesList = banknotesService.list();
        //Separate the banknotes
        banknotesService.saveAll(BanknoteUtils.checkNotes(banknotesList, value, notesGivenService, withdrawal));

//            notesGivenList = notesGivenRepository.saveAll(notesGivenList);
        //Substract the value of total banknotes and save at the database

        //Substract the total amount of the customer
        if ((account.getOpeningBalance().intValue() - value) < 0) {
            account.setOverdraft(account.getOverdraft().subtract(new BigDecimal(value).subtract(account.getOpeningBalance())));
            account.setOpeningBalance(BigDecimal.ZERO);
        }else{
            account.setOpeningBalance(account.getOpeningBalance().subtract(new BigDecimal(value)));
        }
        //Save the Withdrawal
//            withdrawal.setNotesGiven(notesGivenList);
        withdrawal.setWithdrawalDate(LocalDateTime.now());
        withdrawal.setOperation(EnumOperation.WITHDRAW);
        withdrawal.setOperationValue(value);
        withdrawalRepository.save(withdrawal);
        return withdrawal;
    }

}
