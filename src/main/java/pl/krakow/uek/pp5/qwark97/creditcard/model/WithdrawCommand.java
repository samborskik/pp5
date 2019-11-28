package pl.krakow.uek.pp5.qwark97.creditcard.model;

import java.math.BigDecimal;

public class WithdrawCommand {
    private String number;
    private BigDecimal amount;

    public WithdrawCommand() {
    }

    public WithdrawCommand(String number, BigDecimal amount) {
        this.number = number;
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
