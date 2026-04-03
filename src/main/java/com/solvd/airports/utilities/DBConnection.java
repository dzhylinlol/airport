package com.solvd.airports.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
    private static final Logger LOGGER = LogManager.getLogger(DBConnection.class);

    public DBConnection() {
        LOGGER.info(">>> Connection created!");
    }

    public void execute(String query) {
        LOGGER.info("Executing query: " + query);
    }
}
