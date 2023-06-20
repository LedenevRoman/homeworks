package _2023_06_20.task;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class BankingCard {
    private LocalDate cardExpireDate;
    private Status status;
    private PaymentSystem paymentSystem;
    private BigDecimal accountBalance;
    private MyCurrency currency;

    public LocalDate getCardExpireDate() {
        return cardExpireDate;
    }

    public void setCardExpireDate(LocalDate cardExpireDate) {
        this.cardExpireDate = cardExpireDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public MyCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(MyCurrency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingCard that = (BankingCard) o;
        return Objects.equals(cardExpireDate, that.cardExpireDate) && status == that.status && paymentSystem == that.paymentSystem && Objects.equals(accountBalance, that.accountBalance) && currency == that.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardExpireDate, status, paymentSystem, accountBalance, currency);
    }

    @Override
    public String toString() {
        return "BankingCard{" +
                "cardExpireDate=" + cardExpireDate +
                ", status=" + status +
                ", paymentSystem=" + paymentSystem +
                ", accountBalance=" + accountBalance +
                ", currency=" + currency +
                '}';
    }
}
