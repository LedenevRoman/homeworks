package _2023_07_06.homework;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Storage {
    private Map<Client, BigDecimal> storage;

    public Storage(Map<Client, BigDecimal> storage) {
        this.storage = storage;
    }

    public Set<Client> getClientsWithStatus(Status status) {
        return storage.keySet().stream()
                .filter(client -> client.getBankingCard().getStatus().equals(status))
                .collect(Collectors.toSet());
    }

    public Map<String, Set<Client>> getClientsGroupedByBalance(BigDecimal balance) {
        return storage.entrySet().stream()
                .collect(Collectors.groupingBy(entry -> entry.getValue().compareTo(balance) >= 0 ? "Not less than " + balance : "Less than " + balance,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toSet())));
    }

    public double getAvgBalance() {
        return storage.values()
                .stream()
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .orElse(0);
    }

    public Map<String, String> getCardNumbersMappedToNames() {
        return storage.keySet()
                .stream()
                .collect(Collectors.groupingBy(client -> client.getBankingCard().getCardData().substring(0, 16),
                        Collectors.mapping(Client::getName, Collectors.joining(", "))));
    }

    public Set<Client> getClientsWithExpiredCard() {
        return storage.keySet()
                .stream()
                .filter(client -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                    String dateString = client.getBankingCard().getCardData().substring(16, 24);
                    LocalDate expireDate = LocalDate.parse(dateString, formatter);
                    return expireDate.compareTo(LocalDate.now()) < 0;
                })
                .collect(Collectors.toSet());
    }

    public List<Client> getClientsSortedByBalance() {
        return storage.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, List<Client>> getClientsGroupedByExpireDate() {
        return storage.keySet()
                .stream()
                .collect(Collectors.groupingBy(client -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                    String dateString = client.getBankingCard().getCardData().substring(16, 24);
                    LocalDate expireDate = LocalDate.parse(dateString, formatter);
                    return expireDate.compareTo(LocalDate.now()) < 0 ? "Expired" : "Not Expired";
                }));
    }

    public Map<String, List<String>> getNamesMappedToCardNumbers() {
        return storage.keySet()
                .stream()
                .collect(Collectors.groupingBy(Client::getName,
                        Collectors.mapping(client -> client.getBankingCard().getCardData().substring(0, 16), Collectors.toList())));
    }
}
