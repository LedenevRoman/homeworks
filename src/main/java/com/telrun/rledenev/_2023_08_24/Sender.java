package com.telrun.rledenev._2023_08_24;

public class Sender {
    private volatile int dataToSend;

    public synchronized void sendData(int dataToSend) {
        this.dataToSend = dataToSend;
    }

    public int getDataToSend() {
        return dataToSend;
    }
}
