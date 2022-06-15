package com.zinkwork.atm.service;

import com.zinkwork.atm.abstractClasses.AbstractService;
import com.zinkwork.atm.model.Banknotes;
import com.zinkwork.atm.repository.BanknotesRepository;
import org.springframework.stereotype.Service;

@Service
public class BanknotesService extends AbstractService<Long, Banknotes, BanknotesRepository> {


}
