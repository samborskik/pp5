package pl.krakow.uek.pp5.creditcard.model;

import pl.krakow.uek.pp5.creditcard.model.exceptions.CreditBelowMinimumException;

import java.math.BigDecimal;

public class CreditCard {
    private String cardNumber;
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
        currentBalance = currentBalance.subtract(money);
    }

    public BigDecimal currentBalance() {
        return currentBalance;
    }
}