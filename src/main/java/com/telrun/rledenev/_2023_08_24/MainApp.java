package com.telrun.rledenev._2023_08_24;

public class MainApp {
    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();

        Thread senderThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                sender.sendData(i);
                receiver.receiveData(sender.getDataToSend());
            }
        });

        Thread recieverThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                sender.sendData(i);
                receiver.receiveData(sender.getDataToSend());
            }
        });

        Thread mainThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(receiver.getReceivedData());
            }
        });

        recieverThread.start();
        senderThread.start();
        mainThread.start();

    }
}
