/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paydala.creditcardvalidator.pojo;

/**
 *
 * @author Susheela
 */
public class CardInfo {
    private boolean isValid;
    private String lastFour;
    private String creditCardType;

    /**
     * @return the isValid
     */
    public boolean isIsValid() {
        return isValid;
    }

    /**
     * @param isValid the isValid to set
     */
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    /**
     * @return the lastFour
     */
    public String getLastFour() {
        return lastFour;
    }

    /**
     * @param lastFour the lastFour to set
     */
    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    /**
     * @return the creditCardType
     */
    public String getCreditCardType() {
        return creditCardType;
    }

    /**
     * @param creditCardType the creditCardType to set
     */
    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }
   
}
