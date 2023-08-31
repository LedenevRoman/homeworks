package com.telrun.rledenev._2023_31_08.taskCDL;

import java.util.concurrent.CountDownLatch;

/**
 * Вы хотите организовать соревнование, где несколько
 * участников будут стартовать одновременно, как только все они будут готовы.
 *
 * Создайте класс Participant, представляющий участника.
 * Создайте класс Race, который будет организовывать соревнование с использованием CountDownLatch.
 * Реализуйте код, который создает участников и запускает соревнование.
 */

public class TaskCDL {
    public static void main(String[] args) {
        int number = 5;
        CountDownLatch countDownLatch = new CountDownLatch(number);
        Participant participant1 = new Participant(countDownLatch);
        Participant participant2 = new Participant(countDownLatch);
        Participant participant3 = new Participant(countDownLatch);
        Race race = new Race(countDownLatch);

        new Thread(participant1).start();
        new Thread(participant2).start();
        new Thread(participant3).start();

        for (int i = 0; i < number; i++) {
            race.countDown();
        }

    }
}
