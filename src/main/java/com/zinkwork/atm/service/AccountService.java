package com.zinkwork.atm.service;

import com.zinkwork.atm.abstractClasses.AbstractService;
import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<Long, Account, AccountRepository> {

    @Autowired
    private AccountRepository repository;

    public Account checkAccountNumberAndPin(String accountNumber, Integer pin){
        return repository.findByAccountNumberAndPin(accountNumber, pin);
    }

}
