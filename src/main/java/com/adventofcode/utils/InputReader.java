package com.adventofcode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputReader {
    /**
     * Reads the input file for the given day.
     * Input files should be placed in src/main/resources/inputs/dayX.txt
     *
     * @param day The day number
     * @return The contents of the input file as a string
     */
    public static String readInput(int day) {
        try {
            Path inputPath = Paths.get("src", "main", "resources", "inputs", "day" + day + ".txt");
            return Files.readString(inputPath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input for day " + day, e);
        }
    }
}