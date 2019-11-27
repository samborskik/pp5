package pl.krakow.uek.pp5.qwark97.creditcard.ui;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import pl.krakow.uek.pp5.qwark97.creditcard.CreditCard;
import pl.krakow.uek.pp5.qwark97.creditcard.InMemoryCCStorage;
import pl.krakow.uek.pp5.qwark97.creditcard.model.CreditCardFacade;
import pl.krakow.uek.pp5.qwark97.creditcard.model.CreditCardDetailsDto;
import pl.krakow.uek.pp5.qwark97.creditcard.model.WithdrawCommand;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardsManagementController {

    private InMemoryCCStorage inMemoryCCStorage;
    CreditCardFacade creditCardFacade;


    public CardsManagementController(CreditCardFacade creditCardFacade, InMemoryCCStorage inMemoryCCStorage) {
        this.creditCardFacade = creditCardFacade;
        this.inMemoryCCStorage = inMemoryCCStorage;
    }

    @GetMapping("/fake-cards")
    public List<CreditCardDetailsDto> fakeCardBalances() {
        return Arrays.asList(
                new CreditCardDetailsDto("1234", BigDecimal.valueOf(2000)),
                new CreditCardDetailsDto("5678", BigDecimal.valueOf(6000)),
                new CreditCardDetailsDto("7890", BigDecimal.valueOf(1500))
        );
    }
    @PostMapping("/cards/add")
    public void addCard(@RequestBody HashMap<String, String> withdrawCommand) {
        CreditCard card = new CreditCard(withdrawCommand.get("number"));
        card.assignLimit(new BigDecimal(withdrawCommand.get("limit")));
        card.addOwner(withdrawCommand.get("owner"));
        card.setBalance(new BigDecimal(withdrawCommand.get("balance")));
        inMemoryCCStorage.add(card);

    }

    @GetMapping("/cards")
    public HashMap cardBalances() {

        HashMap allCards = inMemoryCCStorage.loadAll();
        System.out.print(allCards); // jak wyswietlic wszystko co w slowniku; czy wyplacanie działa?
        return allCards;
    }


    @PostMapping("/cards/withdraw")
    public void withdraw(@RequestBody HashMap<String, String> withdrawCommand) {
        System.out.print("here");
        creditCardFacade.handle(withdrawCommand);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void createSomeCards() {
        String cardId = creditCardFacade.registerClient(BigDecimal.valueOf(2000));
    }
}
