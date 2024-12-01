package com.adventofcode.solutions.year2024;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day1SolutionTest {
    private final Day1Solution solution = new Day1Solution();

    @Test
    void testPart1WithExampleInput() {
        String exampleInput = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                        """;
        assertEquals("11", solution.solve(exampleInput, 1));
    }

    @Test
    void testPart2WithExampleInput() {
        String exampleInput = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                        """;
        assertEquals("31", solution.solve(exampleInput, 2));
    }
}