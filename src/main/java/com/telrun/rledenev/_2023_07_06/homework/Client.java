package com.telrun.rledenev._2023_07_06.homework;

import java.math.BigDecimal;
import java.util.Objects;

public class Client {
    private final String name;
    private BankingCard bankingCard;
    private BigDecimal balance;

    public Client(String name, BankingCard bankingCard, BigDecimal balance) {
        this.name = name;
        this.bankingCard = bankingCard;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public BankingCard getBankingCard() {
        return bankingCard;
    }

    public void setBankingCard(BankingCard bankingCard) {
        this.bankingCard = bankingCard;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(bankingCard, client.bankingCard) && Objects.equals(balance, client.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bankingCard, balance);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", bankingCard=" + bankingCard +
                ", balance=" + balance +
                '}';
    }
}
