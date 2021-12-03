/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paydala.creditcardvalidator.utils;

import com.paydala.creditcardvalidator.CreditCardType;
import com.paydala.creditcardvalidator.pojo.CardInfo;
import com.paydala.creditcardvalidator.validator.Validator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Susheela
 */
public class CreditCardValidator {

    public static CardInfo validateCreditCard(String cardNo, String expiryDate, String cvv) {
        CardInfo cardInfo = new CardInfo();
        CreditCardType companyName = TypeChecker.checkType(cardNo);
        if(companyName == CreditCardType.OTHER){
            cardInfo.setIsValid(false);
            return cardInfo;
        }
        Validator validator = new Validator(cardNo, expiryDate, cvv);
       //check later
      /*  if (!validator.checkExpirationDate()) {
            cardInfo.setIsValid(false);
            return cardInfo;
        } */
        // need to validate the card 
        List<Integer> creditCardNoList = CreditCardParser.parseNumber(cardNo);
        int length = creditCardNoList.size();
        List<Integer> subList = creditCardNoList.subList(length-4, length);
        cardInfo.setLastFour(subList.stream()
                             .map(Object::toString)
                             .collect(Collectors.joining("")));
        cardInfo.setIsValid(true);
        
        return cardInfo;
    }
}
