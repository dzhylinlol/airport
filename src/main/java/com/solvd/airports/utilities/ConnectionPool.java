package com.solvd.airports.utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPool {

   private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

private static BlockingQueue<Integer> pool;

    public static void main(String[] args) {

        int poolSize = 3;

        pool = new ArrayBlockingQueue<>(poolSize);

        for (int i = 1; i <= poolSize; i++) {
            pool.add(i);
        }

        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (int i = 1; i <= 6; i++) {
            int taskId = i;

            executor.submit(() -> {
                try {
                    LOGGER.info("Thread {} waiting...", taskId);
                    Integer connection = pool.take();

                    LOGGER.info("Thread {} got connection {}", taskId, connection);

                    Thread.sleep(2000);

                    LOGGER.info("Thread {} releasing connection {}", taskId, connection);

                    pool.put(connection);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
