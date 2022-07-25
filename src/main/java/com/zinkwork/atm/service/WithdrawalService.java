package com.zinkwork.atm.service;

import com.zinkwork.atm.abstractClasses.AbstractService;
import com.zinkwork.atm.enumeration.EnumOperation;
import com.zinkwork.atm.exception.*;
import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.model.Banknotes;
import com.zinkwork.atm.model.Withdrawal;
import com.zinkwork.atm.repository.WithdrawalRepository;
import com.zinkwork.atm.utils.BanknoteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger LOGGER = LoggerFactory.getLogger(WithdrawalService.class);

    public Withdrawal orderWithdrawal(String accountNumber, Integer pin, Integer value){
        Withdrawal withdrawal = new Withdrawal();
        //check account number and password
        LOGGER.info("Checking Account Number and Password...");
        Account account = accountService.checkAccountNumberAndPin(accountNumber, pin).get();
        LOGGER.info("Account found!");
        withdrawal.setAccount(account);
        //Check if customer can withdraw its money
        LOGGER.info("Checking if account is active...");
        if (!account.isActive()) throw new InactiveAccount();
        LOGGER.info("Account is active!");
        //Check if customer have funds
        LOGGER.info("Checking funds...");
        if(account.getOpeningBalance().add(account.getOverdraft()).intValue() < value) throw new InsufficientFunds();
        LOGGER.info("Sufficient funds!");
        //Get available notes
        LOGGER.info("Getting available Banknotes...");
        List<Banknotes> banknotesList = banknotesService.list();
        //Separate the banknotes
        LOGGER.info("Selecting Banknotes...");
        banknotesService.saveAll(BanknoteUtils.checkNotes(banknotesList, value, notesGivenService, withdrawal));

        //Substract the total amount of the customer
        LOGGER.info("Updating Balance...");
        if ((account.getOpeningBalance().intValue() - value) < 0) {
            account.setOverdraft(account.getOverdraft().subtract(new BigDecimal(value).subtract(account.getOpeningBalance())));
            account.setOpeningBalance(BigDecimal.ZERO);
        }else{
            account.setOpeningBalance(account.getOpeningBalance().subtract(new BigDecimal(value)));
        }
        LOGGER.info("Balance updated!");
        LOGGER.info("Concluding transaction...");
        //Save the Withdrawal
        withdrawal.setWithdrawalDate(LocalDateTime.now());
        withdrawal.setOperation(EnumOperation.WITHDRAW);
        withdrawal.setOperationValue(value);
        withdrawalRepository.save(withdrawal);
        LOGGER.info("Transaction concluded!");
        return withdrawal;
    }

}
