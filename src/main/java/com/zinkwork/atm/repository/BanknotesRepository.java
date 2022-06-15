package com.zinkwork.atm.repository;

import com.zinkwork.atm.abstractClasses.AbstractInterface;
import com.zinkwork.atm.model.Banknotes;
import org.springframework.stereotype.Repository;

@Repository
public interface BanknotesRepository extends AbstractInterface<Banknotes, Long> {
}
