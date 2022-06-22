package com.zinkwork.atm.repository;

import com.zinkwork.atm.abstractClasses.AbstractInterface;
import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.model.Withdrawal;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends AbstractInterface<Account, Long> {

    public Account findByAccountNumberAndPin(String accountNumber, Integer pin);

}
