package com.telrun.rledenev.summary_0908;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class FileProcessorTest {
    private FileProcessor fileProcessor;

    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor(4);
    }

    @AfterEach
    void tearDown() throws Exception {
        fileProcessor.close();
    }

    @Test
    void processFileShouldInvokeAllLinesTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        AtomicInteger invokeTimes = new AtomicInteger();
        fileProcessor.processFile(new File("emails.txt"), (email) -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            invokeTimes.getAndIncrement();
            countDownLatch.countDown();
        });
        countDownLatch.await();
        Assertions.assertEquals(5, invokeTimes.get());
    }
}