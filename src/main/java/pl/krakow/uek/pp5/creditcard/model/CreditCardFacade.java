package pl.krakow.uek.pp5.creditcard.model;

import java.math.BigDecimal;

class CreditCardFacade {

    private final InMemoryCCStorage storage;

    CreditCardFacade() {
        this.storage = new InMemoryCCStorage();
    }

    public void withdrawFromCard(String creditCardNumber, BigDecimal withdrawValue) {
        CreditCard loaded = storage.load(creditCardNumber);

        loaded.withdraw(withdrawValue);

        storage.add(loaded);
    }
}
