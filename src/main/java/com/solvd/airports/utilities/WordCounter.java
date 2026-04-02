package com.solvd.airports.utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordCounter {

    private static final Logger LOGGER = LogManager.getLogger(WordCounter.class);

    public static void main(String[] args) {

        try {
            String text = FileUtils.readFileToString(new File(Objects.requireNonNull(WordCounter.class.getClassLoader().getResource("input.txt")).getFile()), StandardCharsets.UTF_8);
            text = text.replaceAll("(?iu)(?<=^|\\s)\\p{L}\\.(?=\\s)", "");

            Map <String,Integer> wordCount = Arrays.stream(text.toLowerCase().split("[^\\p{L}]+")).filter(word -> !word.isBlank()).collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

            StringBuilder result = new StringBuilder();
            wordCount.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> result.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n"));

            FileUtils.writeStringToFile(new File("src/main/resources/output.txt"), result.toString(), StandardCharsets.UTF_8);

            LOGGER.info("Done. Check output.txt");

        } catch (IOException e) {
            LOGGER.error("Error while processing the file.");
        }
    }
}