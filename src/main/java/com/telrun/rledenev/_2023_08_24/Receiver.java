package com.telrun.rledenev._2023_08_24;

public class Receiver {
    private volatile int receivedData;

    public synchronized void receiveData(int receivedData) {
        this.receivedData = receivedData;
    }

    public synchronized int getReceivedData() {
        return receivedData;
    }
}
