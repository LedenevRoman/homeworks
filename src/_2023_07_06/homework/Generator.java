package _2023_07_06.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Generator {
    private static final int CARD_NUMBER_LENGTH = 16;
    private static final int CVV_CODE_LENGTH = 3;
    private static final String[] NAMES = {"Ivan", "Petr", "Sidr", "Anton", "Aleksey", "Oleg"};
    private static final Random RANDOM = new Random();

    public String generateCardData() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < CARD_NUMBER_LENGTH; i++) {
            result.append(RANDOM.nextInt(10));
        }

        LocalDate currentDate = LocalDate.now();
        int randomDayOffset = RANDOM.nextInt(1825);
        LocalDate cardExpireDate = currentDate.plusDays(randomDayOffset).minusYears(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        result.append(cardExpireDate.format(formatter));

        for (int i = 0; i < CVV_CODE_LENGTH; i++) {
            result.append(RANDOM.nextInt(10));
        }

        return result.toString();
    }

    public BankingCard generateBankingCard() {
        MyCurrency[] currencies = MyCurrency.values();
        MyCurrency currency = currencies[RANDOM.nextInt(currencies.length)];

        Status[] statuses = Status.values();
        Status status = statuses[RANDOM.nextInt(statuses.length)];

        return new BankingCard(generateCardData(), currency, status);
    }

    public Client generateClient() {
        String name = NAMES[RANDOM.nextInt(NAMES.length)];
        BigDecimal balance = BigDecimal.valueOf(RANDOM.nextDouble() * 1000000).setScale(2, RoundingMode.HALF_UP);
        return new Client(name, generateBankingCard(), balance);
    }

    public Map<Client, BigDecimal> generateStorageMap() {
        Map<Client, BigDecimal> map = new HashMap<>(25);
        for (int i = 0; i < RANDOM.nextInt(26) + 25; i++) {
            Client client = generateClient();
            map.put(client, client.getBalance());
        }
        return map;
    }
}
