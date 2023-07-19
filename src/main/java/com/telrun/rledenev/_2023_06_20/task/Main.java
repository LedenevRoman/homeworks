package com.telrun.rledenev._2023_06_20.task;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Generator generator = new Generator();

        for (int i = 0; i < 5; i++) {
            storage.addClient(generator.generateClient());
        }

        System.out.println(storage.getClientsHavingCardInCurrency(MyCurrency.PLN));
    }
}
