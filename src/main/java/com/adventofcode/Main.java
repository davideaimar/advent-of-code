package com.adventofcode;

import com.adventofcode.solutions.Day1Solution;
import com.adventofcode.utils.InputReader;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <day> <part>");
            System.exit(1);
        }

        int day = Integer.parseInt(args[0]);
        int part = Integer.parseInt(args[1]);
        
        // Get the input for the specific day
        String input = InputReader.readInput(day);
        
        // Get the solution for the day
        AoCSolution solution = getSolution(day);
        
        if (solution == null) {
            System.out.println("No solution found for day " + day);
            System.exit(1);
        }

        // Solve and print the result
        String result = solution.solve(input, part);
        System.out.println("Solution for day " + day + " part " + part + ": " + result);
    }

    private static AoCSolution getSolution(int day) {
        return switch (day) {
            case 1 -> new Day1Solution();
            // Add more cases for other days
            default -> null;
        };
    }
}