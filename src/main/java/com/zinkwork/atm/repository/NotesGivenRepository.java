package com.zinkwork.atm.repository;

import com.zinkwork.atm.abstractClasses.AbstractInterface;
import com.zinkwork.atm.model.Account;
import com.zinkwork.atm.model.NotesGiven;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesGivenRepository extends AbstractInterface<NotesGiven, Long> {

}
