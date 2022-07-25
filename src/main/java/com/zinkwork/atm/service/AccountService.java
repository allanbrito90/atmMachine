package com.zinkwork.atm.service;

import com.zinkwork.atm.abstractClasses.AbstractService;
import com.zinkwork.atm.exception.WrongPassword;
import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService extends AbstractService<Long, Account, AccountRepository> {

    @Autowired
    private AccountRepository repository;

    public Optional<Account> checkAccountNumberAndPin(String accountNumber, Integer pin){
        return Optional.of(repository.findByAccountNumberAndPin(accountNumber, pin).orElseThrow(WrongPassword::new));
    }

}
