package pl.krakow.uek.pp5.qwark97.creditcard.model;

public interface CreditCardStorage {
    void add(CreditCard card);

    CreditCard load(String creditCardNumber);
}
