package com.zinkwork.atm.controller;

import com.zinkwork.atm.dto.WithdrawalDto;
import com.zinkwork.atm.model.Withdrawal;
import com.zinkwork.atm.response.WithdrawalResponse;
import com.zinkwork.atm.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {

    @Autowired
    WithdrawalService service;

    @PostMapping
    public ResponseEntity<WithdrawalResponse> orderWithdraw(@RequestBody WithdrawalDto dto){
        Withdrawal withdrawal = service.orderWithdrawal(dto.getAccount().getAccountNumber(), dto.getAccount().getPin(), dto.getOperationValue());
        return ResponseEntity.ok(new WithdrawalResponse(withdrawal));
    }


}
