package pl.krakow.uek.pp5.qwark97.creditcard.model;

import java.math.BigDecimal;

public class CreditCardDetailsDto {
    private  String cardNumber;
    private BigDecimal saldo;

    public CreditCardDetailsDto(String cardNumber, BigDecimal saldo) {
        this.cardNumber = cardNumber;
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


}
