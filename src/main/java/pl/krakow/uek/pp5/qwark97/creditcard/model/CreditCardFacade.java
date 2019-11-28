package pl.krakow.uek.pp5.qwark97.creditcard.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CreditCardFacade {

    private final InMemoryCCStorage storage;

    public CreditCardFacade(InMemoryCCStorage ccStorage) {
        this.storage = ccStorage;
    }

    public void handle(WithdrawCommand command) {
        CreditCard loaded = storage.load(command.getNumber());
        loaded.withdraw(command.getAmount());
        storage.add(loaded);
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

    public String handle(RegisterNewCardCommand registerNewCardCommand) {
        CreditCard creditCard = new CreditCard(UUID.randomUUID().toString());

        creditCard.assignLimit(registerNewCardCommand.getCreditLimit());

        storage.add(creditCard);

        return creditCard.cardNumber;
    }

    public List<CreditCardDetailsDto> allCardsReport() {
        return storage.loadAll().values().stream()
                .map(cc -> cc.details())
                .collect(Collectors.toList());
    }
}
