package com.telrun.rledenev._2023_31_08.taskSemaphore;

import java.util.concurrent.Semaphore;

/**
 * Вы хотите ограничить количество потоков, которые могут одновременно
 * достучаться к определенному ресурсу (например, к базе данных).
 *
 * Создайте класс Resource (ресурс), представляющий некоторый общий ресурс, к которому потоки должны получать доступ.
 * Создайте класс ResourceManager, который будет ограничивать доступ к ресурсу с использованием Semaphore.
 * Реализуйте код, который запускает несколько потоков, пытающихся получить доступ к ресурсу.
 */
public class TaskSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Resource resource = new Resource();
        ResourceManager resourceManager1 = new ResourceManager(semaphore, resource);
        ResourceManager resourceManager2 = new ResourceManager(semaphore, resource);
        ResourceManager resourceManager3 = new ResourceManager(semaphore, resource);
        ResourceManager resourceManager4 = new ResourceManager(semaphore, resource);

        resourceManager1.start();
        resourceManager2.start();
        resourceManager3.start();
        resourceManager4.start();
    }
}
