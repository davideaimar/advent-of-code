package com.adventofcode.solutions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Day1SolutionTest {
    private final Day1Solution solution = new Day1Solution();

    @Test
    void testPart1WithExampleInput() {
        String exampleInput = """
                            Sample input here
                            """;
        assertEquals("Expected result", solution.solve(exampleInput, 1));
    }

    @Test
    void testPart2WithExampleInput() {
        String exampleInput = """
                            Sample input here
                            """;
        assertEquals("Expected result", solution.solve(exampleInput, 2));
    }
}