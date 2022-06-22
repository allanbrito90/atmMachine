package com.zinkwork.atm.repository;

import com.zinkwork.atm.abstractClasses.AbstractInterface;
import com.zinkwork.atm.model.Banknotes;
import com.zinkwork.atm.model.Withdrawal;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalRepository extends AbstractInterface<Withdrawal, Long> {
}
