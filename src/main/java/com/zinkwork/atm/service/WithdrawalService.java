package com.zinkwork.atm.service;

import com.zinkwork.atm.abstractClasses.AbstractService;
import com.zinkwork.atm.enumeration.EnumOperation;
import com.zinkwork.atm.exception.InsufficientFunds;
import com.zinkwork.atm.exception.InvalidValueException;
import com.zinkwork.atm.exception.NotEnoughBanknotesException;
import com.zinkwork.atm.exception.WrongPassword;
import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.model.Banknotes;
import com.zinkwork.atm.model.NotesGiven;
import com.zinkwork.atm.model.Withdrawal;
import com.zinkwork.atm.repository.NotesGivenRepository;
import com.zinkwork.atm.repository.WithdrawalRepository;
import com.zinkwork.atm.utils.BanknoteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WithdrawalService extends AbstractService<Long, Withdrawal, WithdrawalRepository> {

    @Autowired
    private BanknotesService banknotesService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private NotesGivenRepository notesGivenRepository;

    public Withdrawal orderWithdrawal(String accountNumber, Integer pin, Integer value){
        Withdrawal withdrawal = new Withdrawal();
        try {
            //check account number and password
            Account account = accountService.checkAccountNumberAndPin(accountNumber, pin);
            if(account == null) throw new WrongPassword();
            withdrawal.setAccount(account);
            //Check if customer have funds
            if(account.getOpeningBalance().add(account.getOverdraft()).intValue() < value) throw new InsufficientFunds();
            //Get available notes
            List<Banknotes> banknotesList = banknotesService.list();
            //Separate the banknotes
            Map<Integer,Integer> notesGivenMap = BanknoteUtils.checkNotes(banknotesList, value);
            List<NotesGiven> notesGivenList = new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry : notesGivenMap.entrySet()){
                notesGivenList.add(new NotesGiven(entry.getKey(), entry.getValue()));
            }
            notesGivenList = notesGivenRepository.saveAll(notesGivenList);
            //Substract the value of total banknotes and save at the database

            //Substract the total amount of the customer
            if ((account.getOpeningBalance().intValue() - value) < 0) {
                account.setOverdraft(account.getOverdraft().subtract(new BigDecimal(value).subtract(account.getOpeningBalance())));
                account.setOpeningBalance(BigDecimal.ZERO);
            }else{
                account.setOpeningBalance(account.getOpeningBalance().subtract(new BigDecimal(value)));
            }
            //Save the Withdrawal
            withdrawal.setNotesGiven(notesGivenList);
            withdrawal.setWithdrawalDate(LocalDateTime.now());
            withdrawal.setOperation(EnumOperation.WITHDRAW);
            withdrawal.setOperationValue(value);
            withdrawalRepository.save(withdrawal);
        } catch (InvalidValueException | InsufficientFunds e) {
            e.printStackTrace();
        } catch (NotEnoughBanknotesException e) {
            e.printStackTrace();
        } catch (WrongPassword e) {
            e.printStackTrace();
        }
        return withdrawal;
    }

}
