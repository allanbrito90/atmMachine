package com.zinkwork.atm.dto;

import com.zinkwork.atm.model.Banknotes;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BanknotesDto {
    private Integer banknoteValue;
    private Integer quantity;

    public static List<BanknotesDto> convert (List<Banknotes> banknotes){
        return banknotes.stream().map(BanknotesDto::new).collect(Collectors.toList());
    }

    public BanknotesDto (Banknotes banknote){
        BeanUtils.copyProperties(banknote, this);
    }
}
