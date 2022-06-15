package com.zinkwork.atm.utils;

import com.zinkwork.atm.exception.InvalidValueException;
import com.zinkwork.atm.exception.NotEnoughBanknotesException;
import com.zinkwork.atm.model.Banknotes;

import java.util.*;

public class BanknoteUtils {

    //Select the best banknotes
    public static Map<Integer, Integer> checkNotes(List<Banknotes> availableNotes, Integer value) throws InvalidValueException, NotEnoughBanknotesException {
        //Check if number is multiple of 5
        if(value % 5 != 0){ throw new InvalidValueException(); }

        //Transforming into array and putting in correct order
        Banknotes[] availableNotesArray = availableNotes.toArray(Banknotes[]::new);
        Arrays.sort(availableNotesArray, Collections.reverseOrder());

        //Creating a new List of Notes that were given
        Map<Integer, Integer> notesGiven = new HashMap<>();

        //Creating the partial variable to know the amount of money
        Integer total = 0;
        Integer currentValue;

        /*The logic will pass through the notes from the highest value to the less valuable,
        each note will be comparable to the total value, if the value of the note plus the partial total still being
        less money than the total amount needed, the note will be selected.
        P.S.: It needs to have at least one banknote of the selected value.

        The value is put in a hashmap and it is subtracted one banknote of the total quantity,
        the cursor back to the first position of the array (most valuable banknote).
        * */
        for(int i=0 ; i < availableNotesArray.length; i++){
            if(total.equals(value)) break;
            if((total + availableNotesArray[i].getBanknoteValue()) <= value && (availableNotesArray[i].getQuantity() > 0)){
                currentValue = availableNotesArray[i].getBanknoteValue();
                total += currentValue;
                availableNotesArray[i].setQuantity(availableNotesArray[i].getQuantity() -1);
                notesGiven.put(currentValue, notesGiven.get(currentValue) == null ? 1 : notesGiven.get(currentValue) + 1 );

                i = -1;
            }
        }

        /*
        * If, at the end of the loop, the total still not matching with the value ordered, it means that doesn't have
        * enough banknotes available, so the transaction is canceled.
        * */
        if(!total.equals(value)) throw new NotEnoughBanknotesException();

        /*
        * At the end, the total of banknotes and its values its returned via Hashmap.
        * */
        return notesGiven;
    }

}
