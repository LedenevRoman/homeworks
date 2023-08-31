package com.telrun.rledenev._2023_31_08.taskExchanger;

import java.util.concurrent.Exchanger;

/**
 * Вы хотите реализовать систему обмена данными между двумя потоками.
 * Один поток генерирует числа, а другой поток обрабатывает эти числа и возвращает результат обратно.
 *
 * Создайте класс DataProducer, который генерирует случайные числа и обменивается ими с помощью Exchanger.
 * Создайте класс DataProcessor, который получает числа от DataProducer с помощью Exchanger,
 * выполняет какую-то обработку (например, вычисление квадрата числа) и отправляет результат обратно.
 * Реализуйте код, который запускает оба потока и демонстрирует обмен данными между ними.
 *
 * public class ExchangerExample {
 *     public static void main(String[] args) {
 *         Exchanger<Integer> exchanger = new Exchanger<>();
 *
 *         Thread dataProducerThread = new Thread(new DataProducer(exchanger));
 *         Thread dataProcessorThread = new Thread(new DataProcessor(exchanger));
 *
 *         dataProducerThread.start();
 *         dataProcessorThread.start();
 *     }
 * }
 */

public class TaskExchanger {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        Thread dataProducerThread = new Thread(new DataProducer(exchanger));
        Thread dataProcessorThread = new Thread(new DataProcessor(exchanger));

        dataProducerThread.start();
        dataProcessorThread.start();
    }
}
