package com.zinkwork.atm.controller;

import com.zinkwork.atm.dto.BanknotesDto;
import com.zinkwork.atm.model.Banknotes;
import com.zinkwork.atm.service.BanknotesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banknote")
@Api(value = "API related to banknotes")
public class BanknotesController {
    
    @Autowired
    BanknotesService service;

    @GetMapping
    @ApiOperation(value = "Get the list of Available Banknotes")
    private ResponseEntity<List<BanknotesDto>> list(){
        return ResponseEntity.ok().body(BanknotesDto.convert(service.list()));
    }

}
