package com.adventofcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adventofcode.utils.InputReader;
import com.adventofcode.utils.SolutionsLoader;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 3) {
            logger.error("Usage: java Main <year> <day> <part>");
            System.exit(1);
        }

        int year = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        int part = Integer.parseInt(args[2]);

        // Load solution for the specific day
        AoCSolution solution = SolutionsLoader.getSolution(year, day);

        if (solution == null) {
            logger.error("No solution found for year " + year + " day " + day);
            System.exit(1);
        }

        // Get the input for the specific day
        String input = InputReader.readInput(year, day);

        // Solve and print the result
        String result = solution.solve(input, part);
        logger.info("Solution for year " + year + " day " + day + " part " + part + ": " + result);
    }
}