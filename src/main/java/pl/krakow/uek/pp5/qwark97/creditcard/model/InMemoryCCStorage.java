package pl.krakow.uek.pp5.qwark97.creditcard.model;

import java.util.HashMap;

class InMemoryCCStorage implements CreditCardStorage {
    private HashMap<String, CreditCard> cards;

    public InMemoryCCStorage() {
        cards = new HashMap<String, CreditCard>(); }

    public void add(CreditCard card) {
        cards.put(card.cardNumber, card);
    }

    public CreditCard load(String creditCardNumber) {
        return cards.get(creditCardNumber);
    }

    public HashMap<String, CreditCard> loadAll() {
        return cards;
    }
}
