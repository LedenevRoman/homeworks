package _2023_06_20.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Generator {

    private static final String[] NAMES = {"Ivan", "Petr", "Sidr", "Anton", "Aleksey", "Oleg"};

    public Client generateClient() {
        Random random = new Random();
        Client client = new Client();
        client.setName(NAMES[random.nextInt(NAMES.length)]);
        client.setAge(random.nextInt(72) + 18);

        String randomPassportNumber = UUID.randomUUID()
                .toString()
                .replaceAll("-", "")
                .substring(0, 10);

        client.setPassportNumber(randomPassportNumber);

        List<BankingCard> bankingCardList = new ArrayList<>();

        for (int i = 0; i < random.nextInt(5) + 1; i++) {
            bankingCardList.add(generateBankingCard());
        }
        client.setBankingCardsList(bankingCardList);

        return client;
    }

    public BankingCard generateBankingCard() {
        Random random = new Random();
        BankingCard bankingCard = new BankingCard();

        LocalDate currentDate = LocalDate.now();
        int randomDayOffset = random.nextInt(1825);

        bankingCard.setCardExpireDate(currentDate.plusDays(randomDayOffset));

        MyCurrency[] currencies = MyCurrency.values();
        bankingCard.setCurrency(currencies[random.nextInt(currencies.length)]);

        Status[] statuses = Status.values();
        bankingCard.setStatus(statuses[random.nextInt(statuses.length)]);

        BigDecimal randomBigDecimal = BigDecimal.valueOf(random.nextDouble() * 1000000);
        bankingCard.setAccountBalance(randomBigDecimal.setScale(2, RoundingMode.HALF_UP));

        PaymentSystem[] paymentSystems = PaymentSystem.values();
        bankingCard.setPaymentSystem(paymentSystems[random.nextInt(paymentSystems.length)]);

        return bankingCard;
    }
}
