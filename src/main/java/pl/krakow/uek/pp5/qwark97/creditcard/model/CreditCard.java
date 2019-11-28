package pl.krakow.uek.pp5.qwark97.creditcard.model;

import pl.krakow.uek.pp5.qwark97.creditcard.model.exceptions.CreditBelowMinimumException;
import pl.krakow.uek.pp5.qwark97.creditcard.model.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

public class CreditCard {
    String cardNumber;
    private BigDecimal limit;
    private String ownerName;
    private BigDecimal currentBalance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal newLimit) {
        if (BigDecimal.valueOf(100).compareTo(newLimit) == 1) {
            throw new CreditBelowMinimumException();
        }
        limit = newLimit;
    }

    public BigDecimal getLimit() {
        return limit;
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

    public void addOwner(String owner) {
        ownerName = owner;
    }

    public void setBalance(BigDecimal balance) {
        currentBalance = balance;
    }

    public CreditCardDetailsDto details() {
        return new CreditCardDetailsDto(cardNumber, currentBalance);
    }
}