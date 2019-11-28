package pl.krakow.uek.pp5.qwark97.creditcard.model;

import pl.krakow.uek.pp5.qwark97.creditcard.model.CreditCard;

public interface CreditCardStorage {
    void add(CreditCard card);

    CreditCard load(String creditCardNumber);
}
