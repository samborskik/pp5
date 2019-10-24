package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;
import pl.krakow.uek.pp5.creditcard.model.exceptions.CreditBelowMinimumException;

import java.math.BigDecimal;

public class CreditCardTest {

    public static final int NEW_CREDIT_LIMIT = 2000;
    public static final int MINIMUM_CREDIT_VALUE_ONE = 100;
    public static final int MINIMUM_CREDIT_VALUE_TWO = 10000;

    @Test
    public void itAllowAssignLimitToCreditCard() {
        //Arange //Given
        CreditCard card = new CreditCard("1234-5678");
        //Act //When
        card.assignLimit(BigDecimal.valueOf(NEW_CREDIT_LIMIT));
        //Assert //Then //Expect
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(NEW_CREDIT_LIMIT)));
    }

    @Test
    public void itVerifyMinimumCreditValue() {
        CreditCard card = new CreditCard("1234-5678");

        try {
            card.assignLimit(BigDecimal.valueOf(50));
            Assert.fail("Exception should be thrown");
        } catch (CreditBelowMinimumException e) {
            Assert.assertTrue(true);
        }

    }
}
