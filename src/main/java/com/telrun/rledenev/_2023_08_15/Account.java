package com.telrun.rledenev._2023_08_15;

import java.util.UUID;

public class Account {
    private final String id = generateId();

    private boolean status = true;
    private Zone zone = Zone.ZONE_1;
    private double balance = 0.00;

    public enum Zone {
        ZONE_1,
        ZONE_2,
        ZONE_3
    }

    public Account() {
    }

    public Account(boolean status, Zone zone, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException();
        }
        this.status = status;
        this.zone = zone;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public Zone getZone() {
        return zone;
    }

    public double getBalance() {
        return balance;
    }

    private String generateId() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
