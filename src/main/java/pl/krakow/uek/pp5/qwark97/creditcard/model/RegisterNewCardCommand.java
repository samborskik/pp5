package pl.krakow.uek.pp5.qwark97.creditcard.model;

import java.math.BigDecimal;

public class RegisterNewCardCommand {
    BigDecimal creditLimit;
    String clientId;

    public RegisterNewCardCommand() {}

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
