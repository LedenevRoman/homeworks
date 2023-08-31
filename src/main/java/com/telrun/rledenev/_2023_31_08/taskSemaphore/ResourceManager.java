package com.telrun.rledenev._2023_31_08.taskSemaphore;

import java.util.concurrent.Semaphore;

public class ResourceManager extends Thread {
    private final Semaphore semaphore;
    private final Resource resource;

    public ResourceManager(Semaphore semaphore, Resource resource) {
        this.semaphore = semaphore;
        this.resource = resource;
    }

    public String getEntity() {
        return resource.getDataBase().stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println("Get String from DataBase = " + getEntity());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}
