package com.telrun.rledenev._2023_07_06.homework;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage(new Generator().generateStorageMap());
        System.out.println(storage.getClientsGroupedByBalance(BigDecimal.valueOf(50000)));
        System.out.println(storage.getCardNumbersMappedToNames());
        System.out.println(storage.getClientsWithExpiredCard());
        System.out.println(storage.getClientsSortedByBalance());
        System.out.println(storage.getClientsGroupedByExpireDate());
        System.out.println(storage.getNamesMappedToCardNumbers());
    }
}
