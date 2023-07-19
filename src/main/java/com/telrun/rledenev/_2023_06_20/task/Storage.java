package com.telrun.rledenev._2023_06_20.task;

import java.util.*;

public class Storage {
    private final Map<Client, List<BankingCard>> storage = new TreeMap<>();

    public Map<Client, List<BankingCard>> getStorage() {
        return storage;
    }

    public void addClient(Client client) {
        storage.put(client, client.getBankingCardsList());
    }

    public List<Client> getClientsHavingCardInCurrency(MyCurrency currency) {
        List<Client> result = new ArrayList<>();

        for (Map.Entry<Client, List<BankingCard>> entryMap : storage.entrySet()) {
            List<BankingCard> cards = entryMap.getValue();
            for (BankingCard card : cards) {
                if (card.getCurrency().equals(currency)) {
                    result.add(entryMap.getKey());
                }
            }
        }
        return result;
    }

    public void updateStorage(Client client) {
        storage.put(client, client.getBankingCardsList());
    }

    public void deleteClient(Client client) {
        storage.remove(client);
    }
}
