package com.zinkwork.atm.controller;

import com.zinkwork.atm.dto.WithdrawalDto;
import com.zinkwork.atm.exception.InsufficientFunds;
import com.zinkwork.atm.exception.InvalidValueException;
import com.zinkwork.atm.exception.NotEnoughBanknotesException;
import com.zinkwork.atm.exception.WrongPassword;
import com.zinkwork.atm.model.Withdrawal;
import com.zinkwork.atm.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.DefaultResponseErrorHandler;

@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {

    @Autowired
    WithdrawalService service;

    @PostMapping
    public ResponseEntity<WithdrawalDto> orderWithdraw(@RequestBody WithdrawalDto dto){
        try {
            Withdrawal withdrawal = service.orderWithdrawal(dto.getAccount().getAccountNumber(), dto.getAccount().getPin(), dto.getOperationValue());
            return ResponseEntity.ok(new WithdrawalDto(withdrawal));
        } catch (WrongPassword e) {
            e.printStackTrace();
        } catch (InsufficientFunds e) {
            e.printStackTrace();
        } catch (InvalidValueException e) {
            e.printStackTrace();
        } catch (NotEnoughBanknotesException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }


}
