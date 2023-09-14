package com.telrun.rledenev.summary_0908;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileProcessor implements AutoCloseable {
    private final ExecutorService threadPool;

    public FileProcessor(int numberOfThreads) {
        threadPool = Executors.newFixedThreadPool(numberOfThreads);
    }

    void processFile(File file, Processor processor) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String email = line;
                threadPool.execute(() -> processor.process(email));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        threadPool.shutdown();
    }
}
