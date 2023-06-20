package _2023_06_20.task;

import java.util.List;
import java.util.Objects;

public class Client implements Comparable<Client> {
    private String name;
    private String passportNumber;
    private int age;
    private List<BankingCard> bankingCardList;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BankingCard> getBankingCardsList() {
        return bankingCardList;
    }

    public void setBankingCardsList(List<BankingCard> bankingCardList) {
        this.bankingCardList = bankingCardList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && Objects.equals(name, client.name) && Objects.equals(passportNumber, client.passportNumber) && Objects.equals(bankingCardList, client.bankingCardList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportNumber, age, bankingCardList);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", age=" + age +
                ", bankingCardList=" + bankingCardList +
                '}';
    }

    @Override
    public int compareTo(Client client) {
        return this.getName().compareTo(client.getName());
    }
}
