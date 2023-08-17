package com.telrun.rledenev._2023_08_15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void defaultAccountCreationTest() {
        Account account = new Account();
        assertEquals(account.getId().length(), 6);
        assertEquals(account.getStatus(), true);
        assertEquals(account.getZone(), Account.Zone.ZONE_1);
        assertEquals(account.getBalance(), 0.00);
    }

    @Test
    public void customAccountCreationTest() {
        Account account = new Account(false, Account.Zone.ZONE_3, 125.95);
        assertEquals(account.getId().length(), 6);
        assertEquals(account.getStatus(), false);
        assertEquals(account.getZone(), Account.Zone.ZONE_3);
        assertEquals(account.getBalance(), 125.95);
    }

    @Test
    public void negativeBalanceTest() {
        assertThrows(IllegalArgumentException.class, () -> new Account(false, Account.Zone.ZONE_3, -200));
    }
}