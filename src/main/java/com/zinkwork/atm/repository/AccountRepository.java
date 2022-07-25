package com.zinkwork.atm.repository;

import com.zinkwork.atm.abstractClasses.AbstractInterface;
import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.model.Withdrawal;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends AbstractInterface<Account, Long> {

    public Optional<Account> findByAccountNumberAndPin(String accountNumber, Integer pin);

}
