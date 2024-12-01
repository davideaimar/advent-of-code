package com.adventofcode.solutions;

import com.adventofcode.AoCSolution;

public class Day1Solution implements AoCSolution {
    @Override
    public String solve(String input, int part) {
        return switch (part) {
            case 1 -> solvePart1(input);
            case 2 -> solvePart2(input);
            default -> throw new IllegalArgumentException("Invalid part: " + part);
        };
    }

    private String solvePart1(String input) {
        // Implement solution for part 1
        return "Not implemented yet";
    }

    private String solvePart2(String input) {
        // Implement solution for part 2
        return "Not implemented yet";
    }
}