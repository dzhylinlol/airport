package com.solvd.airports.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static ConnectionPool instance;
    private final BlockingQueue<DBConnection> pool;
    private static final int MAX_CONNECTIONS = 3;

    private ConnectionPool() {
        pool = new LinkedBlockingQueue<>(MAX_CONNECTIONS);

        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            pool.add(new DBConnection());
        }

        LOGGER.info("Connection pool created with {} connections", MAX_CONNECTIONS);
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public DBConnection getConnection() {
        try {
            LOGGER.info("Connection requested from pool");
            return pool.take();
        } catch (InterruptedException e) {
            LOGGER.error("Error getting connection", e);
            Thread.currentThread().interrupt(); // important
            throw new RuntimeException("Failed to get connection", e);
        }
    }

    public void releaseConnection(DBConnection connection) {
        if (connection == null) {
            LOGGER.warn("Attempted to return null connection to pool");
            return;
        }

        boolean added = pool.offer(connection);

        if (added) {
            LOGGER.info("Connection returned to pool");
        } else {
            LOGGER.error("Failed to return connection: pool is full");
        }
    }

    public int getAvailableConnections() {
        return pool.size();
    }
}
