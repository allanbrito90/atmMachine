package com.zinkwork.atm.controller;

import com.zinkwork.atm.dto.WithdrawalDto;
import com.zinkwork.atm.model.Withdrawal;
import com.zinkwork.atm.response.WithdrawalResponse;
import com.zinkwork.atm.service.WithdrawalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/withdrawal")
@Api(value = "API related to Withdrawal Service")
public class WithdrawalController {

    @Autowired
    WithdrawalService service;

    @PostMapping
    @ApiOperation(value = "Execute a Withdrawal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Withdrawal Successfully executed"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<WithdrawalResponse> orderWithdraw(@RequestBody WithdrawalDto dto){
        Withdrawal withdrawal = service.orderWithdrawal(dto.getAccount().getAccountNumber(), dto.getAccount().getPin(), dto.getOperationValue());
        return ResponseEntity.ok(new WithdrawalResponse(withdrawal));
    }


}
