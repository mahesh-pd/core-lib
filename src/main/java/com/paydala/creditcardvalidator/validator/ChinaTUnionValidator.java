package com.paydala.creditcardvalidator.validator;

import static com.paydala.creditcardvalidator.utils.CreditCardParser.parseIIN;
import static com.paydala.creditcardvalidator.utils.CreditCardParser.parseNumber;
import java.util.List;


/*
 * China T-Union format:
 * length = 16
 * IIN range = 31
 */
public class ChinaTUnionValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public ChinaTUnionValidator(String creditCardNumber) {
        creditCardNumberList = parseNumber(creditCardNumber);
    }

    /*
     * Check the length of the card against the format
     * requirement.
     *
     * @return boolean of whether or not credit card
     * number meet requirement.
     */
    @Override
    boolean checkLength() {
        boolean hasAllowedLength = false;

        if (creditCardNumberList.size() == 19) {
            hasAllowedLength = true;
        }

        return hasAllowedLength;
    }

    /*
     * Check that IIN meets IIN range requirement
     *
     * @return boolean of whether or not IIN matches
     * requirement
     */
    @Override
    boolean checkIINRanges() {
        boolean hasAllowedIINRange = false;
        int IINRange = 31;
        int firstTwo = parseIIN(creditCardNumberList, 2);

        if (firstTwo == IINRange) {
            hasAllowedIINRange = true;
        }

        return hasAllowedIINRange;
    }
}
