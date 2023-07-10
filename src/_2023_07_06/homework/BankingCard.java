package _2023_07_06.homework;

import java.util.Objects;

public class BankingCard {
    private final String cardData;
    private final MyCurrency myCurrency;
    private Status status;

    public BankingCard(String cardData, MyCurrency myCurrency, Status status) {
        this.cardData = cardData;
        this.myCurrency = myCurrency;
        this.status = status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCardData() {
        return cardData;
    }

    public MyCurrency getMyCurrency() {
        return myCurrency;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankingCard)) return false;
        BankingCard that = (BankingCard) o;
        return Objects.equals(cardData, that.cardData) && myCurrency == that.myCurrency && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardData, myCurrency, status);
    }

    @Override
    public String toString() {
        return "BankingCard{" +
                "cardData='" + cardData + '\'' +
                ", myCurrency=" + myCurrency +
                ", status=" + status +
                '}';
    }
}
