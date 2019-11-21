package pl.krakow.uek.pp5.qwark97.creditcard.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krakow.uek.pp5.qwark97.creditcard.model.CreditCardDetailsDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardsManagementController {

    @GetMapping("/cards")
    public List<CreditCardDetailsDto> cardBalances() {
        return Arrays.asList(
                new CreditCardDetailsDto("1234", BigDecimal.valueOf(2000)),
                new CreditCardDetailsDto("5678", BigDecimal.valueOf(6000)),
                new CreditCardDetailsDto("7890", BigDecimal.valueOf(1500))
        );
    }
}
