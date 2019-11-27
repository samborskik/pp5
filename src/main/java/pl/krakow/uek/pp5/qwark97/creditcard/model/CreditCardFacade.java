package pl.krakow.uek.pp5.qwark97.creditcard.model;

import pl.krakow.uek.pp5.qwark97.creditcard.CreditCard;
import pl.krakow.uek.pp5.qwark97.creditcard.InMemoryCCStorage;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CreditCardFacade {

    private final InMemoryCCStorage storage;

    public CreditCardFacade(InMemoryCCStorage ccStorage) {
        this.storage = ccStorage;
    }

    public void withdrawFromCard(String creditCardNumber, BigDecimal withdrawValue) {
        CreditCard loaded = storage.load(creditCardNumber);

        loaded.withdraw(withdrawValue);

        storage.add(loaded);

    }

    public void handle(HashMap<String, String> withdrawCommand) {
        CreditCard card = storage.load(withdrawCommand.get("number"));
        card.withdraw(new BigDecimal(withdrawCommand.get("withdrawAmount")));
    }
    /*
    public List<CreditCardDetailsDto> raport() {
        return storage.all().stream()
                .map(card -> CreditCardDetailsDto.of(card.number, card.balance))
                .collect(Collectors.toList());
    }
    */
    public String registerClient(BigDecimal valueOf) {
        String name = "asd";
        return name;
    }
}
