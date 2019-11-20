package pl.krakow.uek.pp5.creditcard.model;

import java.math.BigDecimal;

class CreditCardFacade {

    private final InMemoryCCStorage storage;

    CreditCardFacade(InMemoryCCStorage ccStorage) {
        this.storage = ccStorage;
    }

    public void withdrawFromCard(String creditCardNumber, BigDecimal withdrawValue) {
        CreditCard loaded = storage.load(creditCardNumber);

        loaded.withdraw(withdrawValue);

        storage.add(loaded);

    }
}
