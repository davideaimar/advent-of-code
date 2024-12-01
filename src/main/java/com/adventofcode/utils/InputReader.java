package com.adventofcode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputReader {
    /**
     * Reads the input file for the given year and day.
     * Input files should be placed in src/main/resources/inputs/yearXXXX/dayX.txt
     *
     * @param year The year of the puzzle
     * @param day  The day number
     * @return The contents of the input file as a string
     */
    public static String readInput(int year, int day) {
        try {
            Path inputPath = Paths.get("src", "main", "resources", "inputs",
                    String.valueOf(year), "day" + day + ".txt");
            return Files.readString(inputPath);
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Failed to read input for year %d day %d", year, day), e);
        }
    }
}