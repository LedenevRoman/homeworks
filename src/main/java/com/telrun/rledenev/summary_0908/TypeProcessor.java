package com.telrun.rledenev.summary_0908;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

class TypeProcessor {
    private final Map<Class<?>, Consumer<?>> consumerMap = new HashMap<>();
    private final ExecutorService service;

    public TypeProcessor(int numberOfThreads) {
        service = Executors.newFixedThreadPool(numberOfThreads);
    }

    public <T> void configureProcess(Class<T> cls, Consumer<T> consumer) {
        consumerMap.put(cls, consumer);
    }

    public Future<Void> runProcessAsync(Object o) {
        return (Future<Void>) service.submit(() -> {
            runSync(o);
        });
    }

    public void runSync(Object o) {
        Consumer<Object> consumer = (Consumer<Object>) consumerMap.get(o.getClass());
        consumer.accept(o);
    }

    public void serviceShutdown() {
        service.shutdown();
    }
}
