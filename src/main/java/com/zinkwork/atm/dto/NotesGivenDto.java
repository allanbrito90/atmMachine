package com.zinkwork.atm.dto;

import com.zinkwork.atm.abstractClasses.AbstractModel;
import com.zinkwork.atm.model.NotesGiven;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class NotesGivenDto{
    private Integer banknoteValue;
    private Integer quantity;

    public static List<NotesGivenDto> convert (List<NotesGiven> notesGiven){
        return notesGiven.stream().map(NotesGivenDto::new).collect(Collectors.toList());
    }

    public NotesGivenDto (NotesGiven notesGiven){
        BeanUtils.copyProperties(notesGiven,this);
    }
}
