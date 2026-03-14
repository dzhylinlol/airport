package com.solvd.airports.utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UniqueWordCounter {

    private static final Logger LOGGER = LogManager.getLogger(UniqueWordCounter.class);

    public static void main(String[] args) {

        File inputFile = new File(
                UniqueWordCounter.class
                        .getClassLoader()
                        .getResource("input.txt")
                        .getFile()
        );
        File outputFile = new File("src/main/resources/output.txt");

        try {
            String text = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);

            Set<String> uniqueWords = Arrays.stream(text.toLowerCase().split("[^\\p{L}]+"))
                                            .filter(word -> !word.isBlank())
                                            .collect(Collectors.toSet());

            String result = "Number of unique words: " + uniqueWords.size();

            FileUtils.writeStringToFile(outputFile, result, StandardCharsets.UTF_8);

            LOGGER.info("Done. Check output.txt");

        } catch (IOException e) {
            LOGGER.error("Error while processing the file.");
            e.printStackTrace();
        }
    }
}