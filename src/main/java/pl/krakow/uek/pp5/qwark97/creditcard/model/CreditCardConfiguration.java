package pl.krakow.uek.pp5.qwark97.creditcard.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditCardConfiguration {

    @Bean
    CreditCardFacade create() {
        return  new CreditCardFacade(new InMemoryCCStorage());
    }
    @Bean
    InMemoryCCStorage createMem() {
        return  new InMemoryCCStorage();
    }
}
