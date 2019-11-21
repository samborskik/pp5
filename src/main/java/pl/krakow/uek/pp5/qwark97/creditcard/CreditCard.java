package pl.krakow.uek.pp5.qwark97.creditcard;

import pl.krakow.uek.pp5.qwark97.creditcard.exceptions.CreditBelowMinimumException;
import pl.krakow.uek.pp5.qwark97.creditcard.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

public class CreditCard {
    String cardNumber;
    private BigDecimal creditLimit;
    private String slogan;
    private BigDecimal currentBalance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal newLimit) {
        if (BigDecimal.valueOf(100).compareTo(newLimit) == 1) {
            throw new CreditBelowMinimumException();
        }
        creditLimit = newLimit;
        currentBalance = creditLimit;
    }

    public BigDecimal getLimit() {
        return creditLimit;
    }

    public void withdraw(BigDecimal money) {

        if (BigDecimal.valueOf(0).compareTo(currentBalance.subtract(money)) == 1) {
            throw  new NotEnoughMoneyException();
        }
        currentBalance = currentBalance.subtract(money);
    }

    public BigDecimal currentBalance() {
        return currentBalance;
    }
}