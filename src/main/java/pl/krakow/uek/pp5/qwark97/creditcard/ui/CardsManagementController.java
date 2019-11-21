package pl.krakow.uek.pp5.qwark97.creditcard.ui;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import pl.krakow.uek.pp5.qwark97.creditcard.CreditCard;
import pl.krakow.uek.pp5.qwark97.creditcard.model.CreditCardFacade;
import pl.krakow.uek.pp5.qwark97.creditcard.model.CreditCardDetailsDto;
import pl.krakow.uek.pp5.qwark97.creditcard.model.WithdrawCommand;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardsManagementController {

    public CardsManagementController(CreditCardFacade creditCardFacade) {
        this.creditCardFacade = creditCardFacade;
    }

    @GetMapping("/cards")
    public List<CreditCardDetailsDto> cardBalances() {
        return Arrays.asList(
                new CreditCardDetailsDto("1234", BigDecimal.valueOf(2000)),
                new CreditCardDetailsDto("5678", BigDecimal.valueOf(6000)),
                new CreditCardDetailsDto("7890", BigDecimal.valueOf(1500))
        );
    }

    CreditCardFacade creditCardFacade;


    @PostMapping("/cards/withdraw")
    public void withdraw(@RequestBody WithdrawCommand withdrawCommand) {
        creditCardFacade.handle(withdrawCommand);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void createSomeCards() {
        String cardId = creditCardFacade.registerClient(BigDecimal.valueOf(2000));
    }
}
