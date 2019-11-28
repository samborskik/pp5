package pl.krakow.uek.pp5.qwark97.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardApiTest {

    private static final BigDecimal WITHDRAW_VALUE = BigDecimal.valueOf(500);
    private static final String CREDIT_CARD_NUMBER = "1234-5678";
    private static final int INITIAL_LIMIT = 1000;
    private InMemoryCCStorage ccStorage;
    private CreditCardFacade api;


    @Test
    public void withdrawFromCard() {
        thereIsCCStorage();
        thereIsCreditCard();
        thereIsCCApi();

        api.handle(new WithdrawCommand(CREDIT_CARD_NUMBER, WITHDRAW_VALUE));

        currentBalanceForCCEquals(CREDIT_CARD_NUMBER, BigDecimal.valueOf(500));
    }

    private void currentBalanceForCCEquals(String creditCardNumber, BigDecimal expectedBallance) {
        CreditCard loaded = ccStorage.load(creditCardNumber);

        Assert.assertEquals(expectedBallance, loaded.currentBalance());
    }

    private void thereIsCCApi() {api = new CreditCardFacade(this.ccStorage);}

    private void thereIsCreditCard() {
        CreditCard card = new CreditCard(CREDIT_CARD_NUMBER);
        card.assignLimit(BigDecimal.valueOf(INITIAL_LIMIT));

        ccStorage.add(card);
    }

    private void thereIsCCStorage() {
        ccStorage = new InMemoryCCStorage();

    }
}
